package com.unionpay.withhold.trade.task;

import org.springframework.scheduling.annotation.Scheduled;
//@Component
public class TradeChannelTask {

	/**
	 * 实时异步结果通知 
	 * 批量异步结果通知
	 * 获取对账文件地址 
	 * 实时代扣同步状态查询 
	 * 自动下载对账文件
	 */
	
	@Scheduled(cron="")
	public void downloadCheckChnlFile() {
		
	}
}
