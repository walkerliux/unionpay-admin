package com.unionpay.withhold.admin.enums;

public enum MerchSetlFlgEnums {
	// 清算标记0：不参加清算；1：参加清算；4：参加清算，退还原始手续费；5：参加清算，差额退还原始手续费；

	notjoin("0"),
	join("1"),
	joinreturn("4"),
	joinreturndiff("5");
	private String code;

	private MerchSetlFlgEnums(String code) {
		this.code = code;
	}

	public static MerchSetlFlgEnums fromValue(String value) {
		for (MerchSetlFlgEnums status : values()) {
			if (status.code.equals(value)) {
				return status;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}
}
