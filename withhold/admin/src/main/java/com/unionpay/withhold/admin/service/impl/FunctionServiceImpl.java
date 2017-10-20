package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TFunctionMapper;
import com.unionpay.withhold.admin.mapper.TUserFunctMapper;
import com.unionpay.withhold.admin.pojo.TFunction;
import com.unionpay.withhold.admin.pojo.TFunctionExample;
import com.unionpay.withhold.admin.pojo.TFunctionExample.Criteria;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserFunct;
import com.unionpay.withhold.admin.pojo.TUserFunctExample;
import com.unionpay.withhold.admin.service.FunctionService;
@Service
@Transactional
public class FunctionServiceImpl implements FunctionService {
	@Autowired
	private TFunctionMapper tFunctionMapper;
	@Autowired
	private TUserFunctMapper tUserFunctMapper;
	@Override
	public List<TFunction> findFunction() {
		
		List<TFunction> all = tFunctionMapper.selectAll();
		return all;
	}

	@Override
	public List<TFunction> findLoginFuntion(TUser loginUser) {
		Integer userId = loginUser.getUserId();
		List<TFunction> result = tFunctionMapper.selectByUnion(userId);
		
		return result;
	}

	@Override
	public List<TFunction> findAllFuntion(TUser user) {
		
		return null;
	}

}
