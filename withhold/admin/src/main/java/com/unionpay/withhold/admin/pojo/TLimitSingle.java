package com.unionpay.withhold.admin.pojo;

import java.math.BigDecimal;

public class TLimitSingle {
    private Integer tid;

    private Long caseid;

    private BigDecimal maxAmount;

    private BigDecimal minAmount;

    private Short risklevel;

    private String status;

    private String notes;

    private String remarks;
    
    // 关联属性
    private String riskver;
    private String riskname;
    private String riskLevelName;

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

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public BigDecimal getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(BigDecimal minAmount) {
        this.minAmount = minAmount;
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

	public String getRiskver() {
		return riskver;
	}

	public void setRiskver(String riskver) {
		this.riskver = riskver == null ? null : riskver.trim();
	}

	public String getRiskname() {
		return riskname;
	}

	public void setRiskname(String riskname) {
		this.riskname = riskname == null ? null : riskname.trim();
	}

	public String getRiskLevelName() {
		return riskLevelName;
	}

	public void setRiskLevelName(String riskLevelName) {
		this.riskLevelName = riskLevelName == null ? null : riskLevelName.trim();
	}
    
    
}