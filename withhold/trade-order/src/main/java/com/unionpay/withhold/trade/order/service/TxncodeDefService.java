package com.unionpay.withhold.trade.order.service;

import com.unionpay.withhold.trade.order.pojo.TxncodeDefDO;

public interface TxncodeDefService {

	/**
	 * 取得对外业务类型映射信息
	 * @param record
	 * @return
	 */
	public TxncodeDefDO getBusiCode(TxncodeDefDO record);

}
