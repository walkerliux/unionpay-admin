package com.unionpay.withhold.trade.task.bean;

public enum ChannelEnum {
	CHINAPAY("1000001","CP"),
	UNKNOW("99","99");

	private String code;
	private String chnlType;

	private ChannelEnum(String code,String chnlType) {
		this.code = code;
		this.chnlType = chnlType;
	}

	public static ChannelEnum fromValue(String value) {
		for (ChannelEnum enums : values()) {
			if (enums.code.equals(value)) {
				return enums;
			}
		}
		return UNKNOW;
	}

	public String getCode() {
		return code;
	}

	public String getChnlType() {
		return chnlType;
	}

	
}
