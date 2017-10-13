package com.unionpay.withhold.trade.pay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.trade.pay.dao.MerchCheckFileDAO;
import com.unionpay.withhold.trade.pay.pojo.MerchCheckFileDO;
import com.unionpay.withhold.trade.pay.pojo.MerchCheckFileDOExample;
import com.unionpay.withhold.trade.pay.service.MerchCheckFileService;
import com.unionpay.withhold.utils.DateUtil;

@Service
public class MerchCheckFileServiceImpl implements MerchCheckFileService {

	@Autowired
	private MerchCheckFileDAO merchCheckFileDAO;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public String getMerchCheckFilePath(String merchNo,String date) {
		String downloadPath = null;
		MerchCheckFileDOExample example = new MerchCheckFileDOExample();
		example.createCriteria().andMerchnoEqualTo(merchNo).andCheckdateEqualTo(date);
		List<MerchCheckFileDO> merchCheckFileList = merchCheckFileDAO.selectByExample(example);
		if(merchCheckFileList.size()>0) {
			MerchCheckFileDO merchCheckFile = merchCheckFileList.get(0);
			downloadPath = merchCheckFile.getUri();
			merchCheckFile.setRequesttime(DateUtil.getCurrentDateTime());
			merchCheckFileDAO.updateByPrimaryKey(merchCheckFile);
		}
		return downloadPath;
	} 
}
