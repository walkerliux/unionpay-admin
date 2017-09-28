package com.unionpay.withhold.api.service;

import com.unionpay.withhold.api.common.bean.MessageBean;

/**
 * 批量交易服务接口
 * @author: yuanshaodong
 * @date: 2017年8月30日
 * @version 1.0
 */
public interface BatchTradeService {

	public MessageBean invoke(MessageBean messageBean);
}