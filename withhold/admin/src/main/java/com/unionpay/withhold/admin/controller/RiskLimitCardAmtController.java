package com.unionpay.withhold.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDay;
import com.unionpay.withhold.admin.service.LimitCardAmtService;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.utils.StringUtil;


@Controller
@RequestMapping("/riskLimitCardAmt")
public class RiskLimitCardAmtController {
	@Autowired
	private LimitCardAmtService limitCardAmtService;
	@Autowired
	private OperationLogService operationLogService;
	
	/**
	 * 查询银行卡单日累计限次
	 * @param limitMemNumsDay
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLimitMemNumsDay")
	public PageBean queryLimitMemNumsDay(String caseid,
			@RequestParam(defaultValue ="1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			caseids=null;
		}
		return limitCardAmtService.queryLimitMemNumsDay(caseids, page, rows);	
	}
	/**
	 * 保存银行卡单日累计限次
	 * @param limitAmountsPanDay
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveLimitMemNumDay")
	public ResultBean saveLimitMemNumDay(TLimitAmountsPanDay limitAmountsPanDay, HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
			
			try {
				operationLogService.addOperationLog(request, "保存银行卡单日累计限次");
				limitAmountsPanDay.setCaseid(caseids);
				return limitCardAmtService.saveLimitMemNumDay(limitAmountsPanDay);
			} catch (Exception e) {
				return new ResultBean("", "服务器异常，请稍后再试！");
			}
	}
	/**
	 * 查询一条银行卡单日限次
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLimitMumDaybytid")
	public TLimitAmountsPanDay queryLimitMumDaybytid(Integer tid) {
			return tid == null ? null:limitCardAmtService.queryLimitMemNumsDaybytid(tid);	
	}
	/**
	 * 修改银行卡单日限次
	 * @param limitAmountsPanDay
	 * @param riskid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateLimitMemMNumDay")
	public ResultBean updateLimitMemMNumDay(TLimitAmountsPanDay limitAmountsPanDay,HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
		try {
			operationLogService.addOperationLog(request, "修改商户单日限额");
			limitAmountsPanDay.setCaseid(caseids);
			return limitCardAmtService.updateLimitMemMNumDay( limitAmountsPanDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 注销银行卡累计次数
	 * @param limitAmountsPanDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteLimitMemNumDay")
	public ResultBean deleteLimitMemNumDay(HttpServletRequest request,TLimitAmountsPanDay limitAmountsPanDay) {
		
		try {
			operationLogService.addOperationLog(request, "注销商户累计次数");
			return limitCardAmtService.deleteLimitMemNumDay(limitAmountsPanDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 启用银行卡累计次数
	 * @param limitAmountsPanDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startLimitMemDay")
	public ResultBean startLimitMemDay(HttpServletRequest request,TLimitAmountsPanDay limitAmountsPanDay) {
		
		try {
			operationLogService.addOperationLog(request, "启用商户累计额数");
			return limitCardAmtService.startLimitMemDay(limitAmountsPanDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	
}
