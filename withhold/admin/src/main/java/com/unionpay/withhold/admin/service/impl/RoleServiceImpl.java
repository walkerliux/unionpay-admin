package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.admin.mapper.TRoleMapper;
import com.unionpay.withhold.admin.pojo.TRole;
import com.unionpay.withhold.admin.pojo.TRoleExample;
import com.unionpay.withhold.admin.pojo.TRoleExample.Criteria;
import com.unionpay.withhold.admin.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private TRoleMapper tRoleMapper;
	@Override
	public List<TRole> findByProperty(String string) {
		TRoleExample tRoleExample = new TRoleExample();
		Criteria criteria = tRoleExample.createCriteria();
		
		criteria.andStatusEqualTo(string);
		List<TRole> result = tRoleMapper.selectByExample(tRoleExample);
		return result;
	}

	@Override
	public List<TRole> findAllRole() {
		List<TRole> tRoles = tRoleMapper.findAll();
		return tRoles;
	}

}
