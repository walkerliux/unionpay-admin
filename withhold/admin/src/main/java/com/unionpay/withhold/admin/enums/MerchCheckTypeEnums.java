package com.unionpay.withhold.admin.enums;

public enum MerchCheckTypeEnums {
	/**type:1现有的对账**/
	CP("CP100001","1"), 
	HYL("HYL10001","1"),
	;
	private String code;
	private String type;//对账方式
	private MerchCheckTypeEnums(String code,String type) {
		this.code = code;
		this.type=type;
	}

	public static MerchCheckTypeEnums fromValue(String value) {
		for (MerchCheckTypeEnums status : values()) {
			if (status.code.equals(value)) {
				return status;
			}
		}
		return null;
	}
	
	public static boolean exist(String value,String type) {
		for (MerchCheckTypeEnums status : values()) {
			if (status.code.equals(value) && status.type.equals(type)) {
				return true;
			}
		}
		return false;
	}
	public String getCode() {
		return code;
	}
}
