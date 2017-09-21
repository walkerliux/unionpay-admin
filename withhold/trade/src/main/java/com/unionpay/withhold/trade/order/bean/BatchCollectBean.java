package com.unionpay.withhold.trade.order.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.executor.loader.ResultLoader;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.unionpay.withhold.bean.ResultBean;

public class BatchCollectBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5981485484128643365L;
	@Length(max = 6, message = "param.error.version")
	private String version;// 版本
	@Length(max = 1, message = "param.error.encoding")
	private String encoding;// 编码方式
	/**
	 *  交易类型
	 */
	@NotEmpty(message = "param.empty.txnType")
	@Length(max = 2, message = "param.error.txnType")
	private String txnType;
	/**
	 *  交易子类
	 */
	@NotEmpty(message = "param.empty.txnSubType")
	@Length(max = 2, message = "param.error.txnSubType")
	private String txnSubType;
	/**
	 *  产品类型
	 */
	@NotEmpty(message = "param.empty.bizType")
	@Length(max = 6, message = "param.error.bizType")
	private String bizType;
	@NotEmpty(message = "param.empty.certId")
	@Length(max = 15, message = "param.error.certId")
	private String certId;
	@NotEmpty(message = "param.empty.merId")
	@Length(max = 15, message = "param.error.merId")
	private String merId;// 商户代码
	@Length(max = 128, message = "param.error.backUrl")
	private String backUrl;// 通知地址
	@NotEmpty(message = "param.empty.batchNo")
	@Length(max = 32, message = "param.error.batchNo")
	private String batchNo;// 批次号
	// 交易要素id
	@NotEmpty(message = "param.empty.factorId")
	@Length(max = 4, message = "param.error.factorId")
	private String factorId;
	@NotEmpty(message = "param.empty.txnTime")
	@Length(max = 14, message = "param.error.txnTime")
	private String txnTime;// 订单发送时间
	@NotEmpty(message = "param.empty.totalQty")
	@Length(max = 12, message = "param.error.totalQty")
	private String totalQty;// 总笔数
	@NotEmpty(message = "param.empty.totalAmt")
	@Length(max = 12, message = "param.error.totalAmt")
	private String totalAmt;// 总金额
	@Length(max = 256, message = "param.error.reserved")
	private String reserved;// 保留域
	private List<BatchCollectDetaBean> detaList;
	
	
	/**
	 * 批量报文检查结果
	 */
	private ResultBean batchMessageCheck;
	/**
	 * 重复提交检查结果
	 */
	private ResultBean repeatSubmitCheck;
	/**
	 * 业务检查结果
	 */
	private ResultBean businessCheck;
	/**
	 * 保存批次结果
	 */
	private ResultBean saveBatch;
	
	/**
	 * 保存明细流水结果
	 */
	private ResultBean saveDetaTxnlog;
	
	/**
	 * 保存明细结果
	 */
	private ResultBean saveDeta;
	
	private ResultBean finalResult;
	
	private ResultBean merchCheck;
	
	private String tn;
	
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
	public ResultBean getBatchMessageCheck() {
		return batchMessageCheck;
	}
	public void setBatchMessageCheck(ResultBean batchMessageCheck) {
		this.batchMessageCheck = batchMessageCheck;
	}
	public ResultBean getRepeatSubmitCheck() {
		return repeatSubmitCheck;
	}
	public void setRepeatSubmitCheck(ResultBean repeatSubmitCheck) {
		this.repeatSubmitCheck = repeatSubmitCheck;
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
	public ResultBean getBusinessCheck() {
		return businessCheck;
	}
	public void setBusinessCheck(ResultBean businessCheck) {
		this.businessCheck = businessCheck;
	}
	public String getTn() {
		return tn;
	}
	public void setTn(String tn) {
		this.tn = tn;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
	public ResultBean getSaveBatch() {
		return saveBatch;
	}
	public void setSaveBatch(ResultBean saveBatch) {
		this.saveBatch = saveBatch;
	}
	public ResultBean getSaveDetaTxnlog() {
		return saveDetaTxnlog;
	}
	public void setSaveDetaTxnlog(ResultBean saveDetaTxnlog) {
		this.saveDetaTxnlog = saveDetaTxnlog;
	}
	public ResultBean getSaveDeta() {
		return saveDeta;
	}
	public void setSaveDeta(ResultBean saveDeta) {
		this.saveDeta = saveDeta;
	}
	public ResultBean getFinalResult() {
		return finalResult;
	}
	public void setFinalResult(ResultBean finalResult) {
		this.finalResult = finalResult;
	}
	public ResultBean getMerchCheck() {
		return merchCheck;
	}
	public void setMerchCheck(ResultBean merchCheck) {
		this.merchCheck = merchCheck;
	}
	
	
	
}
