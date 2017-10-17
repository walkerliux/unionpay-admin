package com.unionpay.withhold.trade.order.batch.handle;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Sets;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectDetaBean;
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
		try {
			OrderCollectBatchDO collectBatchOrder = batchOrderServcie.getCollectBatchOrder(batchCollectBean.getMerId(), batchCollectBean.getBatchNo(), batchCollectBean.getTxnTime().substring(0, 8));
			if (collectBatchOrder != null) {
				OrderStatusEnum orderStatus = OrderStatusEnum.fromValue(collectBatchOrder.getStatus());
				if (OrderStatusEnum.FAILED==orderStatus) {
					resultBean = new ResultBean("OD053", "批次交易成功，请不要重复提交");
					resultBean.setResultBool(false);
				}
				if (OrderStatusEnum.INITIAL==orderStatus) {
					resultBean = new ResultBean("OD058", "批次号重复");
					resultBean.setResultBool(false);
				}
				if (OrderStatusEnum.PAYING==orderStatus) {
					resultBean = new ResultBean("OD054", "批次正在交易中，请不要重复提交");
					resultBean.setResultBool(false);
				}
				if (OrderStatusEnum.FAILED==orderStatus) {
					resultBean = new ResultBean("OD054", "批次交易失败，请不要重复提交");
					resultBean.setResultBool(false);
				}
				if (OrderStatusEnum.EXPIRE==orderStatus) {
					resultBean = new ResultBean("OD055", "批次失效");
					resultBean.setResultBool(false);
				}
			}else {
				List<BatchCollectDetaBean> detaList = batchCollectBean.getDetaList();
				Set<BatchCollectDetaBean> repeatSet = Sets.newHashSet();
				repeatSet.addAll(detaList);
				if(detaList.size() != repeatSet.size()) {
					resultBean = new ResultBean("OD058", "批次明细订单号重复");
					resultBean.setResultBool(false);
				}else {
					//检查批次明细内订单号是否重复
					resultBean = new ResultBean("0000", "成功");
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("OD046", "系统内部错误");
			resultBean.setResultBool(false);
		}finally {
			batchCollectBean.setRepeatSubmitCheck(resultBean);
		}
		
	}

}
