package com.unionpay.withhold.api.cache.helper;

import java.util.HashMap;
import java.util.Map;

/**
 * 数据参数配置帮助类
 * 
 * @author lu_feng
 * 
 */
public class ConfigCacheHelper {
    private static Map<String, String> codeToValues = new HashMap<String, String>();

    /**
     * 
     * @param code
     * @return
     */
    public static String get(String code) {
        synchronized (codeToValues) {
            return codeToValues.get(code);
        }
    }

    /**
     * 
     * @param code
     * @return
     */
    public static void set(String code, String value) {
        synchronized (codeToValues) {
            codeToValues.put(code, value);
        }
    }

    /**
     * 
     * @param code
     * @return
     */
    public static void reset() {
        synchronized (codeToValues) {
            codeToValues.clear();
        }
    }
}
