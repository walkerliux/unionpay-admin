package com.unionpay.withhold.admin.pojo;

public class TRateAccum {
    private Long tid;

    private Long rateId;

    private String rateDesc;

    private Short accmode;

    private String accobj;

    private Long servicefee;

    private String notes;

    private String remarks;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public String getRateDesc() {
        return rateDesc;
    }

    public void setRateDesc(String rateDesc) {
        this.rateDesc = rateDesc == null ? null : rateDesc.trim();
    }

    public Short getAccmode() {
        return accmode;
    }

    public void setAccmode(Short accmode) {
        this.accmode = accmode;
    }

    public String getAccobj() {
        return accobj;
    }

    public void setAccobj(String accobj) {
        this.accobj = accobj == null ? null : accobj.trim();
    }

    public Long getServicefee() {
        return servicefee;
    }

    public void setServicefee(Long servicefee) {
        this.servicefee = servicefee;
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