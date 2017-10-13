package com.unionpay.withhold.trade.task.service;

import java.util.List;

import com.unionpay.withhold.trade.task.pojo.MerchChnlDO;

public interface MerchChnlService {

	/**
	 * 查询在用的CP商户信息
	 * @return
	 */
	public List<MerchChnlDO> queryCPMerch();

}
