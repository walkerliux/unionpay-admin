package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.order.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.enums.TradeStatFlagEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;
import com.unionpay.withhold.trade.order.pojo.RspmsgDO;
import com.unionpay.withhold.trade.order.pojo.TxnLogDO;
import com.unionpay.withhold.trade.order.service.BatchOrderServcie;
import com.unionpay.withhold.trade.order.service.OrderCollectDetaService;
import com.unionpay.withhold.trade.order.service.RspmsgService;
import com.unionpay.withhold.trade.order.service.TxnLogService;
import com.unionpay.withhold.utils.DateUtil;

@Component("finalEndBatchHandler")
public class FinalEndBatchHandler implements EventHandler<BatchCollectBean> {
	
	@Autowired
	private RspmsgService rspmsgService;
	@Autowired
	private BatchOrderServcie batchOrderServcie;
	@Autowired
	private OrderCollectDetaService orderCollectDetaService;
	@Autowired
	private TxnLogService txnLogService;
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			String rspCode = null;
			// 非空校验结果
			if (!batchCollectBean.getBatchMessageCheck().isResultBool()) {
				rspCode = batchCollectBean.getBatchMessageCheck().getRespCode();
			}
			// 业务校验结果
			if (!batchCollectBean.getBusinessCheck().isResultBool()) {
				rspCode = batchCollectBean.getBusinessCheck().getRespCode();
			}
			// 商户校验结果
			if (!batchCollectBean.getMerchCheck().isResultBool()) {
				rspCode = batchCollectBean.getMerchCheck().getRespCode();
			}
			// 二次提交校验结果
			if (!batchCollectBean.getRepeatSubmitCheck().isResultBool()) {
				rspCode = batchCollectBean.getRepeatSubmitCheck().getRespCode();
			}
			// 保存实时订单结果
			if (!batchCollectBean.getSaveBatch().isResultBool()) {
				rspCode = batchCollectBean.getSaveBatch().getRespCode();
			}
			// 保存核心流水结果
			if (!batchCollectBean.getSaveDetaTxnlog().isResultBool()) {
				rspCode = batchCollectBean.getSaveDetaTxnlog().getRespCode();
			}
			if(StringUtils.isNotEmpty(rspCode)) {
				RspmsgDO rspmsg = new RspmsgDO();
				rspmsg.setChnltype(ChnlTypeEnum.TRADEORDER.getCode());
				rspmsg.setChnlrspcode(rspCode);
				rspmsg = rspmsgService.getRspmsg(rspmsg);
				if(rspmsg==null) {
					rspmsg = new RspmsgDO();
					rspmsg.setRetcode("3999");
					rspmsg.setRspinfo("交易失败");
					rspmsg.setApicode("3999");
					rspmsg.setApiinfo("交易失败");
				}
				//更新批次状态
				OrderCollectBatchDO orderCollectBatch = new OrderCollectBatchDO();
				orderCollectBatch.setTn(batchCollectBean.getTn());
				orderCollectBatch.setStatus(OrderStatusEnum.FAILED.getCode());
				orderCollectBatch.setOrderfinshtime(DateUtil.getCurrentDateTime());
				batchOrderServcie.updateOrderCollectBatch(orderCollectBatch);
				//更新明细状态
				orderCollectDetaService.updateCollectOrderDeta(batchCollectBean.getTn());
				//更新交易流水
				List<TxnLogDO> txnLogList = Lists.newArrayList();
				List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
				for(BatchCollectDetaBean detaBean : detaList) {
		        	TxnLogDO txnLog = new TxnLogDO();
		        	txnLog.setAccretcode(rspmsg.getRetcode());
					txnLog.setAccretinfo(rspmsg.getRspinfo());
					txnLog.setRetcode(rspmsg.getRetcode());
					txnLog.setRetinfo(rspmsg.getRspinfo());
					txnLog.setAccordfintime(DateUtil.getCurrentDateTime());
					txnLog.setRetdatetime(DateUtil.getCurrentDateTime());
					txnLog.setTradestatflag(TradeStatFlagEnum.ACCFAILED.getStatus());
		        	txnLogList.add(txnLog);
				}
				txnLogService.batchUpdateTxnLog(txnLogList);
				resultBean = new ResultBean(rspmsg.getApicode(), rspmsg.getApiinfo());
				resultBean.setResultBool(false);
			}else {
				resultBean = new ResultBean("0000", "成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("3999", "交易失败");
			resultBean.setResultBool(false);
		} finally {
			batchCollectBean.setFinalResult(resultBean);
		}

	}

}
