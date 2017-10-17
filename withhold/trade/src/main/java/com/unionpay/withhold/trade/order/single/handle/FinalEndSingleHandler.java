package com.unionpay.withhold.trade.order.single.handle;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.pojo.RspmsgDO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
import com.unionpay.withhold.trade.order.service.RspmsgService;
import com.unionpay.withhold.trade.order.service.TxnLogService;
import com.unionpay.withhold.utils.DateUtil;

@Component("finalEndSingleHandler")
public class FinalEndSingleHandler implements EventHandler<SingleCollectBean>{

	@Autowired
	private TxnLogService txnLogService;
	@Autowired
	private OrderCollectSingleService orderCollectSingleService;
	@Autowired
	private RspmsgService rspmsgService;
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		TxnLogDO txnLog = new TxnLogDO();
		txnLog.setTxnseqno(singleCollectBean.getTxnseqno());
		if(singleCollectBean.getFinalResult()==null) {
			String rspCode = null;
			//非空校验结果
			if(!singleCollectBean.getMessageCheck().isResultBool()) {
				rspCode = singleCollectBean.getMessageCheck().getRespCode();
			}
			//业务校验结果
			if(!singleCollectBean.getBusiCheck().isResultBool()) {
				rspCode = singleCollectBean.getBusiCheck().getRespCode();
			}
			//商户校验结果
			if(!singleCollectBean.getMerchCheck().isResultBool()) {
				rspCode = singleCollectBean.getMerchCheck().getRespCode();
			}
			//二次提交校验结果
			if(!singleCollectBean.getRepeatSubmit().isResultBool()) {
				rspCode = singleCollectBean.getRepeatSubmit().getRespCode();
			}
			//保存实时订单结果
			if(!singleCollectBean.getSaveOrder().isResultBool()) {
				rspCode = singleCollectBean.getSaveOrder().getRespCode();
			}
			//保存核心流水结果
			if(!singleCollectBean.getSaveTxnLog().isResultBool()) {
				rspCode = singleCollectBean.getSaveTxnLog().getRespCode();
			}
			if(StringUtils.isNotEmpty(rspCode)) {
				RspmsgDO rspmsg = new RspmsgDO();
				rspmsg.setChnltype(ChnlTypeEnum.TRADEORDER.getCode());
				rspmsg.setChnlrspcode(rspCode);
				rspmsg = rspmsgService.getRspmsg(rspmsg);
				txnLog.setAccretcode(rspmsg.getRetcode());
				txnLog.setAccretinfo(rspmsg.getRspinfo());
				txnLog.setRetcode(rspmsg.getRetcode());
				txnLog.setRetinfo(rspmsg.getRspinfo());
				txnLog.setAccordfintime(DateUtil.getCurrentDateTime());
				txnLog.setRetdatetime(DateUtil.getCurrentDateTime());
				txnLog.setTradestatflag(TradeStatFlagEnum.ACCFAILED.getStatus());
				txnLogService.updateTxnLog(txnLog);
				OrderCollectSingleDO orderCollectSingle = new OrderCollectSingleDO();
				orderCollectSingle.setTn(singleCollectBean.getTn());
				orderCollectSingle.setStatus(OrderStatusEnum.FAILED.getCode());
				orderCollectSingleService.updateOrderCollectSingle(orderCollectSingle);
			}else {
				resultBean = new ResultBean("0000", "成功");
				singleCollectBean.setFinalResult(resultBean);
			}
		}else {
			RspmsgDO rspmsg = new RspmsgDO();
			rspmsg.setChnltype(ChnlTypeEnum.TRADEORDER.getCode());
			rspmsg.setChnlrspcode(singleCollectBean.getFinalResult().getRespCode());
			rspmsg = rspmsgService.getRspmsg(rspmsg);
			txnLog.setAccretcode(rspmsg.getRetcode());
			txnLog.setAccretinfo(rspmsg.getRspinfo());
			txnLog.setRetcode(rspmsg.getRetcode());
			txnLog.setRetinfo(rspmsg.getRspinfo());
			txnLog.setAccordfintime(DateUtil.getCurrentDateTime());
			txnLog.setRetdatetime(DateUtil.getCurrentDateTime());
			txnLog.setTradestatflag(TradeStatFlagEnum.ACCFAILED.getStatus());
			txnLogService.updateTxnLog(txnLog);
			OrderCollectSingleDO orderCollectSingle = new OrderCollectSingleDO();
			orderCollectSingle.setTn(singleCollectBean.getTn());
			orderCollectSingle.setStatus(OrderStatusEnum.FAILED.getCode());
			orderCollectSingleService.updateOrderCollectSingle(orderCollectSingle);
		}
		
	}

}
