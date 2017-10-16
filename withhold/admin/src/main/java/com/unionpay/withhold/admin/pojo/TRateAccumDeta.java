package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TRateAccumDeta {
    private Integer tid;

    private Long rateId;

    private Long startrange;

    private Long endrange;

    private String rateType;

    private Short feeRate;

    private Long minFee;

    private Long maxFee;

    private Long inuser;

    private Date intime;

    private String notes;

    private String remarks;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public Long getStartrange() {
        return startrange;
    }

    public void setStartrange(Long startrange) {
        this.startrange = startrange;
    }

    public Long getEndrange() {
        return endrange;
    }

    public void setEndrange(Long endrange) {
        this.endrange = endrange;
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    public Short getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(Short feeRate) {
        this.feeRate = feeRate;
    }

    public Long getMinFee() {
        return minFee;
    }

    public void setMinFee(Long minFee) {
        this.minFee = minFee;
    }

    public Long getMaxFee() {
        return maxFee;
    }

    public void setMaxFee(Long maxFee) {
        this.maxFee = maxFee;
    }

    public Long getInuser() {
        return inuser;
    }

    public void setInuser(Long inuser) {
        this.inuser = inuser;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
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