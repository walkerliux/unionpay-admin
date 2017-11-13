package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TRiskTradeLog;

public interface RiskTradeService {

	PageBean getRiskRradeLogByPage(TRiskTradeLog riskTradeLog, String stime,
			String etime, int page, int rows);

}
