package com.unionpay.withhold.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TMerchDetaMapper;
import com.unionpay.withhold.admin.mapper.TParaDicMapper;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.service.PortalService;
@Service
@Transactional
public class PortalServiceImpl implements PortalService {
	@Autowired
	private TMerchDetaMapper merchDetaMapper;
	@Autowired
	private TParaDicMapper paraDicMapper;
	@Override
	public TParaDic getTransfactors(String loginName) {
		
		TMerchDeta merchDeta =merchDetaMapper.selectTransfactorsByMemberId(loginName);
		 
		String transfactors= merchDeta.getTransfactors();
		
		TParaDic paraDic = paraDicMapper.selectParaDicByParaCode(transfactors);
		
		return paraDic;
	}

}
