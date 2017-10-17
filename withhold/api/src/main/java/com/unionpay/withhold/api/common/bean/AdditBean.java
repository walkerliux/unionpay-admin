package com.unionpay.withhold.api.common.bean;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;


public class AdditBean implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4197123232264625963L;
	/**
	 * 	接入类型
	 */
	@JSONField(ordinal=1)
	private String accessType;
	/**
	 * 	合作机构号
	 */
	@JSONField(ordinal=2)
	private String coopInstiId;
	/**
	 * 	商户号
	 */
	@JSONField(ordinal=3)
	private String merId;
	/**
	 * 	加密KEY
	 */
	@JSONField(ordinal=4)
	private String encryKey;
	/**
	 * 	加密方法
	 */
	@JSONField(ordinal=5)
	private String encryMethod;
	/**
	 * 	风控信息
	 */
	@JSONField(ordinal=6)
	private String riskInfo;
	
	@JSONField(ordinal=7)
	private String certId;
	
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
	public String getCoopInstiId() {
		return coopInstiId;
	}
	public void setCoopInstiId(String coopInstiId) {
		this.coopInstiId = coopInstiId;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getEncryKey() {
		return encryKey;
	}
	public void setEncryKey(String encryKey) {
		this.encryKey = encryKey;
	}
	public String getEncryMethod() {
		return encryMethod;
	}
	public void setEncryMethod(String encryMethod) {
		this.encryMethod = encryMethod;
	}
	public String getRiskInfo() {
		return riskInfo;
	}
	public void setRiskInfo(String riskInfo) {
		this.riskInfo = riskInfo;
	}
	
	
}
