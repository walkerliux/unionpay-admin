package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TMerchChnl {
    private Integer tid;

    private String merchno;

    private String chnlcode;

    private String chnlmercno;

    private String safetype;

    private String storgetype;

    private String prikeypwd;

    private String status;

    private Date intime;

    private Integer inuser;

    private String notes;

    private String remarks;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getMerchno() {
        return merchno;
    }

    public void setMerchno(String merchno) {
        this.merchno = merchno == null ? null : merchno.trim();
    }

    public String getChnlcode() {
        return chnlcode;
    }

    public void setChnlcode(String chnlcode) {
        this.chnlcode = chnlcode == null ? null : chnlcode.trim();
    }

    public String getChnlmercno() {
        return chnlmercno;
    }

    public void setChnlmercno(String chnlmercno) {
        this.chnlmercno = chnlmercno == null ? null : chnlmercno.trim();
    }

    public String getSafetype() {
        return safetype;
    }

    public void setSafetype(String safetype) {
        this.safetype = safetype == null ? null : safetype.trim();
    }

    public String getStorgetype() {
        return storgetype;
    }

    public void setStorgetype(String storgetype) {
        this.storgetype = storgetype == null ? null : storgetype.trim();
    }

    public String getPrikeypwd() {
        return prikeypwd;
    }

    public void setPrikeypwd(String prikeypwd) {
        this.prikeypwd = prikeypwd == null ? null : prikeypwd.trim();
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

    public Integer getInuser() {
        return inuser;
    }

    public void setInuser(Integer inuser) {
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