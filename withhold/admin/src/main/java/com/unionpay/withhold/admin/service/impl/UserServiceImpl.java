package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TUserMapper;
import com.unionpay.withhold.admin.mapper.TUserRoleMapper;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserExample;
import com.unionpay.withhold.admin.pojo.TUserExample.Criteria;
import com.unionpay.withhold.admin.pojo.TUserRole;
import com.unionpay.withhold.admin.pojo.TUserRoleExample;
import com.unionpay.withhold.admin.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TUserRoleMapper tUserRoleMapper;
	
	@Override
	public TUser getLoginUser(TUser user) {
		TUserExample example = new TUserExample();
		example.setPageNum(1);
		example.setPageSize(1);
		Criteria criteria = example.createCriteria();
		criteria.andLoginNameEqualTo(user.getLoginName());
		List<TUser> users = tUserMapper.selectByExample(example);
		TUser tUser = users.get(0);
		return tUser;
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
		int total = tUserMapper.countByExample(tUserExample);
		if(user.getUserName()!=null&&!"".equals(user.getUserName())){
			criteria.andUserNameEqualTo(user.getUserName());
		}
		if(user.getUserCode()!=null&&!"".equals(user.getUserCode())){
			criteria.andUserCodeEqualTo(user.getUserCode());
		}
		if (userIds!=null&&userIds.size()>0) {
			criteria.andUserIdIn(userIds);
		}
		
		tUserExample.setPageNum(page);
		tUserExample.setPageSize(rows);
		tUserExample.setOrderByClause("CREATE_DATE DESC");
		List<TUser> list = tUserMapper.selectByExample(tUserExample);
		
		return new PageBean(total, list); 
	}
	@Override
	public void saveUser(TUser user) {
		tUserMapper.insert(user);
		
	}
	@Override
	public Map<String, Object> updateUser(TUser user) {
		Map<String, Object> hashMap = new HashMap<String, Object>();
		TUserExample example = new TUserExample();
		
		
		try {
			int i = tUserMapper.updateByPrimaryKeySelective(user);
			hashMap.put("RET", "succ");
			
			
		} catch (Exception e) {
			hashMap.put("RET", "fail");
			e.printStackTrace();
		}
		
		return hashMap;
	}
	@Override
	public TUser getSingleById(Long userId) {
		
		return tUserMapper.selectByPrimaryKey(userId.intValue());
	}
	

}
