package com.unionpay.withhold.admin.enums;

public enum CardTypeEnums {
	/**卡类型1借记,2贷记,3准贷记,4预付费**/
	debit("1"), 
	credit("2"),
	precredit("3"),
	beforepay("4"),
	;
	;
	private String code;

	private CardTypeEnums(String code) {
		this.code = code;
	}

	public static CardTypeEnums fromValue(String value) {
		for (CardTypeEnums status : values()) {
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
