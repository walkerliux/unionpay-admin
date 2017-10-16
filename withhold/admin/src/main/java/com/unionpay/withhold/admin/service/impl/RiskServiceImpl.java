package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TRiskMapper;
import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.service.RiskService;

@Service
@Transactional
public class RiskServiceImpl implements RiskService {

	@Autowired
	private TRiskMapper riskMapper;
	@Override
	public List<TRisk> getAllRiskList() {
		return riskMapper.getAllRiskList();
	}

}
