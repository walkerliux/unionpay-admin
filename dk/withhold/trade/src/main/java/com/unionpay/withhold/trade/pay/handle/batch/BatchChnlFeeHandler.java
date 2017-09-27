package com.unionpay.withhold.trade.pay.handle.batch;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.fee.bean.FeeBean;
import com.unionpay.withhold.trade.fee.service.FeeService;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;

@Component("chnlFeeHandler")
public class BatchChnlFeeHandler  implements EventHandler<TradeBean>{
	
	@Autowired
	private FeeService feeService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		List<ResultBean> chnlFeeList = Lists.newArrayList();
		try {
			if(StringUtils.isEmpty(tradeBean.getChnlCode())) {
				resultBean = new ResultBean("PC010","无可用交易渠道");
				resultBean.setResultBool(false);
				chnlFeeList.add(resultBean);
			}else {
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
					feeBean.setMerchNo(tradeBean.getChnlCode());
					//原交易序列号，
					feeBean.setTxnseqnoOg(null);
					//卡类型 
					feeBean.setCardType(txnLogPay.getCardtype());
					Long merchFee = feeService.getAisleFee(feeBean);
					txnLogPay.setChnlfee(merchFee.toString());
					ResultBean feeResultBean = new ResultBean("0000", "成功");
					feeResultBean.setResultObj(txnLogPay.getTxnseqno());
					chnlFeeList.add(feeResultBean);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			chnlFeeList.clear();
			resultBean = new ResultBean("PC036","系统异常，手续费计算失败");
			resultBean.setResultBool(false);
			chnlFeeList.add(resultBean);
		}finally {
			tradeBean.setChnlFeeList(chnlFeeList);
		}
		
	}

}
