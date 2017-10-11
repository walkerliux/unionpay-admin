package com.unionpay.withhold.trade.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.pay.dao.OrderCollectSinglePayDAO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectSinglePayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectSinglePayService;

@Service
public class OrderCollectSinglePayServiceImpl implements OrderCollectSinglePayService {

	@Autowired
	private OrderCollectSinglePayDAO orderCollectSinglePayDAO;

	@Override
	@Transactional(readOnly=true)
	public OrderCollectSinglePayDO querySingleCollectOrder(OrderCollectSinglePayDO orderCollectSinglePay) {
		// TODO Auto-generated method stub
		return orderCollectSinglePayDAO.querySingleOrder(orderCollectSinglePay);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateSingleCollectOrder(OrderCollectSinglePayDO orderCollectSinglePay) {
		// TODO Auto-generated method stub
		orderCollectSinglePayDAO.updateBySelective(orderCollectSinglePay);
	}
	
	
}
