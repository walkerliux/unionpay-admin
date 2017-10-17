package com.unionpay.withhold.service.path.cp.app.mock;

import com.unionpay.withhold.common.bean.ResultBean;
import com.unionpay.withhold.service.path.cp.app.CPBatchWithhold;
import com.unionpay.withhold.service.path.cp.dto.req.BTRespWithholdReqDto;
import com.unionpay.withhold.service.path.cp.dto.req.BTWithholdQryReqDto;

public class CPBatchWithholdMock implements CPBatchWithhold {

	@Override
	public ResultBean applyBatchWithhold(BTWithholdQryReqDto btWithholdQryReqDto) {
		ResultBean resultBean = new ResultBean();
		resultBean.setErrorResultDto("20FM", "上传文件成功");
		resultBean.setResultBool(true);
		return resultBean;
	}

	@Override
	public ResultBean respBatchWithhold(BTRespWithholdReqDto btRespWithholdReqDto) {
		ResultBean resultBean = new ResultBean();
		resultBean.setErrorResultDto("1001", "处理完成或接收成功");
		resultBean.setResultBool(true);
		return resultBean;
	}

}
