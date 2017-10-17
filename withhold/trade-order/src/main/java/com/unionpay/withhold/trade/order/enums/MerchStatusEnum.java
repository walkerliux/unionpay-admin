package com.unionpay.withhold.trade.order.enums;

public enum MerchStatusEnum {

	NORMAL("00"),//正常，在用
    UNKNOW("99");//未知
    private String code;
    
    private MerchStatusEnum(String code){
        this.code = code;
    }
    
    public static MerchStatusEnum fromValue(String value) {
        for(MerchStatusEnum status:values()){
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
