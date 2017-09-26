package com.unionpay.withhold.trade.pay.service;

import com.unionpay.withhold.bean.ResultBean;

public interface CollectPayService {

	/**
	 * 实时代扣交易方法
	 * @param tn
	 * @return
	 */
	public ResultBean singleCollectPay(String tn);
	/***
	 * 批量代扣交易方法
	 * @param tn
	 * @return
	 */
	public ResultBean batchCollectPay(String tn);
}
