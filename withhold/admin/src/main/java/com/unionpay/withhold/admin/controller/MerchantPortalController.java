package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.utils.ReadExcel;
import com.unionpay.withhold.trade.api.FEAPI;
import com.unionpay.withhold.trade.api.bean.BatchCollectDetaBean;
//merchant_portal/showDetails
@Controller
@RequestMapping("/portalManager")
public class MerchantPortalController {
	@Autowired
	private FEAPI feapi;
	/**
	 * 发起批量交易页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/startbatchtrade")
	public ModelAndView showStartBatchTrade() {
		 ModelAndView result=new ModelAndView("/merchant_portal/merch_batch_trade_manager");
	     return result;
	}
	/**
	 * 发起实时交易页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/startRealTimetrade")
	public ModelAndView startRealTimetrade() {
		 ModelAndView result=new ModelAndView("/merchant_portal/merch_realtime_trade_manager");
	     return result;
	}
	
	/**
	 * @return
	 * @author Administrator
	 * @param date
	 * 发起实时交易
	*/
	public void launchRealTimeTrade(){
		
	}
	/**
	 * @return
	 * @author Administrator
	 * @param date
	 * 解析excel
	*/
	@RequestMapping(value="/showDetails", method = RequestMethod.POST)
	@ResponseBody
	public List<BatchCollectDetaBean> showDetails(@RequestParam("excelFile") MultipartFile excelFile, HttpServletRequest request,HttpServletResponse response){
		
		//判断文件是否为空
        if(excelFile==null){ return null;}
        //获取文件名
        String name=excelFile.getOriginalFilename();
        //进一步判断文件是否为空（即判断其大小是否为0或其名称是否为null）
        long size=excelFile.getSize();
        if(name==null || ("").equals(name) && size==0){ return null;}
        
        ReadExcel readExcel=new ReadExcel();
        //解析excel，获取客户信息集合。
        List<BatchCollectDetaBean> dateList = readExcel.getExcelInfo(name ,excelFile);
        //批量导入。参数：文件名，文件。
        
       return dateList;
	}
	/**
	 * @return
	 * @author Administrator
	 * @param date
	 * 发起批量交易
	*/
	@RequestMapping("")
	public void launchBatchTrade(){
		
		
	}
}
