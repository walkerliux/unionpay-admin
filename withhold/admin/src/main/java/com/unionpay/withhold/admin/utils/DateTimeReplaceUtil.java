package com.unionpay.withhold.admin.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class DateTimeReplaceUtil {
	
	public static String replace(String time){
	
		String time1 = time.replaceAll("-","");
		String time2 = time1.replaceAll(":", "");
		String time3 = time2.replace(" ", "");
		return time3;
	} 
	//将时间字符串转化为date
	public static Date simpleformat(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parse=null;
		try {
			parse = sdf.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return parse;
	}
	public static void main(String[] args) {
		String etime="2017-03-01 16:50:48";
		//String time = DateTimeReplaceUtil.replace(etime);
		Date date = DateTimeReplaceUtil.simpleformat(etime);
		System.out.println(date);
	}
}
