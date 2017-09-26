package com.unionpay.withhold.api.util;

import java.sql.Timestamp;

public class BatchDetail {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 批次号
	 */
	private String batchId;
	/**
	 * 扣款明细序号
	 */
	private Integer detailNo;
	/**
	 * 商户订单号
	 */
	private String mchntOrderId;
	/**
	 * 扣款人开户行名称
	 */
	private String insNm;
	/**
	 * 卡号
	 */
	private String priAcctNo;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 商户号
	 */
	private String mchntCd;
	/**
	 * 交易金额
	 */
	private Long transAt;

	private double transAtFormat;
	/**
	 * 交易要素id
	 */
	private String transFactorId;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private String recCrtUser;
	/**
	 * 创建时间
	 */
	private Timestamp recCrtTs;
	/**
	 * 更新人
	 */
	private String recUpdUser;
	/**
	 * 更新时间
	 */
	private Timestamp recUpdTs;
	/**
	 * 交易时间
	 */
	private String transTm;

	/**
	 * 后台接口通知地址
	 */
	private String interfaceBackUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public Integer getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(Integer detailNo) {
		this.detailNo = detailNo;
	}

	public String getMchntOrderId() {
		return mchntOrderId;
	}

	public void setMchntOrderId(String mchntOrderId) {
		this.mchntOrderId = mchntOrderId;
	}

	public String getInsNm() {
		return insNm;
	}

	public void setInsNm(String insNm) {
		this.insNm = insNm;
	}

	public String getPriAcctNo() {
		return priAcctNo;
	}

	public void setPriAcctNo(String priAcctNo) {
		this.priAcctNo = priAcctNo;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
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

	public String getMchntCd() {
		return mchntCd;
	}

	public void setMchntCd(String mchntCd) {
		this.mchntCd = mchntCd;
	}

	public Long getTransAt() {
		return transAt;
	}

	public void setTransAt(Long transAt) {
		this.transAt = transAt;
	}

	public String getTransFactorId() {
		return transFactorId;
	}

	public void setTransFactorId(String transFactorId) {
		this.transFactorId = transFactorId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRecCrtUser() {
		return recCrtUser;
	}

	public void setRecCrtUser(String recCrtUser) {
		this.recCrtUser = recCrtUser;
	}

	public Timestamp getRecCrtTs() {
		return recCrtTs;
	}

	public void setRecCrtTs(Timestamp recCrtTs) {
		this.recCrtTs = recCrtTs;
	}

	public String getRecUpdUser() {
		return recUpdUser;
	}

	public void setRecUpdUser(String recUpdUser) {
		this.recUpdUser = recUpdUser;
	}

	public Timestamp getRecUpdTs() {
		return recUpdTs;
	}

	public void setRecUpdTs(Timestamp recUpdTs) {
		this.recUpdTs = recUpdTs;
	}

	public double getTransAtFormat() {
		return transAtFormat;
	}

	public void setTransAtFormat(double transAtFormat) {
		this.transAtFormat = transAtFormat;
	}

	public String getTransTm() {
		return transTm;
	}

	public void setTransTm(String transTm) {
		this.transTm = transTm;
	}

	public String getInterfaceBackUrl() {
		return interfaceBackUrl;
	}

	public void setInterfaceBackUrl(String interfaceBackUrl) {
		this.interfaceBackUrl = interfaceBackUrl;
	}

	@Override
	public String toString() {
		return "BatchDetail [id=" + id + ", batchId=" + batchId + ", detailNo=" + detailNo + ", mchntOrderId="
				+ mchntOrderId + ", insNm=" + insNm + ", priAcctNo=" + priAcctNo + ", idCard=" + idCard + ", name="
				+ name + ", phone=" + phone + ", mchntCd=" + mchntCd + ", transAt=" + transAt + ", transFactorId="
				+ transFactorId + ", remark=" + remark + ", recCrtUser=" + recCrtUser + ", recCrtTs=" + recCrtTs
				+ ", recUpdUser=" + recUpdUser + ", recUpdTs=" + recUpdTs + "]";
	}

}
