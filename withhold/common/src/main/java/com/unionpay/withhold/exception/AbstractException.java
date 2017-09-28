/* 
 * AbstractDescribeException.java  
 * 
 * version 1.0
 *
 * 2015年8月31日 
 * 
 * Copyright (c) 2015,zlebank.All rights reserved.
 * 
 */
package com.unionpay.withhold.exception;

import java.util.ResourceBundle;

/**
 * @author yangying
 * @version
 * @date 2015年8月31日 下午12:12:56
 * @since
 */
public abstract class AbstractException extends BaseException {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4880611538778827974L;
    
    @Override
    public String getMessage() {
        String message = getResourceBundle().getString(getCode());
        return String.format(message, getParams());
    }
    
    public abstract ResourceBundle getResourceBundle();
    
    public abstract String getCode();
    
    public AbstractException() {
        super();
    }
    
    public AbstractException(Throwable cause) {
        super(cause);
    }
}
