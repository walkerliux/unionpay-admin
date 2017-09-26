package com.unionpay.withhold.trade.api.bean;

import java.io.Serializable;
import java.util.List;

public class BatchCollectBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981485484128643365L;
	private String version;// 版本
	private String encoding;// 编码方式
	/**交易类型*/
	private String txnType;
	/**交易子类*/
	private String txnSubType;
	/**产品类型*/
	private String bizType;
	private String certId;
	private String merId;// 商户代码
	private String backUrl;// 通知地址
	private String batchNo;// 批次号
	// 交易要素id
	private String factorId;
	private String txnTime;// 订单发送时间
	private String totalQty;// 总笔数
	private String totalAmt;// 总金额
	private String reserved;// 保留域
	private List<BatchCollectDetaBean> detaList;
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
	public String getTxnType() {
		return txnType;
	}
	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}
	public String getTxnSubType() {
		return txnSubType;
	}
	public void setTxnSubType(String txnSubType) {
		this.txnSubType = txnSubType;
	}
	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getFactorId() {
		return factorId;
	}
	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	public String getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}
	public String getReserved() {
		return reserved;
	}
	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
	public List<BatchCollectDetaBean> getDetaList() {
		return detaList;
	}
	public void setDetaList(List<BatchCollectDetaBean> detaList) {
		this.detaList = detaList;
	}
	
}
