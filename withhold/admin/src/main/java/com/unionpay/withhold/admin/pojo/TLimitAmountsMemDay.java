package com.unionpay.withhold.admin.pojo;

import java.math.BigDecimal;

public class TLimitAmountsMemDay {
    private Integer tid;

    private Long caseid;

    private BigDecimal limitAmount;

    private Short risklevel;

    private String status;

    private String notes;

    private String remarks;
    //关联属性
    private String riskname;
    
    
    public String getRiskname() {
		return riskname;
	}

	public void setRiskname(String riskname) {
		this.riskname = riskname;
	}

	public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Long getCaseid() {
        return caseid;
    }

    public void setCaseid(Long caseid) {
        this.caseid = caseid;
    }

    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(BigDecimal limitAmount) {
        this.limitAmount = limitAmount;
    }

    public Short getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(Short risklevel) {
        this.risklevel = risklevel;
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
}