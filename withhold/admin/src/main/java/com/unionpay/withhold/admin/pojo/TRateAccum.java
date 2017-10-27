package com.unionpay.withhold.admin.pojo;

public class TRateAccum {
    private Integer rateId;

    private String rateDesc;

    private String rateMethod;

    private String notes;

    private String remarks;

    public Integer getRateId() {
        return rateId;
    }

    public void setRateId(Integer rateId) {
        this.rateId = rateId;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc == null ? null : rateDesc.trim();
    }

    public String getRateMethod() {
        return rateMethod;
    }

    public void setRateMethod(String rateMethod) {
        this.rateMethod = rateMethod == null ? null : rateMethod.trim();
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
    //新增页面展示字段
    private String inuser;
    private String intime;

	public String getInuser() {
		return inuser;
	}

	public void setInuser(String inuser) {
		this.inuser = inuser;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}
    
}