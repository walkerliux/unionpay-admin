package com.unionpay.withhold.admin.pojo;

public class TMccDesc {
    private String mcc;

    private String mccname;

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc == null ? null : mcc.trim();
    }

    public String getMccname() {
        return mccname;
    }

    public void setMccname(String mccname) {
        this.mccname = mccname == null ? null : mccname.trim();
    }
}