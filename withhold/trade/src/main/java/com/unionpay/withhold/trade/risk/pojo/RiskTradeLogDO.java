package com.unionpay.withhold.trade.risk.pojo;

public class RiskTradeLogDO {
    private Integer tid;

    private Integer riskTradeType;

    private String txnseqno;

    private String orderno;

    private String merchno;

    private String merchname;

    private String cacode;

    private String caname;

    private String chnlcode;

    private String chnlname;

    private Long amount;

    private String pan;

    private Integer tradeRiskLevel;

    private String cardIssuerCode;

    private String cardIssuerName;

    private String acqdatetime;

    private String busicode;

    private String busitype;

    private String resinfo;

    private String rescode;

    private String strategy;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getRiskTradeType() {
        return riskTradeType;
    }

    public void setRiskTradeType(Integer riskTradeType) {
        this.riskTradeType = riskTradeType;
    }

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno == null ? null : txnseqno.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getMerchno() {
        return merchno;
    }

    public void setMerchno(String merchno) {
        this.merchno = merchno == null ? null : merchno.trim();
    }

    public String getMerchname() {
        return merchname;
    }

    public void setMerchname(String merchname) {
        this.merchname = merchname == null ? null : merchname.trim();
    }

    public String getCacode() {
        return cacode;
    }

    public void setCacode(String cacode) {
        this.cacode = cacode == null ? null : cacode.trim();
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname == null ? null : caname.trim();
    }

    public String getChnlcode() {
        return chnlcode;
    }

    public void setChnlcode(String chnlcode) {
        this.chnlcode = chnlcode == null ? null : chnlcode.trim();
    }

    public String getChnlname() {
        return chnlname;
    }

    public void setChnlname(String chnlname) {
        this.chnlname = chnlname == null ? null : chnlname.trim();
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

    public Integer getTradeRiskLevel() {
        return tradeRiskLevel;
    }

    public void setTradeRiskLevel(Integer tradeRiskLevel) {
        this.tradeRiskLevel = tradeRiskLevel;
    }

    public String getCardIssuerCode() {
        return cardIssuerCode;
    }

    public void setCardIssuerCode(String cardIssuerCode) {
        this.cardIssuerCode = cardIssuerCode == null ? null : cardIssuerCode.trim();
    }

    public String getCardIssuerName() {
        return cardIssuerName;
    }

    public void setCardIssuerName(String cardIssuerName) {
        this.cardIssuerName = cardIssuerName == null ? null : cardIssuerName.trim();
    }

    public String getAcqdatetime() {
        return acqdatetime;
    }

    public void setAcqdatetime(String acqdatetime) {
        this.acqdatetime = acqdatetime == null ? null : acqdatetime.trim();
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode == null ? null : busicode.trim();
    }

    public String getBusitype() {
        return busitype;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype == null ? null : busitype.trim();
    }

    public String getResinfo() {
        return resinfo;
    }

    public void setResinfo(String resinfo) {
        this.resinfo = resinfo == null ? null : resinfo.trim();
    }

    public String getRescode() {
        return rescode;
    }

    public void setRescode(String rescode) {
        this.rescode = rescode == null ? null : rescode.trim();
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy == null ? null : strategy.trim();
    }
}