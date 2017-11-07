package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.RouteConfigCheckbox;
import com.unionpay.withhold.admin.pojo.TRouteConfig;

public interface RouteConfigService {

	/**
	 * 查询路由配置分页信息
	 * @param routeConfig
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectListWithCondition(TRouteConfig routeConfig, Integer page, Integer rows);

	/**
	 * 查询路由配置中复选框的信息
	 * @param rid
	 * @return
	 */
	RouteConfigCheckbox queryAllConfigCheckbox(Integer rid);

	/**
	 * 新增路由配置
	 * @param routeConfig
	 * @return
	 */
	ResultBean addRouteConfig(TRouteConfig routeConfig);

	/**
	 * 查询路由配置信息详情
	 * @param rid
	 * @return
	 */
	TRouteConfig queryConfigDetail(Integer rid);

	/**
	 * 修改路由配置
	 * @param routeConfig
	 * @return
	 */
	ResultBean updateRouteConfig(TRouteConfig routeConfig);

}
