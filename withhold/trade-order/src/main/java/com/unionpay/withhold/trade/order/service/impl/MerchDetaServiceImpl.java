package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.MerchDetaDAO;
import com.unionpay.withhold.trade.order.pojo.MerchDetaDO;
import com.unionpay.withhold.trade.order.service.MerchDetaService;

@Service
public class MerchDetaServiceImpl implements MerchDetaService{

	@Autowired
	private MerchDetaDAO merchDetaDAO;

	@Override
	@Transactional(readOnly=true)
	public MerchDetaDO getMerchByMemberId(String memberId) {
		return merchDetaDAO.getByMerchNo(memberId);
	}
	
}
