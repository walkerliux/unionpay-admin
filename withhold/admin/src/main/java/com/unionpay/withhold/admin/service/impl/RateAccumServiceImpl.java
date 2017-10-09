package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TRateAccumMapper;
import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.service.RateAccumService;

@Service
@Transactional
public class RateAccumServiceImpl implements RateAccumService {
	@Autowired
	private TRateAccumMapper rateAccumMapper;
	
	@Override
	public List<TRateAccum> getAllRateList() {
		return rateAccumMapper.getAllRateList();
	}

}
