package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;

public interface BankService {
	PageBean queryByPage(TBankExample bankExample);
	
	ResultBean addBank(TBank bank);
}
