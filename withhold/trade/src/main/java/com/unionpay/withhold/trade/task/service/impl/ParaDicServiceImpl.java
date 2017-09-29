package com.unionpay.withhold.trade.task.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.task.dao.ParaDicDAO;
import com.unionpay.withhold.trade.task.pojo.ParaDicDO;
import com.unionpay.withhold.trade.task.service.ParaDicService;

@Service
public class ParaDicServiceImpl implements ParaDicService {

	@Autowired
	private ParaDicDAO paraDicDAO;
	
	@Override
	@Transactional(readOnly=true)
	public ParaDicDO queryCPPara() {
		ParaDicDO record = new ParaDicDO();
		record.setStatus((short)1);
		record.setParaType("CPFILECRON");
		return paraDicDAO.queryPara(record);
	}
}
