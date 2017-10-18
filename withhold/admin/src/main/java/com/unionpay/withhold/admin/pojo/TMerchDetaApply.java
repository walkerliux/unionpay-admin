package com.unionpay.withhold.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TMerchDetaApply {
	private Integer selfId;

	private Long merchId;

	private Long memId;

	private String memberName;

	private String memberId;

	private String address;

	private String postCode;

	private String contact;

	private String contPhone;

	private String contAddress;

	private String contPost;

	private String contEmail;

	private String setlCycle;

	private BigDecimal charge;

	private BigDecimal deposit;

	private String riskVer;

	private String routVer;

	private String cacode;

	private String mcc;

	private String mccList;

	private String transfactors;

	private String status;

	private Long inUser;

	private Date inTime;

	private Long stexaUser;

	private Date stexaTime;

	private String stexaOpt;

	private Long cvlexaUser;

	private Date cvlexaTime;

	private String cvlexaOpt;

	private String notes;

	private String remarks;

	// 关联属性
	private String caname;
	private String transfactorsName;
	private String mccName;
	private String mccListName;

	public Integer getSelfId() {
		return selfId;
	}

	public void setSelfId(Integer selfId) {
		this.selfId = selfId;
	}

	public Long getMerchId() {
		return merchId;
	}

	public void setMerchId(Long merchId) {
		this.merchId = merchId;
	}

	public Long getMemId() {
		return memId;
	}

	public void setMemId(Long memId) {
		this.memId = memId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName == null ? null : memberName.trim();
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId == null ? null : memberId.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode == null ? null : postCode.trim();
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

	public String getContAddress() {
		return contAddress;
	}

	public void setContAddress(String contAddress) {
		this.contAddress = contAddress == null ? null : contAddress.trim();
	}

	public String getContPost() {
		return contPost;
	}

	public void setContPost(String contPost) {
		this.contPost = contPost == null ? null : contPost.trim();
	}

	public String getContEmail() {
		return contEmail;
	}

	public void setContEmail(String contEmail) {
		this.contEmail = contEmail == null ? null : contEmail.trim();
	}

	public String getSetlCycle() {
		return setlCycle;
	}

	public void setSetlCycle(String setlCycle) {
		this.setlCycle = setlCycle == null ? null : setlCycle.trim();
	}

	public BigDecimal getCharge() {
		return charge;
	}

	public void setCharge(BigDecimal charge) {
		this.charge = charge;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getRiskVer() {
		return riskVer;
	}

	public void setRiskVer(String riskVer) {
		this.riskVer = riskVer == null ? null : riskVer.trim();
	}

	public String getRoutVer() {
		return routVer;
	}

	public void setRoutVer(String routVer) {
		this.routVer = routVer == null ? null : routVer.trim();
	}

	public String getCacode() {
		return cacode;
	}

	public void setCacode(String cacode) {
		this.cacode = cacode == null ? null : cacode.trim();
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc == null ? null : mcc.trim();
	}

	public String getMccList() {
		return mccList;
	}

	public void setMccList(String mccList) {
		this.mccList = mccList == null ? null : mccList.trim();
	}

	public String getTransfactors() {
		return transfactors;
	}

	public void setTransfactors(String transfactors) {
		this.transfactors = transfactors == null ? null : transfactors.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Long getInUser() {
		return inUser;
	}

	public void setInUser(Long inUser) {
		this.inUser = inUser;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
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

	public String getCaname() {
		return caname;
	}

	public void setCaname(String caname) {
		this.caname = caname;
	}

	public String getTransfactorsName() {
		return transfactorsName;
	}

	public void setTransfactorsName(String transfactorsName) {
		this.transfactorsName = transfactorsName;
	}

	public String getMccName() {
		return mccName;
	}

	public void setMccName(String mccName) {
		this.mccName = mccName;
	}

	public String getMccListName() {
		return mccListName;
	}

	public void setMccListName(String mccListName) {
		this.mccListName = mccListName;
	}

}