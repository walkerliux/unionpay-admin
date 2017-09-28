package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TParaDic;

public interface ParaDicService {

	PageBean findParaPage(TParaDic paraDic, int page, int rows);

	void saveTParaDic(TParaDic paraDic);

	void updateTParaDic(TParaDic paraDic);

	TParaDic getSingleById(Long tid);

	List<TParaDic> getParents();

}
