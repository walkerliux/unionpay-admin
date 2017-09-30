package com.unionpay.withhold.trade.task.notify.batch.handle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.EventHandler;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.task.bean.NotifyStatusEnum;
import com.unionpay.withhold.trade.task.bean.TradeNotifyBean;
import com.unionpay.withhold.trade.task.dao.TxnsNotifyTaskDAO;
import com.unionpay.withhold.trade.task.pojo.OrderCollectBatchTaskDO;
import com.unionpay.withhold.trade.task.pojo.TxnsNotifyTaskDO;
@Component("batchSaveNotifyLogHandler")
public class BatchSaveNotifyLogHandler implements EventHandler<TradeNotifyBean>{

	@Autowired
	private TxnsNotifyTaskDAO txnsNotifyTaskDAO;
	@Override
	public void onEvent(TradeNotifyBean tradeNotifyBean, long sequence, boolean endOfBatch) throws Exception {
		for(ResultBean resultBean : tradeNotifyBean.getNotifyResultList()) {
			if (resultBean.getSecondObj() instanceof TxnsNotifyTaskDO) {
				TxnsNotifyTaskDO txnsNotifyTask = (TxnsNotifyTaskDO) resultBean.getSecondObj();
				short sendtimes = (short) (txnsNotifyTask.getSendTimes().shortValue()+1);
				txnsNotifyTask.setSendTimes(sendtimes);
				String httpRescode = (String) resultBean.getResultObj();
				txnsNotifyTask.setHttpRescode(httpRescode);
				if(resultBean.isResultBool()) {
					txnsNotifyTask.setSendStatus(NotifyStatusEnum.SUCCESS.value());
				}else {
					if(sendtimes>=txnsNotifyTask.getMaxSendTimes()) {
						txnsNotifyTask.setSendStatus(NotifyStatusEnum.FAILED.value());
					}else {
						txnsNotifyTask.setSendStatus(NotifyStatusEnum.DOING.value());
					}
				}
				txnsNotifyTaskDAO.updateByPrimaryKey(txnsNotifyTask);
			}else if (resultBean.getSecondObj() instanceof OrderCollectBatchTaskDO) {
				OrderCollectBatchTaskDO orderCollectSingle = (OrderCollectBatchTaskDO) resultBean.getSecondObj();
				TxnsNotifyTaskDO txnsNotifyTask = new TxnsNotifyTaskDO();
				txnsNotifyTask.setMemberId(orderCollectSingle.getMerid());
			    txnsNotifyTask.setTxnseqno(orderCollectSingle.getTn());
			    txnsNotifyTask.setSendTimes((short)1);
			    txnsNotifyTask.setMaxSendTimes((short)5);
			    txnsNotifyTask.setNotifyUrl(orderCollectSingle.getBackurl());
			    txnsNotifyTask.setTaskType("1");
			    txnsNotifyTask.setTardeType("02");
			    String httpRescode = (String) resultBean.getResultObj();
			    txnsNotifyTask.setHttpRescode(httpRescode);
				if(resultBean.isResultBool()) {
					txnsNotifyTask.setSendStatus(NotifyStatusEnum.SUCCESS.value());
				}else {
					txnsNotifyTask.setSendStatus(NotifyStatusEnum.DOING.value());
				}
				txnsNotifyTaskDAO.insert(txnsNotifyTask);
			}
			
		}
		
	}

}
