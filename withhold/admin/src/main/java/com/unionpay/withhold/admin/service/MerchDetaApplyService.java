package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;

public interface MerchDetaApplyService {
	/**
	 * 查询申请信息
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectApplyWithCondition(TMerchDetaApply merchDetaApply, Integer page,Integer rows);

	/**
	 * 注册商户
	 * @param merchDetaApply
	 * @return
	 */
	ResultBean addMerchDetaApply(TMerchDetaApply merchDetaApply);

	/**
	 * 查询商户申请信息详情
	 * @param selfId
	 * @return
	 */
	TMerchDetaApply queryMerchDetaApplyById(Long selfId);

}
