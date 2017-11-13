package com.unionpay.withhold.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TRiskTradeLog;
import com.unionpay.withhold.admin.service.RiskTradeService;

@Controller
@RequestMapping("/riskTrade")
public class RiskTradeLogController {
	@Autowired
	private RiskTradeService riskTradeService;
	
	/**
	 * 风控日志查询页面
	 * @author: 
	 * @return ModelAndView
	 * @version v1.0
	 */
	@RequestMapping("/showRiskRradeLog")
	public ModelAndView showRiskRradeLog() {
		 ModelAndView result=new ModelAndView("/trade/risk/t_risk_trade_log");
	     return result;
	}
	/**
	 * 获取好易联实时交易
	 * @param batchno
	 * @param page rows
	 * @return
	 */
	@RequestMapping("/getRiskRradeLogByPage")
	@ResponseBody
	public PageBean getRiskRradeLogByPage(TRiskTradeLog riskTradeLog,String stime,String etime,int page,int rows) {
		PageBean result =riskTradeService.getRiskRradeLogByPage(riskTradeLog,stime,etime,page,rows);
	    return result;
	}

}
