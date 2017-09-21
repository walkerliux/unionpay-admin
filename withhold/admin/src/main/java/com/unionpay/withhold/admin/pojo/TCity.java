package com.unionpay.withhold.admin.pojo;

public class TCity {
    private Long cId;

    private String cName;

    private String cZcode;

    private String cPcode;

    private Long pId;

    private String cCode;

    private String xzCode;

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcZcode() {
        return cZcode;
    }

    public void setcZcode(String cZcode) {
        this.cZcode = cZcode == null ? null : cZcode.trim();
    }

    public String getcPcode() {
        return cPcode;
    }

    public void setcPcode(String cPcode) {
        this.cPcode = cPcode == null ? null : cPcode.trim();
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public String getXzCode() {
        return xzCode;
    }

    public void setXzCode(String xzCode) {
        this.xzCode = xzCode == null ? null : xzCode.trim();
    }
}