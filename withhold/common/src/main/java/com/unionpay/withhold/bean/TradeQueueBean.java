/* 
 * TradeQueueBean.java  
 * 
 * version TODO
 *
 * 2016年7月19日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.unionpay.withhold.bean;

import java.io.Serializable;

/**
 * Class Description
 *
 * @author guojia
 * @version
 * @date 2016年7月19日 下午3:25:00
 * @since 
 */
public class TradeQueueBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5159052981161149825L;

	/**
	 * 交易序列号
	 */
	private String txnseqno;
	/**
	 * 支付机构代码
	 */
	private String channelCode;
	/**
	 * 交易时间
	 */
	private String txnDateTime;
	
	/**
	 * 交易类型
	 */
	private String busiType;
	
	/**
	 * 交易实现类
	 */
	private String impl;
	
	/**
	 * @return the txnseqno
	 */
	public String getTxnseqno() {
		return txnseqno;
	}
	/**
	 * @param txnseqno the txnseqno to set
	 */
	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}
	
	public String getChannelCode() {
		return channelCode;
	}
	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}
	/**
	 * @return the txnDateTime
	 */
	public String getTxnDateTime() {
		return txnDateTime;
	}
	/**
	 * @param txnDateTime the txnDateTime to set
	 */
	public void setTxnDateTime(String txnDateTime) {
		this.txnDateTime = txnDateTime;
	}
	
	
	/**
	 * @return the impl
	 */
	public String getImpl() {
		return impl;
	}
	/**
	 * @param impl the impl to set
	 */
	public void setImpl(String impl) {
		this.impl = impl;
	}
	
	/**
	 * @return the busiType
	 */
	public String getBusiType() {
		return busiType;
	}
	/**
	 * @param busiType the busiType to set
	 */
	public void setBusiType(String busiType) {
		this.busiType = busiType;
	}
	
}
