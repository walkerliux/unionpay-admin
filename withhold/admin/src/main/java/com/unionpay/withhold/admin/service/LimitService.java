package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitMemNumsDay;
import com.unionpay.withhold.admin.pojo.TRisk;

public interface LimitService {

	PageBean queryLimitMemNumsDay(Long caseid,
			Integer page, Integer rows);

	ResultBean saveLimitMemNumDay(TLimitMemNumsDay limitMenNumsDay);

	TLimitMemNumsDay queryLimitMemNumsDaybytid(Integer tid);

	ResultBean updateLimitMemMNumDay(TLimitMemNumsDay limitMenNumsDay
			);

	List<TRisk> getAllLimitRiskList();

	ResultBean deleteLimitMemNumDay(TLimitMemNumsDay limitMenNumsDay);

	ResultBean startLimitMemDay(TLimitMemNumsDay limitMenNumsDay);
	
	

}
