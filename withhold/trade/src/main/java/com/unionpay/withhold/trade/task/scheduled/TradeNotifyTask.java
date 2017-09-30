package com.unionpay.withhold.trade.task.scheduled;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.unionpay.withhold.trade.task.bean.TradeNotifyBean;

@SuppressWarnings("unchecked")
@Component
public class TradeNotifyTask {
	@Autowired
	@Qualifier("singleNotifyTaskExecutor")
	private TaskExecutor singleNotifyTaskExecutor;
	@Autowired
	@Qualifier("batchNotifyTaskExecutor")
	private TaskExecutor batchNotifyTaskExecutor;
	/** 单笔代扣异步通知handler start */
	@Autowired
	@Qualifier("notifyQueueCheckHandler")
	private EventHandler<TradeNotifyBean> notifyQueueCheckHandler;
	@Autowired
	@Qualifier("tradeNotifyHandler")
	private EventHandler<TradeNotifyBean> tradeNotifyHandler;
	@Autowired
	@Qualifier("saveNotifyLogHandler")
	private EventHandler<TradeNotifyBean> saveNotifyLogHandler;
	@Autowired
	@Qualifier("pushQueueHandler")
	private EventHandler<TradeNotifyBean> pushQueueHandler;

	/** 单笔代扣异步通知handler end */
	@Autowired
	@Qualifier("batchNotifyQueueCheckHandler")
	private EventHandler<TradeNotifyBean> batchNotifyQueueCheckHandler;
	@Autowired
	@Qualifier("batchTradeNotifyHandler")
	private EventHandler<TradeNotifyBean> batchTradeNotifyHandler;
	@Autowired
	@Qualifier("batchSaveNotifyLogHandler")
	private EventHandler<TradeNotifyBean> batchSaveNotifyLogHandler;
	@Autowired
	@Qualifier("batchPushQueueHandler")
	private EventHandler<TradeNotifyBean> batchPushQueueHandler;
	
	
	@Scheduled(cron = "")
	public void singleTradeNotify() {
		int bufferSize = 2048;
		final Disruptor<TradeNotifyBean> disruptor = new Disruptor<TradeNotifyBean>(
				new EventFactory<TradeNotifyBean>() {
					@Override
					public TradeNotifyBean newInstance() {
						return new TradeNotifyBean();
					}
				}, bufferSize, singleNotifyTaskExecutor, ProducerType.SINGLE, new BusySpinWaitStrategy());
		try {
			disruptor.handleEventsWith(notifyQueueCheckHandler);
			disruptor.after(notifyQueueCheckHandler).handleEventsWith(tradeNotifyHandler);
			disruptor.after(tradeNotifyHandler).handleEventsWith(saveNotifyLogHandler, pushQueueHandler);
			disruptor.start();// 启动
			final CountDownLatch latch = new CountDownLatch(1);
			// 生产者准备
			singleNotifyTaskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					disruptor.publishEvent(new EventTranslator<TradeNotifyBean>() {
						@Override
						public void translateTo(TradeNotifyBean tradeNotifyBean, long sequence) {
							// logger.info("EventTranslator");
						}
					});
					latch.countDown();
				}
			});
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disruptor.shutdown();
		}

	}

	@Scheduled(cron = "")
	public void batchTradeNotify() {
		int bufferSize = 2048;
		final Disruptor<TradeNotifyBean> disruptor = new Disruptor<TradeNotifyBean>(
				new EventFactory<TradeNotifyBean>() {
					@Override
					public TradeNotifyBean newInstance() {
						return new TradeNotifyBean();
					}
				}, bufferSize, batchNotifyTaskExecutor, ProducerType.SINGLE, new BusySpinWaitStrategy());
		try {
			disruptor.handleEventsWith(batchNotifyQueueCheckHandler);
			disruptor.after(batchNotifyQueueCheckHandler).handleEventsWith(batchTradeNotifyHandler);
			disruptor.after(batchTradeNotifyHandler).handleEventsWith(batchSaveNotifyLogHandler, batchPushQueueHandler);
			disruptor.start();// 启动
			final CountDownLatch latch = new CountDownLatch(1);
			// 生产者准备
			batchNotifyTaskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					disruptor.publishEvent(new EventTranslator<TradeNotifyBean>() {
						@Override
						public void translateTo(TradeNotifyBean tradeNotifyBean, long sequence) {
							// logger.info("EventTranslator");
						}
					});
					latch.countDown();
				}
			});
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			disruptor.shutdown();
		}
	}

}
