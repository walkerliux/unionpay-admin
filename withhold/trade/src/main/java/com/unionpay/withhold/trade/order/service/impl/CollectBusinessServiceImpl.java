package com.unionpay.withhold.trade.order.service.impl;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.batch.handle.BatchMessageCheckHandler;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.service.CollectBusinessService;
import com.unionpay.withhold.trade.order.single.handle.MessageCheckHandler;
@Service
@SuppressWarnings("unchecked")
public class CollectBusinessServiceImpl implements CollectBusinessService {

	private static final Logger  logger = LoggerFactory.getLogger(CollectBusinessServiceImpl.class);
	@Autowired
	private TaskExecutor taskExecutor;
	@Autowired
	@Qualifier("secondPayHandler")
	private EventHandler<SingleCollectBean> secondPayHandler;
	@Autowired
	@Qualifier("repeatSubmitHandler")
	private EventHandler<SingleCollectBean> repeatSubmitHandler;
	@Autowired
	@Qualifier("saveOrderHandler")
	private EventHandler<SingleCollectBean> saveOrderHandler;
	@Autowired
	@Qualifier("saveTxnlogHandler")
	private EventHandler<SingleCollectBean> saveTxnlogHandler;
	@Autowired
	@Qualifier("busiCheckHandler")
	private EventHandler<SingleCollectBean> busiCheckHandler;
	@Autowired
	@Qualifier("merchCheckHandler")
	private EventHandler<SingleCollectBean> merchCheckHandler;
	@Autowired
	@Qualifier("finalEndSingleHandler")
	private EventHandler<SingleCollectBean> finalEndSingleHandler;
	
	
	@Autowired
	@Qualifier("batchRepeatSubmitHandler")
	private EventHandler<BatchCollectBean> batchRepeatSubmitHandler;
	@Autowired
	@Qualifier("saveBatchHandler")
	private EventHandler<BatchCollectBean> saveBatchHandler;
	@Autowired
	@Qualifier("batchBusinessCheckHandler")
	private EventHandler<BatchCollectBean> batchBusinessCheckHandler;
	@Autowired
	@Qualifier("batchMerchCheckHandler")
	private EventHandler<BatchCollectBean> batchMerchCheckHandler;
	@Autowired
	@Qualifier("saveDetaHandler")
	private EventHandler<BatchCollectBean> saveDetaHandler;
	@Autowired
	@Qualifier("saveDetaTxnlogHandler")
	private EventHandler<BatchCollectBean> saveDetaTxnlogHandler;
	@Autowired
	@Qualifier("finalEndBatchHandler")
	private EventHandler<BatchCollectBean> finalEndBatchHandler;
	
	
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
		//ExecutorService executorService = Executors.newCachedThreadPool();
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
        disruptor.after(messageCheckHandler).handleEventsWith(busiCheckHandler);
        disruptor.after(busiCheckHandler).handleEventsWith(merchCheckHandler);
        disruptor.after(repeatSubmitHandler).handleEventsWith(saveOrderHandler);
        disruptor.after(saveOrderHandler).handleEventsWith(saveTxnlogHandler);
        disruptor.after(saveTxnlogHandler,merchCheckHandler).handleEventsWith(finalEndSingleHandler);
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
						//logger.info("EventTranslator");
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
        logger.info(JSON.toJSONString(singleCollectBean));
        if(singleCollectBean.getFinalResult().isResultBool()) {
        	resultBean = new ResultBean(singleCollectBean.getTn());
        }else {
        	resultBean = singleCollectBean.getFinalResult();
        }
		return resultBean;
	}
	@Override
	public ResultBean createBatchCollectOrder(final BatchCollectBean batchCollectBean) {
		ResultBean resultBean = null;
        int bufferSize=2048;
        final Disruptor<BatchCollectBean> disruptor = new Disruptor<BatchCollectBean>(new EventFactory<BatchCollectBean>() {
			@Override
			public BatchCollectBean newInstance() {
				return batchCollectBean;
			}
		}, bufferSize, taskExecutor, ProducerType.SINGLE, new BusySpinWaitStrategy());
        BatchMessageCheckHandler messageCheckHandler = new BatchMessageCheckHandler();
        disruptor.handleEventsWith(batchRepeatSubmitHandler);
        disruptor.after(batchRepeatSubmitHandler).handleEventsWith(messageCheckHandler,saveBatchHandler);
        disruptor.after(messageCheckHandler).handleEventsWith(batchBusinessCheckHandler);
        disruptor.after(batchBusinessCheckHandler).handleEventsWith(batchMerchCheckHandler);
        disruptor.after(saveBatchHandler).handleEventsWith(saveDetaHandler,saveDetaTxnlogHandler);
        disruptor.after(saveDetaHandler,saveDetaTxnlogHandler,batchMerchCheckHandler).handleEventsWith(finalEndBatchHandler);
        disruptor.start();//启动  
        final CountDownLatch latch=new CountDownLatch(1); 
        //生产者准备 
       
        taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disruptor.publishEvent(new EventTranslator<BatchCollectBean>() {
					@Override
					public void translateTo(BatchCollectBean batchCollectBean, long sequence) {
						//logger.info("EventTranslator");
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
        logger.info(JSON.toJSONString(batchCollectBean));
        if(batchCollectBean.getFinalResult().isResultBool()) {
        	resultBean = new ResultBean(batchCollectBean.getTn());
        }else {
        	resultBean = batchCollectBean.getFinalResult();
        }
		return resultBean;
	}
	
	
}
