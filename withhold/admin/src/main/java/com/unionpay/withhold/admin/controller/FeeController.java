package com.unionpay.withhold.admin.controller;

import org.apache.ibatis.javassist.tools.framedump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.service.FeeService;


@Controller
@RequestMapping("/fee")
public class FeeController {
	
	@Autowired
	private FeeService feeService;
	/**
	 * 交易金额分段扣率页面
	 * 
	 * @return
	 */
	@RequestMapping("/showRateAmt")
	public ModelAndView toCoopAgencyApply() {
		ModelAndView result=new ModelAndView("/fee/_rate_amt_accum_manager");
        return result;
	}
	
	/**
	 * 交易金额分段扣率查询 
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/queryAmtAccumRate")
	@ResponseBody
	public PageBean queryAmtAccumRate(String rateId,String rateDesc,int page,int rows) {
		PageBean resultBean =feeService.queryAmtAccumRate(rateId,rateDesc,page,rows);
	    return resultBean;
	}
	//
	
	/**
	 * 新增交易金额分段扣率
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/saveAmtAccumRate")
	@ResponseBody
	public PageBean saveAmtAccumRate(String rateId,String rateDesc) {
		//PageBean resultBean =feeService.saveAmtAccumRate(rateId,rateDesc,page,rows);
	    return null;
	}
}
