package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Queues;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.route.bean.TradeRouteBean;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDO;
import com.unionpay.withhold.trade.route.service.TradeRouteService;
import com.unionpay.withhold.utils.DateUtil;
@Component("batchTradeRouteHandler")
public class BatchTradeRouteHandler implements EventHandler<TradeBean>{
	
	@Autowired
	private TradeRouteService tradeRouteService;
	
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		try {
			TradeRouteBean tradeRoute = new TradeRouteBean();
			tradeRoute.setTransTime(DateUtil.getCurrentTime());
			tradeRoute.setBusicode(tradeBean.getBusinessEnum().getCode());
			//tradeRoute.setBankcode(tradeBean.getTxnLogPayDO().getCardinstino());
			tradeRoute.setStatus("00");
			//tradeRoute.setCardtype(tradeBean.getTxnLogPayDO().getCardtype());
			tradeRoute.setRoutver(tradeBean.getTxnLogPayDO().getRoutver());
			tradeRoute.setTransAmt(tradeBean.getCollectBatchOrder().getTotalamt());
			List<RouteConfigDO> tradRouteList = tradeRouteService.getTradRouteList(tradeRoute);
			if(tradRouteList.size()>0) {
				Queue<RouteConfigDO> tradeChnlQueue = Queues.newConcurrentLinkedQueue();
				tradeChnlQueue.addAll(tradRouteList);
				tradeBean.setChnlCode(tradeChnlQueue.poll().getChnlcode());
				tradeBean.setTradeChnlQueue(tradeChnlQueue);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tradeBean.setChnlCode("");
		}finally {
			
		}
		
	}

}
