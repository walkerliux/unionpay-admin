package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TCoopAgencyApply {
	private Long selfId;

	private Long caid;

	private String cacode;

	private String caname;

	private Long caprovince;

	private Long cacity;

	private String address;

	private String contact;

	private String contPhone;

	private String status;

	private Short calevel;

	private String supercode;

	private Long inuser;

	private Date intime;

	private String notes;

	private String remarks;

	private String riskver;

	private Long stexaUser;

	private Date stexaTime;

	private String stexaOpt;

	private Long cvlexaUser;

	private Date cvlexaTime;

	private String cvlexaOpt;

	/** 关联查询时的属性 **/
	private String provinceName;
	private String cityName;
	private String superName;
	private String rateId;

	/** 扣率代码 **/
	private String busicode;

	public Long getSelfId() {
		return selfId;
	}

	public void setSelfId(Long selfId) {
		this.selfId = selfId;
	}

	public Long getCaid() {
		return caid;
	}

	public void setCaid(Long caid) {
		this.caid = caid;
	}

	public String getCacode() {
		return cacode;
	}

	public void setCacode(String cacode) {
		this.cacode = cacode == null ? null : cacode.trim();
	}

	public String getCaname() {
		return caname;
	}

	public void setCaname(String caname) {
		this.caname = caname == null ? null : caname.trim();
	}

	public Long getCaprovince() {
		return caprovince;
	}

	public void setCaprovince(Long caprovince) {
		this.caprovince = caprovince;
	}

	public Long getCacity() {
		return cacity;
	}

	public void setCacity(Long cacity) {
		this.cacity = cacity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact == null ? null : contact.trim();
	}

	public String getContPhone() {
		return contPhone;
	}

	public void setContPhone(String contPhone) {
		this.contPhone = contPhone == null ? null : contPhone.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Short getCalevel() {
		return calevel;
	}

	public void setCalevel(Short calevel) {
		this.calevel = calevel;
	}

	public String getSupercode() {
		return supercode;
	}

	public void setSupercode(String supercode) {
		this.supercode = supercode == null ? null : supercode.trim();
	}

	public Long getInuser() {
		return inuser;
	}

	public void setInuser(Long inuser) {
		this.inuser = inuser;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public String getRiskver() {
		return riskver;
	}

	public void setRiskver(String riskver) {
		this.riskver = riskver == null ? null : riskver.trim();
	}

	public Long getStexaUser() {
		return stexaUser;
	}

	public void setStexaUser(Long stexaUser) {
		this.stexaUser = stexaUser;
	}

	public Date getStexaTime() {
		return stexaTime;
	}

	public void setStexaTime(Date stexaTime) {
		this.stexaTime = stexaTime;
	}

	public String getStexaOpt() {
		return stexaOpt;
	}

	public void setStexaOpt(String stexaOpt) {
		this.stexaOpt = stexaOpt == null ? null : stexaOpt.trim();
	}

	public Long getCvlexaUser() {
		return cvlexaUser;
	}

	public void setCvlexaUser(Long cvlexaUser) {
		this.cvlexaUser = cvlexaUser;
	}

	public Date getCvlexaTime() {
		return cvlexaTime;
	}

	public void setCvlexaTime(Date cvlexaTime) {
		this.cvlexaTime = cvlexaTime;
	}

	public String getCvlexaOpt() {
		return cvlexaOpt;
	}

	public void setCvlexaOpt(String cvlexaOpt) {
		this.cvlexaOpt = cvlexaOpt == null ? null : cvlexaOpt.trim();
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getSuperName() {
		return superName;
	}

	public void setSuperName(String superName) {
		this.superName = superName;
	}

	public String getBusicode() {
		return busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode;
	}

	public String getRateId() {
		return rateId;
	}

	public void setRateId(String rateId) {
		this.rateId = rateId;
	}

}