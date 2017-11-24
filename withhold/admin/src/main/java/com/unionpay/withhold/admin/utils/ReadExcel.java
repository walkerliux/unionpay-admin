package com.unionpay.withhold.admin.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.unionpay.withhold.admin.Bean.MyTimer;
import com.unionpay.withhold.trade.api.bean.BatchCollectDetaBean;

public class ReadExcel {
	
	 //总行数
    private int totalRows = 0;  
    //总条数
    private int totalCells = 0; 
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;} 
    //获取总列数
    public int getTotalCells() {  return totalCells;} 
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }  
    
  /**
   * 验证EXCEL文件
   * @param filePath
   * @return
   */
  public boolean validateExcel(String filePath){
        if (filePath == null || !(ReadExcel.isExcel2003(filePath) || ReadExcel.isExcel2007(filePath))){  
            errorMsg = "文件名不是excel格式";  
            return false;  
        }  
        return true;
  }
    
  /**
   * 读EXCEL文件，获取客户信息集合
   * @param fielName
   * @return
   */
  public List<BatchCollectDetaBean> getExcelInfo(String fileName,MultipartFile Mfile,String EXCELPATH){
      
      //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
       File file = new  File(EXCELPATH);
       //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
       if (!file.exists()) file.mkdirs();
       //新建一个文件
       String filenameString=EXCELPATH + new Date().getTime() + ".xlsx";
       File file1 = new File(filenameString); 
       //将上传的文件写入新建的文件中
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }
       Timer timer = new Timer();
       timer.schedule(new MyTimer(filenameString,""), 300000);
       //初始化客户信息的集合    
       List<BatchCollectDetaBean> customerList=new ArrayList<BatchCollectDetaBean>();
       //初始化输入流
       InputStream is = null;  
       try{
          //验证文件名是否合格
          if(!validateExcel(fileName)){
              return null;
          }
          //根据文件名判断文件是2003版本还是2007版本
          boolean isExcel2003 = true; 
          if(ReadExcel.isExcel2007(fileName)){
              isExcel2003 = false;  
          }
          //根据新建的文件实例化输入流
          is = new FileInputStream(file1);
          //根据excel里面的内容读取客户信息
          customerList = getExcelInfo(is, isExcel2003); 
          
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return customerList;
  }
  /**
   * 根据excel里面的内容读取商户交易信息
   * @param is 输入流
   * @param isExcel2003 excel是2003还是2007版本
   * @return
   * @throws IOException
   */
  public  List<BatchCollectDetaBean> getExcelInfo(InputStream is,boolean isExcel2003){
       List<BatchCollectDetaBean> customerList=null;
       try{
           /** 根据版本选择创建Workbook的方式 */
           Workbook wb = null;
           //当excel是2003时
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
           }
           else{//当excel是2007时
               wb = new XSSFWorkbook(is); 
           }
           //读取Excel里面客户的信息
           customerList=readExcelValue(wb);
       }
       catch (IOException e)  {  
           e.printStackTrace();  
       }  
       return customerList;
  }
  /**
   * 读取Excel里面第一行的交易批次号
   * @param wb
   * @return
   */
 /* public  String readFastRowExcelValue(String fileName,MultipartFile Mfile){
	//把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
      CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
      File file = new  File("D:\\fileupload");
      //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
      if (!file.exists()) file.mkdirs();
      //新建一个文件
      File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx"); 
      //将上传的文件写入新建的文件中
      try {
          cf.getFileItem().write(file1); 
      } catch (Exception e) {
          e.printStackTrace();
      }
      
      //初始化客户信息的集合    
      List<BatchCollectDetaBean> customerList=new ArrayList<BatchCollectDetaBean>();
      //初始化输入流
      InputStream is = null;  
      try{
         //验证文件名是否合格
         if(!validateExcel(fileName)){
             return null;
         }
         //根据文件名判断文件是2003版本还是2007版本
         boolean isExcel2003 = true; 
         if(ReadExcel.isExcel2007(fileName)){
             isExcel2003 = false;  
         }
         //根据新建的文件实例化输入流
         is = new FileInputStream(file1);
         //根据excel里面的内容读取客户信息
         customerList = getExcelInfo(is, isExcel2003); 
         
         is.close();
     }catch(Exception e){
         e.printStackTrace();
     } finally{
         if(is !=null)
         {
             try{
                 is.close();
             }catch(IOException e){
                 is = null;    
                 e.printStackTrace();  
             }
         }
     }
    
	return null; 
	  
	
  }*/
  /**
   * 读取Excel里面商户发起的交易信息
   * @param wb
   * @return
   */
  private List<BatchCollectDetaBean> readExcelValue(Workbook wb){ 
      //得到第一个shell  
       Sheet sheet=wb.getSheetAt(0);
       
      //得到Excel的行数
       this.totalRows=sheet.getPhysicalNumberOfRows();
       
      //得到Excel的列数(前提是有行数)
       if(totalRows>=1 && sheet.getRow(0) != null){
            this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
       }
       
       List<BatchCollectDetaBean> customerList=new ArrayList<BatchCollectDetaBean>();
       BatchCollectDetaBean customer;     
       
      //循环Excel行数,从第1行开始。标题不入库
       for(int r=1;r<totalRows;r++){
           Row row = sheet.getRow(r);
           if (row == null) continue;
           customer = new BatchCollectDetaBean();
           
           //循环Excel的列
           for(int c = 0; c <this.totalCells; c++){    
               row.getCell(c).setCellType(Cell.CELL_TYPE_STRING);
               Cell cell = row.getCell(c);
               customer.setCurrencyCode("156");//交易币种
               customer.setCertifTp("01");//证件类型
               customer.setCvn2("");//cvn2
               customer.setExpired("");	// 卡有效期
              if (null != cell){
                   if(c==0){//
                	   customer.setOrderId(cell.getStringCellValue());//商户订单号
                   }else if(c==1){
                	   customer.setAmt(cell.getStringCellValue());//单笔金额
                   }else if(c==2){
                	   customer.setCardNo(cell.getStringCellValue());//银行卡号
                   }else if(c==3){
                	   customer.setCardType(cell.getStringCellValue());//卡类型
                   }else if(c==4){
                	   customer.setCustomerNm(cell.getStringCellValue());//持卡人姓名
                   }else if(c==5){
                	   customer.setCertifId(cell.getStringCellValue());// 身份证件号
                   }else if(c==6){
                	   customer.setPhoneNo(cell.getStringCellValue());// 手机号
                   }/*else if(c==7){
                	   customer.setCvn2(cell.getStringCellValue());//cvn2
                   }else if(c==8){
                	   customer.setExpired(cell.getStringCellValue());	// 卡有效期
                   }*/
                   
                   //证件类型证件号
               }
           }
           //添加客户
           customerList.add(customer);
       }
       return customerList;
  }
  
  
//@描述：是否是2003的excel，返回true是2003 
  public static boolean isExcel2003(String filePath)  {  
       return filePath.matches("^.+\\.(?i)(xls)$");  
   }  
 
  //@描述：是否是2007的excel，返回true是2007 
  public static boolean isExcel2007(String filePath)  {  
       return filePath.matches("^.+\\.(?i)(xlsx)$");  
   } 
}
