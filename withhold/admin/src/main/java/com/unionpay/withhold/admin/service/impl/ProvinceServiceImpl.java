package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.admin.mapper.TProvinceMapper;
import com.unionpay.withhold.admin.pojo.TProvince;
import com.unionpay.withhold.admin.pojo.TProvinceExample;
import com.unionpay.withhold.admin.service.ProvinceService;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	private TProvinceMapper provinceMapper;
	@Override
	public List<TProvince> getAll() {
		TProvinceExample provinceExample = new TProvinceExample();
		return provinceMapper.selectByExample(provinceExample);
	}

}
