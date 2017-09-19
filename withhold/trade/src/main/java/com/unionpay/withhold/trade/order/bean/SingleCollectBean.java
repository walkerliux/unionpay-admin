package com.unionpay.withhold.trade.order.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.unionpay.withhold.bean.ResultBean;

public class SingleCollectBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -3143568519068720043L;
	// 版本号
	@NotEmpty(message = "param.empty.version")
	private String version;
	// 编码方式
	@NotEmpty(message = "param.empty.encoding")
	private String encoding;
	// 证书ID
	@NotEmpty(message = "param.empty.certId")
	private String certId;
	// 签名方式
	@NotEmpty(message = "param.empty.signMethod")
	private String signMethod;
	// 加密证书ID
	private String encryptCertId;
	// 交易类型
	@NotEmpty(message = "param.empty.transType")
	private String transType;
	// 系统订单号
	@NotEmpty(message = "param.empty.orderId")
	private String orderId;
	// 系统商户号
	@NotEmpty(message = "param.empty.mchntCd")
	private String mchntCd;
	// 交易要素id
	@NotEmpty(message = "param.empty.factorId")
	private String factorId;
	// 卡号
	private String priAcctId;
	// 姓名
	private String name;
	// 手机号
	private String phone;
	// 身份证号
	private String idCard;
	// 扣款类型
	@NotEmpty(message = "param.empty.dkType")
	private String dkType;
	// 交易金额
	@NotEmpty(message = "param.empty.transAt")
	private String transAt;
	// 交易币种
	@NotEmpty(message = "param.empty.atType")
	private String atType;
	// 订单发送时间
	@NotEmpty(message = "param.empty.transTm")
	private String transTm;
	// 后台通知地址
	@NotEmpty(message = "param.empty.backUrl")
	private String backUrl;
	//产品类型
	private String bizType;
	//交易子类
	private String txnSubType;
	//交易序列号
	private String txnseqno;
	//受理订单号
	private String tn;
	/**
	 * 数据有效性检查结果
	 */
	private ResultBean MessageCheck;
	/**
	 * 二次提交检查结果
	 */
	private ResultBean repeatSubmit;
	
	/**
	 * 最终结果
	 */
	private ResultBean finalResult;
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

	public ResultBean getMessageCheck() {
		return MessageCheck;
	}

	public void setMessageCheck(ResultBean messageCheck) {
		MessageCheck = messageCheck;
	}

	public ResultBean getFinalResult() {
		return finalResult;
	}

	public void setFinalResult(ResultBean finalResult) {
		this.finalResult = finalResult;
	}

	public ResultBean getRepeatSubmit() {
		return repeatSubmit;
	}

	public void setRepeatSubmit(ResultBean repeatSubmit) {
		this.repeatSubmit = repeatSubmit;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getTxnSubType() {
		return txnSubType;
	}

	public void setTxnSubType(String txnSubType) {
		this.txnSubType = txnSubType;
	}

	public String getTxnseqno() {
		return txnseqno;
	}

	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

}
