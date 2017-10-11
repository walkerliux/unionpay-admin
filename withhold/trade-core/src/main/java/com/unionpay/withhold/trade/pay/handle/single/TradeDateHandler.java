package com.unionpay.withhold.trade.pay.handle.single;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.bean.TradeQueueBean;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.pay.enums.TradeTxnFlagEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectSinglePayDO;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.OrderCollectSinglePayService;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
import com.unionpay.withhold.trade.pay.service.TradeQueueService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
import com.unionpay.withhold.utils.DateUtil;
@Component("tradeDateHandler")
public class TradeDateHandler implements EventHandler<TradeBean> {

	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private RspmsgPayService rspmsgPayService;
	@Autowired
	private OrderCollectSinglePayService orderCollectSinglePayService;
	@Autowired
	private TradeQueueService tradeQueueService;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		String rspCode = null;
		ResultBean resultBean = null;
		try {
			if(tradeBean.getFinalTrade()!=null) {
				if(!tradeBean.getFinalTrade().isResultBool()) {
					rspCode = tradeBean.getFinalTrade().getRespCode();
				}
			}
			
			if(!tradeBean.getFinalRisk().isResultBool()) {
				rspCode = tradeBean.getFinalRisk().getRespCode();
			}
			if(!tradeBean.getFinalFee().isResultBool()) {
				rspCode = tradeBean.getFinalFee().getRespCode();
			}
			TxnLogPayDO txnLogPay = tradeBean.getTxnLogPayDO();
			if(StringUtils.isNotEmpty(rspCode)) {//被风控系统拒绝
				//更新交易核心应答信息
				RspmsgPayDO record = new RspmsgPayDO();
				record.setChnltype(ChnlTypeEnum.TRADECORE.getCode());
				record.setChnlrspcode(rspCode);
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
				OrderCollectSinglePayDO orderCollectSinglePay = new OrderCollectSinglePayDO();
				orderCollectSinglePay.setRelatetradetxn(txnLogPay.getTxnseqno());
				orderCollectSinglePay.setStatus(OrderStatusEnum.FAILED.getCode());
				//更新代扣订单
				orderCollectSinglePayService.updateSingleCollectOrder(orderCollectSinglePay);
				resultBean = new ResultBean(record.getApicode(), record.getApiinfo());
				resultBean.setResultBool(false);
				return ;
			}
			//校验全部通过
			txnLogPay.setAccretcode("0000");
			txnLogPay.setAccretinfo("受理成功");
			txnLogPayService.updateTxnLogPay(txnLogPay);
			
			//放入交易队列中
			TradeQueueBean tradeQueueBean = new TradeQueueBean();
			tradeQueueBean.setTxnseqno(txnLogPay.getTxnseqno());
			tradeQueueBean.setBusiType(txnLogPay.getBusitype());
			tradeQueueBean.setChannelCode(tradeBean.getChnlCode());
			tradeQueueBean.setTxnDateTime(txnLogPay.getTxndate()+txnLogPay.getTxntime());
			tradeQueueService.addSingleTradeQueue(tradeQueueBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("PC035", "交易失败，系统异常");
			resultBean.setResultBool(false);
		}finally {
			tradeBean.setFinalTrade(resultBean);
		}
	}

}
