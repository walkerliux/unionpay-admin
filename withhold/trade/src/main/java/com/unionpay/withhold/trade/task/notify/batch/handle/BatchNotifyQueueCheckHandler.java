package com.unionpay.withhold.trade.task.notify.batch.handle;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.enums.TradeQueueEnum;
import com.unionpay.withhold.trade.task.bean.NotifyQueueBean;
import com.unionpay.withhold.trade.task.bean.TradeNotifyBean;
import com.unionpay.withhold.trade.task.dao.TxnsNotifyTaskDAO;
import com.unionpay.withhold.trade.task.pojo.TxnsNotifyTaskDO;
import com.unionpay.withhold.utils.DateUtil;
@Component("batchNotifyQueueCheckHandler")
public class BatchNotifyQueueCheckHandler implements EventHandler<TradeNotifyBean>{
	private final static Logger log = LoggerFactory.getLogger(BatchNotifyQueueCheckHandler.class);
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Autowired
	private TxnsNotifyTaskDAO txnsNotifyTaskDAO;
	@Override
	public void onEvent(TradeNotifyBean tradeNotifyBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		BoundListOperations<String, String> boundListOps = redisTemplate.boundListOps(TradeQueueEnum.NOTIFYBATCHTRADE.name());
		Long size = boundListOps.size();
		List<NotifyQueueBean> notifyQueueBeanList = Lists.newArrayList();
		for(int i=0;i<size.intValue();i++) {
			String json = boundListOps.rightPop();
			if(StringUtils.isEmpty(json)) {
				continue;
			}
			NotifyQueueBean notifyQueueBean = JSON.parseObject(json, NotifyQueueBean.class);
			if(Long.valueOf(DateUtil.getCurrentDateTime())<Long.valueOf(notifyQueueBean.getSendDateTime())){//没有到通知时间，不发送信息，重回队列
				log.info("【异步通知队列数据,txnseqno:"+notifyQueueBean.getTxnseqno()+"异步通知时间:"+notifyQueueBean.getSendDateTime()+" 未到发送时间】");
				boundListOps.leftPush(JSON.toJSONString(notifyQueueBean));
				continue;
			}
			TxnsNotifyTaskDO txnsNotifyTask = txnsNotifyTaskDAO.queryByTxnseqno(notifyQueueBean.getTn());
			if(txnsNotifyTask!=null) {
				if("00".equals(txnsNotifyTask.getSendStatus())){
					log.info("【异步通知队列数据,txnseqno:"+notifyQueueBean.getTxnseqno()+"异步通知完成】");
					continue;
				}
			}
			notifyQueueBean.setTxnsNotifyTask(txnsNotifyTask);
			notifyQueueBeanList.add(notifyQueueBean);
		}
		tradeNotifyBean.setNotifyQueueBeanList(notifyQueueBeanList);
	}

}
