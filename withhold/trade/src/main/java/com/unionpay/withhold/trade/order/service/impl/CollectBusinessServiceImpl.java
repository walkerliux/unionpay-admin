package com.unionpay.withhold.trade.order.service.impl;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.service.CollectBusinessService;
import com.unionpay.withhold.trade.order.single.handle.MessageCheckHandler;
@Service
@SuppressWarnings("unchecked")
public class CollectBusinessServiceImpl implements CollectBusinessService {

	@Autowired
	private TaskExecutor taskExecutor;
	@Autowired
	@Qualifier("secondPayHandler")
	private EventHandler<SingleCollectBean> secondPayHandler;
	@Autowired
	@Qualifier("repeatSubmitHandler")
	private EventHandler<SingleCollectBean> repeatSubmitHandler;
	@Override
	public ResultBean createSingleCollectOrder(final SingleCollectBean singleCollectBean) {
		/**
		 * 1.检查订单是否为二次支付
		 * 2.检查订单是否为二次提交
		 * 3.检查订单业务有效性
		 * 4.检查商户和合作机构有效性
		 * 5.检查消费订单特殊性要求检查，如果没有可以为空
		 * 6.检查消费订单特殊性要求检查，如果没有可以为空
		 * 7.保存订单信息
		 */
		
		ResultBean resultBean = null;
        int bufferSize=2048;
        final Disruptor<SingleCollectBean> disruptor = new Disruptor<SingleCollectBean>(new EventFactory<SingleCollectBean>() {
			@Override
			public SingleCollectBean newInstance() {
				return singleCollectBean;
			}
		}, bufferSize, taskExecutor, ProducerType.SINGLE, new BusySpinWaitStrategy());
        MessageCheckHandler messageCheckHandler = new MessageCheckHandler();
        disruptor.handleEventsWith(secondPayHandler);
        disruptor.after(secondPayHandler).handleEventsWith(messageCheckHandler,repeatSubmitHandler);
        disruptor.start();//启动  
        final CountDownLatch latch=new CountDownLatch(1); 
        //生产者准备 
       
        taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disruptor.publishEvent(new EventTranslator<SingleCollectBean>() {
					@Override
					public void translateTo(SingleCollectBean singleCollectBean, long sequence) {
						
					}
				});
				latch.countDown();  
			}
		});
        try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//等待生产者完事. 
        disruptor.shutdown();
		return resultBean;
	}
}
