package com.unionpay.withhold.trade.pay.enums;

public enum BusinessEnum {

	/**
     *  (消费类：1000；充值类：2000；提现类：3000；退款类：4000；转账类：5000；保障金：6000;代付类:7000)
     */
    SINGLECOLLECT("1000","10000001"),
    BATCHCOLLECT("1000","10000002"),
    UNKNOW("9999","99");
	private String type;
    private String code;
    
    private BusinessEnum(String type,String code){
    	this.type = type;
        this.code = code;
    }
    
    public static BusinessEnum fromValue(String value) {
        for(BusinessEnum status:values()){
            if(status.code.equals(value)){
                return status;
            }
        }
        return UNKNOW;
    }
    
    public String getCode(){
        return code;
    }
    
    public String getType() {
    	return type;
    }
}
