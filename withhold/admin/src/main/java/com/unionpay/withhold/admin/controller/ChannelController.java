package com.unionpay.withhold.admin.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
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
import com.unionpay.withhold.admin.pojo.TChnlFlowControl;
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
	
	
	@RequestMapping(value = "/toChannelBank", method = RequestMethod.GET)
	public String toChannelBank() {
		return "/channel/channel_bank_limit";
	}
	
	@RequestMapping(value = "/toChannelFlow", method = RequestMethod.GET)
	public String toChannelFlow() {
		return "/channel/channel_flow";
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
	public PageBean queryChannel(TChnlDeta chnlDeta,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		PageHelper.startPage(page, rows);
		List<TChnlDeta> list=  channelService.selectByCondition(chnlDeta);
		PageInfo<TChnlDeta> pageInfo=new PageInfo<>(list);
		PageBean pageBean=new PageBean(new Long(pageInfo.getTotal()).intValue(), list);
		return pageBean;
	}
	
	@ResponseBody
	@RequestMapping("/queryChannelAll")
	public List<TChnlDeta> queryChannelAll() {
		List<TChnlDeta> list=  channelService.selectByCondition(new TChnlDeta());
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/queryChannelFlow")
	public PageBean queryChannelFlow(TChnlFlowControl chnlFlowControl,
			@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
		PageHelper.startPage(page, rows);
		List<TChnlFlowControl> list=  channelService.selectChannlFlowByCondition(chnlFlowControl);
		PageInfo<TChnlFlowControl> pageInfo=new PageInfo<>(list);
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
	
	
	@ResponseBody
	@RequestMapping("/queryChannelBankById")
	public Map<String, Object> queryChannelBankById(String selfId) {
		return selfId == null ? null : channelService.queryChannelBankByChnlcode(selfId);
	}
	@ResponseBody
	@RequestMapping("/changeChannelBank")
	public ResultBean changeChannelBank(HttpServletRequest request ,String chnlcode,String debitdata,String creditdata,String[] debitcheckboxList,String[] creditcheckboxList){
		
		List<String> debitoldlist= new ArrayList<>();
		if (StringUtils.isNotEmpty(debitdata)) {
			debitoldlist=Arrays.asList(debitdata.split("\\|"));
		}
		List<String> debitnewlist=new ArrayList<>();
		if (debitcheckboxList!=null) {
			debitnewlist=Arrays.asList(debitcheckboxList);
		}
		
		List<String> creditdataoldlist= new ArrayList<>();
		if (StringUtils.isNotEmpty(creditdata)) {
			creditdataoldlist=Arrays.asList(creditdata.split("\\|"));
		}
		List<String> creditdatanewlist=new ArrayList<>();
		if (creditcheckboxList!=null) {
			creditdatanewlist=Arrays.asList(creditcheckboxList);
		}
		Map<String, List<String>> debitmap =getDiffrent(debitoldlist, debitnewlist);
		Map<String, List<String>> creditmap =getDiffrent(creditdataoldlist, creditdatanewlist);
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		ResultBean resultBean =channelService.changeChannlBank(debitmap.get("old"), debitmap.get("new"),creditmap.get("old"), creditmap.get("new"),chnlcode,infoByToken.getUserId().longValue());
		return resultBean;
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
	
	
	private static Map<String, List<String>> getDiffrent(List<String> list1, List<String> list2) {
		Map<String, Integer> map = new HashMap<String, Integer>(list1.size() + list2.size());
		for (String string : list1) {
			map.put(string, 1);
		}
		for (String string : list2) {
			Integer cc = map.get(string);
			if (cc != null) {
				map.put(string, 3);
				continue;
			}
			map.put(string, 2);
		}
		list1=new ArrayList<>();
		list2=new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				list1.add(entry.getKey());
			}
			if (entry.getValue() == 2) {
				list2.add(entry.getKey());
			}
		}
		
		Map<String, List<String>> map2 =new HashMap<>();
		map2.put("old", list1);
		map2.put("new", list2);
		return map2;
	}
	
	public static void main(String[] args) {
		String[] tem ="1$2".split("\\&");
		System.out.println(tem);
	}
	
}
