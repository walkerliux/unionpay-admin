package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.dao.OrderCollectSingleDAO;
import com.unionpay.withhold.trade.order.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.pojo.RspmsgDO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
import com.unionpay.withhold.trade.order.service.RspmsgService;
import com.unionpay.withhold.trade.order.service.TxnLogService;
import com.unionpay.withhold.trade.pay.dao.OrderCollectSinglePayDAO;
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
		TxnLogDO txnLog = new TxnLogDO();
		txnLog.setTxnseqno(singleCollectBean.getTxnseqno());
		if(singleCollectBean.getFinalResult()==null) {
			//非空校验结果
			if(!singleCollectBean.getMessageCheck().isResultBool()) {
				
			}
			//业务校验结果
			if(!singleCollectBean.getBusiCheck().isResultBool()) {
				
			}
			//商户校验结果
			if(!singleCollectBean.getMerchCheck().isResultBool()) {
				
			}
			//二次提交校验结果
			if(!singleCollectBean.getRepeatSubmit().isResultBool()) {
				
			}
			//保存实时订单结果
			if(!singleCollectBean.getSaveOrder().isResultBool()) {
				
			}
			//保存核心流水结果
			if(!singleCollectBean.getSaveTxnLog().isResultBool()) {
				
			}
			ResultBean resultBean = null;
			resultBean = new ResultBean("0000", "成功");
			singleCollectBean.setFinalResult(resultBean);
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
			
			txnLogService.updateTxnLog(txnLog);
			OrderCollectSingleDO orderCollectSingle = new OrderCollectSingleDO();
			
			orderCollectSingleService.updateOrderCollectSingle(orderCollectSingle);
		}
		
	}

}
