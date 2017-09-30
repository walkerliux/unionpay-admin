package com.unionpay.withhold.service.path.cp.app;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.dto.req.BTWithholdQryReqDto;

/**
 * 批量代扣业务查询类接口
 * 
 * @author AlanMa
 *
 */
public interface CPBatchWithholdQry {

    /**
     * 批量代扣文件查询
     * 
     * @param btWithholdQryReqDto
     * @return
     */
    public ResultBean qryBTWthdRecord(BTWithholdQryReqDto btWithholdQryReqDto);

}
