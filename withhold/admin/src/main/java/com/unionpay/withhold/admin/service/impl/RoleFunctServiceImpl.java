package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TRoleFunctMapper;
import com.unionpay.withhold.admin.pojo.TRoleFunct;
import com.unionpay.withhold.admin.pojo.TRoleFunctExample;
import com.unionpay.withhold.admin.pojo.TRoleFunctExample.Criteria;
import com.unionpay.withhold.admin.service.RoleFunctService;
@Service
@Transactional
public class RoleFunctServiceImpl implements RoleFunctService {

	@Autowired
	private TRoleFunctMapper tRoleFunctMapper;
	@Override
	public List<TRoleFunct> findRoleFunctByRoleIds(List<Long> roleIdlist) {
		TRoleFunctExample tRoleFunctExample = new TRoleFunctExample();
		Criteria criteria = tRoleFunctExample.createCriteria();		
		criteria.andRoleIdIn(roleIdlist);
		List<TRoleFunct> result = tRoleFunctMapper.selectByExample(tRoleFunctExample);
		return result;
	}
	@Override
	public void deleteRoleFunction(Long roleId) {
		TRoleFunctExample tRoleFunctExample = new TRoleFunctExample();
		Criteria criteria = tRoleFunctExample.createCriteria();	
		criteria.andRoleIdEqualTo(roleId);
		tRoleFunctMapper.deleteByExample(tRoleFunctExample);
		
	}
	@Override
	public void save(List<TRoleFunct> functList) {
		for (TRoleFunct tRoleFunct : functList) {
			tRoleFunctMapper.insertSelective(tRoleFunct);
		}
		
	}
	@Override
	public List<TRoleFunct> findByProperty(Long roleId) {
		TRoleFunctExample tRoleFunctExample = new TRoleFunctExample();
		Criteria criteria = tRoleFunctExample.createCriteria();	
		criteria.andRoleIdEqualTo(roleId);
		List<TRoleFunct> result = tRoleFunctMapper.selectByExample(tRoleFunctExample);
		return result;
	}

}
