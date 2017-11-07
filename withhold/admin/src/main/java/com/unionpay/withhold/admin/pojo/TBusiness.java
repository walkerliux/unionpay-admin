package com.unionpay.withhold.admin.pojo;

public class TBusiness {
    private Integer busiid;

    private String busicode;

    private String businame;

    private String busitype;

    private String riskflag;

    private String status;

    private String notes;

    private Boolean checked = false;
    
    public Integer getBusiid() {
        return busiid;
    }

    public void setBusiid(Integer busiid) {
        this.busiid = busiid;
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode == null ? null : busicode.trim();
    }

    public String getBusiname() {
        return businame;
    }

    public void setBusiname(String businame) {
        this.businame = businame == null ? null : businame.trim();
    }

    public String getBusitype() {
        return busitype;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype == null ? null : busitype.trim();
    }

    public String getRiskflag() {
        return riskflag;
    }

    public void setRiskflag(String riskflag) {
        this.riskflag = riskflag == null ? null : riskflag.trim();
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

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}