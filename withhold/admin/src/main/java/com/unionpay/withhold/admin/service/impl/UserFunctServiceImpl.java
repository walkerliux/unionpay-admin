package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.mapper.TUserFunctMapper;
import com.unionpay.withhold.admin.pojo.TRoleFunct;
import com.unionpay.withhold.admin.pojo.TUserFunct;
import com.unionpay.withhold.admin.pojo.TUserFunctExample;
import com.unionpay.withhold.admin.pojo.TUserFunctExample.Criteria;
import com.unionpay.withhold.admin.service.UserFunctService;
@Service
@Transactional
public class UserFunctServiceImpl implements UserFunctService {
	@Autowired
	private TUserFunctMapper tUserFunctMapper;
	@Override
	public void deleteOldFunc(Long userId) {
		TUserFunctExample tUserFunctExample = new TUserFunctExample();
		Criteria criteria = tUserFunctExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		tUserFunctMapper.deleteByExample(tUserFunctExample);

	}

	@Override
	public void save(List<TUserFunct> functList) {
		for (TUserFunct tUserFunct : functList) {
			tUserFunctMapper.insertSelective(tUserFunct);
		}

	}

	@Override
	public List<TUserFunct> findByProperty(Long userId) {
		TUserFunctExample tUserFunctExample = new TUserFunctExample();
		Criteria criteria = tUserFunctExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<TUserFunct> result = tUserFunctMapper.selectByExample(tUserFunctExample);
		return result;
	}

}
