package com.unionpay.withhold.trade.task.scheduled;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.api.bean.TRspRoot;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.bean.enums.TradeQueueEnum;
import com.unionpay.withhold.trade.task.bean.ChannelEnum;
import com.unionpay.withhold.trade.task.bean.NotifyQueueBean;
import com.unionpay.withhold.trade.task.bean.NotifyStatusEnum;
import com.unionpay.withhold.trade.task.dao.OrderCollectSingleTaskDAO;
import com.unionpay.withhold.trade.task.dao.RspmsgTaskDAO;
import com.unionpay.withhold.trade.task.dao.TxnLogTaskDAO;
import com.unionpay.withhold.trade.task.dao.TxnsNotifyTaskDAO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectSingleTaskDO;
import com.unionpay.withhold.trade.task.pojo.RspmsgTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnLogTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnsNotifyTaskDO;
import com.unionpay.withhold.utils.DateUtil;

@Component
public class TradeNotifyTask {
	private final static Logger log = LoggerFactory.getLogger(TradeNotifyTask.class);
	@Autowired
	private TxnLogTaskDAO txnLogTaskDAO;
	@Autowired
	private OrderCollectSingleTaskDAO orderCollectSingleTaskDAO;
	@Autowired
	private TxnsNotifyTaskDAO txnsNotifyTaskDAO;
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private RspmsgTaskDAO rspmsgTaskDAO;
	@Scheduled(cron="")
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void singleTradeNotify() {
		BoundListOperations<String, String> boundListOps = redisTemplate.boundListOps(TradeQueueEnum.NOTIFYSINGLETRADE.name());
		Long size = boundListOps.size();
		for(int i=0;i<size.intValue();i++) {
			String json = boundListOps.rightPop();
			if(StringUtils.isEmpty(json)) {
				continue;
			}
			NotifyQueueBean notifyQueueBean = JSON.parseObject(json, NotifyQueueBean.class);
			if(Long.valueOf(DateUtil.getCurrentDateTime())<Long.valueOf(notifyQueueBean.getSendDateTime())){//没有到通知时间，不发送信息，重回队列
				log.info("【异步通知队列数据,txnseqno:"+notifyQueueBean.getTxnseqno()+"异步通知时间:"+notifyQueueBean.getSendDateTime()+" 未到发送时间】");
				boundListOps.leftPush(JSON.toJSONString(notifyQueueBean));
				continue;
			}
			TxnsNotifyTaskDO txnsNotifyTask = txnsNotifyTaskDAO.queryByTxnseqno(notifyQueueBean.getTxnseqno());
			if(txnsNotifyTask!=null) {
				if("00".equals(txnsNotifyTask.getSendStatus())){
					log.info("【异步通知队列数据,txnseqno:"+notifyQueueBean.getTxnseqno()+"异步通知完成】");
					continue;
				}
				
			}
			TxnLogTaskDO txnLog = txnLogTaskDAO.selectByPrimaryKey(notifyQueueBean.getTxnseqno());
			OrderCollectSingleTaskDO orderCollectSingle = orderCollectSingleTaskDAO.queryByTxnseqno(notifyQueueBean.getTxnseqno());
			ResultBean resultBean = sendSingleNotify(txnLog,orderCollectSingle);
			
			if(txnsNotifyTask==null) {
				txnsNotifyTask = new TxnsNotifyTaskDO();
				txnsNotifyTask.setMemberId(orderCollectSingle.getOrderid());
			    txnsNotifyTask.setTxnseqno(notifyQueueBean.getTxnseqno());
			    txnsNotifyTask.setSendTimes((short)1);
			    txnsNotifyTask.setMaxSendTimes((short)5);
			    txnsNotifyTask.setNotifyUrl(orderCollectSingle.getBackurl());
			    txnsNotifyTask.setTaskType("1");
			    txnsNotifyTask.setTardeType("02");
			    String httpRescode = (String) resultBean.getResultObj();
			    txnsNotifyTask.setHttpRescode(httpRescode);
				if(resultBean.isResultBool()) {
					txnsNotifyTask.setSendStatus(NotifyStatusEnum.SUCCESS.value());
				}else {
					txnsNotifyTask.setSendStatus(NotifyStatusEnum.DOING.value());
				}
				txnsNotifyTaskDAO.insert(txnsNotifyTask);
			}else {
				short sendtimes = (short) (txnsNotifyTask.getSendTimes().shortValue()+1);
				txnsNotifyTask.setSendTimes(sendtimes);
				String httpRescode = (String) resultBean.getResultObj();
				txnsNotifyTask.setHttpRescode(httpRescode);
				if(resultBean.isResultBool()) {
					txnsNotifyTask.setSendStatus(NotifyStatusEnum.SUCCESS.value());
				}else {
					if(sendtimes>=txnsNotifyTask.getMaxSendTimes()) {
						txnsNotifyTask.setSendStatus(NotifyStatusEnum.FAILED.value());
					}else {
						txnsNotifyTask.setSendStatus(NotifyStatusEnum.DOING.value());
					}
					
				}
				txnsNotifyTaskDAO.updateByPrimaryKey(txnsNotifyTask);
			}
		}
		
	}
	
