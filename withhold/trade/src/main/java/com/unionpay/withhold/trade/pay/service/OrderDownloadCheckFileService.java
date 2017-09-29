package com.unionpay.withhold.trade.pay.service;

import com.unionpay.withhold.api.bean.MerchCheckFileBean;
import com.unionpay.withhold.bean.ResultBean;

public interface OrderDownloadCheckFileService {

	/**
	 * 下载商户对账文件获取下载地址
	 * @param merchCheckFileBean
	 * @return
	 */
	public ResultBean downloadCheckFile(MerchCheckFileBean merchCheckFileBean);

}
