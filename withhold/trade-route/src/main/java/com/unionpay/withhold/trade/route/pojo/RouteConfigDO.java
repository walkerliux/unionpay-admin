package com.unionpay.withhold.trade.route.pojo;

import java.util.Date;

public class RouteConfigDO {
    private Integer rid;

    private Long routid;

    private String routver;

    private String stime;

    private String etime;

    private Long minamt;

    private Long maxamt;

    private String bankcode;

    private String busicode;

    private String cardtype;

    private String chnlcode;

    private String status;

    private Date intime;

    private Long inuser;

    private Date uptime;

    private Long upuser;

    private Long orders;

    private String isdef;

    private String tradeele;

    private String notes;

    private String remarks;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Long getRoutid() {
        return routid;
    }

    public void setRoutid(Long routid) {
        this.routid = routid;
    }

    public String getRoutver() {
        return routver;
    }

    public void setRoutver(String routver) {
        this.routver = routver == null ? null : routver.trim();
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime == null ? null : stime.trim();
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime == null ? null : etime.trim();
    }

    public Long getMinamt() {
        return minamt;
    }

    public void setMinamt(Long minamt) {
        this.minamt = minamt;
    }

    public Long getMaxamt() {
        return maxamt;
    }

    public void setMaxamt(Long maxamt) {
        this.maxamt = maxamt;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode == null ? null : busicode.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getChnlcode() {
        return chnlcode;
    }

    public void setChnlcode(String chnlcode) {
        this.chnlcode = chnlcode == null ? null : chnlcode.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Long getInuser() {
        return inuser;
    }

    public void setInuser(Long inuser) {
        this.inuser = inuser;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public Long getUpuser() {
        return upuser;
    }

    public void setUpuser(Long upuser) {
        this.upuser = upuser;
    }

    public Long getOrders() {
        return orders;
    }

    public void setOrders(Long orders) {
        this.orders = orders;
    }

    public String getIsdef() {
        return isdef;
    }

    public void setIsdef(String isdef) {
        this.isdef = isdef == null ? null : isdef.trim();
    }

    public String getTradeele() {
        return tradeele;
    }

    public void setTradeele(String tradeele) {
        this.tradeele = tradeele == null ? null : tradeele.trim();
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