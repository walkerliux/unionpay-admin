package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.OrderCollectBatchDAO;
import com.unionpay.withhold.trade.order.enums.TableEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;
import com.unionpay.withhold.trade.order.service.BatchOrderServcie;
import com.unionpay.withhold.trade.order.service.SerialNumberService;

@Service//("batchOrderServcie")
public class BatchOrderServcieImpl implements BatchOrderServcie {

	@Autowired
	private OrderCollectBatchDAO orderCollectBatchDAO;
	@Autowired
	private SerialNumberService serialNumberService;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
	public void saveBatchOrder(OrderCollectBatchDO orderCollectBatch) {
		orderCollectBatch.setTid(serialNumberService.generateTID(TableEnum.BATCHCOLLECTIONORDER));
		orderCollectBatchDAO.insert(orderCollectBatch);
	}

}
