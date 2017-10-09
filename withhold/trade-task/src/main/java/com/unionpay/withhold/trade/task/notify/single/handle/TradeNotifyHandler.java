package com.unionpay.withhold.trade.task.notify.single.handle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.api.bean.TRspRoot;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.task.bean.ChannelEnum;
import com.unionpay.withhold.trade.task.bean.NotifyQueueBean;
import com.unionpay.withhold.trade.task.bean.TradeNotifyBean;
import com.unionpay.withhold.trade.task.dao.OrderCollectSingleTaskDAO;
import com.unionpay.withhold.trade.task.dao.RspmsgTaskDAO;
import com.unionpay.withhold.trade.task.dao.TxnLogTaskDAO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectSingleTaskDO;
import com.unionpay.withhold.trade.task.pojo.RspmsgTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnLogTaskDO;
import com.unionpay.withhold.utils.DateUtil;

@Component("tradeNotifyHandler")
public class TradeNotifyHandler implements EventHandler<TradeNotifyBean>{
	@Autowired
	private TxnLogTaskDAO txnLogTaskDAO;
	@Autowired
	private OrderCollectSingleTaskDAO orderCollectSingleTaskDAO;
	@Autowired
	private RspmsgTaskDAO rspmsgTaskDAO;
	@Override
	public void onEvent(TradeNotifyBean tradeNotifyBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		List<ResultBean> notifyResultList = Lists.newArrayList();
		for(NotifyQueueBean notifyQueueBean : tradeNotifyBean.getNotifyQueueBeanList()) {
			TxnLogTaskDO txnLog = txnLogTaskDAO.selectByPrimaryKey(notifyQueueBean.getTxnseqno());
			OrderCollectSingleTaskDO orderCollectSingle = orderCollectSingleTaskDAO.queryByTxnseqno(notifyQueueBean.getTxnseqno());
			ResultBean resultBean = sendSingleNotify(txnLog, orderCollectSingle);
			if(notifyQueueBean.getTxnsNotifyTask()==null) {
				resultBean.setSecondObj(orderCollectSingle);
			}else {
				resultBean.setSecondObj(notifyQueueBean.getTxnsNotifyTask());
			}
			notifyResultList.add(resultBean);
		}
		tradeNotifyBean.setNotifyResultList(notifyResultList);
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
