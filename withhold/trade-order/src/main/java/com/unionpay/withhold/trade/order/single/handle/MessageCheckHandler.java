package com.unionpay.withhold.trade.order.single.handle;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.utils.ValidateLocator;

/**
 * 实时代扣订单bean数据合法性校验handler
 * @author guojia
 *
 */
public class MessageCheckHandler implements EventHandler<SingleCollectBean>{

	@Override
	public void onEvent(SingleCollectBean singleCollectBean, long sequence, boolean endOfBatch) throws Exception {
		ResultBean resultBean = null;
		try {
			if(!singleCollectBean.getFinalResult().isResultBool()) {
				resultBean = singleCollectBean.getFinalResult();
				return;
			}
			resultBean = ValidateLocator.validateBeans(singleCollectBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("OD046", "系统内部错误");
			resultBean.setResultBool(false);
		}finally {
			singleCollectBean.setMessageCheck(resultBean);
		}
		
	}
	
}
