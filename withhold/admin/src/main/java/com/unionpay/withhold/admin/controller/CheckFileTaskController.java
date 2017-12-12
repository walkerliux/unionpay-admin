package com.unionpay.withhold.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unionpay.withhold.admin.Bean.FtpBean;
import com.unionpay.withhold.admin.enums.MerchCheckTypeEnums;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TMerchCheckfile;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSettProcess;
import com.unionpay.withhold.admin.service.CheckBillService;
import com.unionpay.withhold.admin.service.FtpService;
import com.unionpay.withhold.admin.service.MerchDetaService;
import com.unionpay.withhold.admin.service.MerchFileService;
import com.unionpay.withhold.admin.utils.ConfigParamsExcelHeader;
import com.unionpay.withhold.admin.utils.FTPUtilsForJob;
import com.unionpay.withhold.admin.utils.MapTrans;
import com.unionpay.withhold.admin.utils.excel.ExcelUtil;
import com.unionpay.withhold.utils.DateUtil;

@Controller
@RequestMapping("/checktask")
public class CheckFileTaskController{
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
	@ResponseBody
    @RequestMapping("/index")
    public void index() {
        invoke();
    }
	private void invoke() {
		String date = DateUtil.getCurrentDate();
		checkbill(date);
		checkbillfile(date);
	}

	private void checkbill(String date) {
		//执行任务
		List<TChnlDeta> list = checkBillService.getAllChannel();
		
		for (TChnlDeta tChnlDeta : list) {
			if (!MerchCheckTypeEnums.exist(tChnlDeta.getChnlcode(), "1")) {
				continue;
			}
			//1,判断是否今天产生过该机构的任务
			TSettProcess settProcess = checkBillService.isPorcess(tChnlDeta.getChnlcode(), date);
			if (settProcess!=null) {
				continue;
			}
			//2,生成任务
			boolean flag= checkBillService.saveProcess(tChnlDeta.getChnlcode());
			//如果任务 没有添加成功则跳出
			if (!flag) {
				continue;
			}
			TSettProcess settProcessNew = checkBillService.isPorcess(tChnlDeta.getChnlcode(), date);
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
}
