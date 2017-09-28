package com.unionpay.withhold.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.dao.MerchMkMapper;
import com.unionpay.withhold.api.model.MerchMk;
import com.unionpay.withhold.api.service.MerchMkService;

@Service
public class MerchMkServiceImpl implements MerchMkService {
	@Autowired
	private MerchMkMapper merchMkMapper;

	@Override
	public MerchMk selectByPrimaryKey(String key) {
		return merchMkMapper.selectByPrimaryKey(key);
	}
}
