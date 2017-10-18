package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.MerchDetaStatusEnums;
import com.unionpay.withhold.admin.mapper.TMerchDetaApplyMapper;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;
import com.unionpay.withhold.admin.pojo.TMerchDetaApplyExample;
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

	@Override
	public ResultBean addMerchDetaApply(TMerchDetaApply merchDetaApply) {
		// 验重
		TMerchDetaApplyExample merchDetaApplyExample = new TMerchDetaApplyExample();
		TMerchDetaApplyExample.Criteria criteria = merchDetaApplyExample.createCriteria();
		criteria.andMemberIdEqualTo(merchDetaApply.getMemberId());
		int count = merchDetaApplyMapper.countByExample(merchDetaApplyExample);
		if (count > 0) {
			return new ResultBean("", "此商户号已被注册过！");
		}
		
		merchDetaApply.setStatus(MerchDetaStatusEnums.REGISTERCHECKING.getCode());
		merchDetaApply.setInTime(new Date());
		
		// 添加
		count = merchDetaApplyMapper.insertSelective(merchDetaApply);
		if (count > 0) {
			return new ResultBean("操作成功 ！");
		} else {
			return new ResultBean("", "新增商户失败！");
		}
	}

	@Override
	public TMerchDetaApply queryMerchDetaApplyById(Long selfId) {
		return merchDetaApplyMapper.selectByPrimaryKey(selfId.intValue());
	}

}
