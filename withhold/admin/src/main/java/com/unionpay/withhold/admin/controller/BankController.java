package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TBank;

import com.unionpay.withhold.admin.service.BankService;

@Controller
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView result=new ModelAndView("/baseData/bank_manager");
        return result;
    }
	/**
	 * 查询
	 * s
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(TBank bank,int page,int rows){
		
		PageBean resultBean =bankService.findBankPage(bank,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 通过Id获取bank
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TBank getSingleById(Long tid){
		TBank paraDic=bankService.getSingleById(tid);
		return paraDic;
	}
	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
   @RequestMapping("/update")
	public List<?> update(TBank bank) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			
			bankService.updateTBank(bank);
			
			list.add("更新成功");
		} catch (Exception e) {
			list.add("更新失败");
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 新增bank
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(TBank bank) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			
			bankService.saveTBank(bank);
			list.add("保存成功");
		} catch (Exception e) {
			list.add("保存失败");
			e.printStackTrace();
		}
		
		return list;
	}
}
