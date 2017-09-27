package com.unionpay.withhold.trade.pay.service.impl;

import java.util.concurrent.CountDownLatch;

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
import com.unionpay.withhold.trade.pay.bean.TradeBean;
import com.unionpay.withhold.trade.pay.enums.BusinessEnum;
import com.unionpay.withhold.trade.pay.service.CollectPayService;
@SuppressWarnings("unchecked")
@Service
public class CollectPayServiceImpl implements CollectPayService{

	@Autowired
	@Qualifier("payTaskExecutor")
	private TaskExecutor taskExecutor;
	///////////////////////实时交易 start/////////////////////////////
	@Autowired
	@Qualifier("tradeCheckHandler")
	private EventHandler<TradeBean> tradeCheckHandler;
	@Autowired
	@Qualifier("merchFeeHandler")
	private EventHandler<TradeBean> merchFeeHandler;
	@Autowired
	@Qualifier("agentFeeHandler")
	private EventHandler<TradeBean> agentFeeHandler;
	@Autowired
	@Qualifier("merchRiskHandler")
	private EventHandler<TradeBean> merchRiskHandler;
	@Autowired
	@Qualifier("agentRiskHandler")
	private EventHandler<TradeBean> agentRiskHandler;
	@Autowired
	@Qualifier("tradeRouteHandler")
	private EventHandler<TradeBean> tradeRouteHandler;
	@Autowired
	@Qualifier("chnlFeeHandler")
	private EventHandler<TradeBean> chnlFeeHandler;
	@Autowired
	@Qualifier("chnlRiskHandler")
	private EventHandler<TradeBean> chnlRiskHandler;
	@Autowired
	@Qualifier("finalFeeHandler")
	private EventHandler<TradeBean> finalFeeHandler;
	@Autowired
	@Qualifier("finalRiskHandler")
	private EventHandler<TradeBean> finalRiskHandler;
	@Autowired
	@Qualifier("tradeChannelHandler")
	private EventHandler<TradeBean> tradeChannelHandler;
	
	///////////////////////实时交易 end/////////////////////////////
	
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
		tradeBean.setBusinessEnum(BusinessEnum.SINGLECOLLECT);
		tradeBean.setTn(tn);
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
		disruptor.after(tradeCheckHandler).handleEventsWith(tradeRouteHandler);
		disruptor.after(tradeRouteHandler).handleEventsWith(merchFeeHandler,agentFeeHandler,chnlFeeHandler,merchRiskHandler,agentRiskHandler,chnlRiskHandler);
		//disruptor.after(tradeCheckHandler).handleEventsWith(merchFeeHandler,agentFeeHandler,merchRiskHandler,agentRiskHandler,tradeRouteHandler);
		//disruptor.after(tradeRouteHandler).handleEventsWith(chnlFeeHandler,chnlRiskHandler);
		//disruptor.after(merchFeeHandler,agentFeeHandler,chnlFeeHandler).handleEventsWith(finalRiskHandler);
		disruptor.after(merchRiskHandler,agentRiskHandler,chnlRiskHandler,merchFeeHandler,agentFeeHandler,chnlFeeHandler).handleEventsWith(finalFeeHandler,finalRiskHandler);
		disruptor.after(finalFeeHandler,finalRiskHandler).handleEventsWith(tradeChannelHandler);
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
		//判断交易是否成功，如果成功则返回，失败从队列中取出下一个渠道代码，调用二次支付方法
		System.out.println(JSON.toJSONString(tradeBean));
		return tradeBean.getFinalTrade();
	}
	
	public ResultBean secondSingleCollectPay(final TradeBean tradeBean) {
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
		disruptor.after(tradeCheckHandler).handleEventsWith(chnlFeeHandler,chnlRiskHandler);
		disruptor.after(chnlFeeHandler).handleEventsWith(finalFeeHandler);
		disruptor.after(chnlRiskHandler).handleEventsWith(finalRiskHandler);
		disruptor.after(finalFeeHandler,finalRiskHandler).handleEventsWith(tradeChannelHandler);
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
