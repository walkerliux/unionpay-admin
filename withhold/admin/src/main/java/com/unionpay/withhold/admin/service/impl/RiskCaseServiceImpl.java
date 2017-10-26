package com.unionpay.withhold.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TRiskCaseMapper;
import com.unionpay.withhold.admin.mapper.TRiskListMapper;
import com.unionpay.withhold.admin.pojo.TRiskCase;
import com.unionpay.withhold.admin.pojo.TRiskCaseExample;
import com.unionpay.withhold.admin.pojo.TRiskList;
import com.unionpay.withhold.admin.pojo.TRiskListExample;
import com.unionpay.withhold.admin.service.RiskCaseService;

@Service
@Transactional
public class RiskCaseServiceImpl implements RiskCaseService {
	@Autowired
	private TRiskCaseMapper riskCaseMapper;
	@Autowired
	private TRiskListMapper riskListMapper; 
	
	@Override
	public TRiskCase queryRiskCaseByRiskver(String riskver) {
		TRiskCase riskCase = new TRiskCase();
		TRiskListExample riskListExample = new TRiskListExample();
		List<TRiskList> strategyList = riskListMapper.selectByExample(riskListExample);
		
		// 判断是否已存在
		TRiskCaseExample riskCaseExample = new TRiskCaseExample();
		TRiskCaseExample.Criteria criteria = riskCaseExample.createCriteria();
		criteria.andRiskverEqualTo(riskver);
		List<TRiskCase> caseList = riskCaseMapper.selectByExample(riskCaseExample);
		
		if (caseList.size() == 0) {// 不存在
			riskCase.setStrategyList(strategyList);
		} else {// 已存在
			riskCase = caseList.get(0);
			String activeflag = riskCase.getActiveflag();
			for (TRiskList strategy : strategyList) {
				int index = strategy.getOrders();
				char flag = activeflag.charAt(index - 1);
				if (flag == '1') { // 表示选中
					strategy.setChecked(true);
				} 
			}
			riskCase.setStrategyList(strategyList);			
			riskCase.setIsExist(true);
		}
		return riskCase;
	}

	@Override
	public ResultBean addRiskCase(TRiskCase riskCase) {
		// 验重
		TRiskCaseExample riskCaseExample = new TRiskCaseExample();
		TRiskCaseExample.Criteria criteria = riskCaseExample.createCriteria();
		criteria.andRiskverEqualTo(riskCase.getRiskver());
		int count = riskCaseMapper.countByExample(riskCaseExample);
		if (count > 0) {
			return new ResultBean("", "提交的信息异常，配置失败！");
		}
		
		riskCase.setIntime(new Date());
		riskCase.setInitflag(CommonConstants.RISK_CASE_FLAG_INSERT);
		
		// 添加
		count = riskCaseMapper.insertSelective(riskCase);
		return count > 0 ? new ResultBean("风控策略信息配置成功！") : new ResultBean("", "风控策略信息配置失败！");
	}

	@Override
	public ResultBean updateRiskCase(TRiskCase riskCase) {
		TRiskCase riskCaseBack = riskCaseMapper.selectByPrimaryKey(riskCase.getCaseid());
		if (null == riskCaseBack) {
			return new ResultBean("", "信息有误，操作失败！");
		} else {
			riskCase.setUptime(new Date());
			int count = riskCaseMapper.updateByPrimaryKeySelective(riskCase);
			return count > 0 ? new ResultBean("风控策略信息配置成功！") : new ResultBean("", "风控策略信息配置失败！");
		}
	}

	@Override
	public String changRiskStrategy(String[] strategies) {
		StringBuffer activeflag = new StringBuffer("000000000000000000000000000000000000000000000000000000000000");
		if (strategies != null) {
			for (int i = 0; i < strategies.length; i++) {
				activeflag.setCharAt(Integer.parseInt(strategies[i]) - 1, '1');
			}
		}
		return activeflag.toString();
	}
}
