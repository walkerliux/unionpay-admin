package com.unionpay.withhold.trade.pay.service;

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
}
