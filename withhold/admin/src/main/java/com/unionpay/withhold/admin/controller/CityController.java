package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TCity;
import com.unionpay.withhold.admin.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {
	@Autowired
	private CityService cityService;
	
	@RequestMapping("/queryByProID")
	@ResponseBody
	public List<TCity> queryByProID(Long pId){
		return pId == null ? null : cityService.queryByProID(pId);
	}
}
