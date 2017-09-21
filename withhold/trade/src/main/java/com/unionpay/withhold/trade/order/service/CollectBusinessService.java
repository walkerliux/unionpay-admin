package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectQueryBean;

public interface CollectBusinessService {

	/**
	 * 创建实时代扣订单
	 * @param singleCollectBean
	 * @return
	 */
	public ResultBean createSingleCollectOrder(final SingleCollectBean singleCollectBean);

	/**
	 * 创建批量代扣订单
	 * @param batchCollectBean
	 * @return
	 */
	public ResultBean createBatchCollectOrder(final BatchCollectBean batchCollectBean);
	
	/**
	 * 实时代扣订单查询
	 * @param singleCollectQueryBean
	 * @return
	 */
	public ResultBean querySingleCollectOrder(SingleCollectQueryBean singleCollectQueryBean);
}
