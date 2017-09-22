package com.unionpay.withhold.api.model;

public class MerchMk {
    private String memberid;

    private String safeseq;

    private String safetype;

    private String memberpubkey;

    private String memberprikey;

    private String localpubkey;

    private String localprikey;

    private String platformpfxpwd;

    private String bmk;

    private String pin;

    private String mac;

    private String data;

    private String md5;

    private String storgetype;

    private String status;

    private String keyflag;

    private String notes;

    private String remarks;

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid == null ? null : memberid.trim();
    }

    public String getSafeseq() {
        return safeseq;
    }

    public void setSafeseq(String safeseq) {
        this.safeseq = safeseq == null ? null : safeseq.trim();
    }

    public String getSafetype() {
        return safetype;
    }

    public void setSafetype(String safetype) {
        this.safetype = safetype == null ? null : safetype.trim();
    }

    public String getMemberpubkey() {
        return memberpubkey;
    }

    public void setMemberpubkey(String memberpubkey) {
        this.memberpubkey = memberpubkey == null ? null : memberpubkey.trim();
    }

    public String getMemberprikey() {
        return memberprikey;
    }

    public void setMemberprikey(String memberprikey) {
        this.memberprikey = memberprikey == null ? null : memberprikey.trim();
    }

    public String getLocalpubkey() {
        return localpubkey;
    }

    public void setLocalpubkey(String localpubkey) {
        this.localpubkey = localpubkey == null ? null : localpubkey.trim();
    }

    public String getLocalprikey() {
        return localprikey;
    }

    public void setLocalprikey(String localprikey) {
        this.localprikey = localprikey == null ? null : localprikey.trim();
    }

    public String getPlatformpfxpwd() {
        return platformpfxpwd;
    }

    public void setPlatformpfxpwd(String platformpfxpwd) {
        this.platformpfxpwd = platformpfxpwd == null ? null : platformpfxpwd.trim();
    }

    public String getBmk() {
        return bmk;
    }

    public void setBmk(String bmk) {
        this.bmk = bmk == null ? null : bmk.trim();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public String getStorgetype() {
        return storgetype;
    }

    public void setStorgetype(String storgetype) {
        this.storgetype = storgetype == null ? null : storgetype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getKeyflag() {
        return keyflag;
    }

    public void setKeyflag(String keyflag) {
        this.keyflag = keyflag == null ? null : keyflag.trim();
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