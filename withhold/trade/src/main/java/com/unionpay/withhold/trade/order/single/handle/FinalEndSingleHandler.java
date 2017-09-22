package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;

@Component("finalEndSingleHandler")
public class FinalEndSingleHandler implements EventHandler<SingleCollectBean>{

	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		if(singleCollectBean.getFinalResult()==null) {
			//非空校验结果
			if(!singleCollectBean.getMessageCheck().isResultBool()) {
				
			}
			//业务校验结果
			if(!singleCollectBean.getBusiCheck().isResultBool()) {
				
			}
			//商户校验结果
			if(!singleCollectBean.getMerchCheck().isResultBool()) {
				
			}
			//二次提交校验结果
			if(!singleCollectBean.getRepeatSubmit().isResultBool()) {
				
			}
			//保存实时订单结果
			if(!singleCollectBean.getSaveOrder().isResultBool()) {
				
			}
			//保存核心流水结果
			if(!singleCollectBean.getSaveTxnLog().isResultBool()) {
				
			}
			ResultBean resultBean = null;
			resultBean = new ResultBean("0000", "成功");
			singleCollectBean.setFinalResult(resultBean);
		}else {
			
		}
		
	}

}
