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
	TMerchDetaApply queryMerchDetaApplyById(Integer selfId);

	/**
	 * 被拒变更或注册待审的变更
	 * @param merchDetaApply
	 * @return
	 */
	ResultBean updateMerchDetaApply(TMerchDetaApply merchDetaApply);

	/**
	 * 查询商户审核信息
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectCheckWithCondition(TMerchDetaApply merchDetaApply, Integer page, Integer rows);

	/**
	 * 查询商户审核信息详情
	 * @param selfId
	 * @return
	 */
	TMerchDetaApply queryMerchDetaCheckById(Integer selfId);

	/**
	 * 审核拒绝
	 * @param merchDetaApply
	 * @return
	 */
	ResultBean refuseCheck(TMerchDetaApply merchDetaApply);

	/**
	 * 审核通过
	 * @param merchDetaApply
	 * @return
	 */
	ResultBean passCheck(TMerchDetaApply merchDetaApply);

	/**
	 * 查询商户信息（全部或按条件）
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectAllWithCondition(TMerchDetaApply merchDetaApply, Integer page, Integer rows);
	
	/**
	 * 查询商户信息详情
	 * @param selfId
	 * @return
	 */
	TMerchDetaApply queryMerchDetaById(Integer selfId);
}
