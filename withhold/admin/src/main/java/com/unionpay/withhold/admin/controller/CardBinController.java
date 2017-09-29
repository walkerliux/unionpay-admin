package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TCardBin;

import com.unionpay.withhold.admin.service.CardBinService;

@Controller
@RequestMapping("/bin")
public class CardBinController {
	
	@Autowired
	private CardBinService cardBinService;
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView result=new ModelAndView("/baseData/card_bin_manager");
        return result;
    }
	
	/**
	 * 查询
	 * s
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(TCardBin bin,int page,int rows){
		
		PageBean resultBean =cardBinService.findCardBinPage(bin,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 通过Id获取bin
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TCardBin getSingleById(String cardbin){
		TCardBin paraDic=cardBinService.getSingleById(cardbin);
		return paraDic;
	}
	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
   @RequestMapping("/update")
	public List<?> update(TCardBin bin) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			
			cardBinService.updateTCardBin(bin);
			
			list.add("更新成功");
		} catch (Exception e) {
			list.add("更新失败");
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 新增bin
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(TCardBin bin) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			int binlen = bin.getCardbin().length();
			bin.setBinlen((short)binlen);
			
			cardBinService.saveTCardBin(bin);
			list.add("保存成功");
		} catch (Exception e) {
			list.add("保存失败");
			e.printStackTrace();
		}
		
		return list;
	}
}
