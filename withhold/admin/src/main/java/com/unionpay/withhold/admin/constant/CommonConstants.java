package com.unionpay.withhold.admin.constant;

/**
 * 公共常量
 * @author lianhai
 *
 */
public class CommonConstants {

	// MCCList状态
	/**	MCCList状态-正常状态	 **/
	public final static String MCCLIST_STATUS_NORMAL = "1";
	/** MCCList状态-非正常状态  **/
	public final static String MCCLIST_STATUS_UNNORMAL = "0";
	
	// 商户密钥状态
	/** 商户密钥状态-正常状态 **/
	public final static String MERCH_MK_STATUS_NORMAL = "00";

	// 风控版本状态
	/** 风控版本状态-正常状态 **/
	public final static String RISK_STATUS_NORMAL = "00";
	
	// 风控版本实例的操作标识
	/** 风控版本实例的操作标识-添加 **/
	public final static String RISK_CASE_FLAG_INSERT = "i";
	/** 风控版本实例的操作标识-更新 **/
	public final static String RISK_CASE_FLAG_UPDATE = "u";
}
