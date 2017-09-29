package com.unionpay.withhold.api.bean;

import java.io.Serializable;

public class MerchCheckFileBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3434334902586387235L;
	
	private String version;// 版本号
	private String encoding;// 编码方式
	private String cert_id;// 证书
	private String sign_method;// 签名方法
	private String trans_type;// 交易类型
	private String mchnt_cd;// 系统商户号
	private String query_id;// 交易流水号
	private String query_dt;// 发送时间
	private String trans_dt;// 交易日期
	
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
	
	public String getCert_id() {
		return cert_id;
	}
	public void setCert_id(String cert_id) {
		this.cert_id = cert_id;
	}
	public String getSign_method() {
		return sign_method;
	}
	public void setSign_method(String sign_method) {
		this.sign_method = sign_method;
	}
	public String getTrans_type() {
		return trans_type;
	}
	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}
	public String getMchnt_cd() {
		return mchnt_cd;
	}
	public void setMchnt_cd(String mchnt_cd) {
		this.mchnt_cd = mchnt_cd;
	}
	public String getQuery_id() {
		return query_id;
	}
	public void setQuery_id(String query_id) {
		this.query_id = query_id;
	}
	public String getQuery_dt() {
		return query_dt;
	}
	public void setQuery_dt(String query_dt) {
		this.query_dt = query_dt;
	}
	public String getTrans_dt() {
		return trans_dt;
	}
	public void setTrans_dt(String trans_dt) {
		this.trans_dt = trans_dt;
	}

	
}
