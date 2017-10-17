package com.unionpay.withhold.admin.pojo;

public class TCardBin extends TCardBinKey {
	private String bankname;
	private String oldcardbin;
	private Short oldcardlen;
	
    public String getOldcardbin() {
		return oldcardbin;
	}
	public void setOldcardbin(String oldcardbin) {
		this.oldcardbin = oldcardbin;
	}
	public Short getOldcardlen() {
		return oldcardlen;
	}

	public void setOldcardlen(Short oldcardlen) {
		this.oldcardlen = oldcardlen;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	private Short binlen;

    private String cardname;

    private String bankcode;

    private Short type;

    public Short getBinlen() {
        return binlen;
    }

    public void setBinlen(Short binlen) {
        this.binlen = binlen;
    }

    public String getCardname() {
        return cardname;
    }

    public void setCardname(String cardname) {
        this.cardname = cardname == null ? null : cardname.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }
}