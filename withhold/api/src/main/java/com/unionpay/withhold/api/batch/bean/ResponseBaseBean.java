package com.unionpay.withhold.api.batch.bean;

/**
 * API相应数据
 * @author: 张世栋
 * @date: 2017年9月25日13:50:29
 * @version 1.0
 */
public class ResponseBaseBean {
	private String respMsg;//	应答信息
	private String respCode;//	响应码
	
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	

}
