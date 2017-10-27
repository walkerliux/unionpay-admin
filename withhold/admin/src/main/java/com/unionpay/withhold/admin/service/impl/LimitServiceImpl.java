package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TLimitMemNumsDayMapper;
import com.unionpay.withhold.admin.mapper.TRiskMapper;
import com.unionpay.withhold.admin.pojo.TLimitMemNumsDay;
import com.unionpay.withhold.admin.pojo.TRisk;
import com.unionpay.withhold.admin.service.LimitService;
import com.unionpay.withhold.admin.utils.StringUtil;
@Service
@Transactional
public class LimitServiceImpl implements LimitService {
	@Autowired
	private TLimitMemNumsDayMapper limitMemNumsDayMapper;
	@Autowired
	private TRiskMapper riskMapper;
	@Override
	public PageBean queryLimitMemNumsDay(Long caseid,
			Integer page, Integer rows) {
		Integer beginRow = (page - 1) * rows;
		
		List<TLimitMemNumsDay> list = limitMemNumsDayMapper.queryLimitMemNumsDay(caseid,beginRow, rows);
		int count = limitMemNumsDayMapper.selectCountWithCondition(caseid);
		
		return new PageBean(count, list);
		
	}

	@Override
	public ResultBean saveLimitMemNumDay(TLimitMemNumsDay limitMenNumsDay) {
		
		limitMenNumsDay.setStatus("00");
		
		int flag =limitMemNumsDayMapper.insertSelective(limitMenNumsDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}

	}

	@Override
	public TLimitMemNumsDay queryLimitMemNumsDaybytid(Integer tid) {
		
		TLimitMemNumsDay  limitMemNumsDay= limitMemNumsDayMapper.queryLimitMemNumsDaybytid(tid);
		return limitMemNumsDay;
	}

	@Override
	public ResultBean updateLimitMemMNumDay(TLimitMemNumsDay limitMenNumsDay) {
		limitMenNumsDay.setStatus("00");
		
		int flag =limitMemNumsDayMapper.updateByPrimaryKey(limitMenNumsDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}
	}

	@Override
	public List<TRisk> getAllLimitRiskList() {
		
		return riskMapper.getAllLimitRiskList();
	}

	@Override
	public ResultBean deleteLimitMemNumDay(TLimitMemNumsDay limitMenNumsDay) {
		limitMenNumsDay.setStatus("01");
		int flag =limitMemNumsDayMapper.updateByPrimaryKeySelective(limitMenNumsDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}

	@Override
	public ResultBean startLimitMemDay(TLimitMemNumsDay limitMenNumsDay) {
		limitMenNumsDay.setStatus("00");
		int flag =limitMemNumsDayMapper.updateByPrimaryKeySelective(limitMenNumsDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}
}
