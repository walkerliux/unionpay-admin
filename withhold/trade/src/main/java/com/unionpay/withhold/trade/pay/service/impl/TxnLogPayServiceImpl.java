package com.unionpay.withhold.trade.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.pay.dao.TxnLogPayDAO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
@Service
public class TxnLogPayServiceImpl implements TxnLogPayService {

	@Autowired
	private TxnLogPayDAO txnLogPayDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateTxnLogPay(TxnLogPayDO txnLogPay) {
		txnLogPayDAO.updateByPrimaryKey(txnLogPay);
	}
	@Override
	@Transactional(readOnly=true)
	public TxnLogPayDO queryTxnLog(String txnseqno) {
		return txnLogPayDAO.selectByPrimaryKey(txnseqno);
	}

}
