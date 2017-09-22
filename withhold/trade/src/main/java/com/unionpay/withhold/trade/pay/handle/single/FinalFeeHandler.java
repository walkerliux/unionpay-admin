package com.unionpay.withhold.trade.pay.handle.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.dao.TxnLogPayDAO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;

@Component("finalFeeHandler")
public class FinalFeeHandler implements EventHandler<TradeBean>{

	@Autowired
	private TxnLogPayDAO txnLogPayDAO;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		TxnLogPayDO txnLogPay = tradeBean.getTxnLogPayDO();
		if(!tradeBean.getMerchFee().isResultBool()) {
			
		} 
		if(!tradeBean.getAgentFee().isResultBool()) {
			
		}
		if(!tradeBean.getChnlFee().isResultBool()) {
			
		}
		txnLogPayDAO.updateByPrimaryKey(txnLogPay);
		
	}

}
