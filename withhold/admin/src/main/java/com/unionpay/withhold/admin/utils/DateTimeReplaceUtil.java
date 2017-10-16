package com.unionpay.withhold.admin.utils;



public class DateTimeReplaceUtil {
	
	public static String replace(String time){
	
		String time1 = time.replaceAll("-","");
		String time2 = time1.replaceAll(":", "");
		String time3 = time2.replace(" ", "");
		return time3;
	} 
	public static void main(String[] args) {
		String etime="2017-03-01 16:50:48";
		String time = DateTimeReplaceUtil.replace(etime);
		System.out.println(time);
	}
}
