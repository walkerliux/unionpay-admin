package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TCardBin;
import com.unionpay.withhold.admin.pojo.TbankInsti;

public interface CardBinService {

	PageBean findCardBinPage(TCardBin bin, int page, int rows);

	TCardBin getSingleById(String cardbin);

	void updateTCardBin(TCardBin bin);

	void saveTCardBin(TCardBin bin);
	
	List<TbankInsti> selectTbankInstis(String q);

}
