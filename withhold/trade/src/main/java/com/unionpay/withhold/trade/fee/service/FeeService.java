package com.unionpay.withhold.trade.fee.service;

import com.unionpay.withhold.trade.fee.bean.FeeBean;

public interface FeeService {

	/**
	 * 获取商户交易手续费
	 * @param feeBean
	 * @return
	 */
	public Long getMerchFee(FeeBean feeBean);
	
	/**
	 * 获取通道手续费（渠道成功）
	 * @param feeBean
	 * @return
	 */
	public Long getAisleFee(FeeBean feeBean);
	
	/**
	 * 获取渠道（代理商）手续费
	 * @param feeBean
	 * @return
	 */
	public Long getAgentFee(FeeBean feeBean);
}
