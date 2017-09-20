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

}
