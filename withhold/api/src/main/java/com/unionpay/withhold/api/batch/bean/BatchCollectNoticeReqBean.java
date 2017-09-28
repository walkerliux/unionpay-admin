package com.unionpay.withhold.api.batch.bean;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * 批量代收请求bean
 * @author: 张世栋
 * @date: 2017年9月25日13:48:57
 * @version 1.0
 */
public class BatchCollectNoticeReqBean implements Serializable {
	
	private static final long serialVersionUID = 1349442825901337918L;
	
	@Length(message = "[版本]长度不符合规范",max=6)
    @NotEmpty(message = "[版本]不能为空")
    protected String version; // 版本

    @Length(message = "[编码方式]长度不符合规范",max=2)
    @NotEmpty(message = "[编码方式]不能为空")
	protected String encoding; // 编码方式
    
    @Length(message = "[交易类型]长度不符合规范",max=2)
    @NotEmpty(message = "[交易类型]不能为空")
	private String txnType; // 交易类型
    
    @Length(message = "[交易子类]长度不符合规范",max=2)
    @NotEmpty(message = "[交易子类]不能为空")
	private String txnSubType; // 交易子类
	
    private String tradeType;

	@Length( message="[商户代码]长度不符合规范",max = 15)
	@NotEmpty(message="[商户代码]不能为空")
	private String merId;// 商户代码
	@Length( message="[通知地址]长度不符合规范",max = 128)
	@NotEmpty(message="[通知地址]不能为空")
	private String backUrl;// 通知地址
	@Length( message="[批次号]长度不符合规范",max = 32)
	@NotEmpty(message="[批次号]不能为空")
	private String batchNo;// 批次号
	@Length( message="[订单发送时间]长度不符合规范",max = 14)
	@NotEmpty(message="[订单发送时间]不能为空")
	private String txnTime;// 订单发送时间
	@NotEmpty(message="[总笔数]不能为空")
	private String totalQty;// 总笔数
	@NotEmpty(message="[总金额间]不能为空")
	private String totalAmt;// 总金额
	@NotEmpty(message="[文件内容]不能为空")
	private String fileContent;// 文件内容
	private String reserved;// 保留域
	private String 	waitTotalQty	;//	处理中总笔数
	private String 	waitTotalAmt	;//	处理中总金额
	private String 	succTotalQty 	;//	成功总笔数
	private String 	succTotalAmt 	;//	成功总金额 
	private String 	failTotalQty 	;//	失败总笔数
	private String 	failTotalAmt 	;//	失败总金额 

	
	public void prepareBasicData(){
		this.version="1.0";
		this.encoding="utf-8";
		this.txnType="04";
		this.txnSubType="00";
	}
	
	
	public String getWaitTotalQty() {
		return waitTotalQty;
	}
	public void setWaitTotalQty(String waitTotalQty) {
		this.waitTotalQty = waitTotalQty;
	}
	public String getWaitTotalAmt() {
		return waitTotalAmt;
	}
	public void setWaitTotalAmt(String waitTotalAmt) {
		this.waitTotalAmt = waitTotalAmt;
	}
	public String getSuccTotalQty() {
		return succTotalQty;
	}
	public void setSuccTotalQty(String succTotalQty) {
		this.succTotalQty = succTotalQty;
	}
	public String getSuccTotalAmt() {
		return succTotalAmt;
	}
	public void setSuccTotalAmt(String succTotalAmt) {
		this.succTotalAmt = succTotalAmt;
	}
	public String getFailTotalQty() {
		return failTotalQty;
	}
	public void setFailTotalQty(String failTotalQty) {
		this.failTotalQty = failTotalQty;
	}
	public String getFailTotalAmt() {
		return failTotalAmt;
	}
	public void setFailTotalAmt(String failTotalAmt) {
		this.failTotalAmt = failTotalAmt;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
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

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}
}
