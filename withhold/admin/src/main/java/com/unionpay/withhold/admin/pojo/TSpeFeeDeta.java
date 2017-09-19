package com.unionpay.withhold.admin.pojo;

public class TSpeFeeDeta {
    private String tid;

    private String rateId;

    private String minfee;

    private String maxfee;

    private String fixfee;

    private String feerate;

    private String function;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getRateId() {
        return rateId;
    }

    public void setRateId(String rateId) {
        this.rateId = rateId == null ? null : rateId.trim();
    }

    public String getMinfee() {
        return minfee;
    }

    public void setMinfee(String minfee) {
        this.minfee = minfee == null ? null : minfee.trim();
    }

    public String getMaxfee() {
        return maxfee;
    }

    public void setMaxfee(String maxfee) {
        this.maxfee = maxfee == null ? null : maxfee.trim();
    }

    public String getFixfee() {
        return fixfee;
    }

    public void setFixfee(String fixfee) {
        this.fixfee = fixfee == null ? null : fixfee.trim();
    }

    public String getFeerate() {
        return feerate;
    }

    public void setFeerate(String feerate) {
        this.feerate = feerate == null ? null : feerate.trim();
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function == null ? null : function.trim();
    }
}