package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TMccListMapper;
import com.unionpay.withhold.admin.pojo.TMccList;
import com.unionpay.withhold.admin.pojo.TMccListExample;
import com.unionpay.withhold.admin.service.MCCListService;

@Service
@Transactional
public class MCCListServiceImpl implements MCCListService {

	@Autowired
	private TMccListMapper mccListMapper;

	@Override
	public List<TMccList> queryByMcc(String mcc) {
		TMccListExample mccListExample = new TMccListExample();
		TMccListExample.Criteria criteria = mccListExample.createCriteria();
		criteria.andMccEqualTo(mcc);
		criteria.andStatusEqualTo(CommonConstants.MCCLIST_STATUS_NORMAL);
		return mccListMapper.selectByExample(mccListExample);
	}

}
