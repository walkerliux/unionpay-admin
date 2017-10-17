package com.unionpay.withhold.trade.order.enums;

public enum ChnlTypeEnum {

	TRADECORE("TC"), 
	TRADEORDER("TO"),
	CHINAPAY("CP"), 
	EUNIONPAY("HYL"), 
	CHANPAY("CJ"), 
	UNKNOW("99");
	private String code;

	private ChnlTypeEnum(String code) {
		this.code = code;
	}

	public static ChnlTypeEnum fromValue(String value) {
		for (ChnlTypeEnum status : values()) {
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
