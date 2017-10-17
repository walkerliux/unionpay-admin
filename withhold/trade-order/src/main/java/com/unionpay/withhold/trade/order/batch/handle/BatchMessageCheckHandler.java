package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.utils.ValidateLocator;

public class BatchMessageCheckHandler implements EventHandler<BatchCollectBean>{

	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			resultBean = ValidateLocator.validateBeans(batchCollectBean);
			if(resultBean.isResultBool()) {
				resultBean = null;
				List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
				if(detaList.size()==0) {
					resultBean = new ResultBean("OD056", "批次明细不能为空");
					resultBean.setResultBool(false);
				}else {
					List<ResultBean> resultBeans = Lists.newArrayList();
					for(BatchCollectDetaBean detaBean : detaList) {
						resultBean = ValidateLocator.validateBeans(detaBean);
						if(!resultBean.isResultBool()) {
							resultBean.setResultObj(detaBean.getOrderId());
							resultBeans.add(resultBean);
						}
					}
					if(resultBeans.size()>0) {
						resultBean = new ResultBean("OD052", "批量报文校验错误");
						resultBean.setResultBool(false);
						resultBean.setResultObj(resultBeans);
					}
					if(resultBean==null) {
						resultBean = new ResultBean("0000", "成功");
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("OD046", "系统内部错误");
			resultBean.setResultBool(false);
		}finally {
			batchCollectBean.setBatchMessageCheck(resultBean);
		}
		
	}

}
