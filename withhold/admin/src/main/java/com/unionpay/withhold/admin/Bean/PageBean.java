package com.unionpay.withhold.admin.Bean;

public class PageBean {
	private int total;
	private Object data;
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public PageBean(int total, Object data){
		this.total = total;
		this.data = data;
	}
}
