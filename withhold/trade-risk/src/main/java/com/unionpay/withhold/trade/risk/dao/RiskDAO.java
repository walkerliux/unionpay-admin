package com.unionpay.withhold.trade.risk.dao;

import java.util.List;
import java.util.Map;

import com.unionpay.withhold.trade.risk.bean.RiskBean;

public interface RiskDAO {

	/**
	 * 商户交易风控
	 * @param riskBean
	 * @return
	 */
	List<Map<String, Object>> merchRiskControl(RiskBean riskBean);
	
	/**
	 * 渠道（代理商）交易风控
	 * @param riskBean
	 * @return
	 */
	List<Map<String, Object>> agentRiskControl(RiskBean riskBean);
	
	/**
	 * 通道（交易渠道）交易风控
	 * @param riskBean
	 * @return
	 */
	List<Map<String, Object>> aisleRiskControl(RiskBean riskBean);
}
