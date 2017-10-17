package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.pojo.TMccList;

public interface MCCListService {

	List<TMccList> queryByMcc(String mcc);
}
