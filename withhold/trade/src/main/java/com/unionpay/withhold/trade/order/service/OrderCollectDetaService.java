package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;

public interface OrderCollectDetaService {

	/**
	 * 保存批次订单明细
	 * @param orderCollectDeta
	 */
	public void saveOrderCollectDeta(OrderCollectDetaDO orderCollectDeta);
}
