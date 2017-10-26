package com.unionpay.withhold.admin.pojo;

public class TRiskList {
	private Short orders;

	private Long rid;

	private String strategy;

	private String excfnc;

	private String notes;

	private String remarks;

	private Short status;

	private Boolean checked = false;

	public Short getOrders() {
		return orders;
	}

	public void setOrders(Short orders) {
		this.orders = orders;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy == null ? null : strategy.trim();
	}

	public String getExcfnc() {
		return excfnc;
	}

	public void setExcfnc(String excfnc) {
		this.excfnc = excfnc == null ? null : excfnc.trim();
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

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

}