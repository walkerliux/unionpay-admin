package com.unionpay.withhold.service.path.cp.dto.req;

import java.io.Serializable;

/**
 * 批量代扣请求参数
 * 
 * @author AlanMa
 *
 */
public class BTWithholdAppReqDto implements Serializable {

    private static final long serialVersionUID = 7872926219133693883L;
    
    /**
     * 受理批次号
     */
    private String tn;
    
    
    public BTWithholdAppReqDto() {
        super();
    }
    
    public BTWithholdAppReqDto(String tn) {
        super();
        this.tn = tn;
    }

    public String getTn() {
        return tn;
    }

    
    public void setTn(String tn) {
        this.tn = tn;
    }


    @Override
    public String toString() {
        return "BTWithholdAppReqDto [tn=" + tn + "]";
    }

    
}
