package com.unionpay.withhold.trade.pay.service.impl;

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
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.service.CollectPayService;
@SuppressWarnings("unchecked")
@Service
public class CollectPayServiceImpl implements CollectPayService{

	@Autowired
	private TaskExecutor taskExecutor;
	@Autowired
	@Qualifier("tradeCheckHandler")
	private EventHandler<TradeBean> tradeCheckHandler;
	
	
	
	@Override
	public ResultBean singleCollectPay(String tn) {
		/**
		 * 支付流程说明:
		 * 1.取得核心交易流水信息,检查当前交易状态
		 * 2。计算商户手续费，代理商手续费，商户风控，代理商风控，交易路由
		 * 3.通道手续费，通道风控
		 * 4。保存手续费，保存风险交易
		 * 5。实例化交易渠道
		 */
		final TradeBean tradeBean = new TradeBean();
		ResultBean resultBean = null;
		int bufferSize = 2048;
		final Disruptor<TradeBean> disruptor = new Disruptor<TradeBean>(
				new EventFactory<TradeBean>() {
					@Override
					public TradeBean newInstance() {
						return tradeBean;
					}
				}, bufferSize, taskExecutor, ProducerType.SINGLE, new BusySpinWaitStrategy());
		disruptor.handleEventsWith(tradeCheckHandler);
		
		/*
		disruptor.after(secondPayHandler).handleEventsWith(messageCheckHandler, repeatSubmitHandler);
		disruptor.after(messageCheckHandler).handleEventsWith(busiCheckHandler);
		disruptor.after(busiCheckHandler).handleEventsWith(merchCheckHandler);
		disruptor.after(repeatSubmitHandler).handleEventsWith(saveOrderHandler);
		disruptor.after(saveOrderHandler).handleEventsWith(saveTxnlogHandler);
		disruptor.after(saveTxnlogHandler, merchCheckHandler).handleEventsWith(finalEndSingleHandler);*/
		disruptor.start();// 启动
		final CountDownLatch latch = new CountDownLatch(1);
		// 生产者准备

		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				disruptor.publishEvent(new EventTranslator<TradeBean>() {
					@Override
					public void translateTo(TradeBean tradeBean, long sequence) {
						// logger.info("EventTranslator");
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
		}
		disruptor.shutdown();
		return resultBean;
	}

	@Override
	public ResultBean batchCollectPay(String tn) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
