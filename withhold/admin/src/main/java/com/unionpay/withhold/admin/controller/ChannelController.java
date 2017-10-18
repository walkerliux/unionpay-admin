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
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.ChannelService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;

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
	@Autowired
	private UserService userService;
	/**
	 * 通道管理页面
	 * @author: zhangshd
	 * @return String
	 * @date: 2017年10月18日 上午8:57:16 
	 * @version v1.0
	 */
	@RequestMapping(value = "/toChannel", method = RequestMethod.GET)
	public String toCoopAgencyApply() {
		return "/channel/channel";
	}

	/**
	 * 查询通道信息
	 * @author: zhangshd
	 * @param chnlDeta
	 * @param page
	 * @param rows
	 * @return PageBean
	 * @date: 2017年10月18日 上午8:57:22 
	 * @version v1.0
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
	 * 添加通道信息
	 * @author: zhangshd
	 * @param chnlDeta
	 * @param request
	 * @param rates
	 * @return ResultBean
	 * @date: 2017年10月18日 上午8:57:37 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("/addChannel")
	public ResultBean addCoopAgencyApply(TChnlDeta chnlDeta, HttpServletRequest request,String rates) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		chnlDeta.setInuser(infoByToken.getUserId().longValue());
		try {
			return channelService.addChannel(chnlDeta,rates);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 查询通道详情
	 * @author: zhangshd
	 * @param selfId
	 * @return TChnlDeta
	 * @date: 2017年10月18日 上午8:57:49 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("/queryChannelById")
	public TChnlDeta queryChannelById(Integer selfId) {
		return selfId == null ? null : channelService.queryChannelById(selfId);
	}
	
	/**
	 * 修改通道信息
	 * @author: zhangshd
	 * @param chnlDeta
	 * @param request
	 * @return ResultBean
	 * @date: 2017年10月18日 上午8:58:24 
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("/updateChannel")
	public ResultBean updateChannel(TChnlDeta chnlDeta, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		chnlDeta.setInuser(infoByToken.getUserId().longValue());
		try {
			return channelService.updateChannel(chnlDeta);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
