package com.unionpay.withhold.admin.pojo;

public class TTxnsNotifyTask {
    private Long id;

    private String memberId;

    private String txnseqno;

    private Short sendTimes;

    private Short maxSendTimes;

    private String data;

    private String sendStatus;

    private String httpRescode;

    private String notifyUrl;

    private String taskType;

    private String tardeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId == null ? null : memberId.trim();
    }

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno == null ? null : txnseqno.trim();
    }

    public Short getSendTimes() {
        return sendTimes;
    }

    public void setSendTimes(Short sendTimes) {
        this.sendTimes = sendTimes;
    }

    public Short getMaxSendTimes() {
        return maxSendTimes;
    }

    public void setMaxSendTimes(Short maxSendTimes) {
        this.maxSendTimes = maxSendTimes;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public String getSendStatus() {
        return sendStatus;
    }

    public void setSendStatus(String sendStatus) {
        this.sendStatus = sendStatus == null ? null : sendStatus.trim();
    }

    public String getHttpRescode() {
        return httpRescode;
    }

    public void setHttpRescode(String httpRescode) {
        this.httpRescode = httpRescode == null ? null : httpRescode.trim();
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl == null ? null : notifyUrl.trim();
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType == null ? null : taskType.trim();
    }

    public String getTardeType() {
        return tardeType;
    }

    public void setTardeType(String tardeType) {
        this.tardeType = tardeType == null ? null : tardeType.trim();
    }
}