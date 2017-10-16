package com.unionpay.withhold.admin.pojo;

public class TCardBinKey {
    private String cardbin;

    private Short cardlen;

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
}