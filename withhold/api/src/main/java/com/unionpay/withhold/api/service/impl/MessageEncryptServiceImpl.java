package com.unionpay.withhold.api.service.impl;

import java.util.Map;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.unionpay.withhold.api.common.bean.AdditBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.model.MerchMk;
import com.unionpay.withhold.api.service.MerchMkService;
import com.unionpay.withhold.api.service.MessageEncryptService;
import com.unionpay.withhold.api.signaturn.util.AESUtil;
import com.unionpay.withhold.api.signaturn.util.Base64Utils;
import com.unionpay.withhold.api.signaturn.util.RSAHelper2048;


@Service("messageEncryptService")
public class MessageEncryptServiceImpl implements MessageEncryptService{
	private static final Logger logger = LoggerFactory.getLogger(MessageEncryptServiceImpl.class); 
	
	@Autowired
	private MerchMkService merchMKService;
	@Override
	public MessageBean encryptAndSigntrue_2048(String data, AdditBean additBean) throws Exception {
		MessageBean messageBean = new MessageBean();
		String key = AESUtil.getAESKey();
		RSAHelper2048 rsa = null;
		if ("1".equals(additBean.getAccessType())){
			MerchMk merchMk = merchMKService.selectByPrimaryKey((additBean.getMerId()));
			rsa = new RSAHelper2048();
			rsa.initKey(merchMk.getLocalprikey(), merchMk.getMemberpubkey(), 2048);
		}else {
			logger.error("未知的接入方式");
			return null;
		} 
		additBean.setEncryKey(rsa.encrypt(key));
		String singString=key + JSON.toJSONString(additBean,SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteMapNullValue) + data;
		logger.info("============ 需要加签的数据==============="+singString);
		String signData = rsa.sign(singString);
		Map<String, Object> signMap = new TreeMap<String, Object>();
		signMap.put("signature", signData);
		signMap.put("signMethod", "01");
		messageBean.setSign(JSON.toJSONString(signMap));
		additBean.setRiskInfo(Base64Utils.encode(AESUtil.encrypt(additBean.getRiskInfo(), key)));
		messageBean.setData( Base64Utils.encode(AESUtil.encrypt(data, key)));
		messageBean.setAddit(JSON.toJSONString(additBean));
		return messageBean;
	}

}
