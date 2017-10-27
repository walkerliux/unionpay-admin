package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TCheckfileMistake {
    private Integer iid;

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

    private String result;

    private String mistatus;

    private Short mistakeTradeSource;

    private String datasource;

    private String mistakedesc;

    private Long accepterId;

    private Date acceptDate;

    private Short acceptResult;

    private String acceptOpinion;

    private Date dealEndDate;

    private Long dealOperatorId;

    private Date dealDate;

    private Short dealResult;

    private String dealOpinion;

    private Long visitOperatorId;

    private Date visitDate;

    private Short visitResult;

    private String visitOpinion;

    private String notes;

    private String remarks;

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getMistatus() {
        return mistatus;
    }

    public void setMistatus(String mistatus) {
        this.mistatus = mistatus == null ? null : mistatus.trim();
    }

    public Short getMistakeTradeSource() {
        return mistakeTradeSource;
    }

    public void setMistakeTradeSource(Short mistakeTradeSource) {
        this.mistakeTradeSource = mistakeTradeSource;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource == null ? null : datasource.trim();
    }

    public String getMistakedesc() {
        return mistakedesc;
    }

    public void setMistakedesc(String mistakedesc) {
        this.mistakedesc = mistakedesc == null ? null : mistakedesc.trim();
    }

    public Long getAccepterId() {
        return accepterId;
    }

    public void setAccepterId(Long accepterId) {
        this.accepterId = accepterId;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Short getAcceptResult() {
        return acceptResult;
    }

    public void setAcceptResult(Short acceptResult) {
        this.acceptResult = acceptResult;
    }

    public String getAcceptOpinion() {
        return acceptOpinion;
    }

    public void setAcceptOpinion(String acceptOpinion) {
        this.acceptOpinion = acceptOpinion == null ? null : acceptOpinion.trim();
    }

    public Date getDealEndDate() {
        return dealEndDate;
    }

    public void setDealEndDate(Date dealEndDate) {
        this.dealEndDate = dealEndDate;
    }

    public Long getDealOperatorId() {
        return dealOperatorId;
    }

    public void setDealOperatorId(Long dealOperatorId) {
        this.dealOperatorId = dealOperatorId;
    }

    public Date getDealDate() {
        return dealDate;
    }

    public void setDealDate(Date dealDate) {
        this.dealDate = dealDate;
    }

    public Short getDealResult() {
        return dealResult;
    }

    public void setDealResult(Short dealResult) {
        this.dealResult = dealResult;
    }

    public String getDealOpinion() {
        return dealOpinion;
    }

    public void setDealOpinion(String dealOpinion) {
        this.dealOpinion = dealOpinion == null ? null : dealOpinion.trim();
    }

    public Long getVisitOperatorId() {
        return visitOperatorId;
    }

    public void setVisitOperatorId(Long visitOperatorId) {
        this.visitOperatorId = visitOperatorId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Short getVisitResult() {
        return visitResult;
    }

    public void setVisitResult(Short visitResult) {
        this.visitResult = visitResult;
    }

    public String getVisitOpinion() {
        return visitOpinion;
    }

    public void setVisitOpinion(String visitOpinion) {
        this.visitOpinion = visitOpinion == null ? null : visitOpinion.trim();
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