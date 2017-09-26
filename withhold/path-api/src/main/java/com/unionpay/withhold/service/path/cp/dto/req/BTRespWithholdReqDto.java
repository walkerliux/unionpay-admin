package com.unionpay.withhold.service.path.cp.dto.req;

import java.io.Serializable;

/**
 * 回盘文件通知请求参数
 * 
 * @author AlanMa
 *
 */
public class BTRespWithholdReqDto implements Serializable {

    private static final long serialVersionUID = -4117385628860305776L;

    /**
	 * 响应码
	 */
	private String responseCode;

    /**
     * 描述
     */
    private String message;
    
    /**
     * 商户号
     */
    private String merId;
    
    /**
     * 原始文件名
     */
    private String orFileName;
    
    /**
     *下载文件名
     */
    private String fileName;

    
    public String getResponseCode() {
        return responseCode;
    }

    
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    
    public String getMessage() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }

    
    public String getMerId() {
        return merId;
    }

    
    public void setMerId(String merId) {
        this.merId = merId;
    }

    
    public String getOrFileName() {
        return orFileName;
    }

    
    public void setOrFileName(String orFileName) {
        this.orFileName = orFileName;
    }

    
    public String getFileName() {
        return fileName;
    }

    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    @Override
    public String toString() {
        return "BTRespWithholdReqDto [responseCode=" + responseCode + ", message=" + message + ", merId=" + merId + ", orFileName=" + orFileName + ", fileName=" + fileName + "]";
    }
    
}
