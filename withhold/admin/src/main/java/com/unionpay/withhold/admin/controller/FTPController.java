package com.unionpay.withhold.admin.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.FTPfiles;
import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.utils.FTPListAllFiles;
import com.unionpay.withhold.admin.utils.FTPUtils;

@Controller
@RequestMapping("/ftp")
public class FTPController {
	
	 private final static Logger logger = LoggerFactory.getLogger(FTPController.class);
	 private String historyDir="";
	//private static final String ROOTPATH="agency/";
	//private static final String USER="webftp";
	//private static final String PWD="webftp";
	//private static final String IPADDRESS="192.168.2.12";
	//private static final int PORTNUM=21;
	//private static final String DOWNLOADADDRESS="D:/DownLogFromFtp";
	@Value("${IPADDRESS}")
	private String IPADDRESS;
	@Value("${PORTNUM}")
	private int PORTNUM;
	@Value("${USER}")
	private String USER;
	@Value("${PWD}")
	private String PWD;
	@Value("${ROOTPATH}")
	private String ROOTPATH;
	@Value("${DOWNLOADADDRESS}")
	private String DOWNLOADADDRESS;
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/ftp/ftp_mana");
        return result;
    } 
	/**
	 * 查询文件夹
	 * s
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean queryDirectory() throws IOException {
			List<FTPfiles> resultList = new ArrayList<FTPfiles>();
		if(FTPListAllFiles.login(IPADDRESS, PORTNUM, USER, PWD)){
			  List<String> listDirectory = FTPListAllFiles.directoryList(ROOTPATH);
			for (String folder : listDirectory) {
				FTPfiles ftPfiles = new FTPfiles();
				ftPfiles.setFolder(folder);
				ftPfiles.setStatus("00");
				resultList.add(ftPfiles);
			}
			  
			  return new PageBean(resultList.size(), resultList);
		}
		
		return new PageBean(0, null);
		
	}
	/**
	 * 查询实时文件
	 * s
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/getFilesNow")
	public List<FTPfiles> queryFilesAndfolder(String folder) throws IOException {
			List<FTPfiles> resultList = new ArrayList<FTPfiles>();
		if(FTPListAllFiles.login(IPADDRESS, PORTNUM, USER, PWD)){
			List<String> filesList = FTPListAllFiles.filesList(ROOTPATH+folder + "/", "log");
			  for (String fileName : filesList) {
				  FTPfiles ftPfiles = new FTPfiles();
				  ftPfiles.setFileName(fileName);
				  resultList.add(ftPfiles);
			}
			 
		}
		
		return resultList;
		
	}
	/**
	 * 查询历史文件
	 * s
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/getFilesHistory")
	public List<FTPfiles> queryFiles(String folder) throws IOException {
			List<FTPfiles> resultList = new ArrayList<FTPfiles>();
		
		if(FTPListAllFiles.login(IPADDRESS, PORTNUM, USER, PWD)){
			List<String> listDirectory = FTPListAllFiles.directoryList(ROOTPATH+folder+"/");
			historyDir=listDirectory.get(0);
		}
			
		if(FTPListAllFiles.login(IPADDRESS, PORTNUM, USER, PWD)){
			List<String> filesList = FTPListAllFiles.filesList(ROOTPATH+folder +"/"+historyDir+"/", "zip");
			  for (String fileName : filesList) {
				  FTPfiles ftPfiles = new FTPfiles();
				  ftPfiles.setFileName(fileName);
				  resultList.add(ftPfiles);
			}
		}
		return resultList;
		
	}
	/**
	 * 下载文件夹下某个文件
	 * s
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/downloadFile")
	public Map<String, Object> downloadFile(String fileName,HttpServletRequest request,HttpServletResponse response){
		Map<String, Object> hashMap = new HashMap<String, Object>();
		String[] split = fileName.split("/");
		 try {
			 File file = new File(DOWNLOADADDRESS);
			 if(!file.exists()){
				 file.mkdirs();
			 }
			 boolean flag=false;
			
			if(split[1].contains("zip")){
				flag = FTPUtils.downloadFile(IPADDRESS, PORTNUM, USER, PWD,ROOTPATH+split[0]+"/"+historyDir+"/",split[1] , DOWNLOADADDRESS);
			}else{
				flag = FTPUtils.downloadFile(IPADDRESS, PORTNUM, USER, PWD,ROOTPATH+split[0]+"/",split[1] , DOWNLOADADDRESS);
			}
			
			if (flag) {
				ServletContext servletContext = request.getSession().getServletContext();
				String path = servletContext.getRealPath("/");  
				boolean result = download(response,split[1],DOWNLOADADDRESS+"/"+split[1]);
				if(result){
					hashMap.put("RET", "succ");
				}
			}
			 logger.info("flag:"+flag); 
			
		 } catch (Exception e) {
			 hashMap.put("RET", "fail");
			 logger.error("下载文件异常",e);
		}
		
		return null;
	}
	
	/** 
     * @Description:自定义下载文件名方法 
     * @param response 
     * @param fileName 
     * @param filePath 
     * @throws IOException 
     */  
    public boolean download(HttpServletResponse response, String fileName, String filePath) throws Exception{  
    	
    	File file = new File(filePath); 
        boolean result=false;
        if(file.isFile()){  
            String filaname = new String((fileName).getBytes("utf-8"),"ISO8859-1");  
            //response.reset();  
            response.setContentType("application/octet-stream;charset=utf-8");
            //response.setContentType("application/x-download");
            response.setHeader("Content-Disposition","attachment;filename=" + filaname);  
            FileInputStream fis =null;
            BufferedInputStream bis = null;
            ServletOutputStream os=null;
            try {
            	fis = new FileInputStream(file);
            	
				bis = new BufferedInputStream(fis);
				os = response.getOutputStream();
				byte[] b = new byte[1024]; 
				int i = 0;
				while ((i = bis.read(b)) != -1){
					
				    os.write(b,0,i);  
				}
				
				result=true;
			} catch (Exception e) {
				result=false;
				e.printStackTrace();
			}  finally{
				fis.close();
				bis.close();  
				os.flush();
				response.flushBuffer();
			}
        }else{  
        	result=false;
            throw new Exception("下载类型不是文件或不存在！"); 
            
        } 
        return result;
    }  
}
