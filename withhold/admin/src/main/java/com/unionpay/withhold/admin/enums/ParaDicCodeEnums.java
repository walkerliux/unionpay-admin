package com.unionpay.withhold.admin.enums;

public enum ParaDicCodeEnums {
	/** 交易要素 **/
	TRANSFACTORS("transfactors"),
	UNKNOW("unknow");
	private String code;

	private ParaDicCodeEnums(String code) {
		this.code = code;
	}

	public static ParaDicCodeEnums fromValue(String value) {
		for (ParaDicCodeEnums status : values()) {
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
