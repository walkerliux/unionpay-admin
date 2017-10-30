package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TRateAccumDetaMapper;
import com.unionpay.withhold.admin.mapper.TRateAccumMapper;
import com.unionpay.withhold.admin.pojo.TRateAccum;
import com.unionpay.withhold.admin.pojo.TRateAccumExample;
import com.unionpay.withhold.admin.service.FeeService;
@Service
@Transactional
public class FeeServiceImpl implements FeeService {
	
	@Autowired
	private TRateAccumDetaMapper tRateAccumDetaMapper;
	@Autowired
	private TRateAccumMapper tRateAccumMapper;
	@Override
	public PageBean queryAmtAccumRate(String rateId, String rateDesc, int page,
			int rows) {
		//queryAmtAccumRate
		TRateAccumExample tRateAccumExample = new TRateAccumExample();
		if (rateId!=null&&!"".equals(rateId)) {
			tRateAccumExample.setRateId(rateId);
		}
		if (rateDesc!=null&&!"".equals(rateDesc)) {
			tRateAccumExample.setRateDesc(rateDesc);
		}
		int total = tRateAccumMapper.queryAmtAccumRate(tRateAccumExample).size();
		tRateAccumExample.setPageNum(page);
		tRateAccumExample.setPageSize(rows);
		List<TRateAccum> result = tRateAccumMapper.queryAmtAccumRate(tRateAccumExample);
		return new PageBean(total, result);
	}

}
