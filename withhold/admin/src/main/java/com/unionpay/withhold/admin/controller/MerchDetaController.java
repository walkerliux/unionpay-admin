package com.unionpay.withhold.admin.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.ParaDicCodeEnums;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.MerchDetaApplyService;
import com.unionpay.withhold.admin.service.MerchDetaService;
import com.unionpay.withhold.admin.service.ParaDicService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;


/**
 * 商户管理
 * @author 	lianhai
 * @date	2017年10月10日 15:16:06
 */
@Controller
@RequestMapping("/merchDeta")
public class MerchDetaController {
	@Autowired
	private MerchDetaApplyService merchDetaApplyService;
	@Autowired
	private MerchDetaService merchDetaService;
	@Autowired
	private ParaDicService paraDicService;
	@Autowired
	private UserService userService;
	

	/**
	 * 商户申请页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toApply", method = RequestMethod.GET)
	public String toMerchDetaApply() {
		return "/merchDeta/merch_deta_apply";
	}
	
	/**
	 * 商户审核页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCheck", method = RequestMethod.GET)
	public String toMerchDetaCheck() {
		return "/merchDeta/merch_deta_check";
	}
	
	/**
	 * 商户变更页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toModify", method = RequestMethod.GET)
	public String toMerchDetaModify() {
		return "/merchDeta/merch_deta_modify";
	}
	
	/**
	 * 商户查询页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toQuery", method = RequestMethod.GET)
	public String toMerchDetaQuery() {
		return "/merchDeta/merch_deta_query";
	}
	
	/**
	 * 商户秘钥页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toMK", method = RequestMethod.GET)
	public String toMerchDetaMK() {
		return "/merchDeta/merch_mk";
	}
	
	/**
	 * 商户通道配置页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toChnl", method = RequestMethod.GET)
	public String toMerchDetaChnl() {
		return "/merchDeta/merch_chnl";
	}
	
	/**
	 * 查询商户申请信息
	 * 
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApply")
	public PageBean queryMerchDetaApply(TMerchDetaApply merchDetaApply,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {

		if (null == merchDetaApply) {
			return null;
		} else {
			return merchDetaApplyService.selectApplyWithCondition(merchDetaApply, page, rows);
		}
	}
	
	
	/**
	 * 查询商户申请信息详情
	 * 
	 * @param selfId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApplyById")
	public TMerchDetaApply queryMerchDetaApplyById(Integer selfId) {
		if (selfId == null) {
			return null;
		}
		return merchDetaApplyService.queryMerchDetaApplyById(selfId);
	}
	
	/**
	 * 查询所有的交易要素
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/showAllTransfactors")
	public List<TParaDic> showAllTransfactors(){
		return paraDicService.selectParaDicByParentCode(ParaDicCodeEnums.TRANSFACTORS.getCode());
	}

	/**
	 * 新增商户信息(注册)
	 * @param merchDetaApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addApply")
	public ResultBean addMerchDetaApply(TMerchDetaApply merchDetaApply, HttpServletRequest request){
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		merchDetaApply.setInUser(infoByToken.getUserId().longValue());
		try {
			return merchDetaApplyService.addMerchDetaApply(merchDetaApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 被拒变更或注册待审的变更
	 * 
	 * @param merchDetaApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateApply")
	public ResultBean updateMerchDetaApply(TMerchDetaApply merchDetaApply, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		merchDetaApply.setInUser(infoByToken.getUserId().longValue());
		try {
			return merchDetaApplyService.updateMerchDetaApply(merchDetaApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 查询商户审核信息
	 * 
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCheck")
	public PageBean queryMerchDetaCheck(TMerchDetaApply merchDetaApply,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		if (null == merchDetaApply) {
			return null;
		} else {
			return merchDetaApplyService.selectCheckWithCondition(merchDetaApply, page, rows);
		}
	}
	
	/**
	 * 查询商户审核信息详情
	 * 
	 * @param selfId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCheckById")
	public TMerchDetaApply queryMerchDetaCheckById(Integer selfId) {
		return selfId == null ? null : merchDetaApplyService.queryMerchDetaCheckById(selfId);
	}
	
	/**
	 * 审核拒绝
	 * 
	 * @param request
	 * @param merchDetaApply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/refuseCheck")
	public ResultBean refuseCheck(HttpServletRequest request, TMerchDetaApply merchDetaApply) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		merchDetaApply.setStexaUser(infoByToken.getUserId().longValue());
		try {
			return merchDetaApplyService.refuseCheck(merchDetaApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 审核通过
	 * 
	 * @param request
	 * @param merchDetaApply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/passCheck")
	public ResultBean passCheck(HttpServletRequest request, TMerchDetaApply merchDetaApply) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		merchDetaApply.setStexaUser(infoByToken.getUserId().longValue());
		try {
			return merchDetaApplyService.passCheck(merchDetaApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 查询在用信息（在用：信息变动、注销）
	 * 
	 * @param merchDeta
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryModify")
	public PageBean queryMerchDetaModify(TMerchDeta merchDeta, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		if (null == merchDeta) {
			return null;
		} else {
			return merchDetaService.selectInUseWithCondition(merchDeta, page, rows);
		}
	}
	
	/**
	 * 查询在用信息详情(在用)
	 * 
	 * @param merchId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryModifyById")
	public TMerchDeta queryMerchDetaModifyById(Integer merchId) {
		return merchId == null ? null : merchDetaService.queryMerchDetaModifyById(merchId);
	}
	
	/**
	 * 在用的申请变更
	 * 
	 * @param merchDeta
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateInUse")
	public ResultBean updateMerchDetaInUse(TMerchDeta merchDeta, HttpServletRequest request) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		merchDeta.setInUser(infoByToken.getUserId().longValue());
		try {
			return merchDetaService.updateMerchDetaInUse(merchDeta);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 注销
	 * @param request
	 * @param merchDeta
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/commitLogout")
	public ResultBean commitLogout(HttpServletRequest request, TMerchDeta merchDeta) {
//		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
//		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
//		merchDeta.setInUser(infoByToken.getUserId().longValue());
		try {
			return merchDetaService.commitLogout(merchDeta);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 查询商户信息（全部或按条件）
	 * 
	 * @param merchDetaApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAll")
	public PageBean queryAllMerchDetaApply(TMerchDetaApply merchDetaApply,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		if (null == merchDetaApply) {
			return null;
		} else {
			return merchDetaApplyService.selectAllWithCondition(merchDetaApply, page, rows);
		}
	}
	
	/**
	 * 查询商户信息详情
	 * 
	 * @param selfId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryDetailById")
	public TMerchDetaApply queryMerchDetaDetailById(Integer selfId) {
		return selfId == null ? null : merchDetaApplyService.queryMerchDetaById(selfId);
	}
}
