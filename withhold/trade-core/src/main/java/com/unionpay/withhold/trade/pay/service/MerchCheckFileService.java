package com.unionpay.withhold.trade.pay.service;

public interface MerchCheckFileService {

	/**
	 * 获取对账文件地址
	 * @param merchNo
	 * @param date
	 * @return
	 */
	public String getMerchCheckFilePath(String merchNo, String date);

}
