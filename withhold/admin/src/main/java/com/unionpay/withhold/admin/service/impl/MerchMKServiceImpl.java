package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.constant.CommonConstants;
import com.unionpay.withhold.admin.mapper.TMerchMkMapper;
import com.unionpay.withhold.admin.pojo.TMerchMk;
import com.unionpay.withhold.admin.pojo.TMerchMkExample;
import com.unionpay.withhold.admin.service.MerchMKService;

@Service
@Transactional
public class MerchMKServiceImpl implements MerchMKService {
	@Autowired
	private TMerchMkMapper merchMkMapper;
	@Override
	public TMerchMk queryMKById(String memberid) {
		TMerchMkExample merchMkExample = new TMerchMkExample();
		TMerchMkExample.Criteria criteria = merchMkExample.createCriteria();
		criteria.andMemberidEqualTo(memberid);
		criteria.andStatusEqualTo(CommonConstants.MERCH_MK_STATUS_NORMAL);
		
		List<TMerchMk> merchMKList = merchMkMapper.selectByExample(merchMkExample);
		return merchMKList.size() == 0 ? null : merchMKList.get(0);
	}
	@Override
	public ResultBean submitMK(TMerchMk merchMk) {
		// 判断数据库是否存在：若存在，则更新；若不存在，则添加。
		TMerchMk merchMkBack = merchMkMapper.selectByPrimaryKey(merchMk.getSafeseq());
		int count = 0;
		if (null == merchMkBack) {
			// 添加	
			count = merchMkMapper.insertSelective(merchMk);
		} else {
			// 更新
			count = merchMkMapper.updateByPrimaryKeySelective(merchMk);
		}
		return count == 0 ? new ResultBean("", "商户密钥提交失败，请稍后再试 ！") : new ResultBean("商户密钥已提交成功 ！");
	}

}
