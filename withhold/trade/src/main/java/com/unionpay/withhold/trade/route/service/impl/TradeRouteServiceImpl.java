package com.unionpay.withhold.trade.route.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.route.bean.TradeRouteBean;
import com.unionpay.withhold.trade.route.dao.RouteConfigDAO;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDO;
import com.unionpay.withhold.trade.route.service.TradeRouteService;
@Service
public class TradeRouteServiceImpl implements TradeRouteService {

	@Autowired
	private RouteConfigDAO routeConfigDAO;
	@Override
	@Transactional(readOnly=true)
	public List<RouteConfigDO> getTradRouteList(TradeRouteBean tradeRoute) {
		return routeConfigDAO.getTradeRoute(tradeRoute);
	}

}
