package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TRole;

public interface RoleService {

	List<TRole> findByProperty( String string);

	List<TRole> findAllRole();

}
