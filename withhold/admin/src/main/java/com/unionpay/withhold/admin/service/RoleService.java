package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TRole;

public interface RoleService {

	List<TRole> findByProperty( String string);

	List<TRole> findAllRole();

	PageBean findRoleByPage(TRole role, int page, int rows);

	List<TRole> saveRole(TRole role);

	List<TRole> updateRole(TRole role);

	TRole getSingleById(Long roleId);

	

}
