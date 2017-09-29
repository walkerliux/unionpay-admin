package com.unionpay.withhold.path.exception;

import com.unionpay.withhold.path.constants.enums.ErrorCodePCP;



/**
 * ChinaPay支付通道封装的异常信息
 * 
 * @author AlanMa
 *
 */
public class CPBusException extends Exception {

    private static final long serialVersionUID = 8564355573270250157L;

    private String errCode;

    private String errMsg;

    public CPBusException() {
        super();
    }

    public CPBusException(String errCode, String errMsg) {
        super(errCode + errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public CPBusException(String errCode) {
        super(errCode + ErrorCodePCP.parseOf(errCode).getDisplayName());
        this.errCode = errCode;
        this.errMsg = ErrorCodePCP.parseOf(errCode).getDisplayName();
    }

    public CPBusException(ErrorCodePCP errorCode) {
        super(errorCode.getValue() + errorCode.getDisplayName());
        this.errCode = errorCode.getValue();
        this.errMsg = errorCode.getDisplayName();
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    @Override
    public String toString() {
        return "UnionPayException [errCode=" + errCode + ", errMsg=" + errMsg + "]";
    }

}
