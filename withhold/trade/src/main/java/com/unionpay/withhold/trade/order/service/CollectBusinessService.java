package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;

public interface CollectBusinessService {

	/**
	 * 创建实时代扣订单
	 * @param singleCollectBean
	 * @return
	 */
	public ResultBean createSingleCollectOrder(SingleCollectBean singleCollectBean);

}
