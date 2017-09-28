package com.unionpay.withhold.api.task;

import org.apache.log4j.Logger;

/**
 * 异步通知消息机制
 * 
 * @author Luke
 *
 */
public class NotifyTransFlowTask extends AbstractTask implements ITransFlowTask {
	private static final Logger logger = Logger.getLogger(NotifyTransFlowTask.class);
	
	
	
	@Override
	public void execute() throws Exception {
		logger.info("总要执行点什么吧");
	}
}
