package com.unionpay.withhold.admin.controller;

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
	 * 通道统计页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showPassageway")
	public ModelAndView showPassageway() {
		 ModelAndView result=new ModelAndView("/trade/statistic/passageway_manager");
	     return result;
	}
	/**
	 * 渠道统计页面
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
    @RequestMapping("/getPassagewayByPage")
	public PageBean getPassagewayByPage(String payinst,String apporderstatus,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.findPassagewayByPage(payinst,apporderstatus,stime,etime,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询渠道统计
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getChannelByPage")
	public PageBean getChannelByPage(String pathcode,String apporderstatus,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.findChannelByPage(pathcode,apporderstatus,stime,etime,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询商户统计
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getMerchantByPage")
	public PageBean getMerchantByPage(String accsecmerno,String apporderstatus,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.findMerchantByPage(accsecmerno,apporderstatus,stime,etime,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询商户统计
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TTxnsLog getSingleById(String txnseqno){
		TTxnsLog tTxnsLog=tTxnsLogService.queryDetailsById(txnseqno);
		
		return tTxnsLog;
	}
}
