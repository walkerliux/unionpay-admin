package com.unionpay.withhold.trade.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.unionpay.withhold.trade.pay.dao.OrderCollectBatchPayDAO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectBatchPayDO;
import com.unionpay.withhold.trade.pay.service.BatchOrderPayServcie;

@Service
public class BatchOrderPayServcieImpl implements BatchOrderPayServcie {

	@Autowired
	private OrderCollectBatchPayDAO orderCollectBatchPayDAO;
	
	@Override
	@Transactional(readOnly=true)
	public OrderCollectBatchPayDO getCollectBatchOrder(String tn) {
		return orderCollectBatchPayDAO.getCollectBatchOrder(tn);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateCollectBatchOrder(OrderCollectBatchPayDO record) {
		// TODO Auto-generated method stub
		orderCollectBatchPayDAO.updateByTN(record);
	}

	
}
