package com.unionpay.withhold.admin.service;


import com.unionpay.withhold.admin.Bean.PageBean;

import com.unionpay.withhold.admin.pojo.TRspmsg;

public interface RspMsgService {

	PageBean findRspByPage(TRspmsg rspmsg, int page, int rows);

	TRspmsg getSingleById(Long rspid);

	

	void updateTRspmsg(TRspmsg rspmsg);

	void saveTRspmsg(TRspmsg rspmsg);

}
