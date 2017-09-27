package com.unionpay.withhold.trade.pay.handle.single;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.route.bean.TradeRouteBean;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDO;
import com.unionpay.withhold.trade.route.service.TradeRouteService;
import com.unionpay.withhold.utils.DateUtil;
@Component("tradeRouteHandler")
public class TradeRouteHandler  implements EventHandler<TradeBean> {

	@Autowired
	private TradeRouteService tradeRouteService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		TradeRouteBean tradeRoute = new TradeRouteBean();
		tradeRoute.setTransTime(DateUtil.getCurrentTime());
		tradeRoute.setBusiCode(tradeBean.getBusinessEnum().getCode());
		tradeRoute.setBankcode(tradeBean.getTxnLogPayDO().getCardinstino());
		tradeRoute.setStatus("00");
		tradeRoute.setCardType(tradeBean.getTxnLogPayDO().getCardtype());
		tradeRoute.setRoutver(tradeBean.getTxnLogPayDO().getRoutver());
		tradeRoute.setTransAmt(tradeBean.getTxnLogPayDO().getAmount());
		List<RouteConfigDO> tradRouteList = tradeRouteService.getTradRouteList(tradeRoute);
		Queue<RouteConfigDO> tradeChnlQueue = new ConcurrentLinkedQueue<>();
		tradeChnlQueue.addAll(tradRouteList);
		tradeBean.setChnlCode(tradeChnlQueue.poll().getChnlcode());
		tradeBean.setTradeChnlQueue(tradeChnlQueue);
	}

}
