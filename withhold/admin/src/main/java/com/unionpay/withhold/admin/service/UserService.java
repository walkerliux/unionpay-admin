package com.unionpay.withhold.admin.service;



import java.util.Date;
import java.util.List;
import java.util.Map;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TUser;

public interface UserService {
	public abstract TUser getLoginUser(TUser user);

	public abstract TUser getSingleById(Integer integer);

	public abstract void resetPwd(TUser user, Date date);

	public abstract PageBean findUserByPage(TUser user, String roleId,int page, int rows);

	public abstract void saveUser(TUser user);

	public abstract void updateUser(TUser user);

	public abstract TUser getSingleById(Long userId);

}
