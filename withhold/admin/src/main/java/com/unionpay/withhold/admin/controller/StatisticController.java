package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.TTxnsLogService;

@Controller
@RequestMapping("/statistic")
public class StatisticController {

	@Autowired
	private TTxnsLogService tTxnsLogService;
	/**
	 * 渠道统计页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showCoop")
	public ModelAndView showPassageway() {
		 ModelAndView result=new ModelAndView("/trade/statistic/coop_manager");
	     return result;
	}
	/**
	 *  通道统计页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("showChannel")
	public ModelAndView showChannel() {
		 ModelAndView result=new ModelAndView("/trade/statistic/channel_manager");
	     return result;
	}
	/**
	 * 商户统计页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("showMerchant")
	public ModelAndView showMerchant() {
		 ModelAndView result=new ModelAndView("/trade/statistic/merchant_manager");
	     return result;
	}
	/**
	 * 查询通道统计
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getChnlByPage")
	public PageBean getChannelByPage(String payinst,String retcode,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.findChannelByPage(payinst,retcode,stime,etime,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询渠道统计
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getCoopByPage")
	public PageBean getCoopByPage(String accfirmerno,String retcode,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.findCoopByPage(accfirmerno,retcode,stime,etime,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询商户统计
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getMerchantByPage")
	public PageBean getMerchantByPage(String accsecmerno,String retcode,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.findMerchantByPage(accsecmerno,retcode,stime,etime,page, rows);
		
		return resultBean;
		
	}
	
	/**
	 * 查询商户号所有核心流水
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getTnxLogInfoByMerno")
	public PageBean getTnxLogInfoByMerno(String accsecmerno,String retcode,String stime,String etime,int page,int rows){
		PageBean tTxnsLog=tTxnsLogService.getTnxLogInfoByMerno(accsecmerno,retcode,stime,etime,page, rows);
		
		return tTxnsLog;
	}
	/**
	 * 查询商户号所有核心流水
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getTnxLogInfoByCoopno")
	public PageBean getTnxLogInfoByCoopno(String accfirmerno,String retcode,String stime,String etime,int page,int rows){
		PageBean tTxnsLog=tTxnsLogService.getTnxLogInfoByCoopno(accfirmerno,retcode,stime,etime,page, rows);
		
		return tTxnsLog;
	}
	/**
	 * 查询商户号所有核心流水
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getTnxLogInfoByPayinst")
	public PageBean getTnxLogInfoByPayinst(String payinst,String retcode,String stime,String etime,int page,int rows){
		PageBean tTxnsLog=tTxnsLogService.getTnxLogInfoByPayinst(payinst,retcode,stime,etime,page, rows);
		
		return tTxnsLog;
	}
}
