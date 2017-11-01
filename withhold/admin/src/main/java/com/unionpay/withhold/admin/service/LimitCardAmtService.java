package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitAmountsPanDay;


public interface LimitCardAmtService {

	PageBean queryLimitMemNumsDay(Long caseid,
			Integer page, Integer rows);

	ResultBean saveLimitMemNumDay(TLimitAmountsPanDay limitAmountsPanDay);

	TLimitAmountsPanDay queryLimitMemNumsDaybytid(Integer tid);

	ResultBean updateLimitMemMNumDay(TLimitAmountsPanDay limitAmountsPanDay
			);

	ResultBean deleteLimitMemNumDay(TLimitAmountsPanDay limitAmountsPanDay);

	ResultBean startLimitMemDay(TLimitAmountsPanDay limitAmountsPanDay);

}
