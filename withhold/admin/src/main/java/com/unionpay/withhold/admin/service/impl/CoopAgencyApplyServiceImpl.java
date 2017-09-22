package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TCoopAgencyApplyMapper;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;
import com.unionpay.withhold.admin.service.CoopAgencyApplyService;

@Service
@Transactional
public class CoopAgencyApplyServiceImpl implements CoopAgencyApplyService {
	@Autowired
	private TCoopAgencyApplyMapper coopAgencyApplyMapper;
	
	@Override
	public PageBean queryByPage(TCoopAgencyApplyExample coopAgencyApplyExample) {
		int count = coopAgencyApplyMapper.countByExample(coopAgencyApplyExample);
		List<TCoopAgencyApply> list = coopAgencyApplyMapper.selectByExample(coopAgencyApplyExample);
		return new PageBean(count, list);
	}

	@Override
	public ResultBean addCoopAgencyApply(TCoopAgencyApply coopAgencyApply) {
		int count = coopAgencyApplyMapper.insertSelective(coopAgencyApply);
		if (count > 0) {
			return new ResultBean("添加成功 ！");
		} else {
			return new ResultBean("","添加失败！");
		}
	}
}
