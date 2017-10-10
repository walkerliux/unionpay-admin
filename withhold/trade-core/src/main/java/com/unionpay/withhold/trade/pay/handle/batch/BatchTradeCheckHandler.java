package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectBatchPayDO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.service.BatchOrderPayServcie;
import com.unionpay.withhold.trade.pay.service.OrderCollectDetaPayService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;

@Component("batchTradeCheckHandler")
public class BatchTradeCheckHandler implements EventHandler<TradeBean> {

	@Autowired
	private BatchOrderPayServcie batchOrderPayServcie;
	@Autowired
	private OrderCollectDetaPayService orderCollectDetaPayService;
	@Autowired
	private TxnLogPayService txnLogPayService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			OrderCollectBatchPayDO collectBatchOrder = batchOrderPayServcie.getCollectBatchOrder(tradeBean.getTn());
			if (collectBatchOrder == null) {
				resultBean = new ResultBean("PC029", "订单不存在");
			} else {
				OrderStatusEnum orderStatus = OrderStatusEnum.fromValue(collectBatchOrder.getStatus());
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

				List<OrderCollectDetaPayDO> orderDetaList = orderCollectDetaPayService.queryCollectOrderDeta(collectBatchOrder.getTid());
				List<OrderCollectDetaPayDO> removeList = Lists.newArrayList();
				//List<OrderCollectDetaPayDO> txnsLogList = Lists.newArrayList();
				for (OrderCollectDetaPayDO orderCollectDetaPay : orderDetaList) {
					if (OrderStatusEnum.INITIAL == OrderStatusEnum.fromValue(orderCollectDetaPay.getStatus())) {
						continue;
					}
					removeList.add(orderCollectDetaPay);
				}
				orderDetaList.removeAll(removeList);
				collectBatchOrder.setDetaList(orderDetaList);
				tradeBean.setCollectBatchOrder(collectBatchOrder);
				tradeBean.setTxnLogList(txnLogPayService.queryBatchDetaTxnLog(collectBatchOrder.getTid()));
			} 
		} catch (Exception e) {
			e.printStackTrace();
			resultBean = new ResultBean("PC035", "交易失败，系统异常");
			resultBean.setResultBool(false);
		}finally {
			tradeBean.setTradeCheck(resultBean);
		}
	}
}
