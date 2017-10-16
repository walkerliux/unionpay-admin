package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TParaDicMapper;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TParaDicExample;
import com.unionpay.withhold.admin.pojo.TParaDicExample.Criteria;
import com.unionpay.withhold.admin.service.ParaDicService;
@Service
@Transactional
public class ParaDicServiceImpl implements ParaDicService {
	
	@Autowired
	private TParaDicMapper tParaDicMapper;
	@Override
	public PageBean findParaPage(TParaDic paraDic, int page, int rows) {
		TParaDicExample tParaDicExample = new TParaDicExample();
		
		if (paraDic.getParaCode()!=null&&!"".equals(paraDic.getParaCode())) {
			tParaDicExample.setParaCode(paraDic.getParaCode());
			
		}
		if (paraDic.getParaName()!=null&&!"".equals(paraDic.getParaName())) {
			tParaDicExample.setParaName(paraDic.getParaName());
		}
		if (paraDic.getParentId()!=null&&!"".equals(paraDic.getParentId())) {
			tParaDicExample.setParentId(paraDic.getParentId().toString());
		}
		int total = tParaDicMapper.countByExample(tParaDicExample);
		tParaDicExample.setPageNum(page);
		tParaDicExample.setPageSize(rows);
		
		tParaDicExample.setOrderByClause("TID ASC");
		
		
		//List<TParaDic> list = tParaDicMapper.selectByExample(tParaDicExample);
		List<TParaDic> list=tParaDicMapper.selectByLeftJoinExample(tParaDicExample);
		return new PageBean(total, list);
	}
	@Override
	public void saveTParaDic(TParaDic paraDic) {
		tParaDicMapper.insert(paraDic);
		
	}
	@Override
	public void updateTParaDic(TParaDic paraDic) {
		tParaDicMapper.updateByPrimaryKey(paraDic);
		
	}
	@Override
	public TParaDic getSingleById(Long tid) {
		
		return tParaDicMapper.selectByPrimaryKey(tid);
	}
	@Override
	public List<TParaDic> getParents() {
		TParaDicExample tParaDicExample = new TParaDicExample();
		Criteria criteria = tParaDicExample.createCriteria();
		criteria.andParentIdEqualTo(0L);
		 List<TParaDic> list = tParaDicMapper.selectByParentIdExample(tParaDicExample);
		 return list;
	}
	@Override
	public List<TParaDic> selectParaDicByParentCode(String paraCode) {
		return tParaDicMapper.selectParaDicByParentCode(paraCode);
	}

}
