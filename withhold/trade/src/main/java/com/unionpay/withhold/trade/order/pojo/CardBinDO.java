package com.unionpay.withhold.trade.order.pojo;

public class CardBinDO {
    private String cardbin;

    private Short cardlen;

    private Short binlen;

    private String cardname;

    private String bankcode;

    private Short type;

    private String bankname;
    
    public String getCardbin() {
        return cardbin;
    }

    public void setCardbin(String cardbin) {
        this.cardbin = cardbin == null ? null : cardbin.trim();
    }

    public Short getCardlen() {
        return cardlen;
    }

    public void setCardlen(Short cardlen) {
        this.cardlen = cardlen;
    }

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

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}
    
    
}