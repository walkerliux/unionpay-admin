package com.unionpay.withhold.trade.pay.handle.batch;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectDetaPayService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
@Component("batchTradeChannelHandler")
public class BatchTradeChannelHandler implements EventHandler<TradeBean>{
	
	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private OrderCollectDetaPayService orderCollectDetaPayService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		//判断交易是否被风控系统拒绝
		ResultBean finalTrade = null;
		try {
			for(TxnLogPayDO txnLogPay : txnLogPayService.queryBatchDetaTxnLog(tradeBean.getCollectBatchOrder().getTid())) {
				//校验全部通过
				txnLogPay.setAccretcode("0000");
				txnLogPay.setAccretinfo("受理成功");
				txnLogPayService.updateTxnLogPay(txnLogPay);
				//更新批次明细状态
				OrderCollectDetaPayDO orderCollectDetaPay = new  OrderCollectDetaPayDO();
				orderCollectDetaPay.setStatus(OrderStatusEnum.PAYING.getCode());
				orderCollectDetaPay.setRelatetradetxn(txnLogPay.getTxnseqno());
				orderCollectDetaPayService.updateOrderStatus(orderCollectDetaPay);
				//更细批次明细状态
			}
			if("1000001".equals(tradeBean.getChnlCode())) {
				finalTrade = new ResultBean("0000","交易已受理");
			}else if("1000002".equals(tradeBean.getChnlCode())) {
				finalTrade = new ResultBean("0000","交易已受理");
			}else {
				finalTrade = new ResultBean("PC038", "系统异常，请稍后查询结果");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			finalTrade = new ResultBean("PC038", "系统异常，请稍后查询结果");
		}finally {
			tradeBean.setFinalTrade(finalTrade);
		}
	}

}
