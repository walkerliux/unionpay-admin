package com.unionpay.withhold.trade.order.enums;

public enum OrderStatusEnum {
	/**
	 * 01:初始，订单提交成功，但未支付；02：支付中；03：支付失败；00：支付成功，04：订单失效)
	 */
	INITIAL("01"),
	PAYING("02"),
	FAILED("03"),
	EXPIRE("04"),
	FINISH("00"),
    UNKNOW("99");//未知
    private String code;
    
    private OrderStatusEnum(String code){
        this.code = code;
    }
    
    public static OrderStatusEnum fromValue(String value) {
        for(OrderStatusEnum status:values()){
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
