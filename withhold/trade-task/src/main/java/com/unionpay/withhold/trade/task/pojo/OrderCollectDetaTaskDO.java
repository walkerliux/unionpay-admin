package com.unionpay.withhold.trade.task.pojo;

public class OrderCollectDetaTaskDO {
    private Long tid;

    private Long batchtid;

    private String batchno;

    private String orderid;

    private String currencycode;

    private String amt;

    private String bankcode;

    private String cardno;

    private String customernm;

    private String summary;

    private String respcode;

    private String respmsg;

    private String relatetradetxn;

    private String status;

    private String notes;

    private String remarks;

    private String cardtype;

    private String certiftp;

    private String certifid;

    private String phoneno;

    private String cvn2;

    private String expired;

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

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getCustomernm() {
        return customernm;
    }

    public void setCustomernm(String customernm) {
        this.customernm = customernm == null ? null : customernm.trim();
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

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getCertiftp() {
        return certiftp;
    }

    public void setCertiftp(String certiftp) {
        this.certiftp = certiftp == null ? null : certiftp.trim();
    }

    public String getCertifid() {
        return certifid;
    }

    public void setCertifid(String certifid) {
        this.certifid = certifid == null ? null : certifid.trim();
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno == null ? null : phoneno.trim();
    }

    public String getCvn2() {
        return cvn2;
    }

    public void setCvn2(String cvn2) {
        this.cvn2 = cvn2 == null ? null : cvn2.trim();
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired == null ? null : expired.trim();
    }
}