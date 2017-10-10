package com.unionpay.withhold.trade.task.scheduled;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.bean.TradeQueueBean;
import com.unionpay.withhold.bean.enums.TradeQueueEnum;
import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.app.CPRealtimeWithholdQry;
import com.unionpay.withhold.trade.task.bean.NotifyQueueBean;
import com.unionpay.withhold.trade.task.bean.TradeChannelEnum;
import com.unionpay.withhold.trade.task.bean.TradeStatFlagEnum;
import com.unionpay.withhold.trade.task.bean.TxnsLogBean;
import com.unionpay.withhold.trade.task.dao.TxnLogTaskDAO;
import com.unionpay.withhold.trade.task.pojo.TxnLogTaskDO;
import com.unionpay.withhold.utils.DateUtil;

@Component
public class TradeQueryTask {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	//@Reference(version="1.0")
	private CPRealtimeWithholdQry cpRealtimeWithholdQry;
	@Autowired
	private TxnLogTaskDAO txnLogTaskDAO;
	@SuppressWarnings("static-access")
	@Scheduled(cron="0 0/1 * * * ?")
	public void queryCPSingleTrade() {
		BoundListOperations<String, String> boundListOps = redisTemplate.boundListOps(TradeQueueEnum.CPREALTIMETRADE.name());
		Long size = boundListOps.size();
		for(int i=0;i<size.intValue();i++) {
			String json = boundListOps.rightPop();
			if(StringUtils.isEmpty(json)) {
				continue;
			}
			//转换为TradeQueueBean
			TradeQueueBean tradeQueueBean = JSON.parseObject(json,TradeQueueBean.class);
			//获取交易流水
			TxnLogTaskDO txnLog = txnLogTaskDAO.selectByPrimaryKey(tradeQueueBean.getTxnseqno());
			if(txnLog == null) {
				logger.error(json+"交易流水表中无此交易数据");
				continue;
			}else {
				TradeStatFlagEnum tradeStatFlag = TradeStatFlagEnum.fromValue(txnLog.getTradestatflag());
				if(TradeStatFlagEnum.PAYING!=tradeStatFlag) {
					logger.warn(json+"交易流水表中状态非支付中，不进行交易查询");
					continue;
				}
			}
			TradeChannelEnum tradeChannel = TradeChannelEnum.fromValue(txnLog.getPayinst());
			switch (tradeChannel) {
				case CHINAPAY_SINGLE:
					ResultBean resultBean = cpRealtimeWithholdQry.qryRTWthdRecord(tradeQueueBean.getTxnseqno());
					if(resultBean.isResultBool()) {
						if (resultBean.getResultObj() instanceof TxnsLogBean) {
							TxnsLogBean txnsLogBean = (TxnsLogBean) resultBean.getResultObj();
							TradeStatFlagEnum tradeStatFlagEnum = TradeStatFlagEnum.fromValue(txnsLogBean.getTradestatflag());
							if(tradeStatFlagEnum==tradeStatFlagEnum.PAYING) {
								boundListOps.leftPush(json);
							}else if(tradeStatFlagEnum==tradeStatFlagEnum.FINISH_SUCCESS||tradeStatFlagEnum==tradeStatFlagEnum.FINISH_FAILED){
								//交易成功或者失败,发送异步通知通知商户
								BoundListOperations<String, String> boundListOperations = redisTemplate.boundListOps(TradeQueueEnum.NOTIFYSINGLETRADE.name());
								NotifyQueueBean notifyQueueBean = new NotifyQueueBean();
								notifyQueueBean.setSendDateTime(DateUtil.getCurrentDateTime());
								notifyQueueBean.setSendTimes(0);
								notifyQueueBean.setTxnseqno(txnsLogBean.getTxnseqno());
								boundListOperations.leftPush(JSON.toJSONString(notifyQueueBean));
							}
						}
					}else {
						boundListOps.leftPush(json);
					}
					break;
	
				default:
					break;
			}
			
		}
	}
}
