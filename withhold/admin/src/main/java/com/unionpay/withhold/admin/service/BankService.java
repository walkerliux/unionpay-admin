package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;

public interface BankService {
	PageBean queryByPage(TBankExample bankExample);
	
	ResultBean addBank(TBank bank);

	PageBean findBankPage(TBank bank, int page, int rows);

	TBank getSingleById(Long tid);

	void updateTBank(TBank bank);

	void saveTBank(TBank bank);
}
