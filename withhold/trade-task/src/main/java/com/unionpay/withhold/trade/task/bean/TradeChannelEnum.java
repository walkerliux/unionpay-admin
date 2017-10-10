package com.unionpay.withhold.trade.task.bean;

public enum TradeChannelEnum {
	CHINAPAY_SINGLE("CP100001","CP"),
	CHINAPAY_BATCH("CP100002","CP"),
	EUNIONPAY_SINGLE("HYL10000001","HYL"),
	EUNIONPAY_BATCH("HYL10000002","HYL"),
	CHANPAY_SINGLE("CJ10000001","CHANPAY"),
	CHANPAY_BATCH("CJ10000002","CHANPAY"),
    UNKNOW("99","未知");
	
    private String code;
    private String type;
	
    private TradeChannelEnum(String code,String type){
        this.code = code;
        this.type = type;
    }
    
    public static TradeChannelEnum fromValue(String value) {
        for(TradeChannelEnum status:values()){
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
