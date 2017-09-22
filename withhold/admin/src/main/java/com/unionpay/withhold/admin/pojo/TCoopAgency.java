package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TCoopAgency {
    private Long caid;

    private String cacode;

    private String caname;

    private Long caprovince;

    private Long cacity;

    private String address;

    private String contact;

    private String contPhone;

    private String status;

    private Short calevel;

    private String supercode;

    private String riskver;

    private Long inuser;

    private Date intime;

    private Long stexaUser;

    private Date stexaTime;

    private String stexaOpt;

    private Long cvlexaUser;

    private Date cvlexaTime;

    private String cvlexaOpt;

    private String notes;

    private String remarks;

    public Long getCaid() {
        return caid;
    }

    public void setCaid(Long caid) {
        this.caid = caid;
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

    public Long getCaprovince() {
        return caprovince;
    }

    public void setCaprovince(Long caprovince) {
        this.caprovince = caprovince;
    }

    public Long getCacity() {
        return cacity;
    }

    public void setCacity(Long cacity) {
        this.cacity = cacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getContPhone() {
        return contPhone;
    }

    public void setContPhone(String contPhone) {
        this.contPhone = contPhone == null ? null : contPhone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Short getCalevel() {
        return calevel;
    }

    public void setCalevel(Short calevel) {
        this.calevel = calevel;
    }

    public String getSupercode() {
        return supercode;
    }

    public void setSupercode(String supercode) {
        this.supercode = supercode == null ? null : supercode.trim();
    }

    public String getRiskver() {
        return riskver;
    }

    public void setRiskver(String riskver) {
        this.riskver = riskver == null ? null : riskver.trim();
    }

    public Long getInuser() {
        return inuser;
    }

    public void setInuser(Long inuser) {
        this.inuser = inuser;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Long getStexaUser() {
        return stexaUser;
    }

    public void setStexaUser(Long stexaUser) {
        this.stexaUser = stexaUser;
    }

    public Date getStexaTime() {
        return stexaTime;
    }

    public void setStexaTime(Date stexaTime) {
        this.stexaTime = stexaTime;
    }

    public String getStexaOpt() {
        return stexaOpt;
    }

    public void setStexaOpt(String stexaOpt) {
        this.stexaOpt = stexaOpt == null ? null : stexaOpt.trim();
    }

    public Long getCvlexaUser() {
        return cvlexaUser;
    }

    public void setCvlexaUser(Long cvlexaUser) {
        this.cvlexaUser = cvlexaUser;
    }

    public Date getCvlexaTime() {
        return cvlexaTime;
    }

    public void setCvlexaTime(Date cvlexaTime) {
        this.cvlexaTime = cvlexaTime;
    }

    public String getCvlexaOpt() {
        return cvlexaOpt;
    }

    public void setCvlexaOpt(String cvlexaOpt) {
        this.cvlexaOpt = cvlexaOpt == null ? null : cvlexaOpt.trim();
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