package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TMerchDeta;

public interface MerchDetaService {

	/**
	 * 查询在用信息（在用：信息变动、注销）
	 * @param merchDeta
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectInUseWithCondition(TMerchDeta merchDeta, Integer page, Integer rows);

	/**
	 * 查询在用信息详情(在用)
	 * @param merchId
	 * @return
	 */
	TMerchDeta queryMerchDetaModifyById(Integer merchId);

	/**
	 * 在用的申请变更
	 * @param merchDeta
	 * @return
	 */
	ResultBean updateMerchDetaInUse(TMerchDeta merchDeta);

	/**
	 * 注销
	 * @param merchDeta
	 * @return
	 */
	ResultBean commitLogout(TMerchDeta merchDeta);
	
}
