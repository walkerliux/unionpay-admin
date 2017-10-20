package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;

import com.unionpay.withhold.admin.dao.JedisClient;

import com.unionpay.withhold.admin.mapper.TUserMapper;
import com.unionpay.withhold.admin.mapper.TUserRoleMapper;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserExample;
import com.unionpay.withhold.admin.pojo.TUserExample.Criteria;
import com.unionpay.withhold.admin.pojo.TUserRole;
import com.unionpay.withhold.admin.pojo.TUserRoleExample;
import com.unionpay.withhold.admin.service.UserService;

import com.unionpay.withhold.admin.utils.JsonUtils;
import com.unionpay.withhold.admin.utils.MD5Util;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
import com.unionpay.withhold.admin.utils.StringUtil;
import com.unionpay.withhold.admin.utils.SystemUtils;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Value("${REDIS_USER_KEY}")
	private String REDIS_USER_KEY;
	@Value("${REDIS_IP_KEY}")
	private String REDIS_IP_KEY;
	@Value("${REDIS_BROWSER_KEY}")
	private String REDIS_BROWSER_KEY;
	@Value("${REDIS_SESSION_EXPIRE}")
	private int REDIS_SESSION_EXPIRE;


	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TUserRoleMapper tUserRoleMapper;

	@Autowired
	JedisClient jedisClient;

	

	@Override
	public TUser getLoginUser(TUser user) {
		TUserExample example = new TUserExample();
		if (user.getLoginName()!=null&&!"".equals(user.getLoginName())) {
			example.setLoginName(user.getLoginName());
		}

		TUser users = tUserMapper.selectTUserByLoginName(example);
		
		return users;

	}
	@Override
	public TUser getSingleById(Integer userId) {
		TUser user = tUserMapper.selectByPrimaryKey(userId);
		return user;
	}
	@Override
	public void resetPwd(TUser user, Date date) {
		//设置延迟密码时间
		user.setPwdValid(date);
		tUserMapper.updateByPrimaryKey(user);
		
	}
	@Override
	public PageBean findUserByPage(TUser user,String roleId,int page, int rows) {
		
		List<Integer> userIds= new ArrayList<Integer>();
		//根据roleId在中间表查找对应的userId
		if (StringUtils.isNotEmpty(roleId)) {
			TUserRoleExample tUserRoleExample = new TUserRoleExample();
			com.unionpay.withhold.admin.pojo.TUserRoleExample.Criteria userRoleriteria = tUserRoleExample.createCriteria();
			userRoleriteria.andRoleIdEqualTo(Long.parseLong(roleId));
			List<TUserRole> tUserRoles = tUserRoleMapper.selectByExample(tUserRoleExample);
			if(tUserRoles!=null&&tUserRoles.size()>0){
				for (TUserRole tUserRole : tUserRoles) {
					int userId = tUserRole.getUserId().intValue();
					userIds.add(userId);
				}
			}
		}
		
		TUserExample tUserExample = new TUserExample();
		Criteria criteria = tUserExample.createCriteria();
		
		if(user.getUserName()!=null&&!"".equals(user.getUserName())){
			criteria.andUserNameEqualTo(user.getUserName());
		}
		if(user.getUserCode()!=null&&!"".equals(user.getUserCode())){
			criteria.andUserCodeEqualTo(user.getUserCode());
		}
		if (userIds!=null&&userIds.size()>0) {
			criteria.andUserIdIn(userIds);
		}
		int total = tUserMapper.countByExample(tUserExample);
		tUserExample.setPageNum(page);
		tUserExample.setPageSize(rows);
		tUserExample.setOrderByClause("USER_ID");
		List<TUser> list = tUserMapper.selectByExample(tUserExample);
		
		return new PageBean(total, list); 
	}
	@Override
	public void saveUser(TUser user) {
		tUserMapper.insert(user);
		
	}
	@Override
	public void updateUser(TUser user) {
			 tUserMapper.updateByPrimaryKeySelective(user);

	}
	@Override
	public TUser getSingleById(Long userId) {
		
		return tUserMapper.selectByPrimaryKey(userId.intValue());
	}

	@Override
	public void putLoginMsgTORedis(HttpServletResponse response,HttpServletRequest request,TUser user) {
		//判断是否是第二次登录
		String userMsg = jedisClient.get(REDIS_USER_KEY+":"+user.getUserId());
		String ip = jedisClient.get(REDIS_IP_KEY+":"+user.getUserId());
		String browser = jedisClient.get(REDIS_BROWSER_KEY+":"+user.getUserId());
		//有就删除之前的
		if (StringUtil.isNotNull(userMsg)) {
			jedisClient.del(REDIS_USER_KEY+":"+user.getUserId());
		}
		if (StringUtil.isNotNull(ip)) {
			jedisClient.del(REDIS_IP_KEY+":"+user.getUserId());
		}
		if (StringUtil.isNotNull(browser)) {
			jedisClient.del(REDIS_BROWSER_KEY+":"+user.getUserId());
		}
		//用户第一次登录
		//获取当前登录的Ip地址
		String ipAddr = SystemUtils.getIpAddr(request);
		jedisClient.set(REDIS_IP_KEY+":"+user.getUserId(), ipAddr);
		jedisClient.expire(REDIS_IP_KEY+":"+user.getUserId(), REDIS_SESSION_EXPIRE);
		//获取浏览器
		String browserInfo = SystemUtils.getRequestBrowserInfo(request);
		jedisClient.set(REDIS_BROWSER_KEY+":"+user.getUserId(), browserInfo);
		jedisClient.expire(REDIS_BROWSER_KEY+":"+user.getUserId(), REDIS_SESSION_EXPIRE);
		//登录者信息
		jedisClient.set(REDIS_USER_KEY+":"+user.getUserId(), JsonUtils.objectToJson(user));
		jedisClient.expire(REDIS_USER_KEY+":"+user.getUserId(), REDIS_SESSION_EXPIRE);
		MyCookieUtils.setCookie(request, response, "eb_token", user.getUserId().toString());
		
	}
	@Override
	public TUser getUserInfoByToken(String token) {
		String userValue = jedisClient.get(REDIS_USER_KEY+":"+token);
		if (StringUtil.isNull(userValue)) {
			return null;
		}
		
		jedisClient.expire(REDIS_USER_KEY+":"+token, REDIS_SESSION_EXPIRE);
		return JsonUtils.jsonToPojo(userValue,TUser.class);
	}
	@Override
	public void delLoginMsgFromRedis(String token) {
		jedisClient.del(REDIS_USER_KEY+":"+token);
		jedisClient.del(REDIS_IP_KEY+":"+token);
		jedisClient.del(REDIS_BROWSER_KEY+":"+token);
		
	}
	

}
