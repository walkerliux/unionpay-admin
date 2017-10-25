package com.unionpay.withhold.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.service.TTxnsLogService;

@Controller
@RequestMapping("/report")
public class ReportFromController {
	@Autowired
	private TTxnsLogService tTxnsLogService;
	/**
	 * 渠道月分润报表页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showCoopMonthCount")
	public ModelAndView showCoopMonthCount() {
		 ModelAndView result=new ModelAndView("/trade/report/coop_month_count_manager");
	     return result;
	}
	/**
	 * 渠道月分润报表页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showPingTaiMonthCount")
	public ModelAndView showPingTaiMonthCount() {
		 ModelAndView result=new ModelAndView("/trade/report/pingtai_month_count_manager");
	     return result;
	}
	/**
	 * 商户日结算分润报表页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showMerchDayCount")
	public ModelAndView showMerchDayCount() {
		 ModelAndView result=new ModelAndView("/trade/report/merch_day_count_manager");
	     return result;
	}
	
	/**
	 * 查询商户日分润
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getMerchDayCountByPage")
	public PageBean getMerchDayCountByPage(String accsecmerno,String dayormonth,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getMerchDayCountByPage(accsecmerno,dayormonth,stime,etime,page, rows);
		
		return resultBean;
		
	}

	/**
	 * 查询商户日分润详情
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getMerDayCountInfo")
	public PageBean getMerDayCountInfo(String accsecmerno,String txndate,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getMerDayCountInfo(accsecmerno,txndate,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询渠道月分润
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getCoopMonthCountByPage")
	public PageBean getCoopMonthCountByPage(String accfirmerno,String year,String month,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getCoopMonthCountByPage(accfirmerno,year,month,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询渠道月分润详情
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getCoopMonthCountInfo")
	public PageBean getCoopMonthCountInfo(String accfirmerno,String txndate,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getCoopMonthCountInfo(accfirmerno,txndate,page, rows);
		
		return resultBean;
		
	}
}
