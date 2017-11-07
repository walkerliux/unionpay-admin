package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TLimitAmountsPanDayMapper;
import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDay;
import com.unionpay.withhold.admin.service.LimitCardAmtService;
@Service
@Transactional
public class LimitCardAmtServiceImpl implements LimitCardAmtService {
	@Autowired
	private TLimitAmountsPanDayMapper limitAmountsPanDayMapper;
	
	public PageBean queryLimitMemNumsDay(Long caseid,
			Integer page, Integer rows) {
		Integer beginRow = (page - 1) * rows;
		
		List<TLimitAmountsPanDay> list = limitAmountsPanDayMapper.queryLimitMemNumsDay(caseid,beginRow, rows);
		
		//把金额单位换成元
		for (TLimitAmountsPanDay tLimitAmountsPanDay : list) {
			tLimitAmountsPanDay.setLimitAmount(tLimitAmountsPanDay.getLimitAmount()/100);
		}
		int count = limitAmountsPanDayMapper.selectCountWithCondition(caseid);
		
		return new PageBean(count, list);
		
	}

	@Override
	public ResultBean saveLimitMemNumDay(TLimitAmountsPanDay limitAmountsPanDay) {
		
		//判断交易限额是否有效
		Long caseid = limitAmountsPanDay.getCaseid();
		String cardtype= limitAmountsPanDay.getCardtype();
		List<TLimitAmountsPanDay> list = limitAmountsPanDayMapper.queryAllLimitMemNumsDay(caseid,cardtype);
		for (TLimitAmountsPanDay tlimitAmountsPanDay : list) {
			if(limitAmountsPanDay.getRisklevel()<tlimitAmountsPanDay.getRisklevel()&&
			limitAmountsPanDay.getLimitAmount()>=tlimitAmountsPanDay.getLimitAmount()){
				return new ResultBean("此规定限额与其他限额冲突");
			}else if(limitAmountsPanDay.getRisklevel()==tlimitAmountsPanDay.getRisklevel()){
				return new ResultBean("此规定限额已存在");
			}else if(limitAmountsPanDay.getRisklevel()>tlimitAmountsPanDay.getRisklevel()&&
					   limitAmountsPanDay.getLimitAmount()<=tlimitAmountsPanDay.getLimitAmount()){
				return new ResultBean("此规定限额与其他限额冲突");
			}
		}
		
		limitAmountsPanDay.setStatus("00");
		//把金额单位换成分
		limitAmountsPanDay.setLimitAmount(limitAmountsPanDay.getLimitAmount()*100);
		
		int flag =limitAmountsPanDayMapper.insertSelective(limitAmountsPanDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}

	}

	@Override
	public TLimitAmountsPanDay queryLimitMemNumsDaybytid(Integer tid) {
		
		TLimitAmountsPanDay  limitMemNumsDay= limitAmountsPanDayMapper.queryLimitMemNumsDaybytid(tid);
		//把金额单位换成元
		limitMemNumsDay.setLimitAmount(limitMemNumsDay.getLimitAmount()/100);
		return limitMemNumsDay;
	}

	@Override
	public ResultBean updateLimitMemMNumDay(TLimitAmountsPanDay limitAmountsPanDay) {
		//判断交易限额是否有效
		Long caseid = limitAmountsPanDay.getCaseid();
		String cardtype= limitAmountsPanDay.getCardtype();
		List<TLimitAmountsPanDay> list = limitAmountsPanDayMapper.queryAllLimitMemNumsDayOther(caseid,cardtype,limitAmountsPanDay.getTid());
		for (TLimitAmountsPanDay tlimitAmountsPanDay : list) {
			if(limitAmountsPanDay.getRisklevel()<tlimitAmountsPanDay.getRisklevel()&&
			   limitAmountsPanDay.getLimitAmount()>=tlimitAmountsPanDay.getLimitAmount()){
				return new ResultBean("此规定限额与其他限额冲突");
			}else if(limitAmountsPanDay.getRisklevel()>tlimitAmountsPanDay.getRisklevel()&&
					   limitAmountsPanDay.getLimitAmount()<=tlimitAmountsPanDay.getLimitAmount()){
				return new ResultBean("此规定限额与其他限额冲突");
			}
			}
						
		limitAmountsPanDay.setStatus("00");
		
		//把金额单位换成分
		limitAmountsPanDay.setLimitAmount(limitAmountsPanDay.getLimitAmount()*100);
		
		int flag =limitAmountsPanDayMapper.updateByPrimaryKey(limitAmountsPanDay);
		if(flag>0){
			return new ResultBean("操作成功");
		}else{
			return new ResultBean("","添加失败！");
		}
	}


	@Override
	public ResultBean deleteLimitMemNumDay(TLimitAmountsPanDay limitAmountsPanDay) {
		limitAmountsPanDay.setStatus("01");
		int flag =limitAmountsPanDayMapper.updateByPrimaryKeySelective(limitAmountsPanDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}

	@Override
	public ResultBean startLimitMemDay(TLimitAmountsPanDay limitAmountsPanDay) {
		limitAmountsPanDay.setStatus("00");
		int flag =limitAmountsPanDayMapper.updateByPrimaryKeySelective(limitAmountsPanDay);
		 if(flag>0){
				return new ResultBean("操作成功");
			}else{
				return new ResultBean("","添加失败！");
			}
	}
}
