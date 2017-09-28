package com.unionpay.withhold.trade.api.bean;

import java.io.Serializable;

public class BatchCollectDetaBean implements Serializable {
	
	private static final long serialVersionUID = 8355358102224241307L;
	// 商户订单号
	private String orderId;
	// 交易币种
	private String currencyCode;
	// 单笔金额
	private String amt;
	// 银行卡号
	private String cardNo;
	// 卡类型
	private String cardType;
	// 持卡人姓名
	private String customerNm;
	// 证件类型
	private String certifTp;
	// 证件号
	private String certifId;
	// 手机号
	private String phoneNo;
	// cvn2
	private String cvn2;
	// 卡有效期
	private String expired;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCustomerNm() {
		return customerNm;
	}
	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}
	public String getCertifTp() {
		return certifTp;
	}
	public void setCertifTp(String certifTp) {
		this.certifTp = certifTp;
	}
	public String getCertifId() {
		return certifId;
	}
	public void setCertifId(String certifId) {
		this.certifId = certifId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCvn2() {
		return cvn2;
	}
	public void setCvn2(String cvn2) {
		this.cvn2 = cvn2;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	
	
	
}
