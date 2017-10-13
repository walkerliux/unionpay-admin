package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.admin.mapper.TCityMapper;
import com.unionpay.withhold.admin.pojo.TCity;
import com.unionpay.withhold.admin.pojo.TCityExample;
import com.unionpay.withhold.admin.service.CityService;

@Service
public class CityServiceImpl implements CityService {
	@Autowired
	private TCityMapper cityMapper;
	@Override
	public List<TCity> queryByProID(Long pId) {
		TCityExample cityExample = new TCityExample();
		TCityExample.Criteria criteria = cityExample.createCriteria();
		criteria.andPIdEqualTo(pId);
		return cityMapper.selectByExample(cityExample);
	}

}
