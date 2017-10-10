package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.enums.MerchDetaStatusEnums;
import com.unionpay.withhold.admin.mapper.TMerchDetaApplyMapper;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.service.MerchDetaApplyService;

@Service
@Transactional
public class MerchDetaApplyServiceImpl implements MerchDetaApplyService {
	@Autowired
	private TMerchDetaApplyMapper merchDetaApplyMapper;

	@Override
	public PageBean selectApplyWithCondition(TMerchDetaApply merchDetaApply, Integer page, Integer rows) {
		// 查分页数据
		Integer beginRow = (page - 1) * rows;
		List<String> statuses = new ArrayList<>();
		statuses.add(MerchDetaStatusEnums.REGISTERCHECKING.getCode());// 注册待审
		// 注册待审前修改
		statuses.add(MerchDetaStatusEnums.UPDATEAFTERCHECKED.getCode());// 变更待审
		statuses.add(MerchDetaStatusEnums.LOGOUTCHECKING.getCode());// 注销待审

		List<TMerchDetaApply> list = merchDetaApplyMapper.selectApplyWithCondition(merchDetaApply, statuses, beginRow,
				rows);
		int count = merchDetaApplyMapper.selectCountWithCondition(merchDetaApply, statuses);

		return new PageBean(count, list);
	}

}
