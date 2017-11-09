package com.unionpay.withhold.admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.RouteConfigCheckbox;
import com.unionpay.withhold.admin.pojo.TRoute;
import com.unionpay.withhold.admin.pojo.TRouteConfig;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.RouteConfigService;
import com.unionpay.withhold.admin.service.RouteService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;

@Controller
@RequestMapping("/route")
public class RouteController {
	@Autowired
	private RouteService routeService;
	@Autowired
	private RouteConfigService routeConfigService;
	@Autowired
	private UserService userService;
	
	/**
	 * 路由版本
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toRouteManager", method = RequestMethod.GET)
	public String toRiskManager() {
		return "/route/route_manager";
	}
	
	/**
	 * 路由配置
	 * 
	 * @return
	 */
	@RequestMapping(value = "/toRouteConfigManager", method = RequestMethod.GET)
	public String toRouteConfigManager() {
		return "/route/routeconfig_manager";
	}
	
	/**
	 * 查询路由版本分页信息
	 * 
	 * @param route
	 * @param page
	 * @param rows
	 * @return PageBean
	 */
	@ResponseBody
	@RequestMapping("/queryRoute")
	public PageBean queryRoute(TRoute route, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return route == null ? null : routeService.selectListWithCondition(route, page, rows);
	}
	
	/**
	 * 查询路由版本信息详情
	 * 
	 * @param routid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryRouteById")
	public TRoute queryRouteById(Integer routid) {
		return routid == null ? null : routeService.queryRouteById(routid);
	}
	
	/**
	 * 新增路由版本
	 * 
	 * @param route
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addRoute")
	public ResultBean addRoute(TRoute route, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		route.setInuser(infoByToken.getUserId().longValue());
		try {
			return routeService.addRoute(route);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 修改路由版本
	 * 
	 * @param route
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRoute")
	public ResultBean updateRoute(TRoute route, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		route.setUpuser(infoByToken.getUserId().longValue());
		try {
			return routeService.updateRoute(route);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 查询路由配置分页信息
	 * 
	 * @param routeConfig
	 * @param page
	 * @param rows
	 * @return PageBean
	 */
	@ResponseBody
	@RequestMapping("/queryRouteConfig")
	public PageBean queryRouteConfig(TRouteConfig routeConfig, @RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows) {
		return routeConfig == null ? null : routeConfigService.selectListWithCondition(routeConfig, page, rows);
	}
	
	/**
	 * 查询路由配置信息详情
	 * 
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryConfigDetail")
	public TRouteConfig queryConfigDetail(Integer rid) {
		return rid == null ? null : routeConfigService.queryConfigDetail(rid);
	}
	
	/**
	 * 查询路由配置中复选框的信息
	 * @param rid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/queryAllConfigCheckbox")
	public RouteConfigCheckbox queryAllConfigCheckbox(Integer rid){
		return routeConfigService.queryAllConfigCheckbox(rid);
	}
	
	/**
	 * 新增路由配置
	 * 
	 * @param routeConfig
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/addRouteConfig")
	public ResultBean addRouteConfig(TRouteConfig routeConfig, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		routeConfig.setInuser(infoByToken.getUserId().longValue());
		try {
			return routeConfigService.addRouteConfig(routeConfig);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 修改路由配置
	 * 
	 * @param routeConfig
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateRouteConfig")
	public ResultBean updateRouteConfig(TRouteConfig routeConfig, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		routeConfig.setUpuser(infoByToken.getUserId().longValue());
		try {
			return routeConfigService.updateRouteConfig(routeConfig);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	
	/**
	 * 注销路由配置
	 * 
	 * @param routeConfig
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logoutRouteConfig")
	public ResultBean logoutConfig(TRouteConfig routeConfig, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		routeConfig.setUpuser(infoByToken.getUserId().longValue());
		try {
			return routeConfigService.logoutRouteConfig(routeConfig);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
	
	/**
	 * 启用路由配置
	 * 
	 * @param routeConfig
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/startRouteConfig")
	public ResultBean startConfig(TRouteConfig routeConfig, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		routeConfig.setUpuser(infoByToken.getUserId().longValue());
		try {
			return routeConfigService.startRouteConfig(routeConfig);
		} catch (Exception e) {
			return new ResultBean("", "服务器异常，请稍后再试！");
		}
	}
}
