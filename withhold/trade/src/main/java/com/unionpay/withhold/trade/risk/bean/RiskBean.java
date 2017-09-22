package com.unionpay.withhold.trade.risk.bean;

import java.io.Serializable;

public class RiskBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 交易序列号
	 */
	private String txnseqno;
	/**
	 * 合作机构号
	 */
	private String coopInstId;
	/**
	 * 商户号
	 */
	private String merchId;
	/**
	 * 会员号
	 */
	private String memberId;
	/**
	 * 业务代码
	 */
	private String busiCode;
	/**
	 * 交易金额
	 */
	private String txnAmt;
	/**
	 * 银行卡类型
	 */
	private String cardType;
	/**
	 * 卡号/账号
	 */
	private String cardNo;
	/**
	 * 转入卡类型
	 */
	private String inCardType;
	/**
	 * 转入银行账号
	 */
	private String inCardNo;
	
	/**
	 * （代理商）渠道代码
	 */
	private String caCode;
	
	/**
	 * 通道（交易渠道）代码
	 */
	private String chnlCode;
	/**
	 * @return the txnseqno
	 */
	public String getTxnseqno() {
		return txnseqno;
	}
	/**
	 * @param txnseqno the txnseqno to set
	 */
	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}
	/**
	 * @return the coopInstId
	 */
	public String getCoopInstId() {
		return coopInstId;
	}
	/**
	 * @param coopInstId the coopInstId to set
	 */
	public void setCoopInstId(String coopInstId) {
		this.coopInstId = coopInstId;
	}
	/**
	 * @return the merchId
	 */
	public String getMerchId() {
		return merchId;
	}
	/**
	 * @param merchId the merchId to set
	 */
	public void setMerchId(String merchId) {
		this.merchId = merchId;
	}
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the busiCode
	 */
	public String getBusiCode() {
		return busiCode;
	}
	/**
	 * @param busiCode the busiCode to set
	 */
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	/**
	 * @return the txnAmt
	 */
	public String getTxnAmt() {
		return txnAmt;
	}
	/**
	 * @param txnAmt the txnAmt to set
	 */
	public void setTxnAmt(String txnAmt) {
		this.txnAmt = txnAmt;
	}
	/**
	 * @return the cardType
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * @param cardType the cardType to set
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * @return the cardNo
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * @param cardNo the cardNo to set
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getInCardType() {
		return inCardType;
	}
	public void setInCardType(String inCardType) {
		this.inCardType = inCardType;
	}
	public String getInCardNo() {
		return inCardNo;
	}
	public void setInCardNo(String inCardNo) {
		this.inCardNo = inCardNo;
	}
	public String getCaCode() {
		return caCode;
	}
	public void setCaCode(String caCode) {
		this.caCode = caCode;
	}
	public String getChnlCode() {
		return chnlCode;
	}
	public void setChnlCode(String chnlCode) {
		this.chnlCode = chnlCode;
	}
	
}
