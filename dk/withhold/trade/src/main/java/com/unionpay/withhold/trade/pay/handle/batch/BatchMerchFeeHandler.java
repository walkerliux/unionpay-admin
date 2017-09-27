package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.fee.bean.FeeBean;
import com.unionpay.withhold.trade.fee.service.FeeService;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;

@Component("merchFeeHandler")
public class BatchMerchFeeHandler implements EventHandler<TradeBean>{

	@Autowired
	private FeeService feeService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		List<ResultBean> merchFeeList = Lists.newArrayList();
		try {
			for(TxnLogPayDO txnLogPay : tradeBean.getTxnLogList()) {
				FeeBean feeBean = new FeeBean();
				feeBean.setTxnseqno(txnLogPay.getTxnseqno());
				//扣率版本，
				feeBean.setFeeVer(null);
				//业务类型，
				feeBean.setBusiCode(tradeBean.getBusinessEnum().getCode());
				//交易金额，
				feeBean.setTxnAmt(txnLogPay.getAmount().toString());
				//会员号，
				feeBean.setMerchNo(txnLogPay.getAccsecmerno());
				//原交易序列号，
				feeBean.setTxnseqnoOg(null);
				//卡类型 
				feeBean.setCardType(tradeBean.getTxnLogPayDO().getCardtype());
				Long merchFee = feeService.getMerchFee(feeBean);
				tradeBean.getTxnLogPayDO().setTxnfee(merchFee);
				ResultBean resultBean = new ResultBean("0000","成功");
				resultBean.setResultObj(txnLogPay.getTxnseqno());
				merchFeeList.add(resultBean);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			merchFeeList.clear();
			ResultBean resultBean = new ResultBean("0099","手续费计算失败");
			resultBean.setResultBool(false);
			merchFeeList.add(resultBean);
		}finally {
			tradeBean.setMerchFeeList(merchFeeList);
		}
		
	}

}
