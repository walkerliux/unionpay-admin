package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TRiskMapper;
import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.pojo.TRiskExample;
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
	@Override
	public List<TRisk> selectRiskByCondition(TRisk risk) {
		TRiskExample riskExample = new TRiskExample();
		TRiskExample.Criteria criteria = riskExample.createCriteria();
		if (StringUtils.isNotBlank(risk.getRiskver())) {
			criteria.andRiskverEqualTo(risk.getRiskver());
		} 
		if (StringUtils.isNotBlank(risk.getRiskname())) {
			criteria.andRisknameLike("%" + risk.getRiskname() + "%");
		} 
		return riskMapper.selectByExample(riskExample);
	}

}
