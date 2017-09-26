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
	 * 商户号
	 */
	private String merId;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 总笔数
     */
    private String sumNum;

    /**
     *总金额（单位：分）
     */
    private String sumAmt;
    
    /**
     * 批量代扣明细信息（List<BTWithholdAppItem>转换后的Json字符串）
     */
    private String withholdItems;

    
    public String getMerId() {
        return merId;
    }

    
    public void setMerId(String merId) {
        this.merId = merId;
    }

    
    public String getBatchNo() {
        return batchNo;
    }

    
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

    
    public String getSumNum() {
        return sumNum;
    }

    
    public void setSumNum(String sumNum) {
        this.sumNum = sumNum;
    }

    
    public String getSumAmt() {
        return sumAmt;
    }

    
    public void setSumAmt(String sumAmt) {
        this.sumAmt = sumAmt;
    }

    
    public String getWithholdItems() {
        return withholdItems;
    }

    
    public void setWithholdItems(String withholdItems) {
        this.withholdItems = withholdItems;
    }


    @Override
    public String toString() {
        return "BTWithholdAppReqDto [merId=" + merId + ", batchNo=" + batchNo + ", sumNum=" + sumNum + ", sumAmt=" + sumAmt + ", withholdItems=" + withholdItems + "]";
    }
    
}
