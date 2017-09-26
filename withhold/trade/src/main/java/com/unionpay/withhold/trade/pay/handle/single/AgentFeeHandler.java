package com.unionpay.withhold.trade.pay.handle.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.trade.fee.bean.FeeBean;
import com.unionpay.withhold.trade.fee.service.FeeService;
import com.unionpay.withhold.trade.pay.bean.TradeBean;

@Component("agentFeeHandler")
public class AgentFeeHandler implements EventHandler<TradeBean>{
	@Autowired
	private FeeService feeService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		
		FeeBean feeBean = new FeeBean();
		feeBean.setTxnseqno(tradeBean.getTxnseqno());
		//扣率版本，
		feeBean.setFeeVer(null);
		//业务类型，
		feeBean.setBusiCode(tradeBean.getBusinessEnum().getCode());
		//交易金额，
		feeBean.setTxnAmt(tradeBean.getTxnLogPayDO().getAmount().toString());
		//会员号，
		feeBean.setMerchNo(tradeBean.getTxnLogPayDO().getAccfirmerno());
		//原交易序列号，
		feeBean.setTxnseqnoOg(null);
		//卡类型 
		feeBean.setCardType(tradeBean.getTxnLogPayDO().getCardtype());
		Long coopfee = feeService.getAgentFee(feeBean);
		tradeBean.getTxnLogPayDO().setCoopfee(coopfee.toString());
		
	}

}
