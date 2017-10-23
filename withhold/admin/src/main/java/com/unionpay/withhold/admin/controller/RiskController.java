package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.service.RiskService;

@Controller
@RequestMapping("/risk")
public class RiskController {
	@Autowired
	private RiskService riskService;
	
	/**
	 * 风控版本管理
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toRiskManager", method = RequestMethod.GET)
	public String toRiskManager() {
		return "/risk/risk_manager";
	}
	
	/**
	 * 银行卡黑名单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardBlackList", method = RequestMethod.GET)
	public String toCardBlackList() {
		return "/risk/card_black_list";
	}
	
	/**
	 * 持卡人黑名单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardholderBlackList", method = RequestMethod.GET)
	public String toCardholderBlackList() {
		return "/risk/cardholder_black_list";
	}
	
	/**
	 * 银行卡白名单
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardWhiteList", method = RequestMethod.GET)
	public String toCardWhiteList() {
		return "/risk/card_white_list";
	}
	
	/**
	 * 单笔限额
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toSingleLimit", method = RequestMethod.GET)
	public String toSingleLimit() {
		return "/risk/single_limit";
	}
	
	/**
	 * 商户日累计限次
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toMerchDayNumLimit", method = RequestMethod.GET)
	public String toMerchDayNumLimit() {
		return "/risk/merch_day_num_limit";
	}
	
	/**
	 * 商户日累计限额
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toMerchDayAmtLimit", method = RequestMethod.GET)
	public String toMerchDayAmtLimit() {
		return "/risk/merch_day_amt_limit";
	}
	
	/**
	 * 银行卡单日限次
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardDayNumLimit", method = RequestMethod.GET)
	public String toCardDayNumLimit() {
		return "/risk/card_day_num_limit";
	}
	
	/**
	 * 银行卡单日限额
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCardDayAmtLimit", method = RequestMethod.GET)
	public String toCardDayAmtLimit() {
		return "/risk/card_day_amt_limit";
	}
	
	@ResponseBody
	@RequestMapping("/getAllRiskList")
	public List<TRisk> getAllRiskList(){
		return riskService.getAllRiskList();
	}
}
