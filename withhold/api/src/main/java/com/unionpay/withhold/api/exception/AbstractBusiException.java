package com.unionpay.withhold.api.exception;

/**
 * 扩展自定义抽象异常类
 *  
 * @author Luke
 *
 */
public class AbstractBusiException extends Exception {
	private static final long serialVersionUID = -5216383987719843583L;

	/**
	 * 
	 */
	public AbstractBusiException() {
		
	}
	
	public AbstractBusiException(String e) {
		super(e);
	}
	
	public AbstractBusiException(String message, Throwable cause) {
        super(message, cause);
    }
	
	public AbstractBusiException(Throwable cause) {
		super(cause);
	}
}
