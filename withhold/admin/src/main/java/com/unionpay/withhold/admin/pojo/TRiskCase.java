package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TRiskCase {
    private Long caseid;

    private Long riskid;

    private String busicode;

    private String businame;

    private String riskver;

    private String status;

    private Date intime;

    private Long inuser;

    private Date uptime;

    private Long upuser;

    private String notes;

    private String remarks;

    private String activeflag;

    private String initflag;

    public Long getCaseid() {
        return caseid;
    }

    public void setCaseid(Long caseid) {
        this.caseid = caseid;
    }

    public Long getRiskid() {
        return riskid;
    }

    public void setRiskid(Long riskid) {
        this.riskid = riskid;
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

    public String getRiskver() {
        return riskver;
    }

    public void setRiskver(String riskver) {
        this.riskver = riskver == null ? null : riskver.trim();
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

    public String getActiveflag() {
        return activeflag;
    }

    public void setActiveflag(String activeflag) {
        this.activeflag = activeflag == null ? null : activeflag.trim();
    }

    public String getInitflag() {
        return initflag;
    }

    public void setInitflag(String initflag) {
        this.initflag = initflag == null ? null : initflag.trim();
    }
}