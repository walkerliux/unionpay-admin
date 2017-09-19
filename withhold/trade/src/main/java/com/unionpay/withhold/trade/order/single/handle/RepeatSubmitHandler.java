package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
@Component("repeatSubmitHandler")
public class RepeatSubmitHandler implements EventHandler<SingleCollectBean>{

	//private Logger logger = LoggerFactory.getLogger(SecondPayHandler.class);
	@Autowired
	private OrderCollectSingleService orderCollectSingleService;
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		if(singleCollectBean.getFinalResult().isResultBool()) {
			return;
		}
		ResultBean repeatSubmit = null;
		OrderCollectSingleDO orderCollectSingleDO = orderCollectSingleService.getOrderinfoByOrderNoAndMerchNo(singleCollectBean.getMchntCd(), singleCollectBean.getOrderId());
		if (orderCollectSingleDO != null) {
			if ("00".equals(orderCollectSingleDO.getStatus())) {// 交易成功订单不可二次支付
				repeatSubmit = new ResultBean();
				repeatSubmit.setErrorResultDto("OD001","订单交易成功，请不要重复支付");
			}
			if ("02".equals(orderCollectSingleDO.getStatus())) {
				repeatSubmit = new ResultBean();
				repeatSubmit.setErrorResultDto("OD002","订单正在支付中，请不要重复支付");
			}
			if ("04".equals(orderCollectSingleDO.getStatus())) {
				repeatSubmit = new ResultBean();
				repeatSubmit.setErrorResultDto("OD003","订单失效");
			}
			if(repeatSubmit != null) {
				singleCollectBean.setRepeatSubmit(repeatSubmit);
				singleCollectBean.setFinalResult(repeatSubmit);
				return;
			}
		}
		repeatSubmit = new ResultBean("0000", "成功");
		singleCollectBean.setRepeatSubmit(repeatSubmit);
	}

}
