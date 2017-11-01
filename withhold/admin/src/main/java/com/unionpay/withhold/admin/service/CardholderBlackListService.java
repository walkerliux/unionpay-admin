package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TBlacklistIdnum;

public interface CardholderBlackListService {

	/**
	 * 查询持卡人黑名单分页信息
	 * @param blacklistIdnum
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectListWithCondition(TBlacklistIdnum blacklistIdnum, Integer page, Integer rows);

	/**
	 * 新增持卡人黑名单
	 * @param blacklistIdnum
	 * @return
	 */
	ResultBean addCardholderBlackList(TBlacklistIdnum blacklistIdnum);

	/**
	 * 查询持卡人黑名单信息详情
	 * @param tid
	 * @return
	 */
	TBlacklistIdnum queryCardholderBlackListByTid(Integer tid);

	/**
	 * 修改持卡人黑名单
	 * @param blacklistIdnum
	 * @return
	 */
	ResultBean updateCardholderBlackList(TBlacklistIdnum blacklistIdnum);

	/**
	 * 注销持卡人黑名单
	 * @param blacklistIdnum
	 * @return
	 */
	ResultBean logoutCardholderBlackList(TBlacklistIdnum blacklistIdnum);
	
	/**
	 * 注销持卡人黑名单
	 * @param blacklistIdnum
	 * @return
	 */
	ResultBean startCardholderBlackList(TBlacklistIdnum blacklistIdnum);

}
