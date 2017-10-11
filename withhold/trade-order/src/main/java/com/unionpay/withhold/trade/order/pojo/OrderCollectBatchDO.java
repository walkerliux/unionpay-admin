package com.unionpay.withhold.trade.order.pojo;

public class OrderCollectBatchDO {
    private Long tid;

    private String merid;

    private String version;

    private String encoding;

    private String certid;

    private String txntype;

    private String txnsubtype;

    private String biztype;

    private String backurl;

    private String batchno;

    private String factorid;

    private String txntime;

    private String txndate;

    private Long totalqty;

    private Long totalamt;

    private String reserved;

    private String respcode;

    private String respmsg;

    private String status;

    private String ordercommitime;

    private String orderfinshtime;

    private String syncnotify;

    private String tn;

    private String notes;

    private String remarks;

    private String accesstype;

    private String coopinstiid;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid == null ? null : merid.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding == null ? null : encoding.trim();
    }

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid == null ? null : certid.trim();
    }

    public String getTxntype() {
        return txntype;
    }

    public void setTxntype(String txntype) {
        this.txntype = txntype == null ? null : txntype.trim();
    }

    public String getTxnsubtype() {
        return txnsubtype;
    }

    public void setTxnsubtype(String txnsubtype) {
        this.txnsubtype = txnsubtype == null ? null : txnsubtype.trim();
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype == null ? null : biztype.trim();
    }

    public String getBackurl() {
        return backurl;
    }

    public void setBackurl(String backurl) {
        this.backurl = backurl == null ? null : backurl.trim();
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno == null ? null : batchno.trim();
    }

    public String getFactorid() {
        return factorid;
    }

    public void setFactorid(String factorid) {
        this.factorid = factorid == null ? null : factorid.trim();
    }

    public String getTxntime() {
        return txntime;
    }

    public void setTxntime(String txntime) {
        this.txntime = txntime == null ? null : txntime.trim();
    }

    public String getTxndate() {
        return txndate;
    }

    public void setTxndate(String txndate) {
        this.txndate = txndate == null ? null : txndate.trim();
    }

    public Long getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Long totalqty) {
        this.totalqty = totalqty;
    }

    public Long getTotalamt() {
        return totalamt;
    }

    public void setTotalamt(Long totalamt) {
        this.totalamt = totalamt;
    }

    public String getReserved() {
        return reserved;
    }

    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getOrdercommitime() {
        return ordercommitime;
    }

    public void setOrdercommitime(String ordercommitime) {
        this.ordercommitime = ordercommitime == null ? null : ordercommitime.trim();
    }

    public String getOrderfinshtime() {
        return orderfinshtime;
    }

    public void setOrderfinshtime(String orderfinshtime) {
        this.orderfinshtime = orderfinshtime == null ? null : orderfinshtime.trim();
    }

    public String getSyncnotify() {
        return syncnotify;
    }

    public void setSyncnotify(String syncnotify) {
        this.syncnotify = syncnotify == null ? null : syncnotify.trim();
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn == null ? null : tn.trim();
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

    public String getAccesstype() {
        return accesstype;
    }

    public void setAccesstype(String accesstype) {
        this.accesstype = accesstype == null ? null : accesstype.trim();
    }

    public String getCoopinstiid() {
        return coopinstiid;
    }

    public void setCoopinstiid(String coopinstiid) {
        this.coopinstiid = coopinstiid == null ? null : coopinstiid.trim();
    }
}