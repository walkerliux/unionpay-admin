package com.unionpay.withhold.trade.task.notify.single.handle;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.bean.enums.TradeQueueEnum;
import com.unionpay.withhold.trade.task.bean.NotifyQueueBean;
import com.unionpay.withhold.trade.task.bean.TradeNotifyBean;
import com.unionpay.withhold.trade.task.pojo.OrderCollectSingleTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnsNotifyTaskDO;
import com.unionpay.withhold.utils.DateUtil;
@Component("pushQueueHandler")
public class PushQueueHandler implements EventHandler<TradeNotifyBean>{
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	
	@Override
	public void onEvent(TradeNotifyBean tradeNotifyBean, long sequence, boolean endOfBatch) throws Exception {
		// TODO Auto-generated method stub
		BoundListOperations<String, String> boundListOps = redisTemplate.boundListOps(TradeQueueEnum.NOTIFYSINGLETRADE.name());
		for(ResultBean resultBean : tradeNotifyBean.getNotifyResultList()) {
			NotifyQueueBean notifyQueueBean = new NotifyQueueBean();
			TxnsNotifyTaskDO txnsNotifyTask = null;
			if (resultBean.getSecondObj() instanceof TxnsNotifyTaskDO) {//再次发送
				txnsNotifyTask = (TxnsNotifyTaskDO) resultBean.getSecondObj();
				
			}else if (resultBean.getSecondObj() instanceof OrderCollectSingleTaskDO) {//首次发送
				txnsNotifyTask = new TxnsNotifyTaskDO();
				txnsNotifyTask.setSendTimes((short)1);
				txnsNotifyTask.setMaxSendTimes((short)5);
			}
			notifyQueueBean = createNotifyQueueBean(txnsNotifyTask);
			boundListOps.leftPush(JSON.toJSONString(notifyQueueBean));
		}
	}
	
	public NotifyQueueBean createNotifyQueueBean(TxnsNotifyTaskDO txnsNotifyTask) {
		int[] timeSpace = new int[] { 0, 60000 * 1, 60000 * 2, 60000 * 4,60000 * 8, 60000 * 16,60000 * 30,60000 * 60};
		if(txnsNotifyTask.getSendTimes()<txnsNotifyTask.getMaxSendTimes()){
			Long sendTime = System.currentTimeMillis() + timeSpace[txnsNotifyTask.getSendTimes()];
			NotifyQueueBean notifyQueueBean = new NotifyQueueBean();
			notifyQueueBean.setTxnseqno(txnsNotifyTask.getTxnseqno());
			notifyQueueBean.setSendTimes(txnsNotifyTask.getSendTimes()+1);
			notifyQueueBean.setSendDateTime(DateUtil.formatDateTime(DateUtil.DEFAULT_DATE_FROMAT, new Date(sendTime)));
			return notifyQueueBean;
		}
		return null;
	}

}
