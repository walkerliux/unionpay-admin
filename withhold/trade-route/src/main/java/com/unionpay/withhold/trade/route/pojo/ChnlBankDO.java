package com.unionpay.withhold.trade.route.pojo;

import java.util.Date;

public class ChnlBankDO {
    private Integer tid;

    private String chnlcode;

    private String bankcode;

    private String cardtype;

    private Long perlimit;

    private Long accumlimit;

    private String status;

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

    public String getChnlcode() {
        return chnlcode;
    }

    public void setChnlcode(String chnlcode) {
        this.chnlcode = chnlcode == null ? null : chnlcode.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public Long getPerlimit() {
        return perlimit;
    }

    public void setPerlimit(Long perlimit) {
        this.perlimit = perlimit;
    }

    public Long getAccumlimit() {
        return accumlimit;
    }

    public void setAccumlimit(Long accumlimit) {
        this.accumlimit = accumlimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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