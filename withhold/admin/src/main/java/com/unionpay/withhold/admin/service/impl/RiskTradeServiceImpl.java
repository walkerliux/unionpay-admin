package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TRiskTradeLogMapper;
import com.unionpay.withhold.admin.pojo.TRiskTradeLog;
import com.unionpay.withhold.admin.pojo.TRiskTradeLogExample;
import com.unionpay.withhold.admin.pojo.TRiskTradeLogExample.Criteria;
import com.unionpay.withhold.admin.service.RiskTradeService;
import com.unionpay.withhold.admin.utils.DateTimeReplaceUtil;
@Service
@Transactional
public class RiskTradeServiceImpl implements RiskTradeService {
	@Autowired
	private TRiskTradeLogMapper tRiskTradeLogMapper;
	@Override
	public PageBean getRiskRradeLogByPage(TRiskTradeLog riskTradeLog,
			String stime, String etime, int page, int rows) {
		TRiskTradeLogExample riskTradeLogExample = new TRiskTradeLogExample();
		Criteria createCriteria = riskTradeLogExample.createCriteria();
		//商户号
		if (riskTradeLog.getMerchno()!=null&&!"".equals(riskTradeLog.getMerchno())) {
			createCriteria.andMerchnoEqualTo(riskTradeLog.getMerchno());
		}
		//交易卡号
		if (riskTradeLog.getPan()!=null&&!"".equals(riskTradeLog.getPan())) {
			createCriteria.andPanEqualTo(riskTradeLog.getPan());
		}
		//商户订单号
		if (riskTradeLog.getOrderno()!=null&&!"".equals(riskTradeLog.getOrderno())) {
			createCriteria.andOrdernoEqualTo(riskTradeLog.getOrderno());
		}
		//交易序列号
		if (riskTradeLog.getTxnseqno()!=null&&!"".equals(riskTradeLog.getTxnseqno())) {
			createCriteria.andTxnseqnoEqualTo(riskTradeLog.getTxnseqno());
		}
		//起止时间
		if (stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
			String startTime = DateTimeReplaceUtil.replace(stime);
			String endTime = DateTimeReplaceUtil.replace(etime);
			createCriteria.andAcqdatetimeBetween(startTime, endTime);
		}
		//count
		int total = tRiskTradeLogMapper.countByExample(riskTradeLogExample);
		//设置分页条件
		riskTradeLogExample.setPageNum(page);
		riskTradeLogExample.setPageSize(rows);
		//排序规则
		riskTradeLogExample.setOrderByClause("TID DESC");
		List<TRiskTradeLog> list = tRiskTradeLogMapper.selectByExample(riskTradeLogExample);
		return new PageBean(total, list);
	}

}
