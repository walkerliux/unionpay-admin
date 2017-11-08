package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TMerchDetaMapper;
import com.unionpay.withhold.admin.mapper.TMerchMkMapper;
import com.unionpay.withhold.admin.mapper.TParaDicMapper;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TMerchMk;
import com.unionpay.withhold.admin.pojo.TMerchMkExample;
import com.unionpay.withhold.admin.pojo.TMerchMkExample.Criteria;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.service.PortalService;
@Service
@Transactional
public class PortalServiceImpl implements PortalService {
	@Autowired
	private TMerchMkMapper tMerchMkMapper;
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
	@Override
	public TMerchMk getCertId(String loginName) {
		TMerchMkExample tMerchMkExample = new TMerchMkExample();
		Criteria createCriteria = tMerchMkExample.createCriteria();
		createCriteria.andStatusEqualTo("00");
		if (loginName!=null&&!"".equals(loginName)) {
			createCriteria.andMemberidEqualTo(loginName);
		}
		List<TMerchMk> mks = tMerchMkMapper.selectByExample(tMerchMkExample);
		if (mks!=null&&mks.size()>0) {
			TMerchMk tMerchMk = mks.get(0);
			return tMerchMk;
		}
		return null;
	}

}
