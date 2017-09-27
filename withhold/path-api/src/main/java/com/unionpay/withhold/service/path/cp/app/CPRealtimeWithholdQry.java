package com.unionpay.withhold.service.path.cp.app;

import com.unionpay.withhold.common.bean.ResultBean;




/**
 * 实时代扣业务查询类接口
 * 
 * @author AlanMa
 *
 */
public interface CPRealtimeWithholdQry {

	/**
	 * 同步实时代扣交易状态
	 * @param txnseqno
	 * @return
	 */
	public ResultBean qryRTWthdRecord(String txnseqno);
	

}
