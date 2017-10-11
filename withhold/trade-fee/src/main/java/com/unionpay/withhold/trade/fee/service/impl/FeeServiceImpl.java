package com.unionpay.withhold.trade.fee.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.fee.bean.FeeBean;
import com.unionpay.withhold.trade.fee.dao.FeeDAO;
import com.unionpay.withhold.trade.fee.service.FeeService;

@Service
public class FeeServiceImpl implements FeeService{

	@Autowired
	private FeeDAO feeDAO;
	
	
	@Override
	@Transactional(readOnly=true)
	public Long getMerchFee(FeeBean feeBean) {
		// TODO Auto-generated method stub
		return feeDAO.getMerchFee(feeBean);
	}

	@Override
	@Transactional(readOnly=true)
	public Long getAisleFee(FeeBean feeBean) {
		// TODO Auto-generated method stub
		return feeDAO.getAisleFee(feeBean);
	}

	@Override
	@Transactional(readOnly=true)
	public Long getAgentFee(FeeBean feeBean) {
		// TODO Auto-generated method stub
		return feeDAO.getAgentFee(feeBean);
	}

}
