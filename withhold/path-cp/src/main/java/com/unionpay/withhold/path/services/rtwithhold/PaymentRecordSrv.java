package com.unionpay.withhold.path.services.rtwithhold;

import com.unionpay.withhold.path.constants.bean.RTWithholdSerNumBean;
import com.unionpay.withhold.path.model.ChnlCpdkLog;

/**
 * 支付流水相关服务
 * 
 * @author AlanMa
 *
 */
public interface PaymentRecordSrv {

    /**
     * 创建支付通道流水记录
     * @param trWithholdSerNumBean
     * @return
     */
    public ChnlCpdkLog createPaymentRec(RTWithholdSerNumBean trWithholdSerNumBean);

    /**
     * 更新核心流水支付信息
     * @param chnlCpdkLog
     */
    public void updateTxnPaymentRec(ChnlCpdkLog chnlCpdkLog);
    
}
