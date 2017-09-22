package com.unionpay.withhold.api.common.bean;

/**
 * 
 * @author Luke
 *
 */
public class Config {

	private String dkKey;
	private String dkValue;

	private String dkName;

	private String dkDesc;

	private Boolean dkReadonly;

	public String getDkKey() {
		return dkKey;
	}

	public void setDkKey(String dkKey) {
		this.dkKey = dkKey == null ? null : dkKey.trim();
	}

	public String getDkValue() {
		return dkValue;
	}

	public void setDkValue(String dkValue) {
		this.dkValue = dkValue == null ? null : dkValue.trim();
	}

	public String getDkName() {
		return dkName;
	}

	public void setDkName(String dkName) {
		this.dkName = dkName == null ? null : dkName.trim();
	}

	public String getDkDesc() {
		return dkDesc;
	}

	public void setDkDesc(String dkDesc) {
		this.dkDesc = dkDesc == null ? null : dkDesc.trim();
	}

	public Boolean getDkReadonly() {
		return dkReadonly;
	}

	public void setDkReadonly(Boolean dkReadonly) {
		this.dkReadonly = dkReadonly;
	}
}
