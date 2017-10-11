package com.unionpay.withhold.trade.pay.handle.single;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.pay.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.pay.enums.TradeTxnFlagEnum;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
import com.unionpay.withhold.utils.DateUtil;

@Component("finalFeeHandler")
public class FinalFeeHandler implements EventHandler<TradeBean>{

	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private RspmsgPayService rspmsgPayService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			if(tradeBean.getFinalTrade()!=null) {
				if(!tradeBean.getFinalTrade().isResultBool()) {
					resultBean = tradeBean.getFinalTrade();
					return;
				}
			}
			
			String rspcode = null;
			TxnLogPayDO txnLogPay = tradeBean.getTxnLogPayDO();
			if(!tradeBean.getMerchFee().isResultBool()) {
				rspcode = tradeBean.getMerchFee().getRespCode();
			} else if(!tradeBean.getAgentFee().isResultBool()) {
				rspcode = tradeBean.getAgentFee().getRespCode();
			} else if(!tradeBean.getChnlFee().isResultBool()) {
				rspcode = tradeBean.getChnlFee().getRespCode();
			}
			
			if(StringUtils.isNotEmpty(rspcode)) {
				RspmsgPayDO rspmsgPay = new RspmsgPayDO();
				rspmsgPay.setChnltype(ChnlTypeEnum.TRADECORE.getCode());
				rspmsgPay.setChnlrspcode(rspcode);
				rspmsgPay = rspmsgPayService.getRspmsgPay(rspmsgPay);
				txnLogPay.setAccordfintime(DateUtil.getCurrentDateTime());
				txnLogPay.setRetdatetime(DateUtil.getCurrentDateTime());
				txnLogPay.setAccretcode(rspmsgPay.getRetcode());
				txnLogPay.setAccretinfo(rspmsgPay.getRspinfo());
				txnLogPay.setRetcode(rspmsgPay.getRetcode());
				txnLogPay.setRetinfo(rspmsgPay.getRspinfo());
				txnLogPay.setTradestatflag(TradeStatFlagEnum.ACCFAILED.getStatus());
				txnLogPay.setTradetxnflag(TradeTxnFlagEnum.REALTIME_COLLECT_ACCFAILED.getCode());
			}
			//手续费结果校验
			txnLogPayService.updateTxnLogPay(txnLogPay);
			resultBean = new ResultBean("0000", "成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("0000", "手续费失败");
			resultBean.setResultBool(false);
		}
		tradeBean.setFinalFee(resultBean);
	}

}
