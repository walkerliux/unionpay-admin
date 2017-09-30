package com.unionpay.withhold.path.services.rtwithhold.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.path.app.impl.CPRealtimeWithholdQryImpl;
import com.unionpay.withhold.path.dao.TxnsLogMapper;
import com.unionpay.withhold.path.model.TxnsLog;
import com.unionpay.withhold.path.services.rtwithhold.RealtimeWithholdQrySrv;

@Service("realtimeWithholdQrySrv")
public class RealtimeWithholdQrySrvImpl implements RealtimeWithholdQrySrv {

    private final static Logger logger = LoggerFactory.getLogger(CPRealtimeWithholdQryImpl.class);

    @Resource
    private TxnsLogMapper txnsLogMapper;

    @Override
    public ResultBean qryRTWthdRecord(String txnseqno) {
        logger.info("~~~~~~【RealtimeWithholdQrySrv txnseqno】：" + txnseqno);
        TxnsLog log = txnsLogMapper.selectByPrimaryKey(txnseqno);
        logger.info("【qry result is 】：" + JSONObject.toJSONString(log));
        ResultBean rb = new ResultBean(JSONObject.toJSONString(log));
        return rb;
    }

}
