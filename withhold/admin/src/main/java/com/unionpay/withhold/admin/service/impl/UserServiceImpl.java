package com.unionpay.withhold.admin.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.admin.mapper.TUserMapper;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserExample;
import com.unionpay.withhold.admin.pojo.TUserExample.Criteria;
import com.unionpay.withhold.admin.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserMapper tUserMapper;
	@Override
	public TUser getLoginUser(TUser user) {
		TUserExample example = new TUserExample();
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
	public Map<String, Object> findUserByPage(Map<String, Object> variables,
			int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
