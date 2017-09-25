package com.unionpay.withhold.trade.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.pay.dao.RspmsgPayDAO;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
@Service
public class RspmsgPayServiceImpl implements RspmsgPayService {

	@Autowired
	private RspmsgPayDAO rspmsgPayDAO;
	
	@Override
	@Transactional(readOnly=true)
	public RspmsgPayDO getRspmsgPay(RspmsgPayDO rspmsgPay) {
		// TODO Auto-generated method stub
		return rspmsgPayDAO.getTradeRsp(rspmsgPay);
	}

}
