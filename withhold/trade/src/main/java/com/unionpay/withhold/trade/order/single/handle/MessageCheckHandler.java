package com.unionpay.withhold.trade.order.single.handle;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.utils.ValidateLocator;

/**
 * 实时代扣订单bean数据合法性校验handler
 * @author guojia
 *
 */
public class MessageCheckHandler implements EventHandler<SingleCollectBean>{

	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		if(singleCollectBean.getFinalResult()!=null) {
			if(singleCollectBean.getFinalResult().isResultBool()) {
				return;
			}
		}
		ResultBean resultBean = ValidateLocator.validateBeans(singleCollectBean);
		singleCollectBean.setMessageCheck(resultBean);
	}
	
}
