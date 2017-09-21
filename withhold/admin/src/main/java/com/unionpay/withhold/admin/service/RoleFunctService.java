package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TRoleFunct;

public interface RoleFunctService {

	List<TRoleFunct> findRoleFunctByRoleIds(List<Long> roleIdlist);

}
