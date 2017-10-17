package com.unionpay.withhold.path.services.assmsg.impl;

import org.springframework.stereotype.Service;

import com.unionpay.withhold.path.constants.bean.RTWithholdSerNumBean;
import com.unionpay.withhold.path.services.assmsg.MessageAssemble;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;

@Service("messageAssemble")
public class MessageAssembleImpl implements MessageAssemble {

    @Override
    public RTWithholdSerNumBean assembleRTWithhold(RTWithholdAppReqDto rtWithholdAppReqDto) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public byte[] sign(RTWithholdSerNumBean trWithholdSerNumBean) {
        // TODO Auto-generated method stub
        return null;
    }

}
