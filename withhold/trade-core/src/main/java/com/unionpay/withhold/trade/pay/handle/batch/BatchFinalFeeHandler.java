package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Maps;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.pay.enums.TradeTxnFlagEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectDetaPayService;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
import com.unionpay.withhold.trade.pay.service.impl.OrderCollectDetaPayServiceImpl;
import com.unionpay.withhold.utils.DateUtil;

@Component("batchFinalFeeHandler")
public class BatchFinalFeeHandler implements EventHandler<TradeBean>{

	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private RspmsgPayService rspmsgPayService;
	@Autowired
	private OrderCollectDetaPayService orderCollectDetaPayService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean finalFeeResultBean = null;
		try {
			Map<String, ResultBean> errorMap = Maps.newHashMap();
			for(ResultBean resultBean : tradeBean.getMerchFeeList()) {
				if(!resultBean.isResultBool()) {
					errorMap.put(resultBean.getResultObj().toString(), resultBean);
				}
			}
			for(ResultBean resultBean : tradeBean.getAgentFeeList()) {
				if(!resultBean.isResultBool()) {
					errorMap.put(resultBean.getResultObj().toString(), resultBean);
				}
			}
			for(ResultBean resultBean : tradeBean.getChnlFeeList()) {
				if(!resultBean.isResultBool()) {
					errorMap.put(resultBean.getResultObj().toString(), resultBean);
				}
			}
			
			for(TxnLogPayDO txnLogPay : tradeBean.getTxnLogList()) {
				if(errorMap.containsKey(txnLogPay.getTxnseqno())) {
					RspmsgPayDO rspmsgPay = new RspmsgPayDO();
					rspmsgPay.setChnltype(ChnlTypeEnum.TRADECORE.getCode());
					rspmsgPay.setChnlrspcode(errorMap.get(txnLogPay.getTxnseqno()).getRespCode());
					rspmsgPay = rspmsgPayService.getRspmsgPay(rspmsgPay);
					txnLogPay.setAccordfintime(DateUtil.getCurrentDateTime());
					txnLogPay.setRetdatetime(DateUtil.getCurrentDateTime());
					txnLogPay.setAccretcode(rspmsgPay.getRetcode());
					txnLogPay.setAccretinfo(rspmsgPay.getRspinfo());
					txnLogPay.setRetcode(rspmsgPay.getRetcode());
					txnLogPay.setRetinfo(rspmsgPay.getRspinfo());
					txnLogPay.setTradestatflag(TradeStatFlagEnum.ACCFAILED.getStatus());
					txnLogPay.setTradetxnflag(TradeTxnFlagEnum.REALTIME_COLLECT_ACCFAILED.getCode());
					//更新订单明细状态
					OrderCollectDetaPayDO orderCollectDetaPay = new  OrderCollectDetaPayDO();
					orderCollectDetaPay.setStatus(OrderStatusEnum.FAILED.getCode());
					orderCollectDetaPay.setRelatetradetxn(txnLogPay.getTxnseqno());
					orderCollectDetaPayService.updateOrderStatus(orderCollectDetaPay);
					txnLogPayService.updateTxnLogPay(txnLogPay);
				}
				
			}
			finalFeeResultBean = new ResultBean("0000", "成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			finalFeeResultBean = new ResultBean("0000", "手续费失败");
			finalFeeResultBean.setResultBool(false);
		}finally {
			tradeBean.setFinalFee(finalFeeResultBean);
		}
	}

}
