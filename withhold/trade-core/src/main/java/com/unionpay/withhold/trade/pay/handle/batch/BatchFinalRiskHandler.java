package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.enums.RiskLevelEnum;
import com.unionpay.withhold.trade.pay.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.pay.enums.TradeTxnFlagEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectDetaPayService;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
import com.unionpay.withhold.trade.risk.pojo.RiskListDO;
import com.unionpay.withhold.trade.risk.pojo.RiskTradeLogDO;
import com.unionpay.withhold.trade.risk.service.TradeRiskService;
import com.unionpay.withhold.utils.DateUtil;
@Component("batchFinalRiskHandler")
public class BatchFinalRiskHandler implements EventHandler<TradeBean>{

	@Autowired
	private TradeRiskService tradeRiskService;
	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private RspmsgPayService rspmsgPayService;
	@Autowired
	private OrderCollectDetaPayService orderCollectDetaPayService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		List<ResultBean> finalRiskList = Lists.newArrayList();
		
		try {
			Map<String, ResultBean> errorMap = Maps.newHashMap();
			List<TxnLogPayDO> removeList = Lists.newArrayList();
			for (ResultBean resultBean : tradeBean.getMerchRiskList()) {
				if (!resultBean.isResultBool()) {
					errorMap.put(resultBean.getResultObj().toString(), resultBean);
				}
			}
			for (ResultBean resultBean : tradeBean.getAgentRiskList()) {
				if (!resultBean.isResultBool()) {
					errorMap.put(resultBean.getResultObj().toString(), resultBean);
				}
			}
			for (ResultBean resultBean : tradeBean.getChnlRiskList()) {
				if (!resultBean.isResultBool()) {
					errorMap.put(resultBean.getResultObj().toString(), resultBean);
				}
			}
			for (Map.Entry<String, ResultBean> entry : errorMap.entrySet()) {
				TxnLogPayDO txnLogPay = txnLogPayService.queryTxnLog(entry.getKey());
				RiskTradeLogDO tradeLog = new RiskTradeLogDO();
				RiskListDO riskStrategy = (RiskListDO) entry.getValue().getResultObj();
				RiskLevelEnum riskLevel = RiskLevelEnum
						.fromValue(Integer.valueOf(entry.getValue().getSecondObj().toString()));
				tradeLog.setRiskTradeType(Integer.valueOf(riskStrategy.getOrders() + ""));
				tradeLog.setTxnseqno(txnLogPay.getTxnseqno());
				tradeLog.setOrderno(txnLogPay.getAccordno());
				tradeLog.setMerchno(txnLogPay.getAccsecmerno());
				//tradeLog.setMerchname(txnsLog.getaccm);
				tradeLog.setCacode(txnLogPay.getAccfirmerno());
				// tradeLog.setSummerchname("");
				//tradeLog.setMemberi(txnLogPay.getAccmemberid());
				tradeLog.setAmount(txnLogPay.getAmount());
				tradeLog.setPan(txnLogPay.getPan());
				tradeLog.setTradeRiskLevel(riskLevel.getRiskLevel());
				//Map<String, Object> cardMap = txnsLogDAO.getCardInfo(riskBean.getCardNo());
				tradeLog.setCardIssuerCode(txnLogPay.getCardinstino());
				tradeLog.setCardIssuerName("");
				//tradeLog.setAcqInistCode(txnLogPay.getAccordinst());
				tradeLog.setAcqdatetime(txnLogPay.getAccordcommitime());
				tradeLog.setBusicode(tradeBean.getBusinessEnum().getCode());
				tradeLog.setBusitype(tradeBean.getBusinessEnum().getType());
				tradeLog.setStrategy(riskStrategy.getStrategy());
				tradeRiskService.saveRiskTradeLog(tradeLog);
				
				//
				
				ResultBean resultBean = null;
				if (riskLevel == RiskLevelEnum.REFUSE) {
					RspmsgPayDO record = new RspmsgPayDO();
					record.setChnltype(ChnlTypeEnum.TRADECORE.getCode());
					record.setChnlrspcode("PC012");
					record = rspmsgPayService.getRspmsgPay(record);
					txnLogPay.setAccordfintime(DateUtil.getCurrentDateTime());
					txnLogPay.setRetdatetime(DateUtil.getCurrentDateTime());
					txnLogPay.setAccretcode(record.getRetcode());
					txnLogPay.setAccretinfo(record.getRspinfo());
					txnLogPay.setRetcode(record.getRetcode());
					txnLogPay.setRetinfo(record.getRspinfo());
					txnLogPay.setTradestatflag(TradeStatFlagEnum.ACCFAILED.getStatus());
					txnLogPay.setTradetxnflag(TradeTxnFlagEnum.REALTIME_COLLECT_ACCFAILED.getCode());
					txnLogPayService.updateTxnLogPay(txnLogPay);
					//被拒交易需更新为交易失败
					OrderCollectDetaPayDO orderCollectDetaPay = new  OrderCollectDetaPayDO();
					orderCollectDetaPay.setStatus(OrderStatusEnum.FAILED.getCode());
					orderCollectDetaPay.setRelatetradetxn(txnLogPay.getTxnseqno());
					orderCollectDetaPayService.updateOrderStatus(orderCollectDetaPay);
					resultBean = new ResultBean("9999", "交易失败，被风控系统拒绝");
					resultBean.setResultBool(false);
					removeList.add(txnLogPay);
				} else {
					resultBean = new ResultBean("0000", "通过所有风控校验");
				}
				finalRiskList.add(resultBean);
				//tradeBean.getTxnLogList().removeAll(removeList);
			} 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			finalRiskList.clear();
			ResultBean resultBean = new ResultBean("TR001", "风控系统异常");
			resultBean.setResultBool(false);
			finalRiskList.add(resultBean);
		}finally {
			tradeBean.setFinalRiskList(finalRiskList);
		}
		
	}

}
