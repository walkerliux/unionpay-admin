package com.unionpay.withhold.api.common.bean;

/**
 * 自定义一个上下文对象
 * 
 * @author Luke
 *
 */
public interface DkContext {
	/**
	 * 
	 * @param key
	 * @param valClass
	 * @return
	 */
	void set(String key, Object value);

	/**
	 * 
	 * @param key
	 * @param valClass
	 * @return
	 */
	<T> T get(String key, Class<T> valClass);

	/**
	 * 
	 * @param key
	 * @return
	 */
	Object getObject(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	String getString(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	Integer getInteger(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	Long getLong(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	Boolean getBoolean(String key);
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	Double getDouble(String key);
}
