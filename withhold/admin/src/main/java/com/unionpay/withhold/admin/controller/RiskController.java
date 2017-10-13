package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.service.RiskService;

@Controller
@RequestMapping("/risk")
public class RiskController {
	@Autowired
	private RiskService riskService;
	
	@ResponseBody
	@RequestMapping("/getAllRiskList")
	public List<TRisk> getAllRiskList(){
		return riskService.getAllRiskList();
	}
}
