package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.bean.SingleCollectQueryBean;
import com.unionpay.withhold.trade.order.dao.OrderCollectSingleDAO;
import com.unionpay.withhold.trade.order.enums.TableEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
import com.unionpay.withhold.trade.order.service.SerialNumberService;

@Service
public class OrderCollectSingleServiceImpl implements OrderCollectSingleService {

	@Autowired
	private OrderCollectSingleDAO orderCollectSingleDAO;
	@Autowired
	private SerialNumberService serialNumberService;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveOrderCollectSingle(OrderCollectSingleDO orderCollectSingle) {
		orderCollectSingle.setTid(serialNumberService.generateTID(TableEnum.SINGLECOLLECTIONORDER));
		orderCollectSingleDAO.insert(orderCollectSingle);
	}
	@Override
	@Transactional(readOnly=true)
	public OrderCollectSingleDO getOrderinfoByOrderNoAndMerchNo(String merchNo,String orderNo) {
		OrderCollectSingleDO record = new OrderCollectSingleDO();
		record.setMerid(merchNo);
		record.setOrderid(orderNo);
		return orderCollectSingleDAO.getCollctSingleOrder(record);
	}
	@Override
	@Transactional(readOnly=true)
	public OrderCollectSingleDO queryOrderinfo(SingleCollectQueryBean singleCollectQueryBean) {
		OrderCollectSingleDO record = new OrderCollectSingleDO();
		record.setMerid(singleCollectQueryBean.getMchntCd());
		record.setOrderid(singleCollectQueryBean.getOrderId());
		record.setTxntime(singleCollectQueryBean.getTransTm());
		record.setTn(singleCollectQueryBean.getTransQueryId());
		return orderCollectSingleDAO.queryCollctSingleOrder(record);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateOrderCollectSingle(OrderCollectSingleDO orderCollectSingle) {
		// TODO Auto-generated method stub
		orderCollectSingleDAO.updateBySelective(orderCollectSingle);
	}
	
}
