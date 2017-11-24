package com.unionpay.withhold.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitAmountsMemDay;
import com.unionpay.withhold.admin.service.LimitAmountService;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.utils.StringUtil;



@Controller
@RequestMapping("/riskLimitAmount")
public class RiskLimitAmountController {
	@Autowired
	private LimitAmountService limitAmountService;
	@Autowired
	private OperationLogService operationLogService;
	/**
	 * 查询商户单日累计限额
	 * @param limitMemNumsDay
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLimitMemNumsDay")
	public PageBean queryLimitMemAmountsDay(String caseid,
			@RequestParam(defaultValue ="1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			caseids=null;
		}
		return limitAmountService.queryLimitMemAmountsDay(caseids, page, rows);	
	}
	/**
	 * 保存商户单日累计限额
	 * @param limitMenNumsDay
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveLimitMemAmountDay")
	public ResultBean saveLimitMemAmountDay(TLimitAmountsMemDay limitMenAmountsDay, HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
			
			try {
				operationLogService.addOperationLog(request, "保存商户单日累计限额");
				limitMenAmountsDay.setCaseid(caseids);
				return limitAmountService.saveLimitMemAmountDay(limitMenAmountsDay);
			} catch (Exception e) {
				return new ResultBean("", "服务器异常，请稍后再试！");
			}
	}
	/**
	 * 查询一条商户单日限额
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLimitMumDaybytid")
	public TLimitAmountsMemDay queryLimitMumDaybytid(Integer tid) {
			return tid == null ? null:limitAmountService.queryLimitMemAmountsDaybytid(tid);	
	}
	/**
	 * 修改商户单日限额
	 * @param limitMenNumsDay
	 * @param riskid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateLimitMemMNumDay")
	public ResultBean updateLimitMemMNumDay(TLimitAmountsMemDay limitMenAmountsDay, HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
		try {
			
			operationLogService.addOperationLog(request, "修改商户单日限额");
			limitMenAmountsDay.setCaseid(caseids);
			return limitAmountService.updateLimitMemMAmountDay( limitMenAmountsDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 注销商户累计次数
	 * @param limitMenNumsDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteLimitMemAmountDay")
	public ResultBean deleteLimitMemAmountDay(TLimitAmountsMemDay limitMenAmountsDay, HttpServletRequest request) {
		
		try {
			operationLogService.addOperationLog(request, "注销商户累计次数");
			return limitAmountService.deleteLimitMemAmountDay(limitMenAmountsDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 启用商户累计额数
	 * @param limitMenAmountsDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startLimitMemDay")
	public ResultBean startLimitMemDay(TLimitAmountsMemDay limitMenAmountsDay, HttpServletRequest request) {
		
		try {
			operationLogService.addOperationLog(request, "启用商户累计额数");
			return limitAmountService.startLimitMemDay(limitMenAmountsDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
