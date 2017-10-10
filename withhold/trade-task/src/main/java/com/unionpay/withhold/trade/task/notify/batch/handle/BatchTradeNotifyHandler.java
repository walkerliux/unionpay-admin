package com.unionpay.withhold.trade.task.notify.batch.handle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.task.bean.BatchTradeDetaBean;
import com.unionpay.withhold.trade.task.bean.BatchTradeNotifyBean;
import com.unionpay.withhold.trade.task.bean.NotifyQueueBean;
import com.unionpay.withhold.trade.task.bean.TradeNotifyBean;
import com.unionpay.withhold.trade.task.dao.OrderCollectBatchTaskDAO;
import com.unionpay.withhold.trade.task.dao.OrderCollectDetaTaskDAO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectBatchTaskDO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectDetaTaskDO;

@Component("batchTradeNotifyHandler")
public class BatchTradeNotifyHandler implements EventHandler<TradeNotifyBean>{
	@Autowired
	private OrderCollectBatchTaskDAO orderCollectBatchTaskDAO;
	@Autowired
	private OrderCollectDetaTaskDAO orderCollectDetaTaskDAO;
	@Override
	public void onEvent(TradeNotifyBean tradeNotifyBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		List<ResultBean> notifyResultList = Lists.newArrayList();
		for(NotifyQueueBean notifyQueueBean : tradeNotifyBean.getNotifyQueueBeanList()) {
			OrderCollectBatchTaskDO orderCollectBatch = orderCollectBatchTaskDAO.queryByTN(notifyQueueBean.getTn());
			List<OrderCollectDetaTaskDO> orderCollectDetaList = orderCollectDetaTaskDAO.queryByBatchid(orderCollectBatch.getTid());
			ResultBean resultBean = sendBatchTradeNotify(orderCollectBatch, orderCollectDetaList);
			if(notifyQueueBean.getTxnsNotifyTask()==null) {
				resultBean.setSecondObj(orderCollectBatch);
			}else {
				resultBean.setSecondObj(notifyQueueBean.getTxnsNotifyTask());
			}
			notifyResultList.add(resultBean);
		}
		tradeNotifyBean.setNotifyResultList(notifyResultList);
	}
	
	public ResultBean sendBatchTradeNotify(OrderCollectBatchTaskDO orderCollectBatch,List<OrderCollectDetaTaskDO> orderCollectDetaList) {
		ResultBean resultBean = null;
		BatchTradeNotifyBean batchTradeNotifyBean = new BatchTradeNotifyBean();
		batchTradeNotifyBean.setVersion(orderCollectBatch.getVersion());// 版本
		batchTradeNotifyBean.setEncoding(orderCollectBatch.getEncoding());// 编码方式
		batchTradeNotifyBean.setTxnType(orderCollectBatch.getTxntype());// 交易类型
		batchTradeNotifyBean.setTxnSubType(orderCollectBatch.getTxnsubtype());// 交易子类
		batchTradeNotifyBean.setBizType(orderCollectBatch.getBiztype());// 产品类型
		batchTradeNotifyBean.setMerId(orderCollectBatch.getMerid());//委托机构号
		batchTradeNotifyBean.setBatchNo(orderCollectBatch.getBatchno());// 商户订单号
		batchTradeNotifyBean.setTxnTime(orderCollectBatch.getTxntime());// 订单发送时间
		
		batchTradeNotifyBean.setFactorId(orderCollectBatch.getFactorid());//交易要素id
		batchTradeNotifyBean.setTotalQty(orderCollectBatch.getTotalqty().toString());//总笔数
		batchTradeNotifyBean.setTotalAmt(orderCollectBatch.getTotalamt().toString());//总金额
		List<BatchTradeDetaBean> collectDetaList = Lists.newArrayList();
		for(OrderCollectDetaTaskDO orderCollectDeta : orderCollectDetaList) {
			BatchTradeDetaBean batchTradeDetaBean = new BatchTradeDetaBean();
			batchTradeDetaBean.setOrderId(orderCollectDeta.getOrderid());;//商户订单号
			batchTradeDetaBean.setCurrencyCode(orderCollectDeta.getCurrencycode());;//交易币种
			batchTradeDetaBean.setAmt(orderCollectDeta.getAmt());;//单笔金额
			batchTradeDetaBean.setCardNo(orderCollectDeta.getCardno());;//银行卡号
			batchTradeDetaBean.setCardType(orderCollectDeta.getCardtype());;//卡类型
			batchTradeDetaBean.setCustomerNm(orderCollectDeta.getCustomernm());;//持卡人姓名
			batchTradeDetaBean.setCertifTp(orderCollectDeta.getCertiftp());;//证件类型
			batchTradeDetaBean.setCertifId(orderCollectDeta.getCertifid());;//证件号
			batchTradeDetaBean.setPhoneNo(orderCollectDeta.getPhoneno());;//手机号
			batchTradeDetaBean.setCvn2(orderCollectDeta.getCvn2());;//cvn2
			batchTradeDetaBean.setExpired(orderCollectDeta.getExpired());;//卡有效期
			batchTradeDetaBean.setOrderStatus(orderCollectDeta.getStatus());;//订单状态
			collectDetaList.add(batchTradeDetaBean);
		}
		batchTradeNotifyBean.setFileContent(JSON.toJSONString(collectDetaList));//文件内容
		
		resultBean = new ResultBean("0000", "成功");
		return resultBean;
	}
}
