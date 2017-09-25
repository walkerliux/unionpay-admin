package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.TxnLogDO;

public interface TxnLogService {

	/**
	 * 保存核心交易流水
	 * @param txnLogDO
	 */
	public void saveTxnLog(TxnLogDO txnLogDO);
	
	public void updateTxnLog(TxnLogDO txnLogDO);
}
