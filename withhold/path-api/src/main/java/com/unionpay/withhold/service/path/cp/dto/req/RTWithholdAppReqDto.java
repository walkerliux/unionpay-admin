package com.unionpay.withhold.service.path.cp.dto.req;

import java.io.Serializable;

/**
 * 实时代扣请求参数
 * 
 * @author AlanMa
 *
 */
public class RTWithholdAppReqDto implements Serializable {

    private static final long serialVersionUID = 7981006630870396466L;

    /**
     * 交易序列号
     */
    private String txnSeq;

    public RTWithholdAppReqDto() {
        super();
    }

    public RTWithholdAppReqDto(String txnSeq) {
        super();
        this.txnSeq = txnSeq;
    }

    public String getTxnSeq() {
        return txnSeq;
    }

    public void setTxnSeq(String txnSeq) {
        this.txnSeq = txnSeq;

    }

    @Override
    public String toString() {
        return "RTWithholdAppReqDto [txnSeq=" + txnSeq + "]";
    }
}