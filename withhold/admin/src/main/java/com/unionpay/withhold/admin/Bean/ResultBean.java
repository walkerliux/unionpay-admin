package com.unionpay.withhold.admin.Bean;

public class ResultBean{
	private String errCode;
	private String errMsg;
	private Boolean resultBool;
	private Object resultObj;
	
	public ResultBean(){
		this.resultBool=false;
	}
	
	public ResultBean(String errCode,String errMsg){
		this.resultBool=false;
		this.errCode=errCode;
		this.errMsg=errMsg;
	}
	
	public ResultBean(Object resultObj){
		this.resultObj=resultObj;
		this.resultBool=true;
	}
	
	
	
	public void setSuccessResultDto(Object resultObj){
		this.resultObj=resultObj;
		this.resultBool=true;
	}
	
	public void setErrorResultDto(String errMsg){
		this.resultBool=false;
		this.errCode="9999";
		this.errMsg=errMsg;
	}
	
	public void setErrorResultDto(String errCode,String errMsg){
		this.resultBool=false;
		this.errCode=errCode;
		this.errMsg=errMsg;
	}
	
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public Boolean isResultBool() {
		return resultBool;
	}
	public void setResultBool(Boolean resultBool) {
		this.resultBool = resultBool;
	}

	public Object getResultObj() {
		return resultObj;
	}

	public void setResultObj(Object resultObj) {
		this.resultObj = resultObj;
	}
}
