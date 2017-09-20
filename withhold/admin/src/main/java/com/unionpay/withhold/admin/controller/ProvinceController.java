package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.pojo.TProvince;
import com.unionpay.withhold.admin.service.ProvinceService;

@Controller
@RequestMapping("/province")
public class ProvinceController {
	@Autowired
	private ProvinceService provinceService;
	
	@RequestMapping("/getAll")
	@ResponseBody
	public List<TProvince> getAll(){
		return provinceService.getAll();
	}
}
