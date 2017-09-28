package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.bean.BatchCollectQueryBean;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;

public interface BatchOrderServcie {

	/**
	 * 保存批量代扣订单
	 * @param orderCollectBatch
	 */
	public void saveBatchOrder(OrderCollectBatchDO orderCollectBatch);
	
	/**
	 * 查询代收批次数据
	 * @param merchNo
	 * @param batchNo
	 * @param txndate
	 * @return
	 */
	public OrderCollectBatchDO getCollectBatchOrder(String merchNo,String batchNo,String txndate);
	
	/**
	 * 查询代收批次数据（商户接口）
	 * @param batchCollectQueryBean
	 * @return
	 */
	public OrderCollectBatchDO queryCollectBatchOrder(BatchCollectQueryBean batchCollectQueryBean);
}
