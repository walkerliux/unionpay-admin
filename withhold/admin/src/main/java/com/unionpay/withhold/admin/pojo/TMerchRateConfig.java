package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TMerchRateConfig {
    private Long tid;

    private String target;

    private String memberId;

    private String busicode;

    private Short setlflg;

    private Short rateMethod;

    private Long rateId;

    private Date intime;

    private Long inuser;

    private String notes;

    private String remarks;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode == null ? null : busicode.trim();
    }

    public Short getSetlflg() {
        return setlflg;
    }

    public void setSetlflg(Short setlflg) {
        this.setlflg = setlflg;
    }

    public Short getRateMethod() {
        return rateMethod;
    }

    public void setRateMethod(Short rateMethod) {
        this.rateMethod = rateMethod;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
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