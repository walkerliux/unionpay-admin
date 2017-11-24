package com.unionpay.withhold.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitNumsPanDay;
import com.unionpay.withhold.admin.service.LimitCardNumService;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.utils.StringUtil;
;

@Controller
@RequestMapping("/riskLimitCardNum")
public class RiskLimitCardNumController {
	@Autowired
	private LimitCardNumService limitCardNumService;
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
		return limitCardNumService.queryLimitMemNumsDay(caseids, page, rows);	
	}
	/**
	 * 保存银行卡单日累计限次
	 * @param limitNumsPanDay
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveLimitMemNumDay")
	public ResultBean saveLimitMemNumDay(TLimitNumsPanDay limitNumsPanDay, HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
			
			try {
				operationLogService.addOperationLog(request, "保存商户单日累计限额");
				limitNumsPanDay.setCaseid(caseids);
				return limitCardNumService.saveLimitMemNumDay(limitNumsPanDay);
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
	public TLimitNumsPanDay queryLimitMumDaybytid(Integer tid) {
			return tid == null ? null:limitCardNumService.queryLimitMemNumsDaybytid(tid);	
	}
	/**
	 * 修改银行卡单日限次
	 * @param limitNumsPanDay
	 * @param riskid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateLimitMemMNumDay")
	public ResultBean updateLimitMemMNumDay(TLimitNumsPanDay limitNumsPanDay, HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
		try {
			operationLogService.addOperationLog(request, "修改银行卡单日限次");
			limitNumsPanDay.setCaseid(caseids);
			return limitCardNumService.updateLimitMemMNumDay( limitNumsPanDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 注销银行卡累计次数
	 * @param limitNumsPanDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteLimitMemNumDay")
	public ResultBean deleteLimitMemNumDay( HttpServletRequest request,TLimitNumsPanDay limitNumsPanDay) {
		
		try {
			operationLogService.addOperationLog(request, "注销商户累计次数");
			return limitCardNumService.deleteLimitMemNumDay(limitNumsPanDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 启用银行卡累计次数
	 * @param limitNumsPanDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startLimitMemDay")
	public ResultBean startLimitMemDay( HttpServletRequest request,TLimitNumsPanDay limitNumsPanDay) {
		
		try {
			operationLogService.addOperationLog(request, "启用商户累计额数");
			return limitCardNumService.startLimitMemDay(limitNumsPanDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
