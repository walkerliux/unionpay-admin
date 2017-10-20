package com.unionpay.withhold.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.enums.MerchDetaStatusEnums;
import com.unionpay.withhold.admin.mapper.TMerchChnlMapper;
import com.unionpay.withhold.admin.mapper.TMerchDetaMapper;
import com.unionpay.withhold.admin.pojo.TMerchChnl;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.service.MerchChnlService;

@Service
@Transactional
public class MwechChnlServiceImpl implements MerchChnlService {
	@Autowired
	private TMerchChnlMapper merchChnlMapper;
	@Override
	public PageBean queryMerchChnl(TMerchDeta merchDeta, Integer page, Integer rows) {
		// 查分页数据
				Integer beginRow = (page - 1) * rows;

				List<TMerchChnl> list = merchChnlMapper.selectChnlWithCondition(merchDeta,  beginRow, rows);
				int count = merchChnlMapper.selectCountWithCondition(merchDeta);

				return new PageBean(count, list);
	}
}
