package com.unionpay.withhold.api.task;

import com.unionpay.withhold.api.common.bean.DkContext;

/**
 * 处理任务基类
 * 
 * @author Luke
 *
 */
public abstract class AbstractTask implements ITask {

	private DkContext context;
	
	public DkContext getContext() {
		return context;
	}

	public void setContext(DkContext context) {
		this.context = context;
	}

	@Override
	public void run() {
		try {
			execute();
		}
		catch(Exception e) {
			// TODO: take it consider
			e.printStackTrace();
		}
	}

	/**
	 * 任务执行入口
	 */
	public abstract void execute() throws Exception;

}
