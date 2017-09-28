package com.unionpay.withhold.trade.pay.service;

import com.unionpay.withhold.trade.pay.pojo.OrderCollectBatchPayDO;

public interface BatchOrderPayServcie {

	/**
	 * 查询代收批次数据
	 * @param tn
	 * @return
	 */
	public OrderCollectBatchPayDO getCollectBatchOrder(String tn);
}
