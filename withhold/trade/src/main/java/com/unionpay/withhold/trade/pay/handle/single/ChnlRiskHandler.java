package com.unionpay.withhold.trade.pay.handle.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.risk.bean.RiskBean;
import com.unionpay.withhold.trade.risk.service.TradeRiskService;
@Component("chnlRiskHandler")
public class ChnlRiskHandler implements EventHandler<TradeBean>{
	@Autowired
	private TradeRiskService tradeRiskService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		RiskBean riskBean = new RiskBean();
		riskBean.setTxnseqno(tradeBean.getTxnseqno());;
		/**合作机构号*/
		riskBean.setCoopInstId(null);;
		/**商户号*/
		riskBean.setMerchId(tradeBean.getTxnLogPayDO().getAccsecmerno());;
		/**会员号*/
		riskBean.setMemberId("999999999999999");;
		/**业务代码*/
		riskBean.setBusiCode(tradeBean.getBusinessEnum().getCode());;
		/**交易金额*/
		riskBean.setTxnAmt(tradeBean.getTxnLogPayDO().getAmount().toString());;
		/**银行卡类型*/
		riskBean.setCardType(tradeBean.getTxnLogPayDO().getCardtype());;
		/**卡号/账号*/
		riskBean.setCardNo(tradeBean.getTxnLogPayDO().getPan());;
		/**转入卡类型*/
		riskBean.setInCardType(null);;
		/**转入银行账号*/
		riskBean.setInCardNo(null);;
		riskBean.setChnlCode(tradeBean.getChnlCode());
		ResultBean resultBean = tradeRiskService.aisleRiskControl(riskBean);
		tradeBean.setChnlRisk(resultBean);
		
	}

}
