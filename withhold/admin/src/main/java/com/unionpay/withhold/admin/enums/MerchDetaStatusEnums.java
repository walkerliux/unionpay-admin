package com.unionpay.withhold.admin.enums;

public enum MerchDetaStatusEnums {
	// 状态:00在用 09注册审核前被修改 10注册待审 11 注册审核拒绝 20 修改待审 21 修改审核拒绝 30注销待审 31注销审核拒绝
	// 99注销
	/**在用**/
	NORMAL("00"), 
	///**注册审核前被修改**/
	//UPDATEBEFORECHECKING("09"),
	/**注册待审**/
	REGISTERCHECKING("10"),
	/**注册审核拒绝**/
	REGISTERCHECKREFUSED("11"),
	/**修改待审**/
	UPDATEAFTERCHECKED("20"),
	/**修改审核拒绝**/
	UPDATEAFTERCHECKEDREFUSED("21"),
	/**注销审核**/
	LOGOUTCHECKING("30"),
	/**注销审核拒绝**/
	LOGOUTCHECKREFUSED("31"),
	/**不在用**/
	UNNORMAL("99"),
	UNKNOW("99");
	private String code;

	private MerchDetaStatusEnums(String code) {
		this.code = code;
	}

	public static MerchDetaStatusEnums fromValue(String value) {
		for (MerchDetaStatusEnums status : values()) {
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
