package com.unionpay.withhold.trade.pay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.bean.TradeQueueBean;
import com.unionpay.withhold.bean.enums.TradeQueueEnum;
import com.unionpay.withhold.trade.pay.service.TradeQueueService;
@Service
public class TradeQueueServiceImpl implements TradeQueueService {
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void addSingleTradeQueue(TradeQueueBean tradeQueueBean) {
		// TODO Auto-generated method stub
		BoundListOperations<String, String> boundListOps = redisTemplate.boundListOps(TradeQueueEnum.CPREALTIMETRADE.name());
		boundListOps.leftPush(JSON.toJSONString(tradeQueueBean));
	}

	@Override
	public void addBatchTradeQueue(TradeQueueBean tradeQueueBean) {
		// TODO Auto-generated method stub
		BoundListOperations<String, String> boundListOps = redisTemplate.boundListOps(TradeQueueEnum.CPBATCHTRADE.name());
		boundListOps.leftPush(JSON.toJSONString(tradeQueueBean));
	}

}
