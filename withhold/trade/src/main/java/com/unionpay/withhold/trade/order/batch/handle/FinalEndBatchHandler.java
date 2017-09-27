package com.unionpay.withhold.trade.order.batch.handle;

import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;

@Component("finalEndBatchHandler")
public class FinalEndBatchHandler implements EventHandler<BatchCollectBean>{

	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		if(batchCollectBean.getFinalResult()==null) {
			//非空校验结果
			if(!batchCollectBean.getBatchMessageCheck().isResultBool()) {
				
			}
			//业务校验结果
			if(!batchCollectBean.getBusinessCheck().isResultBool()) {
				
			}
			//商户校验结果
			if(!batchCollectBean.getMerchCheck().isResultBool()) {
				
			}
			//二次提交校验结果
			if(!batchCollectBean.getRepeatSubmitCheck().isResultBool()) {
				
			}
			//保存实时订单结果
			if(!batchCollectBean.getSaveBatch().isResultBool()) {
				
			}
			//保存核心流水结果
			if(!batchCollectBean.getSaveDetaTxnlog().isResultBool()) {
				
			}
			ResultBean resultBean = null;
			resultBean = new ResultBean("0000", "成功");
			batchCollectBean.setFinalResult(resultBean);
		}else {
			
		}
		
	}

}
