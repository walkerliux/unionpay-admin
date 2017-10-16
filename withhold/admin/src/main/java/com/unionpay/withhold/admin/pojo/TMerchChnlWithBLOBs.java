package com.unionpay.withhold.admin.pojo;

public class TMerchChnlWithBLOBs extends TMerchChnl {
    private String pubkey;

    private String prikey;

    private String chnlpubkey;

    public String getPubkey() {
        return pubkey;
    }

    public void setPubkey(String pubkey) {
        this.pubkey = pubkey == null ? null : pubkey.trim();
    }

    public String getPrikey() {
        return prikey;
    }

    public void setPrikey(String prikey) {
        this.prikey = prikey == null ? null : prikey.trim();
    }

    public String getChnlpubkey() {
        return chnlpubkey;
    }

    public void setChnlpubkey(String chnlpubkey) {
        this.chnlpubkey = chnlpubkey == null ? null : chnlpubkey.trim();
    }
}