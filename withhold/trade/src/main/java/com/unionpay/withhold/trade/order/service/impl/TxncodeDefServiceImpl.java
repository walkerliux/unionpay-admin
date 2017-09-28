package com.unionpay.withhold.trade.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.order.dao.TxncodeDefDAO;
import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;
import com.unionpay.withhold.trade.order.service.TxncodeDefService;
@Service
public class TxncodeDefServiceImpl implements TxncodeDefService {

	@Autowired
	private TxncodeDefDAO txncodeDefDAO;
	
	@Override
	@Transactional(readOnly=true)
	public TxncodeDefDO getBusiCode(TxncodeDefDO record) {
		return txncodeDefDAO.getBusiCode(record);
	}
}
