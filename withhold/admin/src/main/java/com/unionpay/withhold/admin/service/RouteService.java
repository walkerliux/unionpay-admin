package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TRoute;

public interface RouteService {

	/**
	 * 查询路由版本分页信息
	 * @param route
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectListWithCondition(TRoute route, Integer page, Integer rows);

	/**
	 * 查询路由版本信息详情
	 * @param routid
	 * @return
	 */
	TRoute queryRouteById(Integer routid);

	/**
	 * 新增路由版本
	 * @param route
	 * @return
	 */
	ResultBean addRoute(TRoute route);

	/**
	 * 修改路由版本
	 * @param route
	 * @return
	 */
	ResultBean updateRoute(TRoute route);

}
