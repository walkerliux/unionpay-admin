package com.unionpay.withhold.admin.Bean;

import java.util.List;


public class AccumRateBean {
	//分段扣率接受字段
	private String tid;
	private String rateId;
	private String rateDesc;
	private String notes;
	private List<AccRateBean> ardList;
	private String inuser;
	
	public String getInuser() {
		return inuser;
	}
	public void setInuser(String inuser) {
		this.inuser = inuser;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getRateId() {
		return rateId;
	}
	public void setRateId(String rateId) {
		this.rateId = rateId;
	}
	
	public String getRateDesc() {
		return rateDesc;
	}
	public void setRateDesc(String rateDesc) {
		this.rateDesc = rateDesc;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public List<AccRateBean> getArdList() {
		return ardList;
	}
	public void setArdList(List<AccRateBean> ardList) {
		this.ardList = ardList;
	}
	
	

}
