package com.unionpay.withhold.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionpay.withhold.admin.Bean.LoginUser;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.service.ChannelService;

/**
 * 通道管理
 * 
 * @author 张世栋
 * @date 2017年10月16日10:52:50
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {
	@Autowired
	private ChannelService channelService;
	/**
	 * 渠道申请页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toChannel", method = RequestMethod.GET)
	public String toCoopAgencyApply() {
		return "/channel/channel";
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
	 * @param chnlDeta
	 * @param page
	 * @param rows
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryChannel")
	public PageBean queryCoopAgencyApply(TChnlDeta chnlDeta,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		PageHelper.startPage(page, rows);
		List<TChnlDeta> list=  channelService.selectByCondition(chnlDeta);
		PageInfo<TChnlDeta> pageInfo=new PageInfo<>(list);
		PageBean pageBean=new PageBean(new Long(pageInfo.getTotal()).intValue(), list);
		return pageBean;
	}
	
	/**
	 * 注册
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addChannel")
	public ResultBean addCoopAgencyApply(TChnlDeta chnlDeta, HttpServletRequest request,String rates) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		chnlDeta.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return channelService.addChannel(chnlDeta,rates);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * @author: zhangshd
	 * @param selfId
	 * @return TCoopAgencyApply
	 * @date: 2017年10月17日 下午3:53:37 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("/queryChannelById")
	public TChnlDeta queryChannelById(Integer selfId) {
		return selfId == null ? null : channelService.queryChannelById(selfId);
	}
	
	/**
	 * 
	 * @author: zhangshd
	 * @param coopAgencyApply
	 * @param request
	 * @return ResultBean
	 * @date: 2017年10月17日 下午4:13:01 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("/updateChannel")
	public ResultBean updateChannel(TChnlDeta chnlDeta, HttpServletRequest request) {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute("LOGIN_USER");
		chnlDeta.setInuser(loginUser.getUser().getUserId().longValue());
		try {
			return channelService.updateChannel(chnlDeta);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}

	/*
	*//**
	 * 查询上级渠道
	 * 
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/queryAllSuperCode")
	public List<TCoopAgency> queryAllSuperCode(String supercode) {
		return this.agencyService.queryAllSuperCode(supercode);
	};

	*//**
	 * 查询渠道审核信息
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 *//*
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

	*//**
	 * 查询渠道审核信息详情
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/queryCheckById")
	public TCoopAgencyApply queryCoopAgencyCheckById(Long selfId) {
		return selfId == null ? null : coopAgencyApplyService.queryCoopAgencyCheckById(selfId);
	}

	*//**
	 * 审核拒绝
	 * 
	 * @param request
	 * @param coopAgencyApply
	 * @return
	 *//*
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

	*//**
	 * 审核通过
	 * 
	 * @param request
	 * @param coopAgencyApply
	 * @return
	 *//*
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

	*//**
	 * 查询在用信息（在用：信息变动、注销）
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 *//*
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

	*//**
	 * 查询在用信息详情(在用)
	 * 
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 *//*
	@ResponseBody
	@RequestMapping("/queryModifyById")
	public TCoopAgency queryCoopAgencyModifyById(Long caid) {
		return caid == null ? null : agencyService.queryCoopAgencyModifyById(caid);
	}

	*//**
	 * 在用的申请变更
	 * 
	 * @param coopAgencyApply
	 * @param request
	 * @return
	 *//*
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
	}*/
}
