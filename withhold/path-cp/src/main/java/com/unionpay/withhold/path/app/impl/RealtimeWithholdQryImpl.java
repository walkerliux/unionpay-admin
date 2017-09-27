package com.unionpay.withhold.path.app.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.path.services.RealtimeWithholdQrySrv;
import com.unionpay.withhold.service.path.cp.app.CPRealtimeWithholdQry;

@Service("realtimeWithholdQry")
public class RealtimeWithholdQryImpl implements CPRealtimeWithholdQry {

    private final static Logger logger = LoggerFactory.getLogger(RealtimeWithholdQryImpl.class);
    @Resource
    private RealtimeWithholdQrySrv realtimeWithholdQrySrv;

    @Override
    public ResultBean qryRTWthdRecord(String txnseqno) {
        logger.info("================【txnseqno】：" + txnseqno);
        return realtimeWithholdQrySrv.qryRTWthdRecord(txnseqno);
    }

}
