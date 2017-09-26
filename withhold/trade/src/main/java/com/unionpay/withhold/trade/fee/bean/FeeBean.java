package com.unionpay.withhold.trade.fee.bean;

import java.io.Serializable;

public class FeeBean implements Serializable{
	private static final long serialVersionUID = 2687548389727959837L;
	//交易序列号，
	private String txnseqno;
	//扣率版本，
	private String feeVer;
	//业务类型，
	private String busiCode;
	//交易金额，
	private String txnAmt;
	//会员号，
	private String merchNo;
	//原交易序列号，
	private String txnseqnoOg;
	//卡类型 
	private String cardType;
	public String getTxnseqno() {
		return txnseqno;
	}
	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}
	public String getFeeVer() {
		return feeVer;
	}
	public void setFeeVer(String feeVer) {
		this.feeVer = feeVer;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public String getTxnAmt() {
		return txnAmt;
	}
	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}
	public String getMerchNo() {
		return merchNo;
	}
	public void setMerchNo(String merchNo) {
		this.merchNo = merchNo;
	}
	public String getTxnseqnoOg() {
		return txnseqnoOg;
	}
	public void setTxnseqnoOg(String txnseqnoOg) {
		this.txnseqnoOg = txnseqnoOg;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
}
