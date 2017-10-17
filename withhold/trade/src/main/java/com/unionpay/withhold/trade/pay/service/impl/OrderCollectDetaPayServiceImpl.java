package com.unionpay.withhold.trade.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.pay.dao.OrderCollectDetaPayDAO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectDetaPayService;

@Service
public class OrderCollectDetaPayServiceImpl implements OrderCollectDetaPayService{

	@Autowired
	private OrderCollectDetaPayDAO orderCollectDetaPayDAO;
	
	@Override
	@Transactional(readOnly=true)
	public List<OrderCollectDetaPayDO> queryCollectOrderDeta(Long batchId) {
		return orderCollectDetaPayDAO.queryCollectOrderDeta(batchId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public int updateOrderStatus(OrderCollectDetaPayDO orderCollectDetaPay) {
		// TODO Auto-generated method stub
		return orderCollectDetaPayDAO.updateOrderStatus(orderCollectDetaPay);
	}

}
