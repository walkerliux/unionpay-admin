package com.unionpay.withhold.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;
import com.unionpay.withhold.admin.service.BankService;

/**
 * 商户
 * @author: zhangshd
 * @date:   2017年5月17日 下午1:51:42   
 * @version :v1.0
 */
@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private BankService bankService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test(String data){
	    return "test ok!1233443"+data;
	}
	
	
	@RequestMapping(value = "/testQueryByPage", method = RequestMethod.GET)
	@ResponseBody
	public PageBean testQueryByPage(int pageNum){
		TBankExample bankExample = new TBankExample();
		bankExample.setPageNum(pageNum);
		bankExample.setPageSize(10);
		return bankService.queryByPage(bankExample);
	}
	
	@RequestMapping(value = "/testAdd", method = RequestMethod.POST)
	@ResponseBody
	public ResultBean testAdd(String data){
		TBank bank = new TBank();
		//bank.setTid("2");
		bank.setBankcode("622848");
		bank.setBankname("农业银行");
		return this.bankService.addBank(bank);
	}
}

	
