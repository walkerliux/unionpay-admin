package com.unionpay.withhold.trade.order.batch.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectBatchDO;
import com.unionpay.withhold.trade.order.service.BatchOrderServcie;

@Component("batchRepeatSubmitHandler")
public class BatchRepeatSubmitHandler implements EventHandler<BatchCollectBean>{

	@Autowired
	private BatchOrderServcie batchOrderServcie;
	@Override
	public void onEvent(BatchCollectBean batchCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		OrderCollectBatchDO collectBatchOrder = batchOrderServcie.getCollectBatchOrder(batchCollectBean.getMerId(), batchCollectBean.getBatchNo(), batchCollectBean.getTxnTime().substring(0, 8));
		if (collectBatchOrder != null) {
			OrderStatusEnum orderStatus = OrderStatusEnum.fromValue(collectBatchOrder.getStatus());
			if (OrderStatusEnum.FAILED==orderStatus) {
				resultBean = new ResultBean("OD053", "批次交易成功，请不要重复提交");
			}
			if (OrderStatusEnum.INITIAL==orderStatus) {
				resultBean = new ResultBean("OD058", "批次号重复");
			}
			if (OrderStatusEnum.PAYING==orderStatus) {
				resultBean = new ResultBean("OD054", "批次正在交易中，请不要重复提交");
			}
			if (OrderStatusEnum.FAILED==orderStatus) {
				resultBean = new ResultBean("OD054", "批次交易失败，请不要重复提交");
			}
			if (OrderStatusEnum.EXPIRE==orderStatus) {
				resultBean = new ResultBean("OD055", "批次失效");
			}
		}else {
			resultBean = new ResultBean("0000", "成功");
		}
		batchCollectBean.setRepeatSubmitCheck(resultBean);
	}

}
