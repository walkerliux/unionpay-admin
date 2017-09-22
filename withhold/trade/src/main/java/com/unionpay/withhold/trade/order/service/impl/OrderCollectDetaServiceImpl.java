package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.OrderCollectDetaDAO;
import com.unionpay.withhold.trade.order.enums.TableEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;
import com.unionpay.withhold.trade.order.service.OrderCollectDetaService;
import com.unionpay.withhold.trade.order.service.SerialNumberService;

@Service//("orderCollectDetaService")
public class OrderCollectDetaServiceImpl implements OrderCollectDetaService{

	@Autowired
	private OrderCollectDetaDAO orderCollectDetaDAO;
	@Autowired
	private SerialNumberService serialNumberService;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveOrderCollectDeta(OrderCollectDetaDO orderCollectDeta) {
		orderCollectDeta.setTid(serialNumberService.generateTID(TableEnum.BATCHCOLLECTIONORDERDETA));
		orderCollectDetaDAO.insert(orderCollectDeta);
	}

	
}
