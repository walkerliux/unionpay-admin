package com.unionpay.withhold.admin.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;
import com.unionpay.withhold.admin.service.CoopAgencyApplyService;

/**
 * 渠道（代理商管理）
 * @author 	lianhai
 * @date	2017年9月20日 11:28:57
 */
@Controller
@RequestMapping("/coopAgency")
public class CoopAgencyController {
	@Autowired
	private CoopAgencyApplyService coopAgencyApplyService;
	
	@RequestMapping(value = "/toApply", method = RequestMethod.GET)
	public String toCoopAgencyApply(){
		return "/coopAgency/coop_agency_apply";
	}
	
	/**
	 * 查询渠道申请信息
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryApply")
	public PageBean queryCoopAgencyApply(TCoopAgencyApply coopAgencyApply,Integer page,Integer rows) {
		TCoopAgencyApplyExample coopAgencyApplyExample = new TCoopAgencyApplyExample();
		TCoopAgencyApplyExample.Criteria criteria = coopAgencyApplyExample.createCriteria();
		if (null == coopAgencyApply) {
			return null;
		}else if (StringUtils.isNotBlank(coopAgencyApply.getCacode())) {
			criteria.andCacodeEqualTo(coopAgencyApply.getCacode());
		}else if (StringUtils.isNotBlank(coopAgencyApply.getCaname())) {
			criteria.andCanameEqualTo(coopAgencyApply.getCaname());
		}else if (StringUtils.isNotBlank(coopAgencyApply.getSupercode())) {
			criteria.andSupercodeEqualTo(coopAgencyApply.getSupercode());
		}else if (null != coopAgencyApply.getInuser()) {
			criteria.andInuserEqualTo(coopAgencyApply.getInuser());
		}else if (StringUtils.isNotBlank(coopAgencyApply.getStatus())) {
			criteria.andStatusEqualTo(coopAgencyApply.getStatus());
		}	
		coopAgencyApplyExample.setPageNum(page);
		coopAgencyApplyExample.setPageSize(rows);
		coopAgencyApplyExample.setOrderByClause("SELF_ID DESC");
		
		return coopAgencyApplyService.queryByPage(coopAgencyApplyExample);
	}
	
	/**
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/addApply")
	public ResultBean addCoopAgencyApply(TCoopAgencyApply coopAgencyApply, HttpServletRequest request){
		coopAgencyApply.setInuser((long) 1);
		coopAgencyApply.setIntime(new Date());
		return coopAgencyApplyService.addCoopAgencyApply(coopAgencyApply);
	}
	
}
