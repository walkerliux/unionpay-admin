package com.unionpay.withhold.trade.order.service;

import java.util.List;

import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;

public interface OrderCollectDetaService {

	/**
	 * 保存批次订单明细
	 * @param orderCollectDeta
	 */
	public void saveOrderCollectDeta(OrderCollectDetaDO orderCollectDeta);

	/**
	 * 查询批量代扣订单明细
	 * @param batchId
	 * @return
	 */
	public List<OrderCollectDetaDO> queryCollectOrderDeta(Long batchId);
}
