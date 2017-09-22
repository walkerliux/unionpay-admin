package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.bean.SingleCollectQueryBean;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;

public interface OrderCollectSingleService {

	/**
	 * 保存实时代收订单
	 * @param orderCollectSingle
	 */
	public void saveOrderCollectSingle(OrderCollectSingleDO orderCollectSingle);

	/**
	 * 查询商户实时代扣订单
	 * @param merchNo
	 * @param orderNo
	 * @return
	 */
	public OrderCollectSingleDO getOrderinfoByOrderNoAndMerchNo(String merchNo, String orderNo);
	
	/**
	 * 查询实时代扣订单（商户接口）
	 * @param singleCollectQueryBean
	 * @return
	 */
	public OrderCollectSingleDO queryOrderinfo(SingleCollectQueryBean singleCollectQueryBean);
}
