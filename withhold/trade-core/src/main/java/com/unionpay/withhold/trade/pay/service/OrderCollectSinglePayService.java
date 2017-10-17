package com.unionpay.withhold.trade.pay.service;

import com.unionpay.withhold.trade.pay.pojo.OrderCollectSinglePayDO;

public interface OrderCollectSinglePayService {

	/**
	 * 查询实时代扣订单
	 * @param orderCollectSinglePay
	 * @return
	 */
	public OrderCollectSinglePayDO querySingleCollectOrder(OrderCollectSinglePayDO orderCollectSinglePay);
	
	/**
	 * 更新实时代扣订单
	 * @param orderCollectSinglePay
	 */
	public void updateSingleCollectOrder(OrderCollectSinglePayDO orderCollectSinglePay);
}
