package com.unionpay.withhold.admin.pojo;

public class TBank {
    private Integer tid;

    private String bankcode;

    private String bankname;

    private String pbcBankcode;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getPbcBankcode() {
        return pbcBankcode;
    }

    public void setPbcBankcode(String pbcBankcode) {
        this.pbcBankcode = pbcBankcode == null ? null : pbcBankcode.trim();
    }
    private String oldbankcode;

	public String getOldbankcode() {
		return oldbankcode;
	}

	public void setOldbankcode(String oldbankcode) {
		this.oldbankcode = oldbankcode;
	}
    
}