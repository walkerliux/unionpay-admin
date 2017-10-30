package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;

public interface FeeService {

	PageBean queryAmtAccumRate(String rateId, String rateDesc, int page,
			int rows);

}
