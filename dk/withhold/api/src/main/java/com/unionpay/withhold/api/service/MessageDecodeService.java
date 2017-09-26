package com.unionpay.withhold.api.service;

import com.unionpay.withhold.api.common.bean.MessageBean;

/**
 * 
 * 报文解密验签接口
 *
 * @author guojia
 * @version
 * @date 2017年8月22日 上午9:53:40
 * @since
 */
public interface MessageDecodeService {
	/**
	 * 解密并验签
	 * @param messageBean 报文BEAN
	 * @return 报文BEAN
	 * @throws Exception 
	 */
	public MessageBean decodeAndVerify_2048(MessageBean messageBean) throws Exception;
}
