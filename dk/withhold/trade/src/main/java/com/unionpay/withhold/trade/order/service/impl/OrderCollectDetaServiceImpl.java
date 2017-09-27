package com.unionpay.withhold.trade.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.OrderCollectDetaDAO;
import com.unionpay.withhold.trade.order.enums.TableEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;
import com.unionpay.withhold.trade.order.service.OrderCollectDetaService;
import com.unionpay.withhold.trade.order.service.SerialNumberService;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;

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
	
	@Override
	@Transactional(readOnly=true)
	public List<OrderCollectDetaDO> queryCollectOrderDeta(Long batchId){
		return orderCollectDetaDAO.queryCollectOrderDeta(batchId);
	}

	

	
}
