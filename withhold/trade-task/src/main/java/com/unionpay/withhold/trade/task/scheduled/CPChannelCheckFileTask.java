package com.unionpay.withhold.trade.task.scheduled;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import com.unionpay.withhold.service.path.cp.app.CPAccountCheck;
import com.unionpay.withhold.service.path.cp.dto.req.BTAccChkReqDto;
import com.unionpay.withhold.trade.task.pojo.MerchChnlDO;
import com.unionpay.withhold.trade.task.service.MerchChnlService;
import com.unionpay.withhold.trade.task.service.ParaDicService;
import com.unionpay.withhold.utils.DateUtil;  

@Lazy(false)  
@Component  
@EnableScheduling 
public class CPChannelCheckFileTask implements SchedulingConfigurer{

	private static final Logger logger = LoggerFactory.getLogger(CPChannelCheckFileTask.class);
	@Autowired
	private MerchChnlService merchChnlService;
	@Autowired
	private CPAccountCheck cpAccountCheck;
	@Autowired
	private ParaDicService paraDicService;
	private static String cron;  
	
	 public CPChannelCheckFileTask() {  
	        cron = "0 0 15 * * ?";  //默认每天下午15:00，只能使用6位cron表达式，7位会抛异常
	          
	        ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
	        scheduledExecutor.scheduleAtFixedRate(new Runnable() {  
	            @Override  
	            public void run() { 
	            	cron = paraDicService.queryCPPara().getParaCode();
	                logger.info("cron change to: " + cron);  
	            }  
	        }, 0, 1, TimeUnit.HOURS);
	    }  
	
	/**
	 * 实时异步结果通知 
	 * 批量异步结果通知
	 * 获取对账文件地址 
	 * 实时代扣同步状态查询 
	 * 自动下载对账文件
	 */
	public void downloadCPCheckChnlFile() {
		List<MerchChnlDO> cpMerchList = merchChnlService.queryCPMerch();
		String txndate = DateUtil.getSettleDate(-1);
		for(MerchChnlDO merchChnl : cpMerchList) {
			BTAccChkReqDto btAccChkReqDto = new BTAccChkReqDto();
			btAccChkReqDto.setMerId(merchChnl.getChnlmercno());//外部商户号
			btAccChkReqDto.setTradeDate(txndate);//当前日期减1
			cpAccountCheck.downloadAccChkFile(btAccChkReqDto);
		}
	}
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
		taskRegistrar.addTriggerTask(new Runnable() {  
            @Override  
            public void run() {  
                // 任务逻辑  
            	downloadCPCheckChnlFile();
            }  
        }, new Trigger() {  
            @Override  
            public Date nextExecutionTime(TriggerContext triggerContext) {  
                // 任务触发，可修改任务的执行周期  
                CronTrigger trigger = new CronTrigger(cron);  
                Date nextExec = trigger.nextExecutionTime(triggerContext);  
                return nextExec;  
            }  
        });  
	}
	
}
