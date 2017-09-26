package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.MerchDetaDO;

public interface MerchDetaService {

	/**
	 * 通过会员号获取商户信息
	 * @param memberId
	 * @return
	 */
	public MerchDetaDO getMerchByMemberId(String memberId);
}
