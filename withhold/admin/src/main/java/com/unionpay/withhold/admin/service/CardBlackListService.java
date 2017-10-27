package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TBlacklistPan;

public interface CardBlackListService {

	/**
	 * 查询银行卡黑名单分页信息
	 * @param blacklistPan
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectListWithCondition(TBlacklistPan blacklistPan, Integer page, Integer rows);

	/**
	 * 新增银行卡黑名单
	 * @param blacklistPan
	 * @return
	 */
	ResultBean addCardBlackList(TBlacklistPan blacklistPan);

	/**
	 * 查询银行卡黑名单信息详情
	 * @param tid
	 * @return
	 */
	TBlacklistPan queryCardBlackListByTid(Integer tid);

	/**
	 * 修改银行卡黑名单
	 * @param blacklistPan
	 * @return
	 */
	ResultBean updateCardBlackList(TBlacklistPan blacklistPan);

	/**
	 * 注销银行卡黑名单
	 * @param blacklistPan
	 * @return
	 */
	ResultBean logoutCardBlackList(TBlacklistPan blacklistPan);
	
	/**
	 * 注销银行卡黑名单
	 * @param blacklistPan
	 * @return
	 */
	ResultBean startCardBlackList(TBlacklistPan blacklistPan);

}
