package com.unionpay.withhold.api.common.bean;

import java.io.Serializable;

/**
 * API传入数据
 * @author: yuanshaodong
 * @date: 2017年8月30日
 * @version 1.0
 */
public class MessageBean implements Serializable{
	private static final long serialVersionUID = -8793113493351824648L;
	/**签名字符串**/
	private String sign;
	/**附加域**/
	private String addit;
	/**业务报文字符串**/
	private String data;
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getAddit() {
		return addit;
	}
	public void setAddit(String addit) {
		this.addit = addit;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
