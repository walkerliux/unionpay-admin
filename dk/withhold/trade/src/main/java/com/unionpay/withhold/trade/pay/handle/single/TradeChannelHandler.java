package com.unionpay.withhold.trade.pay.handle.single;



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
@Component("tradeChannelHandler")
public class TradeChannelHandler implements EventHandler<TradeBean>{
	
	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private RspmsgPayService rspmsgPayService;
	
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		//判断交易是否被风控系统拒绝
		ResultBean finalRisk = tradeBean.getFinalRisk();
		TxnLogPayDO txnLogPay = tradeBean.getTxnLogPayDO();
		if(!finalRisk.isResultBool()) {//被风控系统拒绝
			//更新交易核心应答信息
			RspmsgPayDO record = new RspmsgPayDO();
			record.setChnltype(ChnlTypeEnum.TRADECORE.getCode());
			record.setChnlrspcode(finalRisk.getRespCode());
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
			return ;
		}
		//判断手续费是否计算正常
		ResultBean finalFee = tradeBean.getFinalFee();
		if(!finalFee.isResultBool()) {//计费系统异常
			
			return ;
		}
		
		//校验全部通过
		txnLogPay.setAccretcode("0000");
		txnLogPay.setAccretinfo("受理成功");
		txnLogPayService.updateTxnLogPay(txnLogPay);
		
		if("1000001".equals(tradeBean.getChnlCode())) {
			finalRisk = new ResultBean("0000","交易已受理");
			tradeBean.setFinalTrade(finalRisk);
		}
	}

}
