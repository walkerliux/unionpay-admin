package com.unionpay.withhold.admin.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
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

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.admin.Bean.FtpBean;
import com.unionpay.withhold.admin.enums.MerchCheckTypeEnums;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TMerchCheckfile;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TParaDic;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSettProcess;
import com.unionpay.withhold.admin.service.CheckBillService;
import com.unionpay.withhold.admin.service.FtpService;
import com.unionpay.withhold.admin.service.MerchDetaService;
import com.unionpay.withhold.admin.service.MerchFileService;
import com.unionpay.withhold.admin.service.ParaDicService;
import com.unionpay.withhold.admin.utils.ConfigParamsExcelHeader;
import com.unionpay.withhold.admin.utils.FTPUtilsForJob;
import com.unionpay.withhold.admin.utils.MapTrans;
import com.unionpay.withhold.admin.utils.excel.ExcelUtil;
import com.unionpay.withhold.utils.DateUtil;

/**
 * 自动对账, 并且自动生成对账文件
 * @author: zhangshd
 * @date:   2017年11月29日 下午3:03:40   
 * @version :v1.0
 */
@Lazy(false)
@Component
@EnableScheduling
public class CheckFileTask implements SchedulingConfigurer {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CheckBillService checkBillService;
	
	@Autowired
	private ConfigParamsExcelHeader config;
	
	@Autowired
	private MerchDetaService merchDetaService;
	
	@Autowired
	private MerchFileService merchFileService;
	
	@Autowired
	private ParaDicService paraDicService;
	@Autowired
	private FtpService ftpService;
	private static String cron;
	public CheckFileTask() {
		cron = "0 0 18 * * ?";
		ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				List<TParaDic> list =paraDicService.selectByTypeAndStatus("CHECKBILL", Short.valueOf("1"));
				if (!CollectionUtils.isEmpty(list)) {
					cron=list.get(0).getParaCode();
				}
				if(StringUtils.isEmpty(cron)) {
					cron = "0 0 18 * * ?";
				}
				logger.info("cron change to: " + cron);
			}
		}, 0, 1, TimeUnit.HOURS);
	}
	private void invoke() {
		String date = DateUtil.getCurrentDate();
		checkbill(date);
		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		checkbillfile(date);
	}

	private void checkbill(String date) {
		//执行任务
		List<TChnlDeta> list = checkBillService.getAllChannel();
		
		for (TChnlDeta tChnlDeta : list) {
			if (!MerchCheckTypeEnums.exist(tChnlDeta.getInsticode(), "1")) {
				continue;
			}
			//1,判断是否今天产生过该机构的任务
			TSettProcess settProcess = checkBillService.isPorcess(tChnlDeta.getInsticode(), date);
			logger.info("判断定时对账任务是否存在:"+JSON.toJSONString(settProcess));
			if (settProcess!=null) {
				continue;
			}
			//2,生成任务
			boolean flag= checkBillService.saveProcess(tChnlDeta.getInsticode());
			logger.info("定时对账任务生成:"+JSON.toJSONString(settProcess));
			//如果任务 没有添加成功则跳出
			if (!flag) {
				continue;
			}
			TSettProcess settProcessNew = checkBillService.isPorcess(tChnlDeta.getInsticode(), date);
			//3,执行任务
			if (settProcessNew!=null) {
				checkBillService.checkBill(Integer.toString(settProcessNew.getTid()));
			}
		}
	}
	private void checkbillfile(String date) {
		FtpBean ftpBean=ftpService.getFtpBean();
		List<TMerchDeta> merchDetas = merchDetaService.selectAllMerchDates();
		String merchno;
		String dirpath=System.getProperty("user.home") + "/checkbillfiles/";
		File dir=new File(dirpath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		for (TMerchDeta merchdeta : merchDetas) {
			merchno=merchdeta.getMemberId();
			List<TSelfTxn> failList = checkBillService.queryCheckFileInfo(merchno, date);
			List<Map<String, Object>> datas = new ArrayList<>();
			for (TSelfTxn tSelfTxn : failList) {
				datas.add(MapTrans.transBean2Map(tSelfTxn));
			}
			String[] headers = { "txnseqno", "instiid", "payordno", "txndatetime", "busicode", "amount", "pan",
					"merchno", "paytrcno", "acqsettledate", "status", "result" };
			String filename =merchno + "-"+ date + ".xls";
			String localpath = System.getProperty("user.home") + "/checkbillfiles/" + File.separator + filename;
			File file = new File(localpath);
			try {
				OutputStream outputStream =new FileOutputStream(file);
				ExcelUtil.exportExcel(headers, datas, outputStream, config.getParams());
				InputStream inputStream =new FileInputStream(file);
				FTPUtilsForJob.uploadFile(ftpBean.getIp(), Integer.valueOf(ftpBean.getPort()), ftpBean.getUsers(), ftpBean.getPwd(), "", "checkbillfiles/", filename, inputStream);
				
				outputStream.close();
				inputStream.close();
				TMerchCheckfile merchCheckfile =new TMerchCheckfile();
				merchCheckfile.setCheckdate(date);
				merchCheckfile.setFilename(filename);
				merchCheckfile.setIntime(DateUtil.getCurrentDateTime());
				merchCheckfile.setMerchno(merchno);
				merchCheckfile.setUri("checkbillfiles/");
				merchFileService.insertOrUpdate(merchCheckfile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			FileUtils.deleteDirectory(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.addTriggerTask(new Runnable() {
			@Override
			public void run() {
				// 任务逻辑
				String starttime=DateUtil.getCurrentDateTime();
				logger.info("定时对账任务开始===时间:"+starttime);
				invoke();
				String endtime=DateUtil.getCurrentDateTime();
				logger.info("定时对账任务结束===时间:"+DateUtil.getCurrentDateTime()+"==耗时:"+(Long.valueOf(endtime)-Long.valueOf(starttime)));
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
