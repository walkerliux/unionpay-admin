package com.unionpay.withhold.trade.pay.service;

import java.util.List;

import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;

public interface TxnLogPayService {

	/**
	 * 更新核心交易流水数据
	 * @param txnLogPay
	 */
	public void updateTxnLogPay(TxnLogPayDO txnLogPay);

	/**
	 * 查询核心交易流水
	 * @param txnseqno
	 * @return
	 */
	public TxnLogPayDO queryTxnLog(String txnseqno);
	
	/**
	 * 获取批量明细的交易流水集合
	 * @param batchid
	 * @return
	 */
	public List<TxnLogPayDO> queryBatchDetaTxnLog(Long batchid);
}
