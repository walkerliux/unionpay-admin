package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TMccDesc;
import com.unionpay.withhold.admin.service.MCCService;

/**
 * MCC
 * @author lianhai
 *
 */
@Controller
@RequestMapping("/mcc")
public class MCCController {

	@Autowired
	private MCCService mccService;
	
	@RequestMapping("/getAllMCC")
	@ResponseBody
	public List<TMccDesc> getAll(){
		return mccService.getAll();
	}
}
