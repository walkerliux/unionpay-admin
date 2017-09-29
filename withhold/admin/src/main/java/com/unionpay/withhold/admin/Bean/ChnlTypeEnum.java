package com.unionpay.withhold.admin.Bean;

public enum ChnlTypeEnum {

	TRADECORE("TC","交易核心"),
	TRADEORDER("TO","交易订单"),
	CHINAPAY("CP","ChinaPay"),
	EUNIONPAY("HYL","好易联"),
	CHANPAY("CJ","畅捷"),
    UNKNOW("99","未知");
	
    private String code;
    private String name;
	private static ChnlTypeEnum fromValue;
    
    private ChnlTypeEnum(String code,String name){
        this.code = code;
        this.name = name;
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

	public String getName() {
		return name;
	}
	
	public static void main(String[] args) {
		System.out.println(ChnlTypeEnum.fromValue("CJ").getName());
	}
    
    
}
