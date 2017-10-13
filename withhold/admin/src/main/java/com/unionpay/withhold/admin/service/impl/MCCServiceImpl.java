package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TMccDescMapper;
import com.unionpay.withhold.admin.pojo.TMccDesc;
import com.unionpay.withhold.admin.pojo.TMccDescExample;
import com.unionpay.withhold.admin.service.MCCService;

@Service
@Transactional
public class MCCServiceImpl implements MCCService {

	@Autowired
	private TMccDescMapper descMapper;
	@Override
	public List<TMccDesc> getAll() {
		TMccDescExample mccDescExample = new TMccDescExample();
		return descMapper.selectByExample(mccDescExample);
	}

}
