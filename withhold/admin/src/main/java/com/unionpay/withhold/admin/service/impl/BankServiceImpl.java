package com.unionpay.withhold.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TBankMapper;
import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;
import com.unionpay.withhold.admin.pojo.TBankExample.Criteria;
import com.unionpay.withhold.admin.service.BankService;

@Service
@Transactional
public class BankServiceImpl implements BankService {
	@Autowired
	private TBankMapper bankMapper;

	@Override
	public PageBean queryByPage(TBankExample bankExample) {
		int count = bankMapper.countByExample(bankExample);
		List<TBank> list = bankMapper.selectByExample(bankExample);
		return new PageBean(count, list);
	}

	@Override
	public ResultBean addBank(TBank bank) {
		int count = bankMapper.insert(bank);
		if (count > 0) {
			return new ResultBean("添加成功 ！");
		} else {
			return new ResultBean("","添加失败！");
		}
	}

	@Override
	public PageBean findBankPage(TBank bank, int page, int rows) {
		TBankExample tBankExample = new TBankExample();
		Criteria criteria = tBankExample.createCriteria();
		if (bank.getBankcode()!=null&&!"".equals(bank.getBankcode())) {
			criteria.andBankcodeEqualTo(bank.getBankcode());
		}
		if (bank.getBankname()!=null&&!"".equals(bank.getBankname())) {
			criteria.andBanknameEqualTo(bank.getBankname());
		}
		int total = bankMapper.countByExample(tBankExample);
		tBankExample.setPageNum(page);
		tBankExample.setPageSize(rows);
		tBankExample.setOrderByClause("TID");
		List<TBank> list = bankMapper.selectByExample(tBankExample);
		return new PageBean(total, list);
	}

	@Override
	public TBank getSingleById(Long tid) {
		
		
		return bankMapper.selectByPrimaryKey(tid.intValue());
	}

	@Override
	public void updateTBank(TBank bank) {
		bankMapper.updateByPrimaryKey(bank);
		
	}

	@Override
	public void saveTBank(TBank bank) {
		bankMapper.insertSelective(bank);
		
	}

}
