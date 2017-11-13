package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TLimitNumsPanDayMapper;
import com.unionpay.withhold.admin.pojo.TLimitNumsPanDay;
import com.unionpay.withhold.admin.service.LimitCardNumService;
@Service
@Transactional
public class LimitCardNumServiceImpl implements LimitCardNumService {
	@Autowired
	private TLimitNumsPanDayMapper limitNumsPanDayMapper;
	
	@Override
	public PageBean queryLimitMemNumsDay(Long caseid,
			Integer page, Integer rows) {
		Integer beginRow = (page - 1) * rows;
		
		List<TLimitNumsPanDay> list = limitNumsPanDayMapper.queryLimitMemNumsDay(caseid,beginRow, rows);
		int count = limitNumsPanDayMapper.selectCountWithCondition(caseid);
		
		return new PageBean(count, list);
		
	}

	@Override
	public ResultBean saveLimitMemNumDay(TLimitNumsPanDay limitMenNumsDay) {
		
		//判断交易限次是否有效
		Long caseid = limitMenNumsDay.getCaseid();
		String cardtype= limitMenNumsDay.getCardtype();
		List<TLimitNumsPanDay> list = limitNumsPanDayMapper.queryAllLimitMemNumsDay(caseid,cardtype);
		for (TLimitNumsPanDay tLimitNumsPanDay : list) {
			if(limitMenNumsDay.getRisklevel()<tLimitNumsPanDay.getRisklevel()&&
			limitMenNumsDay.getLimitCount()>=tLimitNumsPanDay.getLimitCount()){
				return new ResultBean("","此规定限次与其他限次冲突");
			}else if(limitMenNumsDay.getRisklevel()==tLimitNumsPanDay.getRisklevel()){
				return new ResultBean("","此规定限次已存在");
			}else if(limitMenNumsDay.getRisklevel()>tLimitNumsPanDay.getRisklevel()&&
					   limitMenNumsDay.getLimitCount()<=tLimitNumsPanDay.getLimitCount()){
				return new ResultBean("","此规定限次与其他限次冲突");
			}
		}
		
		limitMenNumsDay.setStatus("00");
		int flag =limitNumsPanDayMapper.insertSelective(limitMenNumsDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}

	}

	@Override
	public TLimitNumsPanDay queryLimitMemNumsDaybytid(Integer tid) {
		
		TLimitNumsPanDay  limitMemNumsDay= limitNumsPanDayMapper.queryLimitMemNumsDaybytid(tid);
		return limitMemNumsDay;
	}

	@Override
	public ResultBean updateLimitMemMNumDay(TLimitNumsPanDay limitMenNumsDay) {
		//判断交易限次是否有效
		Long caseid = limitMenNumsDay.getCaseid();
		String cardtype= limitMenNumsDay.getCardtype();
		List<TLimitNumsPanDay> list = limitNumsPanDayMapper.queryAllLimitMemNumsDayOther(caseid,cardtype,limitMenNumsDay.getTid());
		for (TLimitNumsPanDay tLimitNumsPanDay : list) {
			if(limitMenNumsDay.getRisklevel()<tLimitNumsPanDay.getRisklevel()&&
			   limitMenNumsDay.getLimitCount()>=tLimitNumsPanDay.getLimitCount()){
				return new ResultBean("","此规定限次与其他限次冲突");
			}else if(limitMenNumsDay.getRisklevel()==tLimitNumsPanDay.getRisklevel()){
				return new ResultBean("","此规定限次已存在");
			}else if(limitMenNumsDay.getRisklevel()>tLimitNumsPanDay.getRisklevel()&&
					   limitMenNumsDay.getLimitCount()<=tLimitNumsPanDay.getLimitCount()){
				return new ResultBean("","此规定限次与其他限次冲突");
			}
			}
						
		limitMenNumsDay.setStatus("00");
		int flag =limitNumsPanDayMapper.updateByPrimaryKey(limitMenNumsDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}
	}


	@Override
	public ResultBean deleteLimitMemNumDay(TLimitNumsPanDay limitMenNumsDay) {
		limitMenNumsDay.setStatus("01");
		int flag =limitNumsPanDayMapper.updateByPrimaryKeySelective(limitMenNumsDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}

	@Override
	public ResultBean startLimitMemDay(TLimitNumsPanDay limitMenNumsDay) {
		limitMenNumsDay.setStatus("00");
		int flag =limitNumsPanDayMapper.updateByPrimaryKeySelective(limitMenNumsDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}
}
