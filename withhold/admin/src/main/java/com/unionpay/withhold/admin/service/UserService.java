package com.unionpay.withhold.admin.service;



import java.util.Date;
import java.util.Map;

import com.unionpay.withhold.admin.pojo.TUser;

public interface UserService {
	public abstract TUser getLoginUser(TUser user);

	public abstract TUser getSingleById(Integer integer);

	public abstract void resetPwd(TUser user, Date date);

	public abstract Map<String, Object> findUserByPage(
			Map<String, Object> variables, int page, int rows);

}
