package com.unionpay.withhold.admin.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.service.TTxnsLogService;

@Controller
@RequestMapping("/report")
public class ReportFromController {

	private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static String format(Date date) {
		return simpleDateFormat.format(date);
	}

	@Autowired
	private TTxnsLogService tTxnsLogService;
	
	/**
	 * 渠道月分润报表页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showCoopMonthCount")
	public ModelAndView showCoopMonthCount() {
		 ModelAndView result=new ModelAndView("/trade/report/coop_month_count_manager");
	     return result;
	}
	/**
	 * 渠道月分润报表页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showPingTaiMonthCount")
	public ModelAndView showPingTaiMonthCount() {
		 ModelAndView result=new ModelAndView("/trade/report/pingtai_month_count_manager");
	     return result;
	}
	/**
	 * 商户日结算分润报表页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/showMerchDayCount")
	public ModelAndView showMerchDayCount() {
		 ModelAndView result=new ModelAndView("/trade/report/merch_day_count_manager");
	     return result;
	}
	
	/**
	 * 查询商户日分润
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getMerchDayCountByPage")
	public PageBean getMerchDayCountByPage(String accsecmerno,String dayormonth,String stime,String etime,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getMerchDayCountByPage(accsecmerno,dayormonth,stime,etime,page, rows);
		
		return resultBean;
		
	}

	/**
	 * 查询商户日分润详情
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getMerDayCountInfo")
	public PageBean getMerDayCountInfo(String accsecmerno,String txndate,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getMerDayCountInfo(accsecmerno,txndate,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询渠道月分润
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getCoopMonthCountByPage")
	public PageBean getCoopMonthCountByPage(String accfirmerno,String year,String month,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getCoopMonthCountByPage(accfirmerno,year,month,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 查询渠道月分润详情
	 * 
	 * @return 
	 */
	@ResponseBody
    @RequestMapping("/getCoopMonthCountInfo")
	public PageBean getCoopMonthCountInfo(String accfirmerno,String txndate,int page,int rows){
		
		PageBean resultBean = tTxnsLogService.getCoopMonthCountInfo(accfirmerno,txndate,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 下载商户日分润Excel报表
	 * 
	 * @return 
	 * @throws IOException 
	 */
	@ResponseBody
    @RequestMapping("/downloadmerchExcel")
	public String downloadmerchExcel(HttpServletRequest request,HttpServletResponse response,String accsecmerno,String dayormonth,String stime,String etime) throws IOException{
		// 从数据库得到数据
		PageBean merchDayCountByPage = tTxnsLogService.getMerchDayCountByPage(
				accsecmerno, dayormonth, stime, etime, 0, 0);
		List<TTxnsLog> list = (List<TTxnsLog>) merchDayCountByPage.getRows();
		
		int rowNo = 0;
		int cloNo = 1;
		// 创建工作薄
		String realPath = request.getRealPath("make/xlsprint/TOUTMERCHCOUNT.xls");
		InputStream is = new FileInputStream(realPath);
		Workbook workbook = new HSSFWorkbook(is);
		// 创建工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 大标题
		// 创建行-->从模板中的到
		Row row = sheet.getRow(rowNo++);
		// 创建列（单元格）
		Cell cell = row.getCell(cloNo);

		// 动态设置大标题inputDate.replaceAll("-","年").replaceAll("年0","年")+
		String fileName = fileName(accsecmerno,dayormonth,stime,etime);
		cell.setCellValue(fileName);
	
		// 小标题-->模板自带ll
		rowNo++;
		// 获得模板中数据的样式
		int columnNo = 1;
		row = sheet.getRow(2);
		CellStyle cellStyle1 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle2 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle3 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle4 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle5 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle6 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle7 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle8 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle9 = row.getCell(columnNo++).getCellStyle();
		
		for (TTxnsLog product : list) {
			columnNo = 1;
			Row row1 = sheet.createRow(rowNo++);
			// 交易日期
			Cell cell1 = row1.createCell(columnNo++);
			cell1.setCellStyle(cellStyle1);
			if (dayormonth.equals("01")) {
				String yearmonth = product.getTxndate().substring(0,6);
				cell1.setCellValue(yearmonth);
			}else {
				cell1.setCellValue(product.getTxndate());
			}

			Cell cell2 = row1.createCell(columnNo++);
			cell2.setCellStyle(cellStyle2);
			cell2.setCellValue(product.getAccsecmerno());
			
			Cell cell3 = row1.createCell(columnNo++);
			cell3.setCellStyle(cellStyle3);
			cell3.setCellValue(product.getMemberName());
			
			Cell cell4 = row1.createCell(columnNo++);
			cell4.setCellStyle(cellStyle4);
			cell4.setCellValue(product.getChnlname());
			// 通道编码
			Cell cell5 = row1.createCell(columnNo++);
			cell5.setCellStyle(cellStyle5);
			cell5.setCellValue(product.getAccfirmerno());
			// 总交易笔数
			Cell cell6 = row1.createCell(columnNo++);
			cell6.setCellStyle(cellStyle6);
			cell6.setCellValue(product.getTotal());
			// 总交易金额
			Cell cell7 = row1.createCell(columnNo++);
			cell7.setCellStyle(cellStyle7);
			cell7.setCellValue(fen2yuan(product.getAmount()));
			// 总交易手续费
			Cell cell8 = row1.createCell(columnNo++);
			cell8.setCellStyle(cellStyle8);
			if (product.getTxnfee() == null) {
				cell8.setCellValue(0l);
			} else {
				cell8.setCellValue(fen2yuan(product.getTxnfee()));
			}
			// 实际结算金额
			Cell cell9 = row1.createCell(columnNo++);
			cell9.setCellStyle(cellStyle9);
			if (product.getTxnfee() == null) {
				cell9.setCellValue(fen2yuan(product.getAmount()));
			} else {
				cell9.setCellValue(fen2yuan(product.getAmount()
						- product.getTxnfee()));
			}

		}

		// 发送给客户端
		response.setContentType("application/x-download");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((fileName).getBytes("gbk"), "iso8859-1")
				+ ".xls");
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);

		return null;
		
	}
	 private String fileName(String accsecmerno, String dayormonth,
			String stime, String etime) {
		 String filename=null;
		   if (accsecmerno!=null&&!"".equals(accsecmerno)&&stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)) {
				String[] sit = stime.split(" ");
				String st = sit[0].replaceAll("-", "");
				String[] eit = etime.split(" ");
				String et = eit[0].replaceAll("-", "");
				if (dayormonth.equals("01")) {
					filename="商户号"+accsecmerno+":"+st.substring(0,6)+"-"+et.substring(0, 6)+"月结算报表";
				}else if(dayormonth.equals("00")){
					filename="商户号"+accsecmerno+":"+st+"-"+et+"日结算报表";
				}
			}else if (accsecmerno!=null&&!"".equals(accsecmerno)&&"".equals(stime)&&"".equals(etime)) {
				if (dayormonth.equals("01")) {
					filename="商户号"+accsecmerno+"月结算总报表";
				}else if(dayormonth.equals("00")){
					filename="商户号"+accsecmerno+"日结算总报表";
				}
				
			}else if("".equals(accsecmerno)&&"".equals(stime)&&"".equals(etime)){
				if (dayormonth.equals("01")) {
					filename="商户月结算总报表";
				}else if(dayormonth.equals("00")){
					filename="商户日结算总报表";
				}
			}else if("".equals(accsecmerno)&&stime!=null&&!"".equals(stime)&&etime!=null&&!"".equals(etime)){
				String[] sit = stime.split(" ");
				String st = sit[0].replaceAll("-", "");
				String[] eit = etime.split(" ");
				String et = eit[0].replaceAll("-", "");
				if (dayormonth.equals("01")) {
					filename="商户"+st.substring(0,6)+"-"+et.substring(0, 6)+"月结算报表";
				}else if(dayormonth.equals("00")){
					filename="商户"+st+"-"+et+"日结算报表";
				}
			}
		   
