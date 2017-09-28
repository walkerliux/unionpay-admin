package com.unionpay.withhold.api.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Root")
@XmlType(name = "Root")
public class TRspRoot implements Serializable {
	private static final long serialVersionUID = -6765100196395847463L;
	// 版本号
	private String version;
	// 编码方式
	private String encoding;
	// 证书ID
	private String certId;
	// 签名方式
	private String signMethod;
	// 交易类型
	private String transType;
	// 系统订单号
	private String orderId;
	// 系统商户号
	private String mchntCd;
	// 扣款类型
	private String dkType;
	// 交易金额
	private String transAt;
	// 交易币种
	private String atType;
	// 订单发送时间
	private String transTm;
	// 交易查询流水号
	private String queryId;
	// 应答码
	private String respCod;
	// 应答信息
	private String respMsg;
	// 清算金额
	private String settleAt;
	// 清算币种
	private String settleType;
	// 清算日期
	private String settleDate;
	// 兑换日期
	private String exchangeDate;
	// 清算汇率
	private String exchangeRate;

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

	public String getQueryId() {
		return queryId;
	}

	public void setQueryId(String queryId) {
		this.queryId = queryId;
	}

	public String getRespCod() {
		return respCod;
	}

	public void setRespCod(String respCod) {
		this.respCod = respCod;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getSettleAt() {
		return settleAt;
	}

	public void setSettleAt(String settleAt) {
		this.settleAt = settleAt;
	}

	public String getSettleType() {
		return settleType;
	}

	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	public String getSettleDate() {
		return settleDate;
	}

	public void setSettleDate(String settleDate) {
		this.settleDate = settleDate;
	}

	public String getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(String exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

}
