package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.LoginUser;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCoopAgency;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toApply", method = RequestMethod.GET)
	public String toCoopAgencyApply() {
		return "/coopAgency/coop_agency_apply";
	}

	/**
	 * 渠道审核页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toCheck", method = RequestMethod.GET)
	public String toCoopAgencyCheck() {
		return "/coopAgency/coop_agency_check";
	}

	/**
	 * 渠道变更页面
	 * 
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

		if (null == coopAgencyApply) {
			return null;
		} else {
			return coopAgencyApplyService.selectApplyWithCondition(coopAgencyApply, page, rows);
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
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		coopAgencyApply.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return coopAgencyApplyService.addCoopAgencyApply(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/**
	 * 被拒变更或注册待审的变更
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateApply")
	public ResultBean updateCoopAgencyApply(TCoopAgencyApply coopAgencyApply, HttpServletRequest request) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		coopAgencyApply.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return coopAgencyApplyService.updateCoopAgencyApply(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
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
	 * 查询渠道审核信息
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
			return coopAgencyApplyService.selectCheckWithCondition(coopAgencyApply, page, rows);
		}
	}

	/**
	 * 查询渠道审核信息详情
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
	 * 
	 * @param request
	 * @param coopAgencyApply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/refuseCheck")
	public ResultBean refuseCheck(HttpServletRequest request, TCoopAgencyApply coopAgencyApply) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		coopAgencyApply.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return coopAgencyApplyService.refuseCheck(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/**
	 * 审核通过
	 * 
	 * @param request
	 * @param coopAgencyApply
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/passCheck")
	public ResultBean passCheck(HttpServletRequest request, TCoopAgencyApply coopAgencyApply) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		coopAgencyApply.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return coopAgencyApplyService.passCheck(coopAgencyApply);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/**
	 * 查询在用信息（在用：信息变动、注销）
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryModify")
	public PageBean queryCoopAgencyModify(TCoopAgency coopAgency, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		if (null == coopAgency) {
			return null;
		} else {
			return agencyService.selectInUseWithCondition(coopAgency, page, rows);
		}
	}

	/**
	 * 查询在用信息详情(在用)
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

	/**
	 * 在用的申请变更
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateInUse")
	public ResultBean updateCoopAgencyInUse(TCoopAgency coopAgency, HttpServletRequest request) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		coopAgency.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return agencyService.updateCoopAgencyInUse(coopAgency);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	@ResponseBody
	@RequestMapping("/commitLogout")
	public ResultBean commitLogout(HttpServletRequest request, TCoopAgency coopAgency) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		coopAgency.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return agencyService.commitLogout(coopAgency);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
