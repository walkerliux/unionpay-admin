package com.unionpay.withhold.path.services.assmsg;

import com.unionpay.withhold.path.constants.bean.RTWithholdSerNumBean;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;

/**
 * 报文组装接口 1.生成报文头 2.生成数字签名域 3.组装报文
 * 
 * @author alanma
 * @version
 * @date 2017年2月23日 下午5:54:29
 * @since
 */
public interface MessageAssemble {

    /**
     * 组装实时代扣报文
     * 
     * @param rtWithholdAppReqDto
     * @return
     */
    public RTWithholdSerNumBean assembleRTWithhold(RTWithholdAppReqDto rtWithholdAppReqDto);

    /**
     * 签名报文域
     * @param trWithholdSerNumBean
     * @return
     */
    public byte[] sign(RTWithholdSerNumBean trWithholdSerNumBean);
}
