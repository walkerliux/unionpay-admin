package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApply;
import com.unionpay.withhold.admin.pojo.TCoopAgencyApplyExample;

public interface CoopAgencyApplyService {

	PageBean queryByPage(TCoopAgencyApplyExample coopAgencyApplyExample);

	ResultBean addCoopAgencyApply(TCoopAgencyApply coopAgencyApply);

	TCoopAgencyApply queryCoopAgencyApplyById(Long selfId);

	ResultBean updateCoopAgencyApply(TCoopAgencyApply coopAgencyApply);
	
	/**
	 * 查询申请信息
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectApplyWithCondition(TCoopAgencyApply coopAgencyApply, Integer page,Integer rows);
	
	/**
	 * 查询申请表中的待审核的信息
	 * @param coopAgencyApply
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean selectCheckWithCondition(TCoopAgencyApply coopAgencyApply, Integer page,Integer rows);

	TCoopAgencyApply queryCoopAgencyCheckById(Long selfId);

	ResultBean refuseCheck(TCoopAgencyApply coopAgencyApply);

	ResultBean passCheck(TCoopAgencyApply coopAgencyApply);

}
