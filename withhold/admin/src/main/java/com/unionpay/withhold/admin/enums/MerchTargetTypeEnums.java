package com.unionpay.withhold.admin.enums;

public enum MerchTargetTypeEnums {
	// 1：商户，2：代理商，3：通道
	/** 商户 **/
	MERCH("1"),
	/** 代理商 **/
	COOPAGENCY("2"),
	/** 通道 **/
	CHANNEL("3"),
	/** 未知 **/
	UNKNOW("9");
	private String code;

	private MerchTargetTypeEnums(String code) {
		this.code = code;
	}

	public static MerchTargetTypeEnums fromValue(String value) {
		for (MerchTargetTypeEnums status : values()) {
			if (status.code.equals(value)) {
				return status;
			}
		}
		return UNKNOW;
	}

	public String getCode() {
		return code;
	}
}
