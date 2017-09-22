package com.unionpay.withhold.admin.pojo;

public class TProvince {
    private Long pId;

    private String pName;

    private String pCode;

    private String xzCode;

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode == null ? null : pCode.trim();
    }

    public String getXzCode() {
        return xzCode;
    }

    public void setXzCode(String xzCode) {
        this.xzCode = xzCode == null ? null : xzCode.trim();
    }
}