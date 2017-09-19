package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;

public interface BatchOrderServcie {

	/**
	 * 保存批量代扣订单
	 * @param orderCollectBatch
	 */
	public void saveBatchOrder(OrderCollectBatchDO orderCollectBatch);
}
