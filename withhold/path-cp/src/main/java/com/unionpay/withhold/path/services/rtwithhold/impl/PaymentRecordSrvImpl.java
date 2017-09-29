package com.unionpay.withhold.path.services.rtwithhold.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.path.constants.bean.RTWithholdSerNumBean;
import com.unionpay.withhold.path.model.ChnlCpdkLog;
import com.unionpay.withhold.path.services.rtwithhold.PaymentRecordSrv;

@Service("paymentRecordSrv")
public class PaymentRecordSrvImpl implements PaymentRecordSrv {

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ChnlCpdkLog createPaymentRec(RTWithholdSerNumBean trWithholdSerNumBean) {
        // TODO mxw
        return null;
    }

    @Override
    @Transactional
    public void updateTxnPaymentRec(ChnlCpdkLog chnlCpdkLog) {
        // TODO Auto-generated method stub
        
    }

}
