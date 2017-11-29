package com.unionpay.withhold.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.unionpay.withhold.admin.Bean.FtpBean;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.enums.MerchCheckTypeEnums;
import com.unionpay.withhold.admin.pojo.TCheckfileMistake;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSettProcess;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.CheckBillService;
import com.unionpay.withhold.admin.service.FtpService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.ConfigParamsExcelHeader;
import com.unionpay.withhold.admin.utils.FTPUtilsForJob;
import com.unionpay.withhold.admin.utils.MapTrans;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
import com.unionpay.withhold.admin.utils.excel.ExcelUtil;
import com.unionpay.withhold.utils.DateUtil;

@Controller
@RequestMapping("/checkbill/")
public class CheckBillController {

	@Autowired
	private CheckBillService checkBillService;
	@Autowired
	private UserService userService;

	@Autowired
	private ConfigParamsExcelHeader config;
	
	@Autowired
	private FtpService ftpService;
	
	@RequestMapping("toResult")
	public String index() {
		return "/checkinfo/file_start";
	}

	@RequestMapping("toResultSum")
	public String toResultSum() {
		return "/checkinfo/file_start_sum";
	}

	/**
	 * 查询机构
	 * 
	 * @author: zhangshd
	 * @return List<ChannelFileBean>
	 * @date: 2017年3月1日 下午3:31:05
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryChannel")
	public List<?> queryChannel() {
		List<?> list = checkBillService.getAllChannel();
		return list;
	}

	/**
	 * 任务分页查询（新增任务，开始对账）
	 * 
	 * @author: zhangshd
	 * @return Map<String, Object>
	 * @date: 2017年3月1日 下午4:22:35
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryProcess")
	public PageBean queryProcess(String instiid, String startDate, String endDate, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		if (!StringUtils.isBlank(startDate)) {
			variables.put("startDate", startDate.replace("-", ""));
		}
		if (!StringUtils.isBlank(endDate)) {
			variables.put("endDate", endDate.replace("-", ""));
		}
		if (!StringUtils.isBlank(instiid)) {
			variables.put("instiid", instiid);
		}
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TSettProcess> processList = checkBillService.queryPorcess(variables);
		PageInfo<TSettProcess> pageInfo = new PageInfo<>(processList);
		PageBean pageBean = new PageBean(new Long(pageInfo.getTotal()).intValue(), processList);
		return pageBean;
	}

	/**
	 * 生成任务
	 * 
	 * @param instiid
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveProcess")
	public Map<String, Object> saveProcess(String instiid) {
		Map<String, Object> resultMap = new HashMap<>();
		
		if (!MerchCheckTypeEnums.exist(instiid, "1")) {
			resultMap.put("INFO", "此机构暂时不能提供对账");
			resultMap.put("CODE", "02");
			return resultMap;
		}
		boolean flag=checkBillService.saveProcess(instiid);
		if (flag) {
			resultMap.put("INFO", "任务添加成功");
			resultMap.put("CODE", "00");
		}else{
			resultMap.put("INFO", "任务添加失败");
			resultMap.put("CODE", "01");
		}
		return resultMap;
	}

	/**
	 * 查询对账差错的记录
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("queryFail")
	public PageBean queryFail(HttpServletRequest request, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("proid", request.getParameter("proid"));
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TCheckfileMistake> failList = checkBillService.queryFail(variables);
		PageInfo<TCheckfileMistake> pageInfo = new PageInfo<>(failList);
		PageBean pageBean = new PageBean(new Long(pageInfo.getTotal()).intValue(), failList);
		return pageBean;
	}

	/**
	 * 查询对账成功的记录
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return List<?>
	 * @date: 2017年3月1日 下午5:04:13
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("querySuccess")
	public PageBean querySuccess(HttpServletRequest request, String page, String rows) {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("proid", request.getParameter("proid"));
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TSelfTxn> failList = checkBillService.querySuccess(variables);
		PageInfo<TSelfTxn> pageInfo = new PageInfo<>(failList);
		PageBean pageBean = new PageBean(new Long(pageInfo.getTotal()).intValue(), failList);
		return pageBean;
	}

	@ResponseBody
	@RequestMapping("querySuccessBymerch")
	public PageBean querySuccessBymerch(HttpServletRequest request, String date, String page, String rows) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String merchno = infoByToken.getLoginName().toString();
		if (!StringUtils.isBlank(date)) {
			date = date.replace("-", "");
		} else {
			date = DateUtil.getCurrentDate();
		}
		PageHelper.startPage(Integer.valueOf(page), Integer.valueOf(rows));
		List<TSelfTxn> failList = checkBillService.queryCheckFileInfo(merchno, date);
		PageInfo<TSelfTxn> pageInfo = new PageInfo<>(failList);
		PageBean pageBean = new PageBean(new Long(pageInfo.getTotal()).intValue(), failList);
		return pageBean;
	}

	@ResponseBody
	@RequestMapping("querySuccessFileBymerch")
	public void querySuccessFileBymerch(HttpServletRequest request, String date, HttpServletResponse response) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		String merchno = infoByToken.getLoginName().toString();
		merchno="200000000001588";
		if (!StringUtils.isBlank(date)) {
			date = date.replace("-", "");
		} else {
			date = DateUtil.getCurrentDate();
		}
		
		List<TSelfTxn> failList = checkBillService.queryCheckFileInfo(merchno, date);
		List<Map<String, Object>> datas=new ArrayList<>();
		for (TSelfTxn tSelfTxn : failList) {
			datas.add(MapTrans.transBean2Map(tSelfTxn));
		}
		
		String[] headers = {"txnseqno", "instiid", "payordno", "txndatetime", "busicode", "amount", "pan",
				"merchno", "paytrcno","acqsettledate", "status","result"};
		String dirpath = request.getSession().getServletContext().getRealPath("/")+File.separator+"checkbillfile";
		File dir=new File(dirpath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filename=File.separator+merchno+"-"+date+".xls";
		String path =dirpath+filename;
		File file=new File(path);
		FtpBean ftpBean=ftpService.getFtpBean();
		try {
			OutputStream outputStream=new FileOutputStream(file);
			ExcelUtil.exportExcel(headers, datas,outputStream, config.getParams());
			InputStream inputStream=new FileInputStream(file);
			FTPUtilsForJob.uploadFile(ftpBean.getIp(), Integer.valueOf(ftpBean.getPort()), ftpBean.getUsers(), ftpBean.getPwd(), "", "checkbillfiles/", filename, inputStream);
			response.addHeader("Content-Disposition",
					"attachment;filename=" + new String((merchno+"-"+date+".xls").replaceAll(" ", "").getBytes("utf-8"), "iso8859-1"));
			ExcelUtil.exportExcel(headers, datas,response.getOutputStream(), config.getParams());
			inputStream.close();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			FileUtils.deleteDirectory(dir);
			ExcelUtil.exportExcel(headers, datas,response.getOutputStream() , config.getParams());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 开始执行核对
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return Object
	 * @date: 2017年3月1日 下午4:56:23
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("startCheckFile")
	public ResultBean startCheckFile(String filestartid) {
		return checkBillService.checkBill(filestartid);
	}

	/**
	 * 拒绝处理意见
	 * 
	 * @author: zhangshd
	 * @param filestartid
	 * @return Object
	 * @date: 2017年3月1日 下午4:56:23
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("dealmistake")
	public ResultBean dealmistake(String result, String status, String iid, HttpServletRequest request) {
		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		TUser infoByToken = userService.getUserInfoByToken(cookieValue);
		return checkBillService.dealmistake(result, status, iid, infoByToken.getUserId().longValue());
	}

	@ResponseBody
	@RequestMapping("dealReasult")
	public PageBean dealReasult(String proid) {
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(checkBillService.dealReasult(proid));
		PageBean pageBean = new PageBean(0, list);
		return pageBean;
	}

}
