package com.unionpay.withhold.api.batch.bean;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 批量代收文本域
 * @author: 张世栋
 * @date: 2017年9月25日13:48:46
 * @version 1.0
 */
public class BatchCollectFileContentBean implements Serializable {

	private static final long serialVersionUID = -152704903959954132L;
	
	@Length(max = 32,message="[商户订单号]长度不符合规范")
	@NotEmpty(message="[商户订单号]不能为空")
	private String orderId;
	@Length(max = 3,message="[交易币种]长度不符合规范")
	@NotEmpty(message="[交易币种]不能为空")
	@Pattern(regexp="^(156)$",message="[交易币种]有误")
	private String currencyCode;
	@Length(max = 12,message="[单笔金额]长度不符合规范")
	@NotEmpty(message="[单笔金额]不能为空")
	private String amt;
	@Length(max = 20,message="[银行卡号]长度不符合规范")
	@NotEmpty(message="[银行卡号]不能为空")
	private String cardNo;
	@Length(max = 1,message="[卡类型]长度不符合规范")
	@NotEmpty(message="[卡类型]不能为空")
	@Pattern(regexp="^(1|2)$",message="[卡类型]有误")
	private String cardType;
	@Length(max = 30,message="[持卡人姓名]长度不符合规范")
	@NotEmpty(message="[持卡人姓名]不能为空")
	private String customerNm;
	@Length(max = 2,message="[证件类型]长度不符合规范")
	@NotEmpty(message="[证件类型]不能为空")
	private String certifTp;
	@Length(max = 20,message="[证件号]长度不符合规范")
	@NotEmpty(message="[证件号]不能为空")
	private String certifId;
	@Length(max = 20,message="[手机号]长度不符合规范")
	@NotEmpty(message="[手机号]不能为空")
	@Pattern(regexp="^1[3|4|5|7|8]\\d{9}$",message="[手机号]格式有误")
	private String phoneNo;
	/**卡类型**/
	@Length(max = 4,message="[卡类型]长度不符合规范")
	private String cvn2;
	/**卡有效期**/
	@Length(max = 4,message="[卡有效期]长度不符合规范")
	private String expired;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
	public String getAmt() {
		return amt;
	}
	public void setAmt(String amt) {
		this.amt = amt;
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCustomerNm() {
		return customerNm;
	}
	public void setCustomerNm(String customerNm) {
		this.customerNm = customerNm;
	}
	public String getCertifTp() {
		return certifTp;
	}
	public void setCertifTp(String certifTp) {
		this.certifTp = certifTp;
	}
	public String getCertifId() {
		return certifId;
	}
	public void setCertifId(String certifId) {
		this.certifId = certifId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getCvn2() {
		return cvn2;
	}
	public void setCvn2(String cvn2) {
		this.cvn2 = cvn2;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
}
