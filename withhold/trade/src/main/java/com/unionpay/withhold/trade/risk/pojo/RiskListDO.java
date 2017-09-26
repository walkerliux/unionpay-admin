package com.unionpay.withhold.trade.risk.pojo;

public class RiskListDO {
    private Integer rid;

    private String strategy;

    private Short orders;

    private String excfnc;

    private String notes;

    private String remarks;

    private Short status;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy == null ? null : strategy.trim();
    }

    public Short getOrders() {
        return orders;
    }

    public void setOrders(Short orders) {
        this.orders = orders;
    }

    public String getExcfnc() {
        return excfnc;
    }

    public void setExcfnc(String excfnc) {
        this.excfnc = excfnc == null ? null : excfnc.trim();
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

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }
}