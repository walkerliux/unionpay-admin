package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TUserRoleMapper;
import com.unionpay.withhold.admin.pojo.TUserRole;
import com.unionpay.withhold.admin.pojo.TUserRoleExample;
import com.unionpay.withhold.admin.pojo.TUserRoleExample.Criteria;
import com.unionpay.withhold.admin.service.UserRoleService;
@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private TUserRoleMapper tUserRoleMapper;
	@Override
	public List<TUserRole> findByProperty(Long userId) {
		TUserRoleExample tUserRoleExample = new TUserRoleExample();
		Criteria criteria = tUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<TUserRole> tUserRoles = tUserRoleMapper.selectByExample(tUserRoleExample);
		return tUserRoles;
	}
	@Override
	public void deleteOldUserRole(Long userId) {
		TUserRoleExample tUserRoleExample = new TUserRoleExample();
		Criteria criteria = tUserRoleExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		tUserRoleMapper.deleteByExample(tUserRoleExample);
	}
	@Override
	public void save(List<TUserRole> userRoleList) {
		for (TUserRole tUserRole : userRoleList) {
			tUserRoleMapper.insert(tUserRole);
		}
		
	}
	@Override
	public List<TUserRole> findByRoleId(Long roleId) {
		TUserRoleExample tUserRoleExample = new TUserRoleExample();
		Criteria criteria = tUserRoleExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		List<TUserRole> result = tUserRoleMapper.selectByExample(tUserRoleExample);
		return result;
	}

}
