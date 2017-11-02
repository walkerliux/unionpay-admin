package com.unionpay.withhold.admin.service;

import java.util.Map;

import com.unionpay.withhold.admin.Bean.AccumRateBean;
import com.unionpay.withhold.admin.Bean.PageBean;

public interface FeeService {

	PageBean queryAmtAccumRate(String rateId, String rateDesc, int page,
			int rows);

	void addAmtAccumRate(AccumRateBean accumRateBean);

	PageBean queryAccumRateDeta(String rateId);

	void updateAccumRate(AccumRateBean accumRateBean);

	PageBean querySpecialfee(String rateId, String rateDesc, int page, int rows);

	void savespefee(AccumRateBean accumRateBean);

	PageBean querySpecialFeeDeta(String rateId);

	void updateSpecialFeeRate(AccumRateBean accumRateBean);

}
