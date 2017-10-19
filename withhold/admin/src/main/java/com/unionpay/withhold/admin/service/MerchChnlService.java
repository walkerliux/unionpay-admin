package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TMerchDeta;

public interface MerchChnlService {
	/**
	 * 查询商户通道信息
	 * @param merchDeta
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean queryMerchChnl(TMerchDeta merchDeta, Integer page, Integer rows);

}
