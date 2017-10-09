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
		ResultBean finalResult = null;
		try {
			OrderCollectSingleDO orderCollectSingleDO = orderCollectSingleService.getOrderinfoByOrderNoAndMerchNo(singleCollectBean.getMchntCd(), singleCollectBean.getOrderId());
			if(orderCollectSingleDO==null){
				finalResult = new ResultBean("0000", "成功");
				return;
			}
			if(orderCollectSingleDO.getTxnamt().longValue()!=Long.valueOf(singleCollectBean.getTransAt()).longValue()){
				logger.info("订单金额:{};数据库订单金额:{}", singleCollectBean.getTransAt(),orderCollectSingleDO.getTxnamt());
				finalResult = new ResultBean("OD015", "二次支付订单交易金额错误");
				finalResult.setResultBool(false);
			}else if(!orderCollectSingleDO.getOrdercommitime().equals(singleCollectBean.getTransTm())){
				logger.info("订单时间:{};数据库订单时间:{}", singleCollectBean.getTransTm(),orderCollectSingleDO.getOrdercommitime());
				finalResult = new ResultBean("OD016", "二次支付订单提交时间错误");
				finalResult.setResultBool(false);
			}else {
				finalResult = new ResultBean("0000", "成功");
				finalResult.setResultObj(orderCollectSingleDO.getTn());
			}
		} catch (Exception e) {
			e.printStackTrace();
			finalResult = new ResultBean("OD046", "系统内部错误");
			finalResult.setResultBool(false);
		}finally {
			singleCollectBean.setFinalResult(finalResult);
		}
		
		
		
	}

}
