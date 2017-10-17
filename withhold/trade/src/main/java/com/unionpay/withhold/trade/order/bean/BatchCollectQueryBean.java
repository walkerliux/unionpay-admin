package com.unionpay.withhold.trade.order.bean;

import java.io.Serializable;
import java.util.List;

import com.unionpay.withhold.trade.order.pojo.OrderCollectDetaDO;

public class BatchCollectQueryBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1326104329011536041L;
	private String version;// 版本
	private String encoding;// 编码方式
	private String txnType;// 交易类型
	private String txnSubType;// 交易子类
	private String bizType;// 产品类型
	private String merId;// 商户代码
	private String batchNo;// 批次号
	private String tn;// 受理批次号
	private String txnDate;// 原批次交易日期
	private String txnTime;// 发送时间
	
	private String factorId;//交易要素id
	private List<OrderCollectDetaDO> fileContent;// 	文件内容
	private String totalQty;//	总笔数
	private String totalAmt;//	总金额
	
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
	public String getMerId() {
		return merId;
	}
	public void setMerId(String merId) {
		this.merId = merId;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	public String getTxnDate() {
		return txnDate;
	}
	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}
	public String getTxnTime() {
		return txnTime;
	}
	public void setTxnTime(String txnTime) {
		this.txnTime = txnTime;
	}
	public String getFactorId() {
		return factorId;
	}
	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}
	public List<OrderCollectDetaDO> getFileContent() {
		return fileContent;
	}
	public void setFileContent(List<OrderCollectDetaDO> fileContent) {
		this.fileContent = fileContent;
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
	
	
}
