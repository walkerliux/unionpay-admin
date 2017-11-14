package com.unionpay.withhold.admin.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.enums.ParaDicCodeEnums;
import com.unionpay.withhold.admin.mapper.TBankMapper;
import com.unionpay.withhold.admin.mapper.TBusinessMapper;
import com.unionpay.withhold.admin.mapper.TParaDicMapper;
import com.unionpay.withhold.admin.mapper.TRouteConfigMapper;
import com.unionpay.withhold.admin.pojo.RouteConfigCheckbox;
import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;
import com.unionpay.withhold.admin.pojo.TBusiness;
import com.unionpay.withhold.admin.pojo.TBusinessExample;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TRouteConfig;
import com.unionpay.withhold.admin.pojo.TRouteConfigExample;
import com.unionpay.withhold.admin.service.RouteConfigService;

@Service
@Transactional
public class RouteConfigServiceImpl implements RouteConfigService {
	@Autowired
	private TRouteConfigMapper routeConfigMapper;
	@Autowired
	private TBankMapper bankMapper;
	@Autowired
	private TBusinessMapper businessMapper;
	@Autowired
	private TParaDicMapper paraDicMapper;

	@Override
	public PageBean selectListWithCondition(TRouteConfig routeConfig, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<TRouteConfig> routeConfigList = routeConfigMapper.selectWithCondition(routeConfig, beginRow, rows);
		int count = routeConfigMapper.selectCountWithCondition(routeConfig);
		return new PageBean(count, routeConfigList);
	}

	@Override
	public RouteConfigCheckbox queryAllConfigCheckbox(Integer rid) {
		List<TBank> bankList = null;
		List<TBusiness> businessList = null;
		List<TParaDic> paraDicList = null;
		
		if (rid == null) {
			// 查发卡行
			TBankExample bankExample = new TBankExample();
			bankList = bankMapper.selectByExample(bankExample);
			
			// 查交易类型
			TBusinessExample businessExample = new TBusinessExample();
			businessList = businessMapper.selectByExample(businessExample);
			
			// 查卡类型
			paraDicList = paraDicMapper.selectParaDicByParentCode(ParaDicCodeEnums.CARDTYPE.getCode());
			
		}else {
			TRouteConfig routeConfig = routeConfigMapper.selectByPrimaryKey(rid);
			
			bankList = bankMapper.selectBankCheckbox(routeConfig.getBankcode());
			businessList = businessMapper.selectBusinessCheckbox(routeConfig.getBusicode());
			paraDicList = paraDicMapper.selectCardtypeCheckbox(routeConfig.getCardtype());
			
		}
		
		return new RouteConfigCheckbox(bankList,businessList,paraDicList);
	}

	@Override
	public ResultBean addRouteConfig(TRouteConfig routeConfig) {
		// 验格式
		if (Long.valueOf(routeConfig.getStime()) >= Long.valueOf(routeConfig.getEtime())) {
			return new ResultBean("", "结束时间应当晚于开始时间！");
		}
		if (routeConfig.getMinamt().compareTo(routeConfig.getMaxamt()) >=0 ) {
			return new ResultBean("", "最大交易额应当大于最小交易额！");
		} else {
			routeConfig.setMaxamt(routeConfig.getMaxamt().multiply(new BigDecimal("100")));
			routeConfig.setMinamt(routeConfig.getMinamt().multiply(new BigDecimal("100")));
		}
		
		// 优先级
		TRouteConfigExample routeConfigExampleOrder = new TRouteConfigExample();
		TRouteConfigExample.Criteria criteriaOrder = routeConfigExampleOrder.createCriteria();
		criteriaOrder.andRoutverEqualTo(routeConfig.getRoutver());
		criteriaOrder.andOrdersEqualTo(routeConfig.getOrders());
		int count = routeConfigMapper.countByExample(routeConfigExampleOrder);
		if (count > 0) return new ResultBean("", "该优先级已存在！");
		
		// 发卡行、交易类型、卡类型拼接字符串，并赋值
		routeConfig.setBankcode(routeConfig.getBankcodes() == null || routeConfig.getBankcodes().length == 0 ? "" : StringUtils.join(routeConfig.getBankcodes(), ";"));
		routeConfig.setBusicode(routeConfig.getBusicodes() == null || routeConfig.getBusicodes().length == 0 ? "" : StringUtils.join(routeConfig.getBusicodes(), ";"));
		routeConfig.setCardtype(routeConfig.getCardtypes() == null || routeConfig.getCardtypes().length == 0 ? "" : StringUtils.join(routeConfig.getCardtypes(), ";"));
		
		// 是否设置默认值
		/*if (routeConfig.getIsdef().equals(CommonConstants.ROUTECONFIG_ISDEF)) {
			TRouteConfigExample routeConfigExampleDef = new TRouteConfigExample();
			TRouteConfigExample.Criteria criteriaDef = routeConfigExampleDef.createCriteria();
			criteriaDef.andRoutverEqualTo(routeConfig.getRoutver());
			criteriaDef.andIsdefEqualTo(CommonConstants.ROUTECONFIG_ISDEF);
			
			TRouteConfig condition = new TRouteConfig();
			condition.setIsdef(CommonConstants.ROUTECONFIG_ISNOTDEF);
			
			routeConfigMapper.updateByExampleSelective(condition, routeConfigExampleDef);
		}*/
		// 现在全部为非默认——2017.11.09
		routeConfig.setIsdef(CommonConstants.ROUTECONFIG_ISNOTDEF);
		
		routeConfig.setIntime(new Date());
		routeConfig.setStatus(CommonConstants.ROUTECONFIG_STATUS_NORMAL);
		
		count = routeConfigMapper.insertSelective(routeConfig);
		return count > 0 ? new ResultBean("新路由配置添加成功！") : new ResultBean("", "新路由配置添加失败！");
	}

