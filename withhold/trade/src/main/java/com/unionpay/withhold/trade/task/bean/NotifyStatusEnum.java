package com.unionpay.withhold.trade.task.bean;

public enum NotifyStatusEnum {

	DOING("01"),
	FAILED("02"),
	SUCCESS("00"),
	UNKNOW("");
	private String status;
    
    private NotifyStatusEnum(String status){
        this.status = status;
    }
    
    public static NotifyStatusEnum fromValue(String value) {
        for(NotifyStatusEnum enums:values()){
            if(enums.status.equals(value)){
                return enums;
            }
        }
        return UNKNOW;
    }
    
    public String value(){
        return status;
    }
}
