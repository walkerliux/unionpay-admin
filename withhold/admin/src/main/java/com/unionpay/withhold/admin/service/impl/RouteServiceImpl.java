package com.unionpay.withhold.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TRouteMapper;
import com.unionpay.withhold.admin.pojo.TRoute;
import com.unionpay.withhold.admin.pojo.TRouteExample;
import com.unionpay.withhold.admin.service.RouteService;

@Service
@Transactional
public class RouteServiceImpl implements RouteService {
	@Autowired
	private TRouteMapper routeMapper;

	@Override
	public PageBean selectListWithCondition(TRoute route, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<TRoute> routeList = routeMapper.selectWithCondition(route, beginRow, rows);
		int count = routeMapper.selectCountWithCondition(route);
		return new PageBean(count, routeList);
	}

	@Override
	public TRoute queryRouteById(Integer routid) {
		return routeMapper.selectByPrimaryKey(routid);
	}

	@Override
	public ResultBean addRoute(TRoute route) {
		// 验重
		TRouteExample routeExample = new TRouteExample();
		TRouteExample.Criteria criteria = routeExample.createCriteria();
		criteria.andRoutverEqualTo(route.getRoutver());
		int count = routeMapper.countByExample(routeExample);
		if (count > 0) {
			return new ResultBean("", "该路由版本已存在！");
		}

		route.setIntime(new Date());
		route.setStatus(CommonConstants.ROUTE_STATUS_NORMAL);

		count = routeMapper.insertSelective(route);
		return count > 0 ? new ResultBean("新路由版本添加成功！") : new ResultBean("", "新路由版本添加失败！");
	}

	@Override
	public ResultBean updateRoute(TRoute route) {
		TRoute routeBack = routeMapper.selectByPrimaryKey(route.getRoutid());
		if (null == routeBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (routeBack.getStatus() == null || CommonConstants.ROUTE_STATUS_NORMAL != routeBack.getStatus()) {
			return new ResultBean("", "该路由版本已不在使用！");
		} else {
			route.setUptime(new Date());
			int count = routeMapper.updateByPrimaryKeySelective(route);
			return count > 0 ? new ResultBean("修改成功！") : new ResultBean("", "修改失败！");
		}
	}

}
