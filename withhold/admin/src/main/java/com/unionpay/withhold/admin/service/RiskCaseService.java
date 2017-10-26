package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TRiskCase;

public interface RiskCaseService {
	/**
	 * 查询风控实例信息
	 * @param riskver
	 * @return
	 */
	TRiskCase queryRiskCaseByRiskver(String riskver);

	/**
	 * 配置风控版本-添加
	 * @param riskCase
	 * @return
	 */
	ResultBean addRiskCase(TRiskCase riskCase);

	/**
	 * 配置风控版本-修改
	 * @param riskCase
	 * @return
	 */
	ResultBean updateRiskCase(TRiskCase riskCase);
	
	/**
	 * 风控策略信息转换
	 * @param strategies
	 * @return
	 */
	String changRiskStrategy(String[] strategies);
}
