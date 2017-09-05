package com.unionpay.withhold.trade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(String data){
		
	    return "test trade ok!"+data;
	}
}

