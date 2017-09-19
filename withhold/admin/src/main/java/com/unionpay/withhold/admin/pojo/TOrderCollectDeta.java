package com.unionpay.withhold.admin.pojo;

public class TOrderCollectDeta {
    private Long tid;

    private Long batchtid;

    private String batchno;

    private String orderid;

    private String currencycode;

    private String amt;

    private String debtorbank;

    private String debtoraccount;

    private String debtorname;

    private String debtorconsign;

    private String creditorbank;

    private String creditoraccount;

    private String creditorname;

    private String proprietary;

    private String summary;

    private String respcode;

    private String respmsg;

    private String relatetradetxn;

    private String status;

    private String notes;

    private String remarks;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getBatchtid() {
        return batchtid;
    }

    public void setBatchtid(Long batchtid) {
        this.batchtid = batchtid;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getCurrencycode() {
        return currencycode;
    }

    public void setCurrencycode(String currencycode) {
        this.currencycode = currencycode == null ? null : currencycode.trim();
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt == null ? null : amt.trim();
    }

    public String getDebtorbank() {
        return debtorbank;
    }

    public void setDebtorbank(String debtorbank) {
        this.debtorbank = debtorbank == null ? null : debtorbank.trim();
    }

    public String getDebtoraccount() {
        return debtoraccount;
    }

    public void setDebtoraccount(String debtoraccount) {
        this.debtoraccount = debtoraccount == null ? null : debtoraccount.trim();
    }

    public String getDebtorname() {
        return debtorname;
    }

    public void setDebtorname(String debtorname) {
        this.debtorname = debtorname == null ? null : debtorname.trim();
    }

    public String getDebtorconsign() {
        return debtorconsign;
    }

    public void setDebtorconsign(String debtorconsign) {
        this.debtorconsign = debtorconsign == null ? null : debtorconsign.trim();
    }

    public String getCreditorbank() {
        return creditorbank;
    }

    public void setCreditorbank(String creditorbank) {
        this.creditorbank = creditorbank == null ? null : creditorbank.trim();
    }

    public String getCreditoraccount() {
        return creditoraccount;
    }

    public void setCreditoraccount(String creditoraccount) {
        this.creditoraccount = creditoraccount == null ? null : creditoraccount.trim();
    }

    public String getCreditorname() {
        return creditorname;
    }

    public void setCreditorname(String creditorname) {
        this.creditorname = creditorname == null ? null : creditorname.trim();
    }

    public String getProprietary() {
        return proprietary;
    }

    public void setProprietary(String proprietary) {
        this.proprietary = proprietary == null ? null : proprietary.trim();
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getRespcode() {
        return respcode;
    }

    public void setRespcode(String respcode) {
        this.respcode = respcode == null ? null : respcode.trim();
    }

    public String getRespmsg() {
        return respmsg;
    }

    public void setRespmsg(String respmsg) {
        this.respmsg = respmsg == null ? null : respmsg.trim();
    }

    public String getRelatetradetxn() {
        return relatetradetxn;
    }

    public void setRelatetradetxn(String relatetradetxn) {
        this.relatetradetxn = relatetradetxn == null ? null : relatetradetxn.trim();
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
}