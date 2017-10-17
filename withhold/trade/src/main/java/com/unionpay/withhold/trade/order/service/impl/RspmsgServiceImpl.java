package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.RspmsgDAO;
import com.unionpay.withhold.trade.order.pojo.RspmsgDO;
import com.unionpay.withhold.trade.order.service.RspmsgService;
@Service
public class RspmsgServiceImpl implements RspmsgService {

	@Autowired
	private RspmsgDAO rspmsgDAO;
	
	@Override
	@Transactional(readOnly=true)
	public RspmsgDO getRspmsg(RspmsgDO rspmsg) {
		// TODO Auto-generated method stub
		return rspmsgDAO.getTradeRsp(rspmsg);
	}
}
