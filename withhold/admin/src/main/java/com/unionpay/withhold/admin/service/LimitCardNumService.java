package com.unionpay.withhold.admin.service;



import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitNumsPanDay;


public interface LimitCardNumService {
	PageBean queryLimitMemNumsDay(Long caseid,
			Integer page, Integer rows);

	ResultBean saveLimitMemNumDay(TLimitNumsPanDay limitNumsPanDay);

	TLimitNumsPanDay queryLimitMemNumsDaybytid(Integer tid);

	ResultBean updateLimitMemMNumDay(TLimitNumsPanDay limitNumsPanDay
			);

	ResultBean deleteLimitMemNumDay(TLimitNumsPanDay limitNumsPanDay);

	ResultBean startLimitMemDay(TLimitNumsPanDay limitNumsPanDay);
}
