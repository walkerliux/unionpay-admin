package com.unionpay.withhold.service.path.cp.dto.req;

import java.io.Serializable;

/**
 * 批量代扣业务查询请求参数
 * 
 * @author AlanMa
 *
 */
public class BTWithholdQryReqDto implements Serializable {

    private static final long serialVersionUID = -4002178926596021756L;

    /**
	 * 商户号
	 */
	private String merId;

    /**
     * 受理批次号
     */
    private String tn;

    
    public String getMerId() {
        return merId;
    }

    
    public void setMerId(String merId) {
        this.merId = merId;
    }

    
    public String getTn() {
        return tn;
    }

    
    public void setTn(String tn) {
        this.tn = tn;
    }


    @Override
    public String toString() {
        return "BTWithholdQryReqDto [merId=" + merId + ", tn=" + tn + "]";
    }
    
}
