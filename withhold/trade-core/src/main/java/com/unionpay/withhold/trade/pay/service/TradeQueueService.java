package com.unionpay.withhold.trade.pay.service;

import com.unionpay.withhold.bean.TradeQueueBean;

public interface TradeQueueService {

	/**
	 * 实时交易队列添加
	 * @param tradeQueueBean
	 */
	public void addSingleTradeQueue(TradeQueueBean tradeQueueBean);
	
	/**
	 * 批量交易队列添加
	 * @param tradeQueueBean
	 */
	public void addBatchTradeQueue(TradeQueueBean tradeQueueBean);
	
}
