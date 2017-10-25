package com.unionpay.withhold.admin.service;

import java.util.List;

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
}
