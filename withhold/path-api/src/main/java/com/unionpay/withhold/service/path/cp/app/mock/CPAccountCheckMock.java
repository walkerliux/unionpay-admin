package com.unionpay.withhold.service.path.cp.app.mock;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.app.CPAccountCheck;
import com.unionpay.withhold.service.path.cp.dto.req.BTAccChkReqDto;

public class CPAccountCheckMock implements CPAccountCheck {

	@Override
	public ResultBean downloadAccChkFile(BTAccChkReqDto btAccChkReqDto) {
		ResultBean resultBean = new ResultBean("0000", "处理成功");
		resultBean.setResultBool(true);
		return resultBean;
	}

}
