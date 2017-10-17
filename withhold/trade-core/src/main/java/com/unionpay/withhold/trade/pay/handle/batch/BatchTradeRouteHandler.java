package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
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
		ResultBean resultBean = null;
		try {
			if(tradeBean.getFinalTrade()!=null) {
				if(!tradeBean.getFinalTrade().isResultBool()) {
					resultBean = tradeBean.getFinalTrade();
					return;
				}
			}
			
			TradeRouteBean tradeRoute = new TradeRouteBean();
			tradeRoute.setTransTime(DateUtil.getCurrentTime());
			tradeRoute.setBusicode(tradeBean.getBusinessEnum().getCode());
			//tradeRoute.setBankcode(tradeBean.getTxnLogPayDO().getCardinstino());
			tradeRoute.setStatus("00");
			//tradeRoute.setCardtype(tradeBean.getTxnLogPayDO().getCardtype());
			tradeRoute.setRoutver(tradeBean.getTxnLogList().get(0).getRoutver());
			tradeRoute.setTransAmt(tradeBean.getCollectBatchOrder().getTotalamt());
			List<RouteConfigDO> tradRouteList = tradeRouteService.getTradRouteList(tradeRoute);
			if(tradRouteList.size()<=0) {
				resultBean = new ResultBean("PC010", "无可用交易渠道");
				resultBean.setResultBool(false);
			}else {
				Queue<RouteConfigDO> tradeChnlQueue = new ConcurrentLinkedQueue<>();
				tradeChnlQueue.addAll(tradRouteList);
				tradeBean.setChnlCode(tradeChnlQueue.poll().getChnlcode());
				tradeBean.setTradeChnlQueue(tradeChnlQueue);
				resultBean = new ResultBean("0000", "成功");
				tradeBean.setFinalTrade(resultBean);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			tradeBean.setChnlCode("");
			e.printStackTrace();
			resultBean = new ResultBean("PC035", "交易失败，系统异常");
			resultBean.setResultBool(false);
		}finally {
			tradeBean.setTradeRoute(resultBean);
		}
		
	}

}
