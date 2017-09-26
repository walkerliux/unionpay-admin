package com.unionpay.withhold.trade.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 
 * @author guojia
 *
 */
@Component
public class MerchantCertTask {

	/**
	 * 每隔一分钟加载一次商户公钥
	 */
	@Scheduled(cron = "0 0/1 * * * ?")
	public void loadCertFile() {
		
	}
}
