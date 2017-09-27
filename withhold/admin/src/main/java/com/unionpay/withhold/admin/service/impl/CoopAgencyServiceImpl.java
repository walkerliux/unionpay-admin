package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.enums.CoopAgencyStatusEnums;
import com.unionpay.withhold.admin.mapper.TCoopAgencyMapper;
import com.unionpay.withhold.admin.pojo.TCoopAgency;
import com.unionpay.withhold.admin.service.CoopAgencyService;

@Service
@Transactional
public class CoopAgencyServiceImpl implements CoopAgencyService {
	@Autowired
	private TCoopAgencyMapper coopAgencyMapper;
	
	@Override
	public List<TCoopAgency> queryAllSuperCode(String supercode) {
		return coopAgencyMapper.selectAllSuperCode(supercode);
	}

	@Override
	public PageBean selectWithCondition(TCoopAgency coopAgency, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page -1) * rows; 
		List<String> statuses = new ArrayList<>();
		if (StringUtils.isBlank(coopAgency.getStatus())) {
			statuses.add(CoopAgencyStatusEnums.NORMAL.getCode());// 在用的状态
		} else {
			statuses.add(coopAgency.getStatus());
		}
		
		List<TCoopAgency> list = coopAgencyMapper.selectWithCondition(coopAgency, statuses, beginRow, rows);
		int count = coopAgencyMapper.selectCountWithCondition(coopAgency, statuses);
		
		return new PageBean(count, list);
	}

	@Override
	public TCoopAgency queryCoopAgencyModifyById(Long caid) {
		return coopAgencyMapper.selectCoopAgencyDetailById(caid);
	}
	
}
