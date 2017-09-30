package com.unionpay.withhold.path.services.rtwithhold;

import com.unionpay.withhold.common.bean.ResultBean;

public interface RealtimeWithholdQrySrv {

    /**
     * 同步实时代扣交易状态
     * 
     * @param txnseqno
     * @return
     */
    public ResultBean qryRTWthdRecord(String txnseqno);
}
