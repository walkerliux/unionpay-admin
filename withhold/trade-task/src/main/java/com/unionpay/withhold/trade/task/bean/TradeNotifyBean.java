package com.unionpay.withhold.trade.task.bean;

import java.util.List;

import com.unionpay.withhold.bean.ResultBean;


public class TradeNotifyBean {

	/**异步通知bean集合**/
	private List<NotifyQueueBean> notifyQueueBeanList;

	private List<ResultBean> notifyResultList;
	
	public List<NotifyQueueBean> getNotifyQueueBeanList() {
		return notifyQueueBeanList;
	}

	public void setNotifyQueueBeanList(List<NotifyQueueBean> notifyQueueBeanList) {
		this.notifyQueueBeanList = notifyQueueBeanList;
	}

	public List<ResultBean> getNotifyResultList() {
		return notifyResultList;
	}

	public void setNotifyResultList(List<ResultBean> notifyResultList) {
		this.notifyResultList = notifyResultList;
	}
	
	
}
