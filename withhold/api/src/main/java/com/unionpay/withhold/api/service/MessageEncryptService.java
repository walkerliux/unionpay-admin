package com.unionpay.withhold.api.service;

import com.unionpay.withhold.api.common.bean.AdditBean;
import com.unionpay.withhold.api.common.bean.MessageBean;

/**
 * 
 * 报文加密类
 *
 * @author guojia
 * @version
 * @date 2017年1月20日 下午4:07:27
 * @since
 */
public interface MessageEncryptService {

	/**
	 * 报文加密加签
	 * @param data 业务报文数据
	 * @param additBean 附加域数据
	 * @return 报文bean
	 * @throws Exception 
	 */
	public MessageBean encryptAndSigntrue_2048(String data,AdditBean additBean) throws Exception;
}
