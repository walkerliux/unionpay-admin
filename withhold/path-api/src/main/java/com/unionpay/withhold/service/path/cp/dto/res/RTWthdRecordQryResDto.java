package com.unionpay.withhold.service.path.cp.dto.res;

import java.io.Serializable;

public class RTWthdRecordQryResDto implements Serializable {

    private static final long serialVersionUID = -736192657776552891L;
    /**
     * 交易序列号
     */
    private String txnseqno;
    /**
     * 状态
     */
    private String status;
    
    public String getTxnseqno() {
        return txnseqno;
    }
    
    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RTWthdRecordQryResDto [txnseqno=" + txnseqno + ", status=" + status + "]";
    }
   
}
