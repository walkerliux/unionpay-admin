package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TLimitSingle;

public interface LimitSingleService {

	/**
	 * 查询单笔限额分页信息
	 * @param limitSingle
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectListWithCondition(TLimitSingle limitSingle, Integer page, Integer rows);

	/**
	 * 新增单笔限额
	 * @param limitSingle
	 * @return
	 */
	ResultBean addLimitSingle(TLimitSingle limitSingle);

	/**
	 * 查询单笔限额信息详情
	 * @param tid
	 * @return
	 */
	TLimitSingle queryLimitSingleById(Integer tid);

	/**
	 * 修改单笔限额
	 * @param limitSingle
	 * @return
	 */
	ResultBean updateLimitSingle(TLimitSingle limitSingle);

	/**
	 * 注销单笔限额
	 * @param limitSingle
	 * @return
	 */
	ResultBean logoutLimitSingle(TLimitSingle limitSingle);

	/**
	 * 启用单笔限额
	 * @param limitSingle
	 * @return
	 */
	ResultBean startLimitSingle(TLimitSingle limitSingle);

}
