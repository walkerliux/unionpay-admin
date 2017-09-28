package com.unionpay.withhold.api.common.enums;

/**
 * 批量交易类型
 * @author: 张世栋
 * @date: 2017年9月25日15:47:46
 * @version 1.0
 */
public enum BatchTxnTypeEnum {

	// 批量代收
	collect("01", "00","batchCollectService"),
	// 批量代付
	pay("02", "00","batchPayService"),
	// 交易查询
	query("03", "00","batchQueryService"),
	;
	private String txnType; // 交易类型
	private String txnSubType; // 交易子类型
	private String className;//对应的业务方法

	private BatchTxnTypeEnum(String txnType, String txnSubType,String className) {
		this.txnType = txnType;
		this.txnSubType = txnSubType;
		this.className=className;
	}

	public String getTxnType() {
		return txnType;
	}

	public String getTxnSubType() {
		return txnSubType;
	}
	public String getClassName() {
		return className;
	}
	
	 // 普通方法  
    public static BatchTxnTypeEnum getTxnTypeEnum(String txnType) {  
        for (BatchTxnTypeEnum txnTypeEnum : BatchTxnTypeEnum.values()) {  
            if (txnTypeEnum.getTxnType().equals(txnType)) {  
                return txnTypeEnum;  
            }  
        }  
        return null;  
    }  
	
	
}
