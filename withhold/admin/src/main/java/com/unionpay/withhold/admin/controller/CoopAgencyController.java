package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.CoopAgencyStatusEnums;
import com.unionpay.withhold.admin.pojo.TCoopAgency;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;
import com.unionpay.withhold.admin.service.CoopAgencyApplyService;
import com.unionpay.withhold.admin.service.CoopAgencyService;

/**
 * 渠道（代理商管理）
 * 
 * @author lianhai
 * @date 2017年9月20日 11:28:57
 */
@Controller
@RequestMapping("/coopAgency")
public class CoopAgencyController {
	@Autowired
	private CoopAgencyApplyService coopAgencyApplyService;
	@Autowired
	private CoopAgencyService agencyService;

	/**
	 * 渠道申请页面
	 * @return
	 */
	@RequestMapping(value = "/toApply", method = RequestMethod.GET)
	public String toCoopAgencyApply() {
		return "/coopAgency/coop_agency_apply";
	}

	/**
	 * 渠道审核页面
	 * @return
	 */
	@RequestMapping(value = "/toCheck", method = RequestMethod.GET)
	public String toCoopAgencyCheck() {
		return "/coopAgency/coop_agency_check";
	}
	
	/**
	 * 渠道变更页面
	 * @return
	 */
	@RequestMapping(value = "/toModify", method = RequestMethod.GET)
	public String toCoopAgencyModify() {
		return "/coopAgency/coop_agency_modify";
	}

	/**
	 * 查询渠道申请信息
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApply")
	public PageBean queryCoopAgencyApply(TCoopAgencyApply coopAgencyApply,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		TCoopAgencyApplyExample coopAgencyApplyExample = new TCoopAgencyApplyExample();
		TCoopAgencyApplyExample.Criteria criteria = coopAgencyApplyExample.createCriteria();
		if (null == coopAgencyApply) {
			return null;
		} else if (StringUtils.isNotBlank(coopAgencyApply.getCacode())) {
			criteria.andCacodeEqualTo(coopAgencyApply.getCacode());
		} else if (StringUtils.isNotBlank(coopAgencyApply.getCaname())) {
			criteria.andCanameEqualTo(coopAgencyApply.getCaname());
		} else if (StringUtils.isNotBlank(coopAgencyApply.getSupercode())) {
			criteria.andSupercodeEqualTo(coopAgencyApply.getSupercode());
		} else if (null != coopAgencyApply.getInuser()) {
			criteria.andInuserEqualTo(coopAgencyApply.getInuser());
		} else if (StringUtils.isNotBlank(coopAgencyApply.getStatus())) {
			criteria.andStatusEqualTo(coopAgencyApply.getStatus());
		}

		// 查询待审及未过的
		criteria.andStatusBetween(CoopAgencyStatusEnums.UPDATEBEFORECHECKING.getCode(),
				CoopAgencyStatusEnums.REGISTERCHECKREFUSED.getCode());
		coopAgencyApplyExample.setPageNum(page);
		coopAgencyApplyExample.setPageSize(rows);
		coopAgencyApplyExample.setOrderByClause("SELF_ID DESC");

		return coopAgencyApplyService.queryByPage(coopAgencyApplyExample);
	}

	/**
	 * 查询渠道申请信息详情
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryApplyById")
	public TCoopAgencyApply queryCoopAgencyApplyById(Long selfId) {
		if (selfId == null) {
			return null;
		}
		return coopAgencyApplyService.queryCoopAgencyApplyById(selfId);
	}

	/**
	 * 注册
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addApply")
	public ResultBean addCoopAgencyApply(TCoopAgencyApply coopAgencyApply, HttpServletRequest request) {
		coopAgencyApply.setInuser((long) 1);
		coopAgencyApply.setIntime(new Date());
		coopAgencyApply.setStatus(CoopAgencyStatusEnums.REGISTERCHECKING.getCode());
		if (coopAgencyApply.getSupercode().equals("0")) {
			coopAgencyApply.setCalevel((short) 1);
		}
		return coopAgencyApplyService.addCoopAgencyApply(coopAgencyApply);
	}

	/**
	 * 审核通过前的变更
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateApply")
	public ResultBean updateCoopAgencyApply(TCoopAgencyApply coopAgencyApply, HttpServletRequest request) {
		coopAgencyApply.setInuser((long) 1);
		coopAgencyApply.setIntime(new Date());
		coopAgencyApply.setStatus(CoopAgencyStatusEnums.REGISTERCHECKING.getCode());
		if (coopAgencyApply.getSupercode().equals("0")) {
			coopAgencyApply.setCalevel((short) 1);
		}
		
		try {
			return coopAgencyApplyService.updateCoopAgencyApply(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("","服务器异常，请稍后再试！");			
		}
	}

	/**
	 * 查询上级渠道
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAllSuperCode")
	public List<TCoopAgency> queryAllSuperCode(String supercode) {
		return this.agencyService.queryAllSuperCode(supercode);
	};

	/**
	 * 查询渠道申请信息
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCheck")
	public PageBean queryCoopAgencyCheck(TCoopAgencyApply coopAgencyApply,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		if (null == coopAgencyApply) {
			return null;
		} else {
			return coopAgencyApplyService.selectWithCondition(coopAgencyApply, page, rows);
		}
	}
	
	/**
	 * 查询渠道申请信息详情
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryCheckById")
	public TCoopAgencyApply queryCoopAgencyCheckById(Long selfId) {
		return selfId == null ? null : coopAgencyApplyService.queryCoopAgencyCheckById(selfId);
	}
	
	/**
	 * 审核拒绝
	 * @param request
	 * @param coopAgencyApply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/refuseCheck")
	public ResultBean refuseCheck(HttpServletRequest request, TCoopAgencyApply coopAgencyApply){
		coopAgencyApply.setStexaUser((long) 1);
		try {
			return coopAgencyApplyService.refuseCheck(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("","服务器异常，请稍后再试！");	
		}
	}
	
	/**
	 * 审核通过
	 * @param request
	 * @param coopAgencyApply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/passCheck")
	public ResultBean passCheck(HttpServletRequest request, TCoopAgencyApply coopAgencyApply){
		coopAgencyApply.setStexaUser((long) 1);
		try {
			return coopAgencyApplyService.passCheck(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("","服务器异常，请稍后再试！");	
		}
	}
	
	/**
	 * 查询渠道变更信息
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryModify")
	public PageBean queryCoopAgencyModify(TCoopAgency coopAgency,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		if (null == coopAgency) {
			return null;
		} else {
			return agencyService.selectWithCondition(coopAgency, page, rows);
		}
	}
	
	/**
	 * 查询渠道申请信息详情
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryModifyById")
	public TCoopAgency queryCoopAgencyModifyById(Long caid) {
		return caid == null ? null : agencyService.queryCoopAgencyModifyById(caid);
	}
}
