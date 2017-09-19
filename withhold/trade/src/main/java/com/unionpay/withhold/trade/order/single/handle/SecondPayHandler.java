package com.unionpay.withhold.trade.order.single.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
@Component("secondPayHandler")
public class SecondPayHandler implements EventHandler<SingleCollectBean>{

	private Logger logger = LoggerFactory.getLogger(SecondPayHandler.class);
	@Autowired
	private OrderCollectSingleService orderCollectSingleService;
	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		OrderCollectSingleDO orderCollectSingleDO = orderCollectSingleService.getOrderinfoByOrderNoAndMerchNo(singleCollectBean.getMchntCd(), singleCollectBean.getOrderId());
		if(orderCollectSingleDO==null){
			return;
		}
		if(orderCollectSingleDO.getTxnamt().longValue()!=Long.valueOf(singleCollectBean.getTransAt()).longValue()){
			logger.info("订单金额:{};数据库订单金额:{}", singleCollectBean.getTransAt(),orderCollectSingleDO.getTxnamt());
			
		}
		
		if(!orderCollectSingleDO.getOrdercommitime().equals(singleCollectBean.getTransTm())){
			logger.info("订单时间:{};数据库订单时间:{}", singleCollectBean.getTransTm(),orderCollectSingleDO.getOrdercommitime());
			
		}
		ResultBean finalResult = new ResultBean("0000", "成功");
		finalResult.setResultObj(orderCollectSingleDO.getTn());
		singleCollectBean.setFinalResult(finalResult);
		
		
	}

}
