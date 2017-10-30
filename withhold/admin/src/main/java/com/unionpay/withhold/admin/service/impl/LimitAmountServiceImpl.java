package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TLimitAmountsMemDayMapper;
import com.unionpay.withhold.admin.pojo.TLimitAmountsMemDay;
import com.unionpay.withhold.admin.service.LimitAmountService;
@Service
@Transactional
public class LimitAmountServiceImpl implements LimitAmountService {
	@Autowired
	private TLimitAmountsMemDayMapper limitAmountsMemDayMapper;
	@Override
	public PageBean queryLimitMemAmountsDay(Long caseid, Integer page,
			Integer rows) {
		Integer beginRow = (page - 1) * rows;
		
		List<TLimitAmountsMemDay> list = limitAmountsMemDayMapper.queryLimitMemNumsDay(caseid,beginRow, rows);
		int count = limitAmountsMemDayMapper.selectCountWithCondition(caseid);
		
		return new PageBean(count, list);
	}

	@Override
	public ResultBean saveLimitMemAmountDay(
			TLimitAmountsMemDay limitMenAmountsDay) {
		//判断交易限次是否有效
				Long caseid = limitMenAmountsDay.getCaseid();
				List<TLimitAmountsMemDay> list = limitAmountsMemDayMapper.queryAllLimitMemNumsDay(caseid);
				for (TLimitAmountsMemDay tLimitMemNumsDay : list) {
					if(limitMenAmountsDay.getRisklevel()<tLimitMemNumsDay.getRisklevel()&&
							limitMenAmountsDay.getLimitAmount().compareTo(tLimitMemNumsDay.getLimitAmount())>=0){
								return new ResultBean("此规定限额与其他限次冲突");
							}else if(limitMenAmountsDay.getRisklevel()==tLimitMemNumsDay.getRisklevel()){
								return new ResultBean("此规定限额已存在");
							}else if(limitMenAmountsDay.getRisklevel()>tLimitMemNumsDay.getRisklevel()&&
									   limitMenAmountsDay.getLimitAmount().compareTo(tLimitMemNumsDay.getLimitAmount())<=0){
								return new ResultBean("此规定限额与其他限次冲突");
							}
				}
				
				limitMenAmountsDay.setStatus("00");
				int flag =limitAmountsMemDayMapper.insertSelective(limitMenAmountsDay);
				if(flag>0){
					return new ResultBean("操作成功");
				}else{
					return new ResultBean("","添加失败！");
				}
	}

	@Override
	public TLimitAmountsMemDay queryLimitMemAmountsDaybytid(Integer tid) {
		TLimitAmountsMemDay  limitMemAmountDay= limitAmountsMemDayMapper.queryLimitMemNumsDaybytid(tid);
		return limitMemAmountDay;
	}

	@Override
	public ResultBean updateLimitMemMAmountDay(
			TLimitAmountsMemDay limitMenAmountsDay) {
		//判断交易限次是否有效
		Long caseid = limitMenAmountsDay.getCaseid();
		List<TLimitAmountsMemDay> list = limitAmountsMemDayMapper.queryAllLimitMemNumsDay(caseid);
		for (TLimitAmountsMemDay tLimitMemNumsDay : list) {
			if(limitMenAmountsDay.getRisklevel()<tLimitMemNumsDay.getRisklevel()&&
					limitMenAmountsDay.getLimitAmount().compareTo(tLimitMemNumsDay.getLimitAmount())>=0){
				return new ResultBean("此规定限额与其他限次冲突");
			}else if(limitMenAmountsDay.getRisklevel()>tLimitMemNumsDay.getRisklevel()&&
					limitMenAmountsDay.getLimitAmount().compareTo(tLimitMemNumsDay.getLimitAmount())<=0){
				return new ResultBean("此规定限额与其他限次冲突");
			}
		}
		limitMenAmountsDay.setStatus("00");
		int flag =limitAmountsMemDayMapper.updateByPrimaryKey(limitMenAmountsDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}
	}


	@Override
	public ResultBean deleteLimitMemAmountDay(
			TLimitAmountsMemDay limitMenAmountsDay) {
		limitMenAmountsDay.setStatus("01");
		int flag =limitAmountsMemDayMapper.updateByPrimaryKeySelective(limitMenAmountsDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}

	@Override
	public ResultBean startLimitMemDay(TLimitAmountsMemDay limitMenAmountsDay) {
		limitMenAmountsDay.setStatus("00");
		int flag =limitAmountsMemDayMapper.updateByPrimaryKeySelective(limitMenAmountsDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}

}
