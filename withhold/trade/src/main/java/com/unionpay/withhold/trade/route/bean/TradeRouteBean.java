package com.unionpay.withhold.trade.route.bean;

import java.io.Serializable;

public class TradeRouteBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3586635743736868012L;
	private String routver;
	private String transTime;
	private Long transAmt;
	private String busiCode;
	private String status;
	private String bankcode;
	private String cardType;
	
	public String getRoutver() {
		return routver;
	}
	public void setRoutver(String routver) {
		this.routver = routver;
	}
	public String getTransTime() {
		return transTime;
	}
	public void setTransTime(String transTime) {
		this.transTime = transTime;
	}
	public Long getTransAmt() {
		return transAmt;
	}
	public void setTransAmt(Long transAmt) {
		this.transAmt = transAmt;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBankcode() {
		return bankcode;
	}
	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	
	
	
}
