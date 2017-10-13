package com.unionpay.withhold.trade.pay.service;

import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;

public interface RspmsgPayService {

	/**
	 * 	取得应答信息
	 * @param rspmsgPay
	 * @return
	 */
	public RspmsgPayDO getRspmsgPay(RspmsgPayDO rspmsgPay);
}
