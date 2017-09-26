package com.unionpay.withhold.service.path.cp.app;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.dto.req.BTAccChkReqDto;


/**
 * 对账处理类
 * @author AlanMa
 *
 */
public interface CPAccountCheck {

    /**
     * 下载对账文件
     * @param btAccChkReqDto
     * @return
     */
    public ResultBean downloadAccChkFile(BTAccChkReqDto btAccChkReqDto);
}
