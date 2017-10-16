package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TRateAccum;

public interface RateAccumService {
	/**
	 * 扣率列表
	 * @return
	 */
	List<TRateAccum> getAllRateList();
}
