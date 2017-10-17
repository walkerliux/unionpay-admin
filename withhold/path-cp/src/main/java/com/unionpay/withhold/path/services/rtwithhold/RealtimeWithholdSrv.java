package com.unionpay.withhold.path.services.rtwithhold;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.path.constants.bean.RTWithholdRespBean;
import com.unionpay.withhold.path.exception.CPBusException;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;


public interface RealtimeWithholdSrv {
    
    /**
     * 实时代扣请求
     * @param txnseqno
     * @return
     */
    public ResultBean applyRTWithhold(RTWithholdAppReqDto rtWithholdAppReqDto);
    
    /**
     * 实时代扣应答后续处理
     * @param rtWithholdRespBean
     * @return
     */
    public void hdlRespRTWithhold(RTWithholdRespBean rtWithholdRespBean);
    
    /**
     * 记录发送报文失败信息
     * 
     * @param exception
     * @return
     */
    public void recordSendMsgErrInfo(CPBusException exception, byte[] message);
}
