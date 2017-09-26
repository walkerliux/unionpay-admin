package com.unionpay.withhold.service.path.cp.app;

import com.unionpay.withhold.common.bean.ResultBean;




public interface RealtimeWithholdQry {

	/**
	 * 同步实时代扣交易状态
	 * @param txnseqno
	 * @return
	 */
	public ResultBean qryRTWthdRecord(String txnseqno);
	

}
