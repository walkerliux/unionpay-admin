package com.unionpay.withhold.api.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotEmpty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Root")
@XmlType(name = "Root")
public class DwnReqRoot implements Serializable {
	private static final long serialVersionUID = 4948055921885130928L;

	// 版本号
	@NotEmpty(message="0080[版本号]为空")
	@Pattern(regexp="^(1.0.0)$",message="0035[版本号]有误")
	private String version;
	// 编码方式
	@Pattern(regexp="^(UTF-8|GBK|GB2312|GB18030)$",message="0036[编码方式]有误")
	@NotEmpty(message="0080[编码方式]为空")
	private String encoding;
	// 证书ID
	@NotEmpty(message="0080[证书ID]为空")
	private String certId;
	// 加密证书ID
	//@NotEmpty(message="0080[加密证书ID]为空")
	private String encryptCertId;
	// 签名方式
	@Pattern(regexp="^(01)$",message="0039[签名方式]有误")
	@NotEmpty(message="0080[签名方式]为空")
	private String signMethod;
	// 交易类型
	@Pattern(regexp="^(99)$",message="0039[交易类型]有误")
	@NotEmpty(message="0080[交易类型]为空")
	private String transType;
	// 系统商户号
	@NotEmpty(message="0080[系统商户号]为空")
	private String mchntCd;
	// 流水号
	@NotEmpty(message="0080[流水号]为空")
	private String queryId;
	// 发送时间
	@NotEmpty(message="0080[发送时间]为空")
	private String queryDt;
	// 交易日期
	@NotEmpty(message="0080[交易日期]为空")
	private String transDt;

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

	public String getEncryptCertId() {
		return encryptCertId;
	}

	public void setEncryptCertId(String encryptCertId) {
		this.encryptCertId = encryptCertId;
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

	public String getMchntCd() {
		return mchntCd;
	}

	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}
	 
	public String getQueryDt() {
		return queryDt;
	}

	public void setQueryDt(String queryDt) {
		this.queryDt = queryDt;
	}

	public String getTransDt() {
		return transDt;
	}

	public void setTransDt(String transDt) {
		this.transDt = transDt;
	}

	@Override
	public String toString() {
		return "QReqRoot [version=" + version + ", encoding=" + encoding + ", certId=" + certId + ", encryptCertId="
				+ encryptCertId + ", signMethod=" + signMethod + ", transType=" + transType + ", mchntCd=" + mchntCd
				+ ", queryId=" + queryId + ", queryDt=" + queryDt + ", transDt=" + transDt + "]";
	}

}
