package com.unionpay.withhold.trade.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.task.dao.MerchChnlDAO;
import com.unionpay.withhold.trade.task.pojo.MerchChnlDO;
import com.unionpay.withhold.trade.task.service.MerchChnlService;
@Service
public class MerchChnlServiceImpl implements MerchChnlService {

	@Autowired
	private MerchChnlDAO merchChnlDAO;
	@Override
	@Transactional(readOnly=true)
	public List<MerchChnlDO> queryCPMerch(){
		MerchChnlDO record = new MerchChnlDO();
		record.setStatus("00");
		record.setChnlcode("10000001");
		return merchChnlDAO.queryMerchChnl(record);
	}
}
