package com.unionpay.withhold.path.app.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.path.services.rtwithhold.RealtimeWithholdQrySrv;
import com.unionpay.withhold.service.path.cp.app.CPRealtimeWithholdQry;

@Service("realtimeWithholdQry")
public class CPRealtimeWithholdQryImpl implements CPRealtimeWithholdQry {

    private final static Logger logger = LoggerFactory.getLogger(CPRealtimeWithholdQryImpl.class);
    @Resource
    private RealtimeWithholdQrySrv realtimeWithholdQrySrv;

    @Override
    public ResultBean qryRTWthdRecord(String txnseqno) {
        logger.info("================【txnseqno】：" + txnseqno);
        return realtimeWithholdQrySrv.qryRTWthdRecord(txnseqno);
    }

}
