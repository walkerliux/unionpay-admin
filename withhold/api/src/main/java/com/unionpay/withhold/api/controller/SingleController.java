package com.unionpay.withhold.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 批量代收付接口
 * @author: 张世栋
 * @date: 2017年9月25日10:48:49
 * @version 1.0
 */
@Controller
@RequestMapping("/single/")
public class SingleController {

	private Logger log = LoggerFactory.getLogger(SingleController.class);
	@ResponseBody
	@RequestMapping("notice")
	public String notice(String data) {
		//TODO:逻辑处理
		
		return "success";
	}
}
