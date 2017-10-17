package com.unionpay.withhold.trade.route.service;

import java.util.List;

import com.unionpay.withhold.trade.route.bean.TradeRouteBean;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDO;

public interface TradeRouteService {

	/**
	 * 获取交易路由中的交易渠道（交易通道）
	 * @param tradeRoute
	 * @return
	 */
	public List<RouteConfigDO> getTradRouteList(TradeRouteBean tradeRoute);
}
