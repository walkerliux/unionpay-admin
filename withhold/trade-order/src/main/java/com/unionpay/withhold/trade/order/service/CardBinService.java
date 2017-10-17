package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.CardBinDO;

public interface CardBinService {

	/**
	 * 查询银行卡的卡bin信息
	 * @param cardNo
	 * @return
	 */
	public CardBinDO getCardBin(String cardNo);

}
