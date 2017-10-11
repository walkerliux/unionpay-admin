package com.unionpay.withhold.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.service.MerchDetaApplyService;

/**
 * 商户管理
 * @author 	lianhai
 * @date	2017年10月10日 15:16:06
 */
@Controller
@RequestMapping("/merchDeta")
public class MerchDetaController {
	@Autowired
	private MerchDetaApplyService merchDetaApplyService;
	
	/**
	 * 商户申请页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toApply", method = RequestMethod.GET)
	public String toMerchDetaApply() {
		return "/merchDeta/merch_deta_apply";
	}
	
	/**
	 * 商户审核页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCheck", method = RequestMethod.GET)
	public String toMerchDetaCheck() {
		return "/merchDeta/merch_deta_check";
	}
	
	/**
	 * 商户变更页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toModify", method = RequestMethod.GET)
	public String toMerchDetaModify() {
		return "/merchDeta/merch_deta_modify";
	}
	
	/**
	 * 商户查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toQuery", method = RequestMethod.GET)
	public String toMerchDetaQuery() {
		return "/merchDeta/merch_deta_query";
	}
	
	/**
	 * 商户秘钥页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toMK", method = RequestMethod.GET)
	public String toMerchDetaMK() {
		return "/merchDeta/merch_mk";
	}
	
	/**
	 * 商户通道配置页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toChnl", method = RequestMethod.GET)
	public String toMerchDetaChnl() {
		return "/merchDeta/merch_chnl";
	}
	
	/**
	 * 查询渠道申请信息
	 * 
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApply")
	public PageBean queryMerchDetaApply(TMerchDetaApply merchDetaApply,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {

		if (null == merchDetaApply) {
			return null;
		} else {
			return merchDetaApplyService.selectApplyWithCondition(merchDetaApply, page, rows);
		}
	}
}
