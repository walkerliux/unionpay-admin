package com.unionpay.withhold.admin.pojo;

public class TCphpNotice {
    private String tid;

    private String responsecode;

    private String message;

    private String merid;

    private String orfilename;

    private String filename;

    private String intime;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid == null ? null : tid.trim();
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

    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid == null ? null : merid.trim();
    }

    public String getOrfilename() {
        return orfilename;
    }

    public void setOrfilename(String orfilename) {
        this.orfilename = orfilename == null ? null : orfilename.trim();
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime == null ? null : intime.trim();
    }
}