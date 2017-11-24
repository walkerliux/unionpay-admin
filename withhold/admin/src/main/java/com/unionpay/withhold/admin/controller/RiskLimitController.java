package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitMemNumsDay;
import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.service.LimitService;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.service.ParaDicService;
import com.unionpay.withhold.admin.service.RiskService;
import com.unionpay.withhold.admin.utils.StringUtil;

@Controller
@RequestMapping("/riskLimitNum")
public class RiskLimitController {
	@Autowired
	private RiskService riskService;
	@Autowired
	private ParaDicService paraDicService;
	@Autowired
	private LimitService limitService;
	@Autowired
	private OperationLogService operationLogService;
	/**
	 * 查询风控列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllLimitRiskList")
	public List<TRisk> getAllRiskList(){
		return limitService.getAllLimitRiskList();
	}
	
	/**
	 * 查询商户单日累计限次
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
		return limitService.queryLimitMemNumsDay(caseids, page, rows);	
	}
	/**
	 * 保存商户单日累计限次
	 * @param limitMenNumsDay
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveLimitMemNumDay")
	public ResultBean saveLimitMemNumDay(TLimitMemNumsDay limitMenNumsDay, HttpServletRequest request,String caseid) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
			
			try {
				operationLogService.addOperationLog(request, "保存商户单日累计限额");
				limitMenNumsDay.setCaseid(caseids);
				return limitService.saveLimitMemNumDay(limitMenNumsDay);
			} catch (Exception e) {
				return new ResultBean("", "服务器异常，请稍后再试！");
			}
	}
	/**
	 * 查询一条商户单日限次
	 * @param tid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryLimitMumDaybytid")
	public TLimitMemNumsDay queryLimitMumDaybytid(Integer tid) {
			return tid == null ? null:limitService.queryLimitMemNumsDaybytid(tid);	
	}
	/**
	 * 修改商户单日限次
	 * @param limitMenNumsDay
	 * @param riskver
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateLimitMemMNumDay")
	public ResultBean updateLimitMemMNumDay(TLimitMemNumsDay limitMenNumsDay,String caseid, HttpServletRequest request) {
		Long caseids;
		if(StringUtil.isNotEmpty(caseid)){
			caseids=Long.valueOf(caseid);
		}else{
			return  new ResultBean("", "风控版本不能为空！");
		}
		try {
			operationLogService.addOperationLog(request, "修改商户单日限额");
			limitMenNumsDay.setCaseid(caseids);
			return limitService.updateLimitMemMNumDay( limitMenNumsDay);
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
	@RequestMapping("/deleteLimitMemNumDay")
	public ResultBean deleteLimitMemNumDay(TLimitMemNumsDay limitMenNumsDay, HttpServletRequest request) {
		
		try {
			operationLogService.addOperationLog(request, "注销商户累计次数");
			return limitService.deleteLimitMemNumDay(limitMenNumsDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	/**
	 * 启用商户累计次数
	 * @param limitMenNumsDay
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startLimitMemDay")
	public ResultBean startLimitMemDay(TLimitMemNumsDay limitMenNumsDay, HttpServletRequest request) {
		
		try {
			operationLogService.addOperationLog(request, "启用商户累计额数");
			return limitService.startLimitMemDay(limitMenNumsDay);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
