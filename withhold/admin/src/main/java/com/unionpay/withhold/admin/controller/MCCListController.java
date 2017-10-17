package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TMccList;
import com.unionpay.withhold.admin.service.MCCListService;

/**
 * MCCList
 * @author lianhai
 *
 */
@Controller
@RequestMapping("/mccList")
public class MCCListController {

	@Autowired
	private MCCListService mccListService;
	
	@RequestMapping("/queryByMcc")
	@ResponseBody
	public List<TMccList> queryByMcc(String mcc){
		return mcc == null ? null : mccListService.queryByMcc(mcc);
	}
}