	@Override
	public TRouteConfig queryConfigDetail(Integer rid) {
		return routeConfigMapper.selectDetailByID(rid);
	}

	@Override
	public ResultBean updateRouteConfig(TRouteConfig routeConfig) {
		// 验格式
		if (Long.valueOf(routeConfig.getStime()) >= Long.valueOf(routeConfig.getEtime())) {
			return new ResultBean("", "结束时间应当晚于开始时间！");
		}
		if (routeConfig.getMinamt().compareTo(routeConfig.getMaxamt()) >=0 ) {
			return new ResultBean("", "最大交易额应当大于最小交易额！");
		} else {
			routeConfig.setMaxamt(routeConfig.getMaxamt().multiply(new BigDecimal("100")));
			routeConfig.setMinamt(routeConfig.getMinamt().multiply(new BigDecimal("100")));
		}
		
		// 优先级
		TRouteConfigExample routeConfigExampleOrder = new TRouteConfigExample();
		TRouteConfigExample.Criteria criteriaOrder = routeConfigExampleOrder.createCriteria();
		criteriaOrder.andRoutverEqualTo(routeConfig.getRoutver());
		criteriaOrder.andOrdersEqualTo(routeConfig.getOrders());
		criteriaOrder.andRidNotEqualTo(routeConfig.getRid());
		int count = routeConfigMapper.countByExample(routeConfigExampleOrder);
		if (count > 0) return new ResultBean("", "该优先级已存在！");
		
		// 发卡行、交易类型、卡类型拼接字符串，并赋值
		routeConfig.setBankcode(routeConfig.getBankcodes() == null || routeConfig.getBankcodes().length == 0 ? "" : StringUtils.join(routeConfig.getBankcodes(), ";"));
		routeConfig.setBusicode(routeConfig.getBusicodes() == null || routeConfig.getBusicodes().length == 0 ? "" : StringUtils.join(routeConfig.getBusicodes(), ";"));
		routeConfig.setCardtype(routeConfig.getCardtypes() == null || routeConfig.getCardtypes().length == 0 ? "" : StringUtils.join(routeConfig.getCardtypes(), ";"));
		
		// 是否设置默认值
		/*if (routeConfig.getIsdef().equals(CommonConstants.ROUTECONFIG_ISDEF)) {
			TRouteConfigExample routeConfigExampleDef = new TRouteConfigExample();
			TRouteConfigExample.Criteria criteriaDef = routeConfigExampleDef.createCriteria();
			criteriaDef.andRoutverEqualTo(routeConfig.getRoutver());
			criteriaDef.andIsdefEqualTo(CommonConstants.ROUTECONFIG_ISDEF);
			
			TRouteConfig condition = new TRouteConfig();
			condition.setIsdef(CommonConstants.ROUTECONFIG_ISNOTDEF);
			
			routeConfigMapper.updateByExampleSelective(condition, routeConfigExampleDef);
		}*/// 现在全部为非默认——2017.11.14
		
		routeConfig.setUptime(new Date());
		routeConfig.setStatus(CommonConstants.ROUTECONFIG_STATUS_NORMAL);
		
		count = routeConfigMapper.updateByPrimaryKeySelective(routeConfig);
		return count > 0 ? new ResultBean("路由配置修改成功！") : new ResultBean("", "路由配置修改失败！");
	}

	@Override
	public ResultBean logoutRouteConfig(TRouteConfig routeConfig) {
		TRouteConfig routeConfigBack = routeConfigMapper.selectDetailByID(routeConfig.getRid());
		if (null == routeConfigBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (!routeConfigBack.getStatus().equals(CommonConstants.ROUTECONFIG_STATUS_NORMAL)) {
			return new ResultBean("", "该路由配置规则已被注销！");
		}else {
			routeConfig.setStatus(CommonConstants.ROUTECONFIG_STATUS_UNNORMAL);
			int count = routeConfigMapper.updateByPrimaryKeySelective(routeConfig);
			return count > 0 ? new ResultBean(routeConfigBack) : new ResultBean("", "注销失败！");
		}
	}

	@Override
	public ResultBean startRouteConfig(TRouteConfig routeConfig) {
		TRouteConfig routeConfigBack = routeConfigMapper.selectDetailByID(routeConfig.getRid());
		if (null == routeConfigBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else if (routeConfigBack.getStatus().equals(CommonConstants.ROUTECONFIG_STATUS_NORMAL)) {
			return new ResultBean("", "该路由配置规则已被启用！");
		}else {
			routeConfig.setStatus(CommonConstants.ROUTECONFIG_STATUS_NORMAL);
			int count = routeConfigMapper.updateByPrimaryKeySelective(routeConfig);
			return count > 0 ? new ResultBean(routeConfigBack) : new ResultBean("", "启用失败！");
		}
	}
}
