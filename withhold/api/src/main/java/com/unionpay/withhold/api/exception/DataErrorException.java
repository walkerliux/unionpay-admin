package com.unionpay.withhold.api.exception;

public class DataErrorException extends AbstractBusiException{

	public DataErrorException(String string) {
		super(string);
	}
	public DataErrorException() {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1113823669976401584L;
	
	private String respCode;

	private String respMessage;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}

}
