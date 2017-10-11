package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.RspmsgDO;

public interface RspmsgService {

	/**
	 * 获取应答信息
	 * @param rspmsg
	 * @return
	 */
	public RspmsgDO getRspmsg(RspmsgDO rspmsg);

}
