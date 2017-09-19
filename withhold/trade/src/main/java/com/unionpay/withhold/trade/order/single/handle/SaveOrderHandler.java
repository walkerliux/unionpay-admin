package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;

@Component("saveOrderHandler")
public class SaveOrderHandler implements EventHandler<SingleCollectBean>{

	@Override
	public void onEvent(SingleCollectBean event, long sequence, boolean endOfBatch) throws Exception {
		
		
	}

}
