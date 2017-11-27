package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TMerchCheckfileMapper;
import com.unionpay.withhold.admin.pojo.TMerchCheckfile;
import com.unionpay.withhold.admin.pojo.TMerchCheckfileExample;
import com.unionpay.withhold.admin.service.MerchFileService;

@Service
@Transactional
public class MerchFileServiceImpl implements MerchFileService {
	@Autowired
	private TMerchCheckfileMapper merchCheckfileMapper;

	@Override
	public boolean insertOrUpdate(TMerchCheckfile merchCheckfile) {
		TMerchCheckfileExample example =new TMerchCheckfileExample();
		TMerchCheckfileExample.Criteria criteria=example.createCriteria();
		criteria.andCheckdateEqualTo(merchCheckfile.getCheckdate());
		criteria.andMerchnoEqualTo(merchCheckfile.getMerchno());
		List<TMerchCheckfile> list = new ArrayList<>();
		list =merchCheckfileMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(list)) {
			merchCheckfileMapper.insertSelective(merchCheckfile);
		}
		return true;
	}

	
	

}
