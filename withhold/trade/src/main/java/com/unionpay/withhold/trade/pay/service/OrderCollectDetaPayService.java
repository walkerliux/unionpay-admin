package com.unionpay.withhold.trade.pay.service;

import java.util.List;

import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;

public interface OrderCollectDetaPayService {

	/**
	 * 查询批量代扣订单明细
	 * @param batchId
	 * @return
	 */
	public List<OrderCollectDetaPayDO> queryCollectOrderDeta(Long batchId);
	
	/**
	 * 更新批次明细状态
	 * @param record
	 * @return
	 */
	public int updateOrderStatus(OrderCollectDetaPayDO orderCollectDetaPay);
}
