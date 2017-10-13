package com.unionpay.withhold.trade.order.enums;


public enum TableEnum {
	BATCHCOLLECTIONORDER("SEQUENCE:BATCHORDER"),
	BATCHCOLLECTIONORDERDETA("SEQUENCE:BATCHORDERDETA"),
	SINGLECOLLECTIONORDER("SEQUENCE:SINGLEORDER"),
    UNKNOW("99");
    private String code;
    
    private TableEnum(String code){
        this.code = code;
    }
    
    public static TableEnum fromValue(String value) {
        for(TableEnum status:values()){
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