	public ResultBean sendSingleNotify(TxnLogTaskDO txnLog,OrderCollectSingleTaskDO orderCollectSingle) {
		TRspRoot rspRoot = new TRspRoot();
		// 版本号
		rspRoot.setVersion(orderCollectSingle.getVersion());
		// 编码方式
		rspRoot.setEncoding(orderCollectSingle.getEncoding());
		// 证书ID
		rspRoot.setCertId(orderCollectSingle.getCertid());
		// 签名方式
		rspRoot.setSignMethod("01");
		// 交易类型
		rspRoot.setTransType(orderCollectSingle.getTxntype());
		// 系统订单号
		rspRoot.setOrderId(orderCollectSingle.getOrderid());
		// 系统商户号
		rspRoot.setMchntCd(orderCollectSingle.getMerid());
		// 扣款类型
		rspRoot.setDkType(orderCollectSingle.getDktype());
		// 交易金额
		rspRoot.setTransAt(orderCollectSingle.getTxnamt().toString());
		// 交易币种
		rspRoot.setAtType(orderCollectSingle.getCurrencycode());
		// 订单发送时间
		rspRoot.setTransTm(orderCollectSingle.getTxntime());
		// 交易查询流水号
		rspRoot.setQueryId(orderCollectSingle.getTn());
		
		RspmsgTaskDO record = new RspmsgTaskDO();
		record.setChnltype(ChannelEnum.fromValue(txnLog.getPayinst()).getChnlType());
		record.setChnlrspcode(txnLog.getPayretcode());
		record.setRetcode(txnLog.getRetcode());
		RspmsgTaskDO rspmsg = rspmsgTaskDAO.queryRspmsg(record);
		// 应答码
		rspRoot.setRespCod(rspmsg.getApicode());
		// 应答信息
		rspRoot.setRespMsg(rspmsg.getApiinfo());
		// 清算金额
		Long settleAmt = txnLog.getAmount()-txnLog.getTxnfee();
		rspRoot.setSettleAt(settleAmt.toString());
		// 清算币种
		rspRoot.setSettleType(orderCollectSingle.getCurrencycode());
		// 清算日期
		rspRoot.setSettleDate(DateUtil.skipDate(txnLog.getTxndate(), 1));
		// 兑换日期
		rspRoot.setExchangeDate("");
		// 清算汇率
		rspRoot.setExchangeRate("");
		String notifyURL = orderCollectSingle.getBackurl();
		//暂无发送方法
		
		ResultBean resultBean = new ResultBean("0000", "成功");
		return resultBean;
	}
}
