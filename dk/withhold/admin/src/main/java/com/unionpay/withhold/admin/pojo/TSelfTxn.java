package com.unionpay.withhold.admin.pojo;

public class TSelfTxn {
    private Long tid;

    private String txnseqno;

    private String instiid;

    private String payordno;

    private String txndatetime;

    private String busicode;

    private Long amount;

    private String pan;

    private String merchno;

    private String systrcno;

    private String paytrcno;

    private Long cfee;

    private Long dfee;

    private String retcode;

    private String acqsettledate;

    private Long proid;

    private String status;

    private String result;

    private String notes;

    private String remarks;

    private String checkingId;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno == null ? null : txnseqno.trim();
    }

    public String getInstiid() {
        return instiid;
    }

    public void setInstiid(String instiid) {
        this.instiid = instiid == null ? null : instiid.trim();
    }

    public String getPayordno() {
        return payordno;
    }

    public void setPayordno(String payordno) {
        this.payordno = payordno == null ? null : payordno.trim();
    }

    public String getTxndatetime() {
        return txndatetime;
    }

    public void setTxndatetime(String txndatetime) {
        this.txndatetime = txndatetime == null ? null : txndatetime.trim();
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode == null ? null : busicode.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan == null ? null : pan.trim();
    }

    public String getMerchno() {
        return merchno;
    }

    public void setMerchno(String merchno) {
        this.merchno = merchno == null ? null : merchno.trim();
    }

    public String getSystrcno() {
        return systrcno;
    }

    public void setSystrcno(String systrcno) {
        this.systrcno = systrcno == null ? null : systrcno.trim();
    }

    public String getPaytrcno() {
        return paytrcno;
    }

    public void setPaytrcno(String paytrcno) {
        this.paytrcno = paytrcno == null ? null : paytrcno.trim();
    }

    public Long getCfee() {
        return cfee;
    }

    public void setCfee(Long cfee) {
        this.cfee = cfee;
    }

    public Long getDfee() {
        return dfee;
    }

    public void setDfee(Long dfee) {
        this.dfee = dfee;
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    public String getAcqsettledate() {
        return acqsettledate;
    }

    public void setAcqsettledate(String acqsettledate) {
        this.acqsettledate = acqsettledate == null ? null : acqsettledate.trim();
    }

    public Long getProid() {
        return proid;
    }

    public void setProid(Long proid) {
        this.proid = proid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
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

    public String getCheckingId() {
        return checkingId;
    }

    public void setCheckingId(String checkingId) {
        this.checkingId = checkingId == null ? null : checkingId.trim();
    }
}