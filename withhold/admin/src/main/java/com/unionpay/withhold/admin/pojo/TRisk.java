package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TRisk {
    private Long riskid;

    private String riskver;

    private String riskname;

    private String status;

    private Date intime;

    private Long inuser;

    private Date uptime;

    private Long upuser;

    private String notes;

    private String remarks;

    public Long getRiskid() {
        return riskid;
    }

    public void setRiskid(Long riskid) {
        this.riskid = riskid;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Long getInuser() {
        return inuser;
    }

    public void setInuser(Long inuser) {
        this.inuser = inuser;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Long getUpuser() {
        return upuser;
    }

    public void setUpuser(Long upuser) {
        this.upuser = upuser;
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