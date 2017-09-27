package com.unionpay.withhold.trade.fee.dao;

import com.unionpay.withhold.trade.fee.bean.FeeBean;

public interface FeeDAO {

	
	/**
	 * 获取商户手续费
	 * @param feeBean
	 * @return
	 */
	public Long getMerchFee(FeeBean feeBean);
	/**
	 * 渠道（代理商）手续费
	 * @param feeBean
	 * @return
	 */
	public Long getAgentFee(FeeBean feeBean);
	/**
	 * 通道（交易渠道）手续费
	 * @param feeBean
	 * @return
	 */
	public Long getAisleFee(FeeBean feeBean);
}
