package com.unionpay.withhold.trade.pay.service.impl;

import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.bean.CPBackFileNotifyBean;
import com.unionpay.withhold.service.path.cp.app.CPBatchWithhold;
import com.unionpay.withhold.service.path.cp.dto.req.BTRespWithholdReqDto;
import com.unionpay.withhold.trade.pay.service.ChannelNotifyService;
import com.unionpay.withhold.utils.BeanCopyUtil;
@Service
public class ChannelNotifyServiceImpl implements ChannelNotifyService{

	//@Reference(version="1.0")
	private CPBatchWithhold cpBatchWithhold;
	@Override
	public void chinaPayNotify(CPBackFileNotifyBean cpBackFileNotifyBean) {
		cpBatchWithhold.respBatchWithhold(BeanCopyUtil.copyBean(BTRespWithholdReqDto.class, cpBackFileNotifyBean));
	}

}
