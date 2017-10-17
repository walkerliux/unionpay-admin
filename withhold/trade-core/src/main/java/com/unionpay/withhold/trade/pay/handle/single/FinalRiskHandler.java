package com.unionpay.withhold.trade.pay.handle.single;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.RiskLevelEnum;
import com.unionpay.withhold.trade.risk.pojo.RiskListDO;
import com.unionpay.withhold.trade.risk.pojo.RiskTradeLogDO;
import com.unionpay.withhold.trade.risk.service.TradeRiskService;
@Component("finalRiskHandler")
public class FinalRiskHandler implements EventHandler<TradeBean>{

	@Autowired
	private TradeRiskService tradeRiskService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		RiskLevelEnum finalRiskLevel = null;
		ResultBean resultBean = null;
		try {
			if(tradeBean.getFinalTrade()!=null) {
				if(!tradeBean.getFinalTrade().isResultBool()) {
					resultBean = tradeBean.getFinalTrade();
					return;
				}
			}
			if(!tradeBean.getMerchRisk().isResultBool()) {
				RiskTradeLogDO tradeLog = new RiskTradeLogDO();
				RiskListDO riskStrategy =  (RiskListDO) tradeBean.getMerchRisk().getResultObj();
				RiskLevelEnum riskLevel = RiskLevelEnum.fromValue(Integer.valueOf(tradeBean.getMerchRisk().getSecondObj().toString()));
			    tradeLog.setRiskTradeType(Integer.valueOf(riskStrategy.getOrders()+""));
			    tradeLog.setTxnseqno(tradeBean.getTxnseqno());
			    tradeLog.setOrderno(tradeBean.getTxnLogPayDO().getAccordno());
			    tradeLog.setMerchno(tradeBean.getTxnLogPayDO().getAccsecmerno());
			    //tradeLog.setMerchname(txnsLog.getaccm);
			    tradeLog.setCacode(tradeBean.getTxnLogPayDO().getAccfirmerno());
			    // tradeLog.setSummerchname("");
			    //tradeLog.setMemberi(tradeBean.getTxnLogPayDO().getAccmemberid());
			    tradeLog.setAmount(tradeBean.getTxnLogPayDO().getAmount());
			    tradeLog.setPan(tradeBean.getTxnLogPayDO().getPan()); 
			    
			    tradeLog.setTradeRiskLevel(riskLevel.getRiskLevel());  ;
			    //Map<String, Object> cardMap = txnsLogDAO.getCardInfo(riskBean.getCardNo());
			    tradeLog.setCardIssuerCode(tradeBean.getTxnLogPayDO().getCardinstino()); ;
			    tradeLog.setCardIssuerName(""); ;
			    //tradeLog.setAcqInistCode(tradeBean.getTxnLogPayDO().getAccordinst());
			    tradeLog.setAcqdatetime(tradeBean.getTxnLogPayDO().getAccordcommitime());
			    tradeLog.setBusicode(tradeBean.getBusinessEnum().getCode());
			    tradeLog.setBusitype(tradeBean.getBusinessEnum().getType());
			    tradeLog.setStrategy(riskStrategy.getStrategy());
			    tradeRiskService.saveRiskTradeLog(tradeLog);
			    if(riskLevel==RiskLevelEnum.REFUSE) {
			    	finalRiskLevel=RiskLevelEnum.REFUSE;
			    }
			}
			if(!tradeBean.getAgentRisk().isResultBool()) {
				RiskTradeLogDO tradeLog = new RiskTradeLogDO();
				RiskListDO riskStrategy =  (RiskListDO) tradeBean.getAgentRisk().getResultObj();
				RiskLevelEnum riskLevel = RiskLevelEnum.fromValue(Integer.valueOf(tradeBean.getAgentRisk().getSecondObj().toString()));
			    tradeLog.setRiskTradeType(Integer.valueOf(riskStrategy.getOrders()+""));
			    tradeLog.setTxnseqno(tradeBean.getTxnseqno());
			    tradeLog.setOrderno(tradeBean.getTxnLogPayDO().getAccordno());
			    tradeLog.setMerchno(tradeBean.getTxnLogPayDO().getAccsecmerno());
			    //tradeLog.setMerchname(txnsLog.getaccm);
			    tradeLog.setCacode(tradeBean.getTxnLogPayDO().getAccfirmerno());
			    // tradeLog.setSummerchname("");
			    //tradeLog.setMemberi(tradeBean.getTxnLogPayDO().getAccmemberid());
			    tradeLog.setAmount(tradeBean.getTxnLogPayDO().getAmount());
			    tradeLog.setPan(tradeBean.getTxnLogPayDO().getPan()); 
			    
			    tradeLog.setTradeRiskLevel(riskLevel.getRiskLevel());  ;
			    //Map<String, Object> cardMap = txnsLogDAO.getCardInfo(riskBean.getCardNo());
			    tradeLog.setCardIssuerCode(tradeBean.getTxnLogPayDO().getCardinstino()); ;
			    tradeLog.setCardIssuerName(""); ;
			    //tradeLog.setAcqInistCode(tradeBean.getTxnLogPayDO().getAccordinst());
			    tradeLog.setAcqdatetime(tradeBean.getTxnLogPayDO().getAccordcommitime());
			    tradeLog.setBusicode(tradeBean.getBusinessEnum().getCode());
			    tradeLog.setBusitype(tradeBean.getBusinessEnum().getType());
			    tradeLog.setStrategy(riskStrategy.getStrategy());
			    tradeRiskService.saveRiskTradeLog(tradeLog);
			    if(riskLevel==RiskLevelEnum.REFUSE) {
			    	finalRiskLevel=RiskLevelEnum.REFUSE;
			    }
			}
			if(!tradeBean.getChnlRisk().isResultBool()) {
				RiskTradeLogDO tradeLog = new RiskTradeLogDO();
				RiskListDO riskStrategy =  (RiskListDO) tradeBean.getChnlRisk().getResultObj();
				RiskLevelEnum riskLevel = RiskLevelEnum.fromValue(Integer.valueOf(tradeBean.getChnlRisk().getSecondObj().toString()));
			    tradeLog.setRiskTradeType(Integer.valueOf(riskStrategy.getOrders()+""));
			    tradeLog.setTxnseqno(tradeBean.getTxnseqno());
			    tradeLog.setOrderno(tradeBean.getTxnLogPayDO().getAccordno());
			    tradeLog.setMerchno(tradeBean.getTxnLogPayDO().getAccsecmerno());
			    //tradeLog.setMerchname(txnsLog.getaccm);
			    tradeLog.setCacode(tradeBean.getTxnLogPayDO().getAccfirmerno());
			    // tradeLog.setSummerchname("");
			    //tradeLog.setMemberi(tradeBean.getTxnLogPayDO().getAccmemberid());
			    tradeLog.setAmount(tradeBean.getTxnLogPayDO().getAmount());
			    tradeLog.setPan(tradeBean.getTxnLogPayDO().getPan());
			    tradeLog.setTradeRiskLevel(riskLevel.getRiskLevel());  ;
			    //Map<String, Object> cardMap = txnsLogDAO.getCardInfo(riskBean.getCardNo());
			    tradeLog.setCardIssuerCode(tradeBean.getTxnLogPayDO().getCardinstino()); ;
			    tradeLog.setCardIssuerName(""); ;
			    //tradeLog.setAcqInistCode(tradeBean.getTxnLogPayDO().getAccordinst());
			    tradeLog.setAcqdatetime(tradeBean.getTxnLogPayDO().getAccordcommitime());
			    tradeLog.setBusicode(tradeBean.getBusinessEnum().getCode());
			    tradeLog.setBusitype(tradeBean.getBusinessEnum().getType());
			    tradeLog.setStrategy(riskStrategy.getStrategy());
			    tradeRiskService.saveRiskTradeLog(tradeLog);
			    if(riskLevel==RiskLevelEnum.REFUSE) {
			    	finalRiskLevel=RiskLevelEnum.REFUSE;
			    }
			}
			if(finalRiskLevel == RiskLevelEnum.REFUSE) {
				resultBean = new ResultBean("9999", "交易失败，被风控系统拒绝");
				resultBean.setResultBool(false);
			}else {
				resultBean = new ResultBean("0000", "通过所有风控校验");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("PC037", "系统异常，风控系统异常");
			resultBean.setResultBool(false);
		}finally {
			tradeBean.setFinalRisk(resultBean);
		}
		
	}

}
