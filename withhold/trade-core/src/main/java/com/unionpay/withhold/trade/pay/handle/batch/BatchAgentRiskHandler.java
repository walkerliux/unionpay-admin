package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.risk.bean.RiskBean;
import com.unionpay.withhold.trade.risk.service.TradeRiskService;
@Component("batchAgentRiskHandler")
public class BatchAgentRiskHandler implements EventHandler<TradeBean>{
	
	@Autowired
	private TradeRiskService tradeRiskService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		List<ResultBean> agentRiskList = Lists.newArrayList();
		try {
			for(TxnLogPayDO txnLogPay : tradeBean.getTxnLogList()) {
				RiskBean riskBean = new RiskBean();
				riskBean.setTxnseqno(txnLogPay.getTxnseqno());;
				/**合作机构号*/
				riskBean.setCoopInstId(null);;
				/**商户号*/
				riskBean.setMerchId(txnLogPay.getAccsecmerno());;
				/**会员号*/
				riskBean.setMemberId("999999999999999");;
				/**业务代码*/
				riskBean.setBusiCode(tradeBean.getBusinessEnum().getCode());;
				/**交易金额*/
				riskBean.setTxnAmt(txnLogPay.getAmount().toString());;
				/**银行卡类型*/
				riskBean.setCardType(txnLogPay.getCardtype());;
				/**卡号/账号*/
				riskBean.setCardNo(txnLogPay.getPan());;
				/**转入卡类型*/
				riskBean.setInCardType(null);;
				/**转入银行账号*/
				riskBean.setInCardNo(null);;
				riskBean.setCaCode(txnLogPay.getAccfirmerno());
				ResultBean resultBean = tradeRiskService.agentRiskControl(riskBean);
				resultBean.setResultObj(txnLogPay.getTxnseqno());
				agentRiskList.add(resultBean);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			agentRiskList.clear();
			ResultBean resultBean = new ResultBean("PC037", "系统异常，风控系统异常");
			resultBean.setResultBool(false);
			agentRiskList.add(resultBean);
		} finally {
			tradeBean.setAgentRiskList(agentRiskList);
		}
	}

	
}
