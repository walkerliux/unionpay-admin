package com.unionpay.withhold.trade.risk.service;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.risk.bean.RiskBean;
import com.unionpay.withhold.trade.risk.pojo.RiskTradeLogDO;

public interface TradeRiskService {

	/**
	 * 商户交易风控
	 * @param riskBean
	 * @return
	 */
	public ResultBean merchRiskControl(RiskBean riskBean);
	
	/**
	 * 渠道（代理商）交易风控
	 * @param riskBean
	 * @return
	 */
	public ResultBean agentRiskControl(RiskBean riskBean);
	
	/**
	 * 通道（交易渠道）交易风控
	 * @param riskBean
	 * @return
	 */
	public ResultBean aisleRiskControl(RiskBean riskBean);
	
	/**
	 * 保存风险交易
	 * @param riskTradeLogDO
	 */
	public void saveRiskTradeLog(RiskTradeLogDO riskTradeLog);
	
}
