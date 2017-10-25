package com.unionpay.withhold.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
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

	@Override
	public ResultBean addRisk(TRisk risk) {
		// 验重
		TRiskExample riskExample = new TRiskExample();
		TRiskExample.Criteria criteria = riskExample.createCriteria();
		criteria.andRiskverEqualTo(risk.getRiskver());
		int count = riskMapper.countByExample(riskExample);
		if (count > 0) {
			return new ResultBean("", "此风控版本代码已存在！");
		}

		risk.setStatus(CommonConstants.RISK_STATUS_NORMAL);
		risk.setIntime(new Date());

		// 添加
		count = riskMapper.insertSelective(risk);
		return count > 0 ? new ResultBean("风控版本添加成功 ！") : new ResultBean("", "风控版本添加失败！");
	}

	@Override
	public ResultBean updateRisk(TRisk risk) {
		TRisk riskBack = riskMapper.selectByPrimaryKey(risk.getRiskid());
		if (null == riskBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else {
			risk.setUptime(new Date());
			int count = riskMapper.updateByPrimaryKeySelective(risk);
			return count > 0 ? new ResultBean("风控版本修改成功 ！") : new ResultBean("", "风控版本修改失败！");
		}
	}

	@Override
	public TRisk queryRiskByRiskid(Long riskid) {
		return riskMapper.selectByPrimaryKey(riskid);
	}

}
