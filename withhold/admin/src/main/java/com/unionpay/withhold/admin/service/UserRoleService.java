package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TUserRole;

public interface UserRoleService {

	List<TUserRole> findByProperty(Long userId);

	void deleteOldUserRole(Long userId);

	void save(List<TUserRole> userRoleList);

}
