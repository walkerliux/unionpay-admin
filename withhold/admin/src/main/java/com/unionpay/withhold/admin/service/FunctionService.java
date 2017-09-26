package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TFunction;
import com.unionpay.withhold.admin.pojo.TUser;

public interface FunctionService {

	List<?> findFunction();

	List<?> findLoginFuntion(TUser loginUser);

	List<TFunction> findAllFuntion(TUser user);

}
