package com.unionpay.withhold.trade.pay.enums;

public enum ChnlTypeEnum {

	TRADECORE("TC"),
	TRADEORDER("TO"),
    UNKNOW("99");
    private String code;
    
    private ChnlTypeEnum(String code){
        this.code = code;
    }
    
    public static ChnlTypeEnum fromValue(String value) {
        for(ChnlTypeEnum status:values()){
            if(status.code.equals(value)){
                return status;
            }
        }
        return UNKNOW;
    }
    
    public String getCode(){
        return code;
    }
}
