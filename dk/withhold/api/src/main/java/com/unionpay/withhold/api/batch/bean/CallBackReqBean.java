package com.unionpay.withhold.api.batch.bean;

/**
 * 回盘请求bean
 * @author: 张世栋
 * @date: 2017年9月25日13:48:57
 * @version 1.0
 */
public class CallBackReqBean {
	
	private static final long serialVersionUID = 1349442825901337918L;
	private String 	responseCode	;//	响应码
	private String 	message	;//	描述
	private String 	merId	;//	商户号
	private String 	orFileName	;//	原始文件名
	private String 	fileName	;//	下载文件名
	private String 	chkValue	;//	签名密文
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
	public String getChkValue() {
		return chkValue;
	}
	public void setChkValue(String chkValue) {
		this.chkValue = chkValue;
	}

}
