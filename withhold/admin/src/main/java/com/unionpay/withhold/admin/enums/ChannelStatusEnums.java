package com.unionpay.withhold.admin.enums;

public enum ChannelStatusEnums {
	/**在用**/
	NORMAL("00"), 
	/**禁用**/
	FORBIDDEN("01");
	private String code;

	private ChannelStatusEnums(String code) {
		this.code = code;
	}

	public static ChannelStatusEnums fromValue(String value) {
		for (ChannelStatusEnums status : values()) {
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
