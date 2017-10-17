package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.mapper.TCardBinMapper;
import com.unionpay.withhold.admin.pojo.TCardBin;
import com.unionpay.withhold.admin.pojo.TCardBinExample;
import com.unionpay.withhold.admin.pojo.TCardBinExample.Criteria;
import com.unionpay.withhold.admin.service.CardBinService;
@Service
@Transactional
public class CardBinServiceImpl implements CardBinService {
	@Autowired
	private TCardBinMapper tCardBinMapper;
	@Override
	public PageBean findCardBinPage(TCardBin bin, int page, int rows) {
		TCardBinExample tCardBinExample = new TCardBinExample();
		
		if(bin.getCardbin()!=null&&!"".equals(bin.getCardbin())){
			tCardBinExample.setCardbin(bin.getCardbin());
		}
		int total = tCardBinMapper.countByExample(tCardBinExample);
		//tCardBinExample.setOrderByClause("CARDBIN");
		tCardBinExample.setPageNum(page);
		tCardBinExample.setPageSize(rows);
		List<TCardBin> list = tCardBinMapper.selectByExample(tCardBinExample);
		return new PageBean(total, list);
	}
	@Override
	public TCardBin getSingleById(String cardbin) {
		TCardBinExample tCardBinExample = new TCardBinExample();
		if(cardbin!=null&&!"".equals(cardbin)){
			tCardBinExample.setCardbin(cardbin);
		}
		TCardBin result = tCardBinMapper.selectByCardBinNum(tCardBinExample);
		return result;
	}
	@Override
	public void updateTCardBin(TCardBin bin) {
		tCardBinMapper.updateByPrimaryKeySelective(bin);
		System.out.println();
	}
	@Override
	public void saveTCardBin(TCardBin bin) {
		tCardBinMapper.insert(bin);
		
	}

}
