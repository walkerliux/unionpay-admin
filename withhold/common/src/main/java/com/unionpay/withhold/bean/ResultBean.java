package com.unionpay.withhold.bean;

import java.io.Serializable;



public class ResultBean implements Serializable {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8907255757029910430L;
	private boolean resultBool;
	private Object resultObj;
	private String respCode;
	private String respMsg;
	private Object secondObj;
	
	public ResultBean(){
		this.resultBool=false;
	}
	
	public ResultBean(String respCode,String respMsg){
		this.resultBool=true;
		this.respCode=respCode;
		this.respMsg=respMsg;
	}
	
	public ResultBean(Object resultObj){
		this.resultObj=resultObj;
		this.resultBool=true;
	}
	
	
	
	public void setSuccessResultDto(Object resultObj){
		this.resultObj=resultObj;
		this.resultBool=true;
	}
	
	public void setErrorResultDto(String respMsg){
		this.resultBool=false;
		this.respCode="9999";
		this.respMsg=respMsg;
	}
	
	public void setErrorResultDto(String respCode,String respMsg){
		this.resultBool=false;
		this.respCode=respCode;
		this.respMsg=respMsg;
	}
	
	
	public boolean isResultBool() {
		return resultBool;
	}
	public void setResultBool(boolean resultBool) {
		this.resultBool = resultBool;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}

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

	public Object getSecondObj() {
		return secondObj;
	}

	public void setSecondObj(Object secondObj) {
		this.secondObj = secondObj;
	}
	
}
