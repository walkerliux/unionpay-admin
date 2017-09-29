package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TCity;

public interface CityService {
	List<TCity> queryByProID(Long pId);
}
