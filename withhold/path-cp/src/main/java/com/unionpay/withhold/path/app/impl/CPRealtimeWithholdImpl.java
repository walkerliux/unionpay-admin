package com.unionpay.withhold.path.app.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.path.services.rtwithhold.RealtimeWithholdSrv;
import com.unionpay.withhold.service.path.cp.app.CPRealtimeWithhold;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;

@Service("realtimeWithholdQry")
public class CPRealtimeWithholdImpl implements CPRealtimeWithhold {

    private final static Logger logger = LoggerFactory.getLogger(CPRealtimeWithholdImpl.class);
    
    @Resource
    private RealtimeWithholdSrv realtimeWithholdSrv;

    @Override
    public ResultBean applyRealtimeWithhold(RTWithholdAppReqDto rtWithholdAppReqDto) {
        return realtimeWithholdSrv.applyRTWithhold(rtWithholdAppReqDto);
    }

}
