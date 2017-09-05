package com.unionpay.withhold.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商户
 * @author: zhangshd
 * @date:   2017年5月17日 下午1:51:42   
 * @version :v1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(String data){
		
	    return "test ok!"+data;
	}
}

