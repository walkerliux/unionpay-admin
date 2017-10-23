package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TMerchMk;

public interface MerchMKService {

	TMerchMk queryMKById(String memberid);

	ResultBean submitMK(TMerchMk merchMk);

}
