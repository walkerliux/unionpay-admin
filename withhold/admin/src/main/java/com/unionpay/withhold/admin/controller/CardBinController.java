package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TCardBin;
import com.unionpay.withhold.admin.pojo.TbankInsti;
import com.unionpay.withhold.admin.service.CardBinService;
import com.unionpay.withhold.admin.service.OperationLogService;

@Controller
@RequestMapping("/bin")
public class CardBinController {
	@Autowired
	private OperationLogService operationLogService;
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
	public List<?> update(TCardBin bin,HttpServletRequest request) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			List<TbankInsti> TbankInstis = cardBinService.selectTbankInstis(bin.getBankcode());
			String bankcode = TbankInstis.get(0).getBankcode();
			bin.setBankcode(bankcode);
			int binlen = bin.getCardbin().length();
			bin.setBinlen((short)binlen);
			cardBinService.updateTCardBin(bin);
			operationLogService.addOperationLog(request, "修改cardbin");
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
	public List<?> save(TCardBin bin,HttpServletRequest request) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			List<TbankInsti> TbankInstis = cardBinService.selectTbankInstis(bin.getBankcode());
			String bankcode = TbankInstis.get(0).getBankcode();
			bin.setBankcode(bankcode);
			int binlen = bin.getCardbin().length();
			bin.setBinlen((short)binlen);
			
			cardBinService.saveTCardBin(bin);
			operationLogService.addOperationLog(request, "新增cardbin");
			list.add("保存成功");
		} catch (Exception e) {
			list.add("保存失败");
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
     * 关键字查询开户行
     */
    @ResponseBody
	@RequestMapping("/selectTbankInsti")
    public List<?> queryBankNode(String bankname, Integer page, Integer rows,HttpServletRequest request) { 
    	List<Map<String, Object>> resultList = Lists.newArrayList();

    	List<TbankInsti> bankInstis = cardBinService.selectTbankInstis(bankname);
    	for(TbankInsti map : bankInstis ){
    		Map<String, Object> valueMap = Maps.newHashMap();
    		valueMap.put("id",  map.getBankcode());
    		valueMap.put("text", map.getBankname());
    		resultList.add(valueMap);
    	}
    	return resultList;
     }
}
