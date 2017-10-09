package com.unionpay.withhold.admin.pojo;

public class TSpeFeeDeta {
    private Integer tid;

    private Long rateId;

    private Long minfee;

    private Long maxfee;

    private Long fixfee;

    private Long feerate;

    private String function;

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

    public Long getMinfee() {
        return minfee;
    }

    public void setMinfee(Long minfee) {
        this.minfee = minfee;
    }

    public Long getMaxfee() {
        return maxfee;
    }

    public void setMaxfee(Long maxfee) {
        this.maxfee = maxfee;
    }

    public Long getFixfee() {
        return fixfee;
    }

    public void setFixfee(Long fixfee) {
        this.fixfee = fixfee;
    }

    public Long getFeerate() {
        return feerate;
    }

    public void setFeerate(Long feerate) {
        this.feerate = feerate;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
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