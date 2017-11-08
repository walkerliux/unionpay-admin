package com.unionpay.withhold.admin.service;


import com.unionpay.withhold.admin.pojo.TMerchMk;
import com.unionpay.withhold.admin.pojo.TParaDic;

public interface PortalService {

	TParaDic getTransfactors(String loginName);
	TMerchMk getCertId(String loginName);

}
