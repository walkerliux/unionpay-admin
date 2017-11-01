package com.unionpay.withhold.admin.pojo;

public class TWhitelistPan {
	private Integer tId;

	private String pan;

	private String status;

	private String notes;

	private String remarks;

	private Short risklevel;

	private String riskLevelName;

	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan == null ? null : pan.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
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

	public Short getRisklevel() {
		return risklevel;
	}

	public void setRisklevel(Short risklevel) {
		this.risklevel = risklevel;
	}

	public String getRiskLevelName() {
		return riskLevelName;
	}

	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName == null ? null : riskLevelName.trim();
	}

}