package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TWhitelistPan;

public interface CardWhiteListService {

	/**
	 * 查询银行卡白名单分页信息
	 * @param whitelistPan
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectListWithCondition(TWhitelistPan whitelistPan, Integer page, Integer rows);

	/**
	 * 新增银行卡白名单
	 * @param whitelistPan
	 * @return
	 */
	ResultBean addCardWhiteList(TWhitelistPan whitelistPan);

	/**
	 * 查询银行卡白名单信息详情
	 * @param tid
	 * @return
	 */
	TWhitelistPan queryCardWhiteListByTid(Integer tid);

	/**
	 * 修改银行卡白名单
	 * @param whitelistPan
	 * @return
	 */
	ResultBean updateCardWhiteList(TWhitelistPan whitelistPan);

	/**
	 * 注销银行卡白名单
	 * @param whitelistPan
	 * @return
	 */
	ResultBean logoutCardWhiteList(TWhitelistPan whitelistPan);
	
	/**
	 * 注销银行卡白名单
	 * @param whitelistPan
	 * @return
	 */
	ResultBean startCardWhiteList(TWhitelistPan whitelistPan);

}
