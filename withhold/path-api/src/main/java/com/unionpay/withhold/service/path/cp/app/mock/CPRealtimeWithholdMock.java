package com.unionpay.withhold.service.path.cp.app.mock;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.app.CPRealtimeWithhold;
import com.unionpay.withhold.service.path.cp.dto.req.RTWithholdAppReqDto;

public class CPRealtimeWithholdMock implements CPRealtimeWithhold {

	@Override
	public ResultBean applyRealtimeWithhold(RTWithholdAppReqDto rtWithholdAppReqDto) {
		ResultBean resultBean = new ResultBean();
		resultBean.setErrorResultDto("1001", "处理完成或接收成功");
		resultBean.setResultBool(true);
		return resultBean;
	}

}
