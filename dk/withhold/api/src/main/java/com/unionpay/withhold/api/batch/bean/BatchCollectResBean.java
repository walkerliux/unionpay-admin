package com.unionpay.withhold.api.batch.bean;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.unionpay.withhold.api.common.bean.BaseBean;

/**
 * 批量代收应答bean
 * @author: 张世栋
 * @date: 2017年9月25日13:49:09
 * @version 1.0
 */
public class BatchCollectResBean extends BaseBean {
	
	private static final long serialVersionUID = 5750273172316551231L;
	
	@Length(message = "[产品类型]长度不符合规范",max=6)
    @NotEmpty(message = "[产品类型]不能为空")
	private String bizType="000004"; // 产品类型
	@Length(message="[商户代码]长度不符合规范",max = 15)
	@NotEmpty(message="[商户代码]不能为空")
	private String merId;// 商户代码
	@Length(message="[通知地址]长度不符合规范",max = 128)
	@NotEmpty(message="[通知地址]不能为空")
	private String backUrl;// 通知地址
	@Length(message="[批次号]长度不符合规范",max = 32)
	@NotEmpty(message="[批次号]不能为空")
	private String batchNo;// 批次号
	@Length(message="[订单发送时间]长度不符合规范",max = 14)
	@NotEmpty(message="[订单发送时间]不能为空")
	private String txnTime;// 订单发送时间
	@NotEmpty(message="[总笔数]不能为空")
	private String totalQty;// 总笔数
	@NotEmpty(message="[总金额]不能为空")
	private String totalAmt;// 总金额
	private String reserved;// 保留域
	@Length(message="[响应码]长度不符合规范",max = 4)
	@NotEmpty(message="[响应码]不能为空")
	private String respCode;// 响应码
	@Length(message="[应答信息]长度不符合规范",max = 256)
	@NotEmpty(message="[应答信息]不能为空")
	private String respMsg;// 应答信息
	private String tn;
	

	public String getBizType() {
		return bizType;
	}
	public void setBizType(String bizType) {
		this.bizType = bizType;
	}
	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
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

	public String getReserved() {
		return reserved;
	}

	public void setReserved(String reserved) {
		this.reserved = reserved;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

}
