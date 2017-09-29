package com.unionpay.withhold.trade.task.bean;

public class ConstantBean {

	public static final String CPFILETYPE = "CPFILECRON";
	public static String cpfilecron = "";
	private static class SingletonHolder {
		// 静态初始化器机制初始化本数据（保证了同步控制，线程安全）
		private static ConstantBean instance = new ConstantBean();
	}

	private ConstantBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static ConstantBean getInstance() {
		return SingletonHolder.instance;
	}
	
	

	
	
}
