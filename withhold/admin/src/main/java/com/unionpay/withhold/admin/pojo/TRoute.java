package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TRoute {
    private Integer routid;

    private String routver;

    private String routname;

    private Short status;

    private Date intime;

    private Long inuser;

    private Date uptime;

    private Long upuser;

    private String notes;

    private String remarks;

    public Integer getRoutid() {
        return routid;
    }

    public void setRoutid(Integer routid) {
        this.routid = routid;
    }

    public String getRoutver() {
        return routver;
    }

    public void setRoutver(String routver) {
        this.routver = routver == null ? null : routver.trim();
    }

    public String getRoutname() {
        return routname;
    }

    public void setRoutname(String routname) {
        this.routname = routname == null ? null : routname.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
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