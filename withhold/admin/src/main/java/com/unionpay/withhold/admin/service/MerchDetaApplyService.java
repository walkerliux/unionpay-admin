package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
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

}
