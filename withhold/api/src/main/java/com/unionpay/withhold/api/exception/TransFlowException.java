package com.unionpay.withhold.api.exception;


/**
 * 
 * @author Luke
 *
 */
public class TransFlowException extends AbstractBusiException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TransFlowException() {}
	
	/**
	 * 
	 * @param code
	 * @param message
	 */
	public TransFlowException(String code, String message) {
		this.respCode = code;
		this.respMessage = message;
	}
	
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
