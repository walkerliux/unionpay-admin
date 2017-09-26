package com.unionpay.withhold.service.path.cp.dto.req;

import java.io.Serializable;

/**
 * 对账文件下载请求参数
 * 
 * @author AlanMa
 *
 */
public class BTAccChkReqDto implements Serializable {

    private static final long serialVersionUID = -741007790586708246L;

    /**
	 * 商户号
	 */
	private String merId;

    /**
     * 交易日期（yyyymmdd）
     */
    private String tradeDate;

    
    public String getMerId() {
        return merId;
    }

    
    public void setMerId(String merId) {
        this.merId = merId;
    }

    
    public String getTradeDate() {
        return tradeDate;
    }

    
    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }


    @Override
    public String toString() {
        return "BTAccChkReqDto [merId=" + merId + ", tradeDate=" + tradeDate + "]";
    }
    
}
