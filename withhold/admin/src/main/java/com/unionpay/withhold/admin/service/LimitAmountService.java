package com.unionpay.withhold.admin.service;


import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitAmountsMemDay;


public interface LimitAmountService {


	PageBean queryLimitMemAmountsDay(Long caseid,
			Integer page, Integer rows);

	ResultBean saveLimitMemAmountDay(TLimitAmountsMemDay limitMenAmountsDay);

	TLimitAmountsMemDay queryLimitMemAmountsDaybytid(Integer tid);

	ResultBean updateLimitMemMAmountDay(TLimitAmountsMemDay limitMenAmountsDay
			);

	
	ResultBean deleteLimitMemAmountDay(TLimitAmountsMemDay limitMenAmountsDay);

	ResultBean startLimitMemDay(TLimitAmountsMemDay limitMenAmountsDay);



}
