package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.bean.BatchCollectQueryBean;
import com.unionpay.withhold.trade.order.dao.OrderCollectBatchDAO;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;
import com.unionpay.withhold.trade.order.service.BatchOrderServcie;

@Service//("batchOrderServcie")
public class BatchOrderServcieImpl implements BatchOrderServcie {

	@Autowired
	private OrderCollectBatchDAO orderCollectBatchDAO;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void saveBatchOrder(OrderCollectBatchDO orderCollectBatch) {
		orderCollectBatchDAO.insert(orderCollectBatch);
	}

	@Override
	@Transactional(readOnly=true)
	public OrderCollectBatchDO getCollectBatchOrder(String merchNo, String batchNo, String txndate) {
		OrderCollectBatchDO record = new OrderCollectBatchDO();
		record.setMerid(merchNo);
		record.setBatchno(batchNo);
		record.setTxndate(txndate);
		return orderCollectBatchDAO.getCollectBatchOrder(record);
	}

	@Override
	@Transactional(readOnly=true)
	public OrderCollectBatchDO queryCollectBatchOrder(BatchCollectQueryBean batchCollectQueryBean) {
		OrderCollectBatchDO record = new OrderCollectBatchDO();
		record.setTn(batchCollectQueryBean.getTn());
		record.setTxndate(batchCollectQueryBean.getTxnDate());
		record.setBatchno(batchCollectQueryBean.getBatchNo());
		return orderCollectBatchDAO.queryCollectBatchOrder(record);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void updateOrderCollectBatch(OrderCollectBatchDO orderCollectBatch) {
		orderCollectBatchDAO.updateByTN(orderCollectBatch);
	}
	
	

}
