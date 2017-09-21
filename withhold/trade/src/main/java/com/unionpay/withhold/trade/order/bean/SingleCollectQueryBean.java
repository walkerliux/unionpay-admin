package com.unionpay.withhold.trade.order.bean;

import java.io.Serializable;

public class SingleCollectQueryBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1248242970937067791L;
	private String mchntCd;// 系统商户号
	private String orderId;// 商户订单号
	private String transTm;// 订单发送时间
	private String transQueryId;// 查询交易流水号
	
	public String getMchntCd() {
		return mchntCd;
	}
	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getTransTm() {
		return transTm;
	}
	public void setTransTm(String transTm) {
		this.transTm = transTm;
	}
	public String getTransQueryId() {
		return transQueryId;
	}
	public void setTransQueryId(String transQueryId) {
		this.transQueryId = transQueryId;
	}
	
	
}
