package com.unionpay.withhold.admin.pojo;

public class TMerchChnl {
    private String tid;

    private String merchno;

    private String chnlcode;

    private String chnlmercno;

    private String safetype;

    private String storgetype;

    private String pubkey;

    private String prikey;

    private String prikeypwd;

    private String chnlpubkey;

    private String status;

    private String intime;

    private String inuser;

    private String notes;

    private String remarks;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
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

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey == null ? null : pubkey.trim();
    }

    public String getPrikey() {
        return prikey;
    }

    public void setPrikey(String prikey) {
        this.prikey = prikey == null ? null : prikey.trim();
    }

    public String getPrikeypwd() {
        return prikeypwd;
    }

    public void setPrikeypwd(String prikeypwd) {
        this.prikeypwd = prikeypwd == null ? null : prikeypwd.trim();
    }

    public String getChnlpubkey() {
        return chnlpubkey;
    }

    public void setChnlpubkey(String chnlpubkey) {
        this.chnlpubkey = chnlpubkey == null ? null : chnlpubkey.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime == null ? null : intime.trim();
    }

    public String getInuser() {
        return inuser;
    }

    public void setInuser(String inuser) {
        this.inuser = inuser == null ? null : inuser.trim();
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