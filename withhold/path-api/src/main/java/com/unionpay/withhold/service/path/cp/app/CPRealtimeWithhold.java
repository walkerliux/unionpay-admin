package com.unionpay.withhold.service.path.cp.app;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;

/**
 * 实时代扣交易类接口
 * 
 * @author AlanMa
 *
 */
public interface CPRealtimeWithhold {

    /**
     * 实时代扣
     * 
     * @param rtWithholdAppReqDto
     * @return
     */
    public ResultBean applyRealtimeWithhold(RTWithholdAppReqDto rtWithholdAppReqDto);

}
