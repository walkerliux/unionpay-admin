package com.unionpay.withhold.api.common.bean;

import java.util.HashMap;

/**
 * 
 * @author Luke
 *
 */
public class DkContextImpl extends HashMap<String, Object> implements DkContext {
	private static final long serialVersionUID = 4548503560995856259L;

	@Override
	public void set(String key, Object value) {
		this.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Class<T> objClass) {
		Object item = this.get(key);
		if(item == null) {
			return (T)null;
		}
		return (T)item;
	}

	@Override
	public String getString(String key) {
		Object item = this.get(key);
		if(item != null) {
			if(item instanceof String) {
				return (String)item;
			}
			else {
				// TODO: Throw exception or cast it as toString?
				return item.toString();
			}
		}
		return null;
	}

	@Override
	public Integer getInteger(String key) {
		Object item = this.get(key);
		if(item != null) {
			if(item instanceof Integer) {
				return (Integer)item;
			}
			else {
				// TODO: Throw exception or cast it as toString?
				return Integer.parseInt(item.toString());
			}
		}
		return null;
	}

	@Override
	public Long getLong(String key) {
		Object item = this.get(key);
		if(item != null) {
			if(item instanceof Long) {
				return (Long)item;
			}
			else {
				// TODO: Throw exception or cast it as toString?
				return Long.parseLong(item.toString());
			}
		}
		return null;
	}

	@Override
	public Boolean getBoolean(String key) {
		Object item = this.get(key);
		if(item != null) {
			if(item instanceof Boolean) {
				return (Boolean)item;
			}
			else {
				// TODO: Throw exception or cast it as toString?
				return Boolean.parseBoolean(item.toString());
			}
		}
		return false;
	}

	@Override
	public Double getDouble(String key) {
		Object item = this.get(key);
		if(item != null) {
			if(item instanceof Double) {
				return (Double)item;
			}
			else {
				// TODO: Throw exception or cast it as toString?
				return Double.parseDouble(item.toString());
			}
		}
		return null;
	}

	@Override
	public Object getObject(String key) {
		return this.get(key);
	}
}
