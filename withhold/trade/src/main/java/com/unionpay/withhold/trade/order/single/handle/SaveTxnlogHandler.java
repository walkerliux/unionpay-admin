package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.service.TxnLogService;
@Component("saveTxnlogHandler")
public class SaveTxnlogHandler implements EventHandler<SingleCollectBean>{

	@Autowired
	private TxnLogService txnLogService;
	@Override
	public void onEvent(SingleCollectBean event, long sequence, boolean endOfBatch) throws Exception {
		
		
	}

}
