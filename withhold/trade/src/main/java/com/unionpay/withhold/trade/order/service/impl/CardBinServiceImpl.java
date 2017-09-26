package com.unionpay.withhold.trade.order.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.unionpay.withhold.trade.order.dao.CardBinDAO;
import com.unionpay.withhold.trade.order.pojo.CardBinDO;
import com.unionpay.withhold.trade.order.service.CardBinService;

@Service
public class CardBinServiceImpl implements CardBinService {

	@Autowired
	private CardBinDAO cardBinDAO;
	
	@Override
	@Transactional(readOnly=true)
	public CardBinDO getCardBin(String cardNo) {
		Map<String,Object> record = Maps.newHashMap();
		record.put("cardno", cardNo);
		record.put("cardlen", cardNo.length());
		CardBinDO cardInfo = cardBinDAO.getCardInfo(record);
		return cardInfo;
	}
}
