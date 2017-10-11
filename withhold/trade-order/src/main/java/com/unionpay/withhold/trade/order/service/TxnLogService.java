package com.unionpay.withhold.trade.order.service;

import java.util.List;

import com.unionpay.withhold.trade.order.pojo.TxnLogDO;

public interface TxnLogService {

	/**
	 * 保存核心交易流水
	 * @param txnLogDO
	 */
	public void saveTxnLog(TxnLogDO txnLogDO);
	
	/**
	 * 更新核心交易流水信息
	 * @param txnLogDO
	 */
	public void updateTxnLog(TxnLogDO txnLogDO);

	/**
	 * 批量保存核心交易流水信息
	 * @param txnLogList
	 */
	public void batchSaveTxnLog(List<TxnLogDO> txnLogList);
	/**
	 * 批量更新核心交易流水数据
	 * @param txnLogList
	 */
	public void batchUpdateTxnLog(List<TxnLogDO> txnLogList);
}
