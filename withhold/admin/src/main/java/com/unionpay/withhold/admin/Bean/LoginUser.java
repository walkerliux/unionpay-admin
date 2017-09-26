package com.unionpay.withhold.admin.Bean;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TUser;

public class LoginUser {
	
	private TUser user;
	private String sessionId;
	public TUser getUser() {
		return user;
	}
	public void setUser(TUser user) {
		this.user = user;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
	
}
