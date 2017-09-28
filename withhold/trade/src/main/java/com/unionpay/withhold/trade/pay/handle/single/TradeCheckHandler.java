package com.unionpay.withhold.trade.pay.handle.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectSinglePayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectSinglePayService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;

@Component("tradeCheckHandler")
public class TradeCheckHandler implements EventHandler<TradeBean> {

	@Autowired
	private OrderCollectSinglePayService collectSinglePayService;
	@Autowired
	private TxnLogPayService TxnLogPayService;

	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		OrderCollectSinglePayDO record = new OrderCollectSinglePayDO();
		record.setTn(tradeBean.getTn());
		OrderCollectSinglePayDO orderCollectSingle = collectSinglePayService.querySingleCollectOrder(record);
		if(orderCollectSingle==null){//订单不存在
			resultBean = new ResultBean("PC029", "订单不存在");
		}else {
			tradeBean.setTxnseqno(orderCollectSingle.getRelatetradetxn());
			OrderStatusEnum orderStatus = OrderStatusEnum.fromValue(orderCollectSingle.getStatus());
			switch (orderStatus) {
				case INITIAL:
					break;
				case EXPIRE:
					resultBean = new ResultBean("PC031", "实时代扣订单失效");
					break;
				case FAILED:
					resultBean = new ResultBean("PC035", "交易失败");
					break;
				case FINISH:
					resultBean = new ResultBean("PC022", "订单支付成功，请不要重复支付");
					break;
				case PAYING:
					resultBean = new ResultBean("PC030", "实时代收订单正在交易中");
					break;
				default:
					break;
			}
		}
		if(resultBean == null) {
			TxnLogPayDO txnLogPay = TxnLogPayService.queryTxnLog(tradeBean.getTxnseqno());
			if(txnLogPay==null) {
				resultBean = new ResultBean("PC008", "交易流水不存在");
			}else {
				tradeBean.setTxnLogPayDO(txnLogPay);
				resultBean = new ResultBean("0000", "成功");
			}
		}else {
			resultBean.setResultBool(false);
		}
		
		tradeBean.setTradeCheck(resultBean);
	}

}
