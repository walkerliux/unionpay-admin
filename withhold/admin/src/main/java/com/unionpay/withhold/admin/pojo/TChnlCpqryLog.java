package com.unionpay.withhold.admin.pojo;

public class TChnlCpqryLog {
    private String tid;

    private String merid;

    private String transtype;

    private String orderno;

    private String transdate;

    private String version;

    private String priv1;

    private String responsecode;

    private String transamt;

    private String curyid;

    private String transstat;

    private String chnlretdate;

    private String message;

    private String intime;

    private String uptime;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
    }

    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid == null ? null : merid.trim();
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype == null ? null : transtype.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate == null ? null : transdate.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
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

    public String getTransamt() {
        return transamt;
    }

    public void setTransamt(String transamt) {
        this.transamt = transamt == null ? null : transamt.trim();
    }

    public String getCuryid() {
        return curyid;
    }

    public void setCuryid(String curyid) {
        this.curyid = curyid == null ? null : curyid.trim();
    }

    public String getTransstat() {
        return transstat;
    }

    public void setTransstat(String transstat) {
        this.transstat = transstat == null ? null : transstat.trim();
    }

    public String getChnlretdate() {
        return chnlretdate;
    }

    public void setChnlretdate(String chnlretdate) {
        this.chnlretdate = chnlretdate == null ? null : chnlretdate.trim();
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
}