package com.unionpay.withhold.trade.order.single.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.enums.OrderStatusEnum;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
@Component("repeatSubmitHandler")
public class RepeatSubmitHandler implements EventHandler<SingleCollectBean>{

	//private Logger logger = LoggerFactory.getLogger(SecondPayHandler.class);
	@Autowired
	private OrderCollectSingleService orderCollectSingleService;
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		
		ResultBean repeatSubmit = null;
		try {
			if(!singleCollectBean.getFinalResult().isResultBool()) {
				repeatSubmit = singleCollectBean.getFinalResult();
				return;
			}
			repeatSubmit = null;
			OrderCollectSingleDO orderCollectSingleDO = orderCollectSingleService.getOrderinfoByOrderNoAndMerchNo(singleCollectBean.getMchntCd(), singleCollectBean.getOrderId());
			if (orderCollectSingleDO != null) {
				OrderStatusEnum orderStatus = OrderStatusEnum.fromValue(orderCollectSingleDO.getStatus());
				if (OrderStatusEnum.FINISH==orderStatus) {
					repeatSubmit = new ResultBean();
					repeatSubmit.setErrorResultDto("OD001","订单交易成功，请不要重复支付");
				}
				if (OrderStatusEnum.PAYING==orderStatus) {
					repeatSubmit = new ResultBean();
					repeatSubmit.setErrorResultDto("OD002","订单正在支付中，请不要重复支付");
				}
				if (OrderStatusEnum.EXPIRE==orderStatus) {
					repeatSubmit = new ResultBean();
					repeatSubmit.setErrorResultDto("OD003","订单失效");
				}
				if (OrderStatusEnum.INITIAL==orderStatus) {
					repeatSubmit = new ResultBean();
					repeatSubmit.setErrorResultDto("OD060","订单号重复");
				}
				if(repeatSubmit != null) {
					singleCollectBean.setFinalResult(repeatSubmit);
					return;
				}
			}
			repeatSubmit = new ResultBean("0000", "成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			repeatSubmit = new ResultBean("OD046", "系统内部错误");
			repeatSubmit.setResultBool(false);
		}finally {
			singleCollectBean.setRepeatSubmit(repeatSubmit);
		}
		
	}

}
