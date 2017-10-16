package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCoopAgency;

public interface CoopAgencyService {
	List<TCoopAgency> queryAllSuperCode(String supercode);
	
	/**
	 * 查询在用表中的信息
	 * @param coopAgency
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectInUseWithCondition(TCoopAgency coopAgency, Integer page, Integer rows);

	/**
	 * 查询渠道申请信息详情
	 * @param caid
	 * @return
	 */
	TCoopAgency queryCoopAgencyModifyById(Long caid);
	
	/**
	 * 在用渠道信息变更
	 * @param coopAgency
	 * @return
	 */
	ResultBean updateCoopAgencyInUse(TCoopAgency coopAgency);

	/**
	 * 在用渠道注销申请
	 * @param coopAgency
	 * @return
	 */
	ResultBean commitLogout(TCoopAgency coopAgency);
}
