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
public class ReqRoot implements Serializable {

	private static final long serialVersionUID = -6765100196395847463L;
	// 版本号
	@Pattern(regexp="^(1.0.0)$",message="0035[版本号]有误")
	private String version;
	// 编码方式
	@Pattern(regexp="^(UTF-8|GBK|GB2312|GB18030)$",message="0036[编码方式]有误")
	private String encoding="UTF-8";
	// 证书ID
	@NotEmpty(message="0037[证书ID]为空")
	private String certId;
	// 签名方式
	@NotEmpty(message="0039[签名方式]为空")
	@Pattern(regexp="^(01)$",message="0039[签名方式]有误")
	private String signMethod;
	// 加密证书ID
	private String encryptCertId;
	// 交易类型
	@NotEmpty(message="0040[交易类型]为空")
	@Pattern(regexp="^(00|11)$",message="0040[交易类型]有误")
	private String transType;
	// 系统订单号
	@NotEmpty(message="0005[订单号]为空")
	private String orderId;
	// 系统商户号
	@NotEmpty(message="0002[商户号]为空")
	@Pattern(regexp="^\\d{15}$",message="0041[商户号]格式有误")
	private String mchntCd;
	// 交易要素id
	@NotEmpty(message="0002[交易要素id]为空")
	@Pattern(regexp="^\\d*$",message="0004[交易要素id]格式有误")
	private String factorId;
	// 卡号
	@Pattern(regexp="^(\\d{16}|\\d{19}|\\d{18})$",message="0004[银行卡号]格式有误")
	private String priAcctId;
	// 姓名
	@NotEmpty(message="0002[姓名]为空")
	private String name;
	// 手机号
	@NotEmpty(message="0002[手机号]为空")
	@Pattern(regexp="^1[3|4|5|7|8]\\d{9}$",message="0004[手机号]格式有误")
	private String phone;
	// 身份证号
	@NotEmpty(message="0002[身份证号]为空")
	@Pattern(regexp="(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)",message="0004[身份证号]格式有误")
	private String idCard;
	// 扣款类型
	@NotEmpty(message="0001[扣款类型]为空")
	@Pattern(regexp="^(1|2)$",message="0001[扣款类型]有误")
	private String dkType;
	// 交易金额
	@NotEmpty(message="0003[交易金额]为空")
	@Pattern(regexp="^([1-9][\\d]{0,60}|0)(\\.[\\d]{1,2})?$",message="0003[交易金额]有误")
	private String transAt;
	// 交易币种
	@NotEmpty(message="0042[交易币种]为空")
	@Pattern(regexp="^\\d{3}$",message="0042[交易币种]有误")
	private String atType;
	// 订单发送时间
	@NotEmpty(message="0043[订单发送时间]为空")
	private String transTm;
	// 后台通知地址
	@NotEmpty(message="0044[后台通知地址]为空")
	@Pattern(regexp="^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]",message="0042[后台通知地址]有误")
	private String backUrl;

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

	public String getSignMethod() {
		return signMethod;
	}

	public void setSignMethod(String signMethod) {
		this.signMethod = signMethod;
	}

	public String getEncryptCertId() {
		return encryptCertId;
	}

	public void setEncryptCertId(String encryptCertId) {
		this.encryptCertId = encryptCertId;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getMchntCd() {
		return mchntCd;
	}

	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}

	public String getFactorId() {
		return factorId;
	}

	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}

	public String getPriAcctId() {
		return priAcctId;
	}

	public void setPriAcctId(String priAcctId) {
		this.priAcctId = priAcctId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getDkType() {
		return dkType;
	}

	public void setDkType(String dkType) {
		this.dkType = dkType;
	}

	public String getTransAt() {
		return transAt;
	}

	public void setTransAt(String transAt) {
		this.transAt = transAt;
	}

	public String getAtType() {
		return atType;
	}

	public void setAtType(String atType) {
		this.atType = atType;
	}

	public String getTransTm() {
		return transTm;
	}

	public void setTransTm(String transTm) {
		this.transTm = transTm;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	@Override
	public String toString() {
		return "Root [version=" + version + ", encoding=" + encoding + ", certId=" + certId + ", signMethod="
				+ signMethod + ", encryptCertId=" + encryptCertId + ", transType=" + transType + ", orderId=" + orderId
				+ ", mchntCd=" + mchntCd + ", factorId=" + factorId + ", priAcctId=" + priAcctId + ", name=" + name
				+ ", phone=" + phone + ", idCard=" + idCard + ", dkType=" + dkType + ", transAt=" + transAt
				+ ", atType=" + atType + "]";
	}

}
