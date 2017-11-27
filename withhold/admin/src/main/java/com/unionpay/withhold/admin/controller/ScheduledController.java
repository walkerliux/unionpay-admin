package com.unionpay.withhold.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unionpay.withhold.admin.Bean.FtpBean;
import com.unionpay.withhold.admin.mapper.TMerchCheckfileMapper;
import com.unionpay.withhold.admin.pojo.TMerchCheckfile;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.service.CheckBillService;
import com.unionpay.withhold.admin.service.FtpService;
import com.unionpay.withhold.admin.service.MerchDetaService;
import com.unionpay.withhold.admin.service.MerchFileService;
import com.unionpay.withhold.admin.utils.ConfigParamsExcelHeader;
import com.unionpay.withhold.admin.utils.FTPUtilsForJob;
import com.unionpay.withhold.admin.utils.MapTrans;
import com.unionpay.withhold.admin.utils.excel.ExcelUtil;
import com.unionpay.withhold.utils.DateUtil;

//@Component
@Controller
@RequestMapping("/sche/")
public class ScheduledController {

	@Autowired
	private CheckBillService checkBillService;

	@Autowired
	private ConfigParamsExcelHeader config;
	
	@Autowired
	private MerchDetaService merchDetaService;
	
	@Autowired
	private MerchFileService merchFileService;
	
	@Autowired
	private FtpService ftpService;

	//@Scheduled(cron = "0/10 * *  * * ? ") // 每10秒执行一次
	@RequestMapping("check")
	public void createCheckBillFile() {
		try {
			// TimeUnit.SECONDS.sleep(300);
			String date = DateUtil.formatDateTime(DateUtil.SIMPLE_DATE_FROMAT, DateUtil.skipDateTime(new Date(), -1));
			FtpBean ftpBean=ftpService.getFtpBean();
			execute(date,ftpBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void execute(String date,FtpBean ftpBean) {
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
				//写入数据库
				TMerchCheckfile merchCheckfile =new TMerchCheckfile();
				merchCheckfile.setCheckdate(date);
				merchCheckfile.setFilename(filename);
				merchCheckfile.setIntime(DateUtil.getCurrentDateTime());
				merchCheckfile.setMerchno(merchno);
				merchCheckfile.setUri("/checkbillfiles/");
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
}
