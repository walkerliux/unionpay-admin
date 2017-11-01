package com.unionpay.withhold.admin.pojo;

import java.util.List;

public class TMerchChnlWithBLOBs extends TMerchChnl {
    private String pubkey;

    private String prikey;

    private String chnlpubkey;
    
    private  List<TMerchChnlWithBLOBs> ardList;
    
    
    public List<TMerchChnlWithBLOBs> getArdList() {
		return ardList;
	}

	public void setArdList(List<TMerchChnlWithBLOBs> ardList) {
		this.ardList = ardList;
	}

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