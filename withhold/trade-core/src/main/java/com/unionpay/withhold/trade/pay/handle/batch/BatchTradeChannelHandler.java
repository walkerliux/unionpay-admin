package com.unionpay.withhold.trade.pay.handle.batch;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.bean.TradeQueueBean;
import com.unionpay.withhold.service.path.cp.app.CPBatchWithhold;
import com.unionpay.withhold.service.path.cp.dto.req.BTWithholdQryReqDto;
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.ChnlTypeEnum;
import com.unionpay.withhold.trade.pay.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.pay.enums.TradeChannelEnum;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectBatchPayDO;
import com.unionpay.withhold.trade.pay.pojo.OrderCollectDetaPayDO;
import com.unionpay.withhold.trade.pay.pojo.RspmsgPayDO;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.pay.service.BatchOrderPayServcie;
import com.unionpay.withhold.trade.pay.service.OrderCollectDetaPayService;
import com.unionpay.withhold.trade.pay.service.RspmsgPayService;
import com.unionpay.withhold.trade.pay.service.TradeQueueService;
import com.unionpay.withhold.trade.pay.service.TxnLogPayService;
import com.unionpay.withhold.utils.BeanCopyUtil;
import com.unionpay.withhold.utils.DateUtil;
@Component("batchTradeChannelHandler")
public class BatchTradeChannelHandler implements EventHandler<TradeBean>{
	@Autowired
	private TradeQueueService tradeQueueService;
	@Autowired
	private RspmsgPayService rspmsgPayService;
	@Autowired
	private TxnLogPayService txnLogPayService;
	@Autowired
	private OrderCollectDetaPayService orderCollectDetaPayService;
	@Autowired
	private BatchOrderPayServcie batchOrderPayServcie;
	@Autowired
	private CPBatchWithhold cpBatchWithhold;
	@Override
	public void onEvent(TradeBean tradeBean, long sequence, boolean endOfBatch) throws Exception {
		//判断交易是否被风控系统拒绝
		ResultBean finalTrade = null;
		try {
			List<TxnLogPayDO> batchDetaTxnLogList = txnLogPayService.queryBatchDetaTxnLog(tradeBean.getCollectBatchOrder().getTid());
			if(batchDetaTxnLogList.size()<=0) {
				OrderCollectBatchPayDO collectBatchOrder = tradeBean.getCollectBatchOrder();
				collectBatchOrder.setStatus(OrderStatusEnum.FINISH.getCode());
				collectBatchOrder.setOrderfinshtime(DateUtil.getCurrentDateTime());
				batchOrderPayServcie.updateCollectBatchOrder(collectBatchOrder);
				finalTrade = new ResultBean("PC000", "交易已受理，请稍后查询结果");
				RspmsgPayDO rspmsgPay = new RspmsgPayDO();
				rspmsgPay.setChnltype(ChnlTypeEnum.CHINAPAY.getCode());
				rspmsgPay.setChnlrspcode(finalTrade.getRespCode());
				finalTrade = new ResultBean(rspmsgPay.getApicode(), rspmsgPay.getApiinfo());
			}else {
				for(TxnLogPayDO txnLogPay : batchDetaTxnLogList) {
					//校验全部通过
					txnLogPay.setAccretcode("0000");
					txnLogPay.setAccretinfo("受理成功");
					txnLogPayService.updateTxnLogPay(txnLogPay);
					//更新批次明细状态
					OrderCollectDetaPayDO orderCollectDetaPay = new  OrderCollectDetaPayDO();
					orderCollectDetaPay.setStatus(OrderStatusEnum.PAYING.getCode());
					orderCollectDetaPay.setRelatetradetxn(txnLogPay.getTxnseqno());
					orderCollectDetaPayService.updateOrderStatus(orderCollectDetaPay);
				}
				//放入交易队列中
				TradeQueueBean tradeQueueBean = new TradeQueueBean();
				tradeQueueBean.setTxnseqno(tradeBean.getTn());
				tradeQueueBean.setBusiType(tradeBean.getBusinessEnum().getType());
				tradeQueueBean.setChannelCode(tradeBean.getChnlCode());
				tradeQueueBean.setTxnDateTime(tradeBean.getCollectBatchOrder().getOrdercommitime());
				tradeQueueService.addBatchTradeQueue(tradeQueueBean);
				TradeChannelEnum tradeChannel = TradeChannelEnum.fromValue(tradeBean.getChnlCode());
				switch (tradeChannel) {
					case CHINAPAY_BATCH:
						BTWithholdQryReqDto btWithholdQryReqDto = new BTWithholdQryReqDto(tradeBean.getTn());
						com.unionpay.withhold.common.bean.ResultBean resultBean = cpBatchWithhold.applyBatchWithhold(btWithholdQryReqDto);
						finalTrade = BeanCopyUtil.copyBean(ResultBean.class, resultBean);
						RspmsgPayDO rspmsgPay = new RspmsgPayDO();
						rspmsgPay.setChnltype(ChnlTypeEnum.CHINAPAY.getCode());
						rspmsgPay.setChnlrspcode(resultBean.getErrCode());
						rspmsgPay = rspmsgPayService.getRspmsgPay(rspmsgPay);
						finalTrade = new ResultBean(rspmsgPay.getApicode(), rspmsgPay.getApiinfo());
						break;
					default:
						finalTrade = new ResultBean("PC010", "交易失败，无可用交易渠道");
						finalTrade.setResultBool(false);
						break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			finalTrade = new ResultBean("PC038", "系统异常，请稍后查询结果");
			finalTrade.setResultBool(false);
		}finally {
			tradeBean.setFinalTrade(finalTrade);
		}
	}

}
