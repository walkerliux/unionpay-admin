package com.unionpay.withhold.admin.pojo;

public class TChnlCpdkBatchDeta {
    private Integer tid;

    private String txnseqno;

    private String batchno;//批次号

    private String transdate;//商户日期

    private String orderno;//订单号

    private String openbankid;//开户行号

    private String cardtype;//卡折标志

    private String cardno;//卡号/折号

    private String usrname;//持卡人姓名

    private String certtype;//证件类型

    private String certid;//证件号

    private String curyid;//币种

    private String transamt;//金额

    private String purpose;

    private String priv1;//私有域

    private String responsecode;//应答信息

    private String message;//描述

    private String intime;

    private String uptime;

    private String extfield;//

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno == null ? null : txnseqno.trim();
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate == null ? null : transdate.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getOpenbankid() {
        return openbankid;
    }

    public void setOpenbankid(String openbankid) {
        this.openbankid = openbankid == null ? null : openbankid.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname == null ? null : usrname.trim();
    }

    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype == null ? null : certtype.trim();
    }

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid == null ? null : certid.trim();
    }

    public String getCuryid() {
        return curyid;
    }

    public void setCuryid(String curyid) {
        this.curyid = curyid == null ? null : curyid.trim();
    }

    public String getTransamt() {
        return transamt;
    }

    public void setTransamt(String transamt) {
        this.transamt = transamt == null ? null : transamt.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getPriv1() {
        return priv1;
    }

    public void setPriv1(String priv1) {
        this.priv1 = priv1 == null ? null : priv1.trim();
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode == null ? null : responsecode.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime == null ? null : intime.trim();
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime == null ? null : uptime.trim();
    }

    public String getExtfield() {
        return extfield;
    }

    public void setExtfield(String extfield) {
        this.extfield = extfield == null ? null : extfield.trim();
    }
}