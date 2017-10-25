package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TRisk;

public interface RiskService {
	/**
	 * 查询全部风控版本列表（风控版本代码、风控版本名称）
	 * @return
	 */
	List<TRisk> getAllRiskList();

	/**
	 * 查询风控分页信息
	 * 
	 * @param risk
	 * @return
	 */
	List<TRisk> selectRiskByCondition(TRisk risk);

	/**
	 * 添加风控版本信息
	 * @param risk
	 * @return
	 */
	ResultBean addRisk(TRisk risk);

	/**
	 * 修改版本信息
	 * @param risk
	 * @return
	 */
	ResultBean updateRisk(TRisk risk);

	/**
	 * 查询风控版本信息详情
	 * @param riskid
	 * @return
	 */
	TRisk queryRiskByRiskid(Long riskid);
}