		   return filename;
		
	}
	//大标题的样式
    public CellStyle bigTitle(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short)16);
        font.setBoldweight(Font.BOLDWEIGHT_BOLD);					//字体加粗

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        return style;
    }
    //小标题的样式
    public CellStyle title(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("黑体");
        font.setFontHeightInPoints((short)12);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_CENTER);					//横向居中
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }

    //文字样式
    public CellStyle text(Workbook wb){
        CellStyle style = wb.createCellStyle();
        Font font = wb.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short)10);

        style.setFont(font);

        style.setAlignment(CellStyle.ALIGN_LEFT);					//横向居左
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);		//纵向居中

        style.setBorderTop(CellStyle.BORDER_THIN);					//上细线
        style.setBorderBottom(CellStyle.BORDER_THIN);				//下细线
        style.setBorderLeft(CellStyle.BORDER_THIN);					//左细线
        style.setBorderRight(CellStyle.BORDER_THIN);				//右细线

        return style;
    }
    public String fen2yuan(Long amount){
    	 int flag = 0;    
         String amString = amount.toString();    
         if(amString.charAt(0)=='-'){    
             flag = 1;    
             amString = amString.substring(1);    
         }    
         StringBuffer result = new StringBuffer();    
         if(amString.length()==1){    
             result.append("0.0").append(amString);    
         }else if(amString.length() == 2){    
             result.append("0.").append(amString);    
         }else{    
             String intString = amString.substring(0,amString.length()-2);    
             for(int i=1; i<=intString.length();i++){    
                 if( (i-1)%3 == 0 && i !=1){    
                     result.append(",");    
                 }    
                 result.append(intString.substring(intString.length()-i,intString.length()-i+1));    
             }    
             result.reverse().append(".").append(amString.substring(amString.length()-2));    
         }    
         if(flag == 1){    
             return "-"+result.toString();    
         }else{    
             return result.toString();    
         }
    } 
    /**
	 * 下载商户日分润明细Excel报表
	 * 
	 * @return 
     * @throws IOException 
	 */
	@ResponseBody
    @RequestMapping("/downloadmerchExcelInfo")
    public String downloadmerchExcelInfo(HttpServletRequest request,HttpServletResponse response,String accsecmerno,String txndate ) throws IOException{
		//从数据库得到数据
		PageBean resultBean = tTxnsLogService.getMerDayCountInfo(accsecmerno,txndate,0, 0);
		List<TTxnsLog> list = (List<TTxnsLog>)resultBean.getRows();
		int rowNo = 0;
		int cloNo = 1;
		// 创建工作薄
		String realPath = request.getRealPath("make/xlsprint/TOUTMERCHCOUNTINFO.xls");
		InputStream is = new FileInputStream(realPath);
		Workbook workbook = new HSSFWorkbook(is);
		// 创建工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 大标题
		// 创建行-->从模板中的到
		Row row = sheet.getRow(rowNo++);
		// 创建列（单元格）
		Cell cell = row.getCell(cloNo);

		// 动态设置大标题inputDate.replaceAll("-","年").replaceAll("年0","年")+
		String str=null;
		if (txndate.length()==6) {
			str="商户号"+accsecmerno+"-"+txndate+"月结算表";
		}else if (txndate.length()==8){
			str="商户号"+accsecmerno+"-"+txndate+"日结算表";
		}
		cell.setCellValue(str);
	
		// 小标题-->模板自带ll
		rowNo++;
		// 获得模板中数据的样式
		int columnNo = 1;
		row = sheet.getRow(2);
		CellStyle cellStyle1 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle2 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle3 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle4 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle5 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle6 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle7 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle8 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle9 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle10 = row.getCell(columnNo++).getCellStyle();
		for (TTxnsLog product : list) {
			columnNo = 1;
			Row row1 = sheet.createRow(rowNo++);
			// 交易序列号
			Cell cell1 = row1.createCell(columnNo++);
			cell1.setCellStyle(cellStyle1);
			cell1.setCellValue(product.getTxnseqno());
			
			//通道
			Cell cell2 = row1.createCell(columnNo++);
			cell2.setCellStyle(cellStyle2);
			cell2.setCellValue(product.getChnlname());
			//商户号
			Cell cell3 = row1.createCell(columnNo++);
			cell3.setCellStyle(cellStyle3);
			cell3.setCellValue(product.getAccsecmerno());
			// 商户名称
			Cell cell4 = row1.createCell(columnNo++);
			cell4.setCellStyle(cellStyle4);
			cell4.setCellValue(product.getMemberName());
			// 交易卡号
			Cell cell5 = row1.createCell(columnNo++);
			cell5.setCellStyle(cellStyle5);
			cell5.setCellValue(product.getPan());
			// 姓名
			Cell cell6 = row1.createCell(columnNo++);
			cell6.setCellStyle(cellStyle6);
			cell6.setCellValue(product.getPanName());
			// 交易金额
			Cell cell7 = row1.createCell(columnNo++);
			cell7.setCellStyle(cellStyle7);
			if (product.getAmount() == null) {
				cell7.setCellValue(fen2yuan(0l));
			} else {
				cell7.setCellValue(fen2yuan(product.getAmount()));
			}
			// 交易手续费
			Cell cell8 = row1.createCell(columnNo++);
			cell8.setCellStyle(cellStyle8);
			if (product.getTxnfee() == null) {
				cell8.setCellValue(fen2yuan(0l));
			} else {
				cell8.setCellValue(fen2yuan(product.getTxnfee()));
			}
			// 结算金额
			Cell cell9 = row1.createCell(columnNo++);
			cell9.setCellStyle(cellStyle9);
			if (product.getTxnfee() == null) {
				cell9.setCellValue(fen2yuan(product.getAmount()));
			} else {
				cell9.setCellValue(fen2yuan(product.getAmount()
					- product.getTxnfee()));
			}
			//交易时间
			Cell cell10 = row1.createCell(columnNo++);
			cell10.setCellStyle(cellStyle10);
			cell10.setCellValue(product.getTxndate());
		}

		// 发送给客户端
		response.setContentType("application/x-download");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((str).getBytes("gbk"), "iso8859-1")
				+ ".xls");
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);
    	return null;
    }
	/**
	 * 下载渠道分润Excel报表
	 * 
	 * @return 
     * @throws IOException 
	 */
	@ResponseBody
    @RequestMapping("/downloadcoopExcel")
    public String downloadcoopExcel(HttpServletRequest request,HttpServletResponse response,String accfirmerno,String year,String month ) throws IOException{
		PageBean resultBean = tTxnsLogService.getCoopMonthCountByPage(accfirmerno,year,month,0, 0);
		List<TTxnsLog> list = (List<TTxnsLog>)resultBean.getRows();
		int rowNo = 0;
		int cloNo = 1;
		// 创建工作薄
		String realPath = request.getRealPath("make/xlsprint/TOUTCOOPCOUNT.xls");
		InputStream is = new FileInputStream(realPath);
		Workbook workbook = new HSSFWorkbook(is);
		// 创建工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 大标题
		// 创建行-->从模板中的到
		Row row = sheet.getRow(rowNo++);
		// 创建列（单元格）
		Cell cell = row.getCell(cloNo);

		// 动态设置大标题inputDate.replaceAll("-","年").replaceAll("年0","年")+
		String str=null;
		if (!"".equals(accfirmerno)&&!"".equals(year)&&!"".equals(month)) {
			str="渠道号"+accfirmerno+"-"+year+month+"月结算表";
		}else if (!"".equals(accfirmerno)&&"".equals(year)&&"".equals(month)){
			str="渠道号"+accfirmerno+"-"+"月结算表";
		}else if ("".equals(accfirmerno)&&!"".equals(year)&&!"".equals(month)) {
			str="渠道"+year+month+"月结算表";
		}else if ("".equals(accfirmerno)&&"".equals(year)&&"".equals(month)) {
			str="渠道总月结算表";
		}
		cell.setCellValue(str);
	
		// 小标题-->模板自带ll
		rowNo++;
		// 获得模板中数据的样式
		int columnNo = 1;
		row = sheet.getRow(2);
		CellStyle cellStyle1 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle2 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle3 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle4 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle5 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle6 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle7 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle8 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle9 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle10 = row.getCell(columnNo++).getCellStyle();
		for (TTxnsLog product : list) {
			columnNo = 1;
			Row row1 = sheet.createRow(rowNo++);
			// 交易时间
			Cell cell1 = row1.createCell(columnNo++);
			cell1.setCellStyle(cellStyle1);
			cell1.setCellValue(product.getTxndate().substring(0, 6));
			
			//商户号
			Cell cell2 = row1.createCell(columnNo++);
			cell2.setCellStyle(cellStyle2);
			cell2.setCellValue(product.getAccsecmerno());
			//通道
			Cell cell3 = row1.createCell(columnNo++);
			cell3.setCellStyle(cellStyle3);
			cell3.setCellValue(product.getChnlname());
			//通道号
			Cell cell4 = row1.createCell(columnNo++);
			cell4.setCellStyle(cellStyle4);
			cell4.setCellValue(product.getPayinst());
			// 渠道
			Cell cell5 = row1.createCell(columnNo++);
			cell5.setCellStyle(cellStyle5);
			cell5.setCellValue(product.getCaname());
			// 渠道号
			Cell cell6 = row1.createCell(columnNo++);
			cell6.setCellStyle(cellStyle6);
			cell6.setCellValue(product.getAccfirmerno());
			// 总交易笔数
			Cell cell7 = row1.createCell(columnNo++);
			cell7.setCellStyle(cellStyle7);
			cell7.setCellValue(product.getTotal());
			// 交易金额
			Cell cell8 = row1.createCell(columnNo++);
			cell8.setCellStyle(cellStyle8);
			if (product.getAmount() == null) {
				cell8.setCellValue(fen2yuan(0l));
			} else {
				cell8.setCellValue(fen2yuan(product.getAmount()));
			}
			// 交易手续费
			Cell cell9 = row1.createCell(columnNo++);
			cell9.setCellStyle(cellStyle9);
			if (product.getTxnfee() == null) {
				cell9.setCellValue(fen2yuan(0l));
			} else {
				cell9.setCellValue(fen2yuan(product.getTxnfee()));
			}
			
			//渠道分润额
			Cell cell10 = row1.createCell(columnNo++);
			cell10.setCellStyle(cellStyle10);
			if (product.getTxnfee() == null&&product.getCoopfee()==null) {
				//
				cell10.setCellValue(fen2yuan(0l));
			}else if (product.getTxnfee() != null&&product.getCoopfee()==null){ 
				cell10.setCellValue(fen2yuan(product.getTxnfee()));
			}else if(product.getTxnfee() == null&&product.getCoopfee()!=null){
				cell10.setCellValue(fen2yuan(0l-product.getTxnfee()));
			}else if(product.getTxnfee() != null&&product.getCoopfee()!=null){
				String coop = fen2yuan(product.getTxnfee()-product.getCoopfee());
				cell10.setCellValue(coop);
			}
			
		}

		// 发送给客户端
		response.setContentType("application/x-download");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((str).getBytes("gbk"), "iso8859-1")
				+ ".xls");
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);
		return null;
	}
	/**
	 * 下载渠道月分润明细Excel报表
	 * 
	 * @return 
     * @throws IOException 
	 */
	@ResponseBody
    @RequestMapping("/downloadcoopExcelInfo")
    public String downloadcoopExcelInfo(HttpServletRequest request,HttpServletResponse response,String accfirmerno,String txndate ) throws IOException{
		//从数据库得到数据
		PageBean resultBean = tTxnsLogService.getCoopMonthCountInfo(accfirmerno,txndate,0, 0);
		List<TTxnsLog> list = (List<TTxnsLog>)resultBean.getRows();
		int rowNo = 0;
		int cloNo = 1;
		// 创建工作薄
		String realPath = request.getRealPath("make/xlsprint/TOUTCOOPCOUNTINFO.xls");
		InputStream is = new FileInputStream(realPath);
		Workbook workbook = new HSSFWorkbook(is);
		// 创建工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 大标题
		// 创建行-->从模板中的到
		Row row = sheet.getRow(rowNo++); 
		// 创建列（单元格）
		Cell cell = row.getCell(cloNo);

		// 动态设置大标题inputDate.replaceAll("-","年").replaceAll("年0","年")+
		String str=null;
		str="渠道号"+accfirmerno+"-"+txndate+"月结算表";
		cell.setCellValue(str);
	
		// 小标题-->模板自带ll
		rowNo++;
		// 获得模板中数据的样式
		int columnNo = 1;
		row = sheet.getRow(2);
		CellStyle cellStyle1 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle2 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle3 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle4 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle5 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle6 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle7 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle8 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle9 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle10 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle11 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle12 = row.getCell(columnNo++).getCellStyle();
		for (TTxnsLog product : list) {
			columnNo = 1;
			Row row1 = sheet.createRow(rowNo++);
			// 交易序列号
			Cell cell1 = row1.createCell(columnNo++);
			cell1.setCellStyle(cellStyle1);
			cell1.setCellValue(product.getTxnseqno());
			
			//通道
			Cell cell2 = row1.createCell(columnNo++);
			cell2.setCellStyle(cellStyle2);
			cell2.setCellValue(product.getChnlname());
			//商户号
			Cell cell3 = row1.createCell(columnNo++);
			cell3.setCellStyle(cellStyle3);
			cell3.setCellValue(product.getAccsecmerno());
			// 商户名称
			Cell cell4 = row1.createCell(columnNo++);
			cell4.setCellStyle(cellStyle4);
			cell4.setCellValue(product.getMemberName());
			// 交易卡号
			Cell cell5 = row1.createCell(columnNo++);
			cell5.setCellStyle(cellStyle5);
			cell5.setCellValue(product.getPan());
			// 姓名
			Cell cell6 = row1.createCell(columnNo++);
			cell6.setCellStyle(cellStyle6);
			cell6.setCellValue(product.getPanName());
			// 交易金额
			Cell cell7 = row1.createCell(columnNo++);
			cell7.setCellStyle(cellStyle7);
			if (product.getAmount() == null) {
				cell7.setCellValue(fen2yuan(0l));
			} else {
				cell7.setCellValue(fen2yuan(product.getAmount()));
			}
			// 交易手续费
			Cell cell8 = row1.createCell(columnNo++);
			cell8.setCellStyle(cellStyle8);
			if (product.getTxnfee() == null) {
				cell8.setCellValue(fen2yuan(0l));
			} else {
				cell8.setCellValue(fen2yuan(product.getTxnfee()));
			}
			// 结算金额
			Cell cell9 = row1.createCell(columnNo++);
			cell9.setCellStyle(cellStyle9);
			if (product.getTxnfee() == null) {
				cell9.setCellValue(fen2yuan(product.getAmount()));
			} else {
				cell9.setCellValue(fen2yuan(product.getAmount()
					- product.getTxnfee()));
			}
			//渠道
			Cell cell10 = row1.createCell(columnNo++);
			cell10.setCellStyle(cellStyle10);
			cell10.setCellValue(product.getCaname());
			//渠道分润
			Cell cell11 = row1.createCell(columnNo++);
			cell11.setCellStyle(cellStyle11);
			if (product.getTxnfee() == null&&product.getCoopfee()==null) {
				//
				cell11.setCellValue(fen2yuan(0l));
			}else if (product.getTxnfee() != null&&product.getCoopfee()==null){ 
				cell11.setCellValue(fen2yuan(product.getTxnfee()));
			}else if(product.getTxnfee() == null&&product.getCoopfee()!=null){
				cell11.setCellValue(fen2yuan(0l-product.getTxnfee()));
			}else if(product.getTxnfee() != null&&product.getCoopfee()!=null){
				String coop = fen2yuan(product.getTxnfee()-product.getCoopfee());
				cell11.setCellValue(coop);
			}
			//交易时间
			Cell cell12 = row1.createCell(columnNo++);
			cell12.setCellStyle(cellStyle12);
			cell12.setCellValue(product.getTxndate());
		}

		// 发送给客户端
		response.setContentType("application/x-download");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((str).getBytes("gbk"), "iso8859-1")
				+ ".xls");
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);
    	return null;
    }
	//
	/**
	 * 下载平台月分润Excel报表
	 * 
	 * @return 
     * @throws IOException 
	 */
	@ResponseBody
    @RequestMapping("/downloadpingtaiExcel")
    public String downloadpingtaiExcel(HttpServletRequest request,HttpServletResponse response,String accfirmerno,String year,String month ) throws IOException{
		PageBean resultBean = tTxnsLogService.getCoopMonthCountByPage(accfirmerno,year,month,0, 0);
		List<TTxnsLog> list = (List<TTxnsLog>)resultBean.getRows();
		int rowNo = 0;
		int cloNo = 1;
		// 创建工作薄
		String realPath = request.getRealPath("make/xlsprint/TOUTPINGTAICOUNT.xls");
		InputStream is = new FileInputStream(realPath);
		Workbook workbook = new HSSFWorkbook(is);
		// 创建工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 大标题
		// 创建行-->从模板中的到
		Row row = sheet.getRow(rowNo++);
		// 创建列（单元格）
		Cell cell = row.getCell(cloNo);

		// 动态设置大标题inputDate.replaceAll("-","年").replaceAll("年0","年")+
		String str=null;
		if (!"".equals(accfirmerno)&&!"".equals(year)&&!"".equals(month)) {
			str="渠道号"+accfirmerno+"-"+year+month+"月结算表(含银联分润)";
		}else if (!"".equals(accfirmerno)&&"".equals(year)&&"".equals(month)){
			str="渠道号"+accfirmerno+"-"+"月结算表(含银联分润)";
		}else if ("".equals(accfirmerno)&&!"".equals(year)&&!"".equals(month)) {
			str="渠道"+year+month+"月结算表(含银联分润)";
		}else if ("".equals(accfirmerno)&&"".equals(year)&&"".equals(month)) {
			str="渠道总月结算表(含银联分润)";
		}
		cell.setCellValue(str);
	
		// 小标题-->模板自带ll
		rowNo++;
		// 获得模板中数据的样式
		int columnNo = 1;
		row = sheet.getRow(2);
		CellStyle cellStyle1 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle2 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle3 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle4 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle5 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle6 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle7 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle8 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle9 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle10 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle11 = row.getCell(columnNo++).getCellStyle();
		for (TTxnsLog product : list) {
			columnNo = 1;
			Row row1 = sheet.createRow(rowNo++);
			// 交易时间
			Cell cell1 = row1.createCell(columnNo++);
			cell1.setCellStyle(cellStyle1);
			cell1.setCellValue(product.getTxndate().substring(0, 6));
			
			//商户号
			Cell cell2 = row1.createCell(columnNo++);
			cell2.setCellStyle(cellStyle2);
			cell2.setCellValue(product.getAccsecmerno());
			//通道
			Cell cell3 = row1.createCell(columnNo++);
			cell3.setCellStyle(cellStyle3);
			cell3.setCellValue(product.getChnlname());
			//通道编号
			Cell cell4 = row1.createCell(columnNo++);
			cell4.setCellStyle(cellStyle4);
			cell4.setCellValue(product.getPayinst());
			// 渠道
			Cell cell5 = row1.createCell(columnNo++);
			cell5.setCellStyle(cellStyle5);
			cell5.setCellValue(product.getCaname());
			// 渠道号
			Cell cell6 = row1.createCell(columnNo++);
			cell6.setCellStyle(cellStyle6);
			cell6.setCellValue(product.getAccfirmerno());
			// 总交易笔数
			Cell cell7 = row1.createCell(columnNo++);
			cell7.setCellStyle(cellStyle7);
			cell7.setCellValue(product.getTotal());
			// 交易金额
			Cell cell8 = row1.createCell(columnNo++);
			cell8.setCellStyle(cellStyle8);
			if (product.getAmount() == null) {
				cell8.setCellValue(fen2yuan(0l));
			} else {
				cell8.setCellValue(fen2yuan(product.getAmount()));
			}
			// 交易手续费
			Cell cell9 = row1.createCell(columnNo++);
			cell9.setCellStyle(cellStyle9);
			if (product.getTxnfee() == null) {
				cell9.setCellValue(fen2yuan(0l));
			} else {
				cell9.setCellValue(fen2yuan(product.getTxnfee()));
			}
			
			//渠道分润额
			Cell cell10 = row1.createCell(columnNo++);
			cell10.setCellStyle(cellStyle10);
			if (product.getTxnfee() == null&&product.getCoopfee()==null) {
				//
				cell10.setCellValue(fen2yuan(0l));
			}else if (product.getTxnfee() != null&&product.getCoopfee()==null){ 
				cell10.setCellValue(fen2yuan(product.getTxnfee()));
			}else if(product.getTxnfee() == null&&product.getCoopfee()!=null){
				cell10.setCellValue(fen2yuan(0l-product.getTxnfee()));
			}else if(product.getTxnfee() != null&&product.getCoopfee()!=null){
				String coop = fen2yuan(product.getTxnfee()-product.getCoopfee());
				cell10.setCellValue(coop);
			}
			//银联分润
			Cell cell11 = row1.createCell(columnNo++);
			cell11.setCellStyle(cellStyle11);
			if (product.getChnlfee() == null&&product.getCoopfee()==null) {
				//
				cell11.setCellValue(fen2yuan(0l));
			}else if (product.getChnlfee() == null&&product.getCoopfee()!=null){ 
				cell11.setCellValue(fen2yuan(product.getCoopfee()));
			}else if(product.getChnlfee() != null&&product.getCoopfee()==null){
				cell11.setCellValue(fen2yuan(0l-product.getChnlfee()));
			}else if(product.getChnlfee() != null&&product.getCoopfee()!=null){
				String coop = fen2yuan(product.getCoopfee()-product.getChnlfee());
				cell11.setCellValue(coop);
			}
		}

		// 发送给客户端
		response.setContentType("application/x-download");
		
		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((str).getBytes("gbk"), "iso8859-1")
				+ ".xls");
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);
		return null;
		
	}
	/**
	 * 下载银联月分润明细Excel报表
	 * 
	 * @return 
     * @throws IOException 
	 */
	@ResponseBody
    @RequestMapping("/downloadpingtaiExcelInfo")
    public String downloadpingtaiExcelInfo(HttpServletRequest request,HttpServletResponse response,String accfirmerno,String txndate ) throws IOException{
		// 从数据库得到数据
		PageBean resultBean = tTxnsLogService.getCoopMonthCountInfo(
				accfirmerno, txndate, 0, 0);
		List<TTxnsLog> list = (List<TTxnsLog>) resultBean.getRows();
		int rowNo = 0;
		int cloNo = 1;
		// 创建工作薄
		String realPath = request
				.getRealPath("make/xlsprint/TOUTPINGTAICOUNTINFO.xls");
		InputStream is = new FileInputStream(realPath);
		Workbook workbook = new HSSFWorkbook(is);
		// 创建工作表
		Sheet sheet = workbook.getSheetAt(0);
		// 大标题
		// 创建行-->从模板中的到
		Row row = sheet.getRow(rowNo++);
		// 创建列（单元格）
		Cell cell = row.getCell(cloNo);

		// 动态设置大标题inputDate.replaceAll("-","年").replaceAll("年0","年")+
		String str = null;
		str = "渠道号" + accfirmerno + "-" + txndate + "月结算表(含银联分润)";
		cell.setCellValue(str);

		// 小标题-->模板自带ll
		rowNo++;
		// 获得模板中数据的样式
		int columnNo = 1;
		row = sheet.getRow(2);
		CellStyle cellStyle1 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle2 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle3 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle4 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle5 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle6 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle7 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle8 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle9 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle10 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle11 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle12 = row.getCell(columnNo++).getCellStyle();
		CellStyle cellStyle13 = row.getCell(columnNo++).getCellStyle();
		for (TTxnsLog product : list) {
			columnNo = 1;
			Row row1 = sheet.createRow(rowNo++);
			// 交易序列号
			Cell cell1 = row1.createCell(columnNo++);
			cell1.setCellStyle(cellStyle1);
			cell1.setCellValue(product.getTxnseqno());

			// 通道
			Cell cell2 = row1.createCell(columnNo++);
			cell2.setCellStyle(cellStyle2);
			cell2.setCellValue(product.getChnlname());
			// 商户号
			Cell cell3 = row1.createCell(columnNo++);
			cell3.setCellStyle(cellStyle3);
			cell3.setCellValue(product.getAccsecmerno());
			// 商户名称
			Cell cell4 = row1.createCell(columnNo++);
			cell4.setCellStyle(cellStyle4);
			cell4.setCellValue(product.getMemberName());
			// 交易卡号
			Cell cell5 = row1.createCell(columnNo++);
			cell5.setCellStyle(cellStyle5);
			cell5.setCellValue(product.getPan());
			// 姓名
			Cell cell6 = row1.createCell(columnNo++);
			cell6.setCellStyle(cellStyle6);
			cell6.setCellValue(product.getPanName());
			// 交易金额
			Cell cell7 = row1.createCell(columnNo++);
			cell7.setCellStyle(cellStyle7);
			if (product.getAmount() == null) {
				cell7.setCellValue(fen2yuan(0l));
			} else {
				cell7.setCellValue(fen2yuan(product.getAmount()));
			}
			// 交易手续费
			Cell cell8 = row1.createCell(columnNo++);
			cell8.setCellStyle(cellStyle8);
			if (product.getTxnfee() == null) {
				cell8.setCellValue(fen2yuan(0l));
			} else {
				cell8.setCellValue(fen2yuan(product.getTxnfee()));
			}
			// 结算金额
			Cell cell9 = row1.createCell(columnNo++);
			cell9.setCellStyle(cellStyle9);
			if (product.getTxnfee() == null) {
				cell9.setCellValue(fen2yuan(product.getAmount()));
			} else {
				cell9.setCellValue(fen2yuan(product.getAmount()
						- product.getTxnfee()));
			}
			// 渠道
			Cell cell10 = row1.createCell(columnNo++);
			cell10.setCellStyle(cellStyle10);
			cell10.setCellValue(product.getCaname());
			// 渠道分润
			Cell cell11 = row1.createCell(columnNo++);
			cell11.setCellStyle(cellStyle11);
			if (product.getTxnfee() == null && product.getCoopfee() == null) {
				//
				cell11.setCellValue(fen2yuan(0l));
			} else if (product.getTxnfee() != null
					&& product.getCoopfee() == null) {
				cell11.setCellValue(fen2yuan(product.getTxnfee()));
			} else if (product.getTxnfee() == null
					&& product.getCoopfee() != null) {
				cell11.setCellValue(fen2yuan(0l - product.getTxnfee()));
			} else if (product.getTxnfee() != null
					&& product.getCoopfee() != null) {
				String coop = fen2yuan(product.getTxnfee()
						- product.getCoopfee());
				cell11.setCellValue(coop);
			}
			//银联分润
			Cell cell12 = row1.createCell(columnNo++);
			cell12.setCellStyle(cellStyle12);
			if (product.getChnlfee() == null&&product.getCoopfee()==null) {
				//
				cell12.setCellValue(fen2yuan(0l));
			}else if (product.getChnlfee() == null&&product.getCoopfee()!=null){ 
				cell12.setCellValue(fen2yuan(product.getCoopfee()));
			}else if(product.getChnlfee() != null&&product.getCoopfee()==null){
				cell12.setCellValue(fen2yuan(0l-product.getChnlfee()));
			}else if(product.getChnlfee() != null&&product.getCoopfee()!=null){
				String coop = fen2yuan(product.getCoopfee()-product.getChnlfee());
				cell12.setCellValue(coop);
			}
			// 交易时间
			Cell cell13 = row1.createCell(columnNo++);
			cell13.setCellStyle(cellStyle13);
			cell13.setCellValue(product.getTxndate());
		}

		// 发送给客户端
		response.setContentType("application/x-download");

		response.setHeader("Content-Disposition", "attachment;filename="
				+ new String((str).getBytes("gbk"), "iso8859-1") + ".xls");
		ServletOutputStream os = response.getOutputStream();
		workbook.write(os);
		return null;

	}
}