package com.unionpay.withhold.service.path.cp.app;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.dto.req.BTRespWithholdReqDto;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;


/**
 * 批量代扣交易类接口
 * 
 * @author AlanMa
 *
 */
public interface CPBatchWithhold {

    /**
     * 批量代扣
     * @param rtWithholdAppReqDto
     * @return
     */
    public ResultBean applyBatchWithhold(RTWithholdAppReqDto rtWithholdAppReqDto);
    
    /**
     * 接收回盘文件通知
     * @param btRespWithholdReqDto
     * @return
     */
    public ResultBean respBatchWithhold(BTRespWithholdReqDto btRespWithholdReqDto);
}
