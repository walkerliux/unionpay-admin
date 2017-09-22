package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TRoleFunct;
import com.unionpay.withhold.admin.pojo.TUserFunct;

public interface UserFunctService {

	void deleteOldFunc(Long userId);

	void save(List<TUserFunct> functList);

	List<TUserFunct> findByProperty(Long userId);

}
