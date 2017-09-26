/* 
 * LogHelper.java  
 * 
 * version v1.2
 *
 * 2016年1月29日 
 * 
 * Copyright (c) 2016,zlebank.All rights reserved.
 * 
 */
package com.unionpay.withhold.utils;

import java.lang.reflect.Method;

import net.sf.json.util.JSONUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;


/**
 * 日志打印
 *
 * @author Luxiaoshuai
 * @version
 * @date 2016年1月29日 下午2:04:29
 * @since 
 */
public class LogHelper {
    private Logger log = LoggerFactory.getLogger(LogHelper.class);
    /**事前通知**/
    public void before() {
    	
    }
    /**事后通知**/
    public void after() {
    }
    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable  {
        long startTime = System.currentTimeMillis();
        debugLogs(joinPoint);
        Object obj=joinPoint.proceed(joinPoint.getArgs());
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("【方法"+method.getName()+"()执行时间】"+(System.currentTimeMillis()-startTime));
        String resultJson = objectToString(obj);
        log.info("【方法"+method.getName()+"()返回值】"+(resultJson.length()>2000?resultJson.substring(0,2000)+"...":resultJson));
        return obj;
    }
    
    private void debugLogs(ProceedingJoinPoint joinPoint) {
        // 取得所执行的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 取得所执行的方法参数
        Object[] param = joinPoint.getArgs();
        // 利用类名进行Log 构造
        log = LoggerFactory.getLogger(joinPoint.getTarget().getClass()); 
        // 输出方法名LOG
        log.info(method.getName()+"()");
        // 输出方法参数LOG
        if (param != null) {
            int i=1;
            for (Object obj : param) {
                log.info(String.format("【参数%d】", i++) + objectToString(obj));
            }
        }
       
    }
    /**
     * 将对象转为字符串作为log输出
     * @param obj
     * @return 字符串
     */
    private String objectToString(Object obj) {

        // 对象为空
        if (obj == null || JSONUtils.isNull(obj))
            return "";
        // 对象为枚举类
        if (obj instanceof Enum)
            return obj.toString();
        // 对象为数值/布尔/字符类型
        if ((JSONUtils.isNumber(obj)) || (JSONUtils.isBoolean(obj)) || (JSONUtils.isString(obj)))
            return String.valueOf(obj);
        try {
            String json = JSON.toJSONString(obj);
            if(json.length()>2000){
            	return json.substring(0,2000)+"...";
            }
        	return json;
        } catch (Exception e) {
            log.debug("这个参数不能打印出来，可能发生了循环引用的问题。");
            return obj.toString();
        }
    }
    
    public void throwException(Exception ex) {
        log.error("【发生异常】");
        log.error(ex == null ? null : ex.getMessage(), ex);
    }
}
