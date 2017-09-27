package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TRoleMapper;
import com.unionpay.withhold.admin.pojo.TRole;
import com.unionpay.withhold.admin.pojo.TRoleExample;
import com.unionpay.withhold.admin.pojo.TRoleExample.Criteria;
import com.unionpay.withhold.admin.service.RoleService;
@Service
@Transactional
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

	@Override
	public PageBean findRoleByPage(TRole role, int page, int rows) {
		TRoleExample tRoleExample = new TRoleExample();
		Criteria criteria = tRoleExample.createCriteria();
	
		if (role.getRoleName()!=null&&!"".equals(role.getRoleName())) {
			criteria.andRoleNameEqualTo(role.getRoleName());
		}
		int total = tRoleMapper.countByExample(tRoleExample);
		tRoleExample.setPageNum(page);
		tRoleExample.setPageSize(rows);
		tRoleExample.setOrderByClause("CREAT_DATE DESC");
		List<TRole> result = tRoleMapper.selectByPageExample(tRoleExample);
		
		return new PageBean(total, result);
	}

	@Override
	public List<TRole> saveRole(TRole role) {
		
		tRoleMapper.insertSelective(role);
		return null;
	}

	@Override
	public List<TRole> updateRole(TRole role) {
		tRoleMapper.updateByPrimaryKeySelective(role);
		return null;
	}

	@Override
	public TRole getSingleById(Long roleId) {
		
		return tRoleMapper.selectByPrimaryKey(roleId);
	}

	

}
