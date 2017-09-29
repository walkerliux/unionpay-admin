package com.unionpay.withhold.path.constants.enums;

public enum ErrorCodePCP {

    SIGN_FAILED("PCP001", "报文体加签失败"), 
    NONE_RECORD("PCP002", "交易流水号无对应实时代收/代付记录"), 
    REPEAT_REQUEST("PCP003", "交易重复，拒绝本次请求"), 
    INTERRUPT_EXP("PCP004", "线程异常中断"), 
    NONE_MAIN_REC("PCP005", "交易流水号无对应主流水记录"), 
    UNKNOWN_BT("PCP006", "未知业务类型（非实时代收付）"), 
    NONE_PAY_ORDER("PCP007", "实时代收付订单信息缺失"),
    NONE_PAY_LOG("PCP008", "实时代收付主流水信息缺失"),
    REPEAT_RESP("PCP009", "回执信息重复，拒绝本次请求"), 
    ORDER_STS_WRONG("PCP010", "实时代收/代付订单状态非法"),
    CHL_SER_STS_WR("PCP011", "核心交易流水状态非法"),
    RSP_NOT_MATCH("PCP012", "业务应答与原交易记录关键信息不匹配"),
    PAR_PARSE_FAIL("PCP013", "参数转换异常"),
    CONN_FAIL("PCP014", "网络异常，无法建立连接"),
    NO_RESP("PCP015", "清算中心处理中，请稍后进行状态查询"),
    SENDER_LENG_ERROR("PCP016", "发送方机构号位数错误"),
    PRIO_LENG_ERROR("PCP017", "业务种类代码位数错误"),
    MISS_CONTRACT("PCP018", "合同信息缺失"),
    SEND_FAILED("PCP019", "发送报文至杭州清算中心失败"), 
    ;

    private String value;
    private final String displayName;

    ErrorCodePCP(String value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static ErrorCodePCP parseOf(String value) {

        for (ErrorCodePCP item : values())
            if (item.getValue().equals(value))
                return item;

        return null;
    }

     public static void main(String[] args) {
         System.out.println(ErrorCodePCP.SIGN_FAILED.getDisplayName());
         System.out.println(ErrorCodePCP.SIGN_FAILED.getValue());
         System.out.println(parseOf(ErrorCodePCP.SIGN_FAILED.getValue()).getDisplayName());
         System.out.print(ErrorCodePCP.SIGN_FAILED);
     }
}
