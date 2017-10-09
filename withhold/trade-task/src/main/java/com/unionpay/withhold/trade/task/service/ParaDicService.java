package com.unionpay.withhold.trade.task.service;

import com.unionpay.withhold.trade.task.pojo.ParaDicDO;

public interface ParaDicService {

	/**
	 * 获取CP对账文件cron表达式参数
	 * @return
	 */
	public ParaDicDO queryCPPara();

}
