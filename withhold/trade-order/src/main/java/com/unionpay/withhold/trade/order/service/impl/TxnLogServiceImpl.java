package com.unionpay.withhold.trade.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.TxnLogDAO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.service.TxnLogService;

@Service
public class TxnLogServiceImpl implements TxnLogService {

	@Autowired
	private TxnLogDAO txnLogDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveTxnLog(TxnLogDO txnLogDO) {
		txnLogDAO.insert(txnLogDO);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateTxnLog(TxnLogDO txnLogDO) {
		txnLogDAO.updateByPrimaryKeySelective(txnLogDO);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void batchSaveTxnLog(List<TxnLogDO> txnLogList) {
		for(TxnLogDO txnLogDO : txnLogList) {
			txnLogDAO.insert(txnLogDO);
		}
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void batchUpdateTxnLog(List<TxnLogDO> txnLogList) {
		for(TxnLogDO txnLogDO : txnLogList) {
			txnLogDAO.updateByPrimaryKeySelective(txnLogDO);
		}
	}
}
