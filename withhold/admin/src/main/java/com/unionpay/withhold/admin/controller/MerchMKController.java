package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.ParaDicCodeEnums;
import com.unionpay.withhold.admin.pojo.TMerchMk;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.service.MerchMKService;
import com.unionpay.withhold.admin.service.ParaDicService;

/**
 * 商户密钥
 * @author lianhai
 * @date 2017年10月20日 15:00:34
 */
@Controller
@RequestMapping("/merchMK")
public class MerchMKController {

	@Autowired
	private MerchMKService merchMKService;
	@Autowired
	private ParaDicService paraDicService;
	
	/**
	 * 查询商户密钥详情
	 * 
	 * @param memberid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryMKById")
	public TMerchMk queryMKById(String memberid) {
		if (memberid == null) {
			return null;
		}
		return merchMKService.queryMKById(memberid);
	}
	
	/**
	 * 查询所有的安全类型
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showAllSafeType")
	public List<TParaDic> showAllSafeType(){
		return paraDicService.selectParaDicByParentCode(ParaDicCodeEnums.SAFETYPE.getCode());
	}
	
	/**
	 * 查询所有的存储方式
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showAllStorgeType")
	public List<TParaDic> showAllStorgeType(){
		return paraDicService.selectParaDicByParentCode(ParaDicCodeEnums.STORGETYPE.getCode());
	}
	
	/**
	 * 
	 * @param merchMk
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/submitMK")
	public ResultBean submitMK(TMerchMk merchMk, HttpServletRequest request){
		try {
			return merchMk == null ? new ResultBean("", "提交的信息有误！") :merchMKService.submitMK(merchMk);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
