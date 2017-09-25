package com.unionpay.withhold.admin.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import com.unionpay.withhold.admin.Bean.PageBean;


public interface OperationLogService {

	PageBean findLogByPage(String userId, String userName, Date beginDate,
			Date endDate, int page, int rows);
	void addOperationLog(HttpServletRequest request,String opContent);
}
