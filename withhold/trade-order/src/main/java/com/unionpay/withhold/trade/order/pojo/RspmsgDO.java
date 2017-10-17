package com.unionpay.withhold.trade.order.pojo;

public class RspmsgDO {
    private Integer rspid;

    private String apicode;

    private String apiinfo;

    private String retcode;

    private String rspinfo;

    private String chnltype;

    private String chnlrspcode;

    private String reason;

    private String notes;

    public Integer getRspid() {
        return rspid;
    }

    public void setRspid(Integer rspid) {
        this.rspid = rspid;
    }

    public String getApicode() {
        return apicode;
    }

    public void setApicode(String apicode) {
        this.apicode = apicode == null ? null : apicode.trim();
    }

    public String getApiinfo() {
        return apiinfo;
    }

    public void setApiinfo(String apiinfo) {
        this.apiinfo = apiinfo == null ? null : apiinfo.trim();
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    public String getRspinfo() {
        return rspinfo;
    }

    public void setRspinfo(String rspinfo) {
        this.rspinfo = rspinfo == null ? null : rspinfo.trim();
    }

    public String getChnltype() {
        return chnltype;
    }

    public void setChnltype(String chnltype) {
        this.chnltype = chnltype == null ? null : chnltype.trim();
    }

    public String getChnlrspcode() {
        return chnlrspcode;
    }

    public void setChnlrspcode(String chnlrspcode) {
        this.chnlrspcode = chnlrspcode == null ? null : chnlrspcode.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }
}