package com.unionpay.withhold.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.model.MerchMk;
import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.api.common.bean.AdditBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.dao.MerchMkMapper;
import com.unionpay.withhold.api.service.MerchMkService;
import com.unionpay.withhold.api.service.MessageDecodeService;
import com.unionpay.withhold.api.signaturn.util.GateKeeper;
import com.unionpay.withhold.api.signaturn.util.RSAHelper2048;
import com.unionpay.withhold.api.signaturn.util.StringUtil;

@Service("messageDecodeService")
public class MessageDecodeServiceImpl implements MessageDecodeService{
	private static final Logger logger = LoggerFactory.getLogger(MessageDecodeServiceImpl.class); 
	
	@Autowired
	private MerchMkService merchMKService;
	
	@Override
	public MessageBean decodeAndVerify_2048(MessageBean messageBean) throws Exception {
		RSAHelper2048 rsa = null;
		AdditBean additBean = JSON.parseObject(messageBean.getAddit(), AdditBean.class);
		if ("1".equals(additBean.getAccessType())) {
			MerchMk merchMk = merchMKService.selectByPrimaryKey((additBean.getMerId()));
			rsa = new RSAHelper2048();
			rsa.initKey(merchMk.getLocalprikey(), merchMk.getMemberpubkey(), 2048);
		} else {
			logger.error("未知的接入方式");
			return null;
		}
		GateKeeper keeper = new GateKeeper(messageBean.getData(), messageBean.getSign(), messageBean.getAddit(), rsa);
		if (keeper.getErrorMsg() == null || keeper.getErrorMsg().isNormal())
			
		// 异常情况
		if (StringUtil.isNotEmpty(keeper.getErrorMsg().getErrorCode())){
			throw new IllegalArgumentException(keeper.getErrorMsg().getErrorMessage());
		}
		MessageBean returnMessageBean = new MessageBean();
		returnMessageBean.setAddit(keeper.getAddit().toString());
		returnMessageBean.setData(keeper.getData().toString());
		returnMessageBean.setSign(messageBean.getSign());
		return returnMessageBean;
	}
	

}
