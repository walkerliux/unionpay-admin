package com.unionpay.withhold.trade.order.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BatchCollectDetaBean implements Serializable {
	
	private static final long serialVersionUID = 8355358102224241307L;
	// 商户订单号
	@NotEmpty(message = "param.empty.orderId")
	@Length(max = 32, message = "param.error.orderId")
	private String orderId;
	// 交易币种
	@NotEmpty(message = "param.empty.currencyCode")
	@Length(max = 3, message = "param.error.currencyCode")
	private String currencyCode;
	// 单笔金额
	@NotEmpty(message = "param.empty.amt")
	@Length(max = 12, message = "param.error.amt")
	private String amt;
	// 银行卡号
	@NotEmpty(message = "param.empty.cardNo")
	@Length(max = 20, message = "param.error.cardNo")
	private String cardNo;
	// 卡类型
	@NotEmpty(message = "param.empty.cardType")
	@Length(max = 1, message = "param.error.cardType")
	private String cardType;
	// 持卡人姓名
	@NotEmpty(message = "param.empty.customerNm")
	@Length(max = 30, message = "param.error.customerNm")
	private String customerNm;
	// 证件类型
	@NotEmpty(message = "param.empty.certifTp")
	@Length(max = 2, message = "param.error.certifTp")
	private String certifTp;
	// 证件号
	@NotEmpty(message = "param.empty.certifId")
	@Length(max = 20, message = "param.error.certifId")
	private String certifId;
	// 手机号
	@NotEmpty(message = "param.empty.phoneNo")
	@Length(max = 11, message = "param.error.phoneNo")
	private String phoneNo;
	// cvn2
	private String cvn2;
	// 卡有效期
	private String expired;
	//批次ID
	private long batchId;
	//交易序列号
	private String txnseqno;
	
	
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
	public long getBatchId() {
		return batchId;
	}
	public void setBatchId(long batchId) {
		this.batchId = batchId;
	}
	public String getTxnseqno() {
		return txnseqno;
	}
	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}
	
}
