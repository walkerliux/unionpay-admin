package com.unionpay.withhold.trade.order.bean;

import java.io.Serializable;

public class SingleCollectQueryBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1248242970937067791L;
	
	private String version;//版本号
	private String encoding;//编码方式
	private String certId;//证书ID
	private String signature;//签名
	private String signMethod;//签名方法
	private String transType;//交易类型
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
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getSignMethod() {
		return signMethod;
	}
	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	
	
}
