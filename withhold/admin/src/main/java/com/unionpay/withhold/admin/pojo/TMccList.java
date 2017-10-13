package com.unionpay.withhold.admin.pojo;

public class TMccList {
    private String mcclist;

    private String mcccont;

    private String mcctype;

    private String mcctrade;

    private String industry;

    private String mccclass;

    private String mcc;

    private String status;

    public String getMcclist() {
        return mcclist;
    }

    public void setMcclist(String mcclist) {
        this.mcclist = mcclist == null ? null : mcclist.trim();
    }

    public String getMcccont() {
        return mcccont;
    }

    public void setMcccont(String mcccont) {
        this.mcccont = mcccont == null ? null : mcccont.trim();
    }

    public String getMcctype() {
        return mcctype;
    }

    public void setMcctype(String mcctype) {
        this.mcctype = mcctype == null ? null : mcctype.trim();
    }

    public String getMcctrade() {
        return mcctrade;
    }

    public void setMcctrade(String mcctrade) {
        this.mcctrade = mcctrade == null ? null : mcctrade.trim();
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getMccclass() {
        return mccclass;
    }

    public void setMccclass(String mccclass) {
        this.mccclass = mccclass == null ? null : mccclass.trim();
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc == null ? null : mcc.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}