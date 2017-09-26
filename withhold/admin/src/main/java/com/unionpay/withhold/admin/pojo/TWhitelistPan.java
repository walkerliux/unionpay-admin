package com.unionpay.withhold.admin.pojo;

public class TWhitelistPan {
    private Long tId;

    private Long caseid;

    private String pan;

    private String status;

    private String notes;

    private String remarks;

    private Short risklevel;

    public Long gettId() {
        return tId;
    }

    public void settId(Long tId) {
        this.tId = tId;
    }

    public Long getCaseid() {
        return caseid;
    }

    public void setCaseid(Long caseid) {
        this.caseid = caseid;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan == null ? null : pan.trim();
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

    public Short getRisklevel() {
        return risklevel;
    }

    public void setRisklevel(Short risklevel) {
        this.risklevel = risklevel;
    }
}