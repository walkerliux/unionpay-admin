package com.unionpay.withhold.service.path.cp.dto.req;

import java.io.Serializable;


/**
 * 实时代扣请求参数
 * 
 * @author AlanMa
 *
 */
public class RTWithholdAppReqDto implements Serializable {

	private static final long serialVersionUID = 7981006630870396466L;
	
	/**
	 * 商户号
	 */
	private String merId;

    /**
     * 商户日期YYYYMMDD
     */
    private String transDate;

    /**
     * 开户行号
     */
    private String openBankId;

    /**
     *卡折标志 （0表示卡,1表示折）
     */
    private String cardType;

    /**
     * 卡号/折号
     */
    private String cardNo;

    /**
     * 持卡人姓名
     */
    private String usrName;
    
    /**
     * 证件类型（身份证01）
     */
    private String certType;
    
    /**
     * 证件号
     */
    private String certId;
    
    /**
     * 金额（以分为单位 ）
     */
    private String transAmt;

    
    public String getMerId() {
        return merId;
    }

    
    public void setMerId(String merId) {
        this.merId = merId;
    }

    
    public String getTransDate() {
        return transDate;
    }

    
    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    
    public String getOpenBankId() {
        return openBankId;
    }

    
    public void setOpenBankId(String openBankId) {
        this.openBankId = openBankId;
    }

    
    public String getCardType() {
        return cardType;
    }

    
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    
    public String getCardNo() {
        return cardNo;
    }

    
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    
    public String getUsrName() {
        return usrName;
    }

    
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }

    
    public String getCertType() {
        return certType;
    }

    
    public void setCertType(String certType) {
        this.certType = certType;
    }

    
    public String getCertId() {
        return certId;
    }

    
    public void setCertId(String certId) {
        this.certId = certId;
    }

    
    public String getTransAmt() {
        return transAmt;
    }

    
    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }


    @Override
    public String toString() {
        return "RTWithholdAppReqDto [merId=" + merId + ", transDate=" + transDate + ", openBankId=" + openBankId + ", cardType=" + cardType + ", cardNo=" + cardNo + ", usrName=" + usrName
                + ", certType=" + certType + ", certId=" + certId + ", transAmt=" + transAmt + "]";
    }
    
}
