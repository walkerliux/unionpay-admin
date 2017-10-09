package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.service.RateAccumService;

@Controller
@RequestMapping("/rateAccum")
public class RateAccumController {
	@Autowired
	private RateAccumService rateAccumService;
	
	/**
	 * 扣率列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getAllRateList")
	public List<TRateAccum> getAllRateList(){
		return rateAccumService.getAllRateList();
	}
}
