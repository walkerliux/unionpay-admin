package com.unionpay.withhold.admin.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	private static final String ROOTPATH="agency/";
	private static final String USER="webftp";
	private static final String PWD="webftp";
	private static final String IPADDRESS="192.168.2.12";
	private static final int PORTNUM=21;
	private static final String DOWNLOADADDRESS="D:/DownLogFromFtp";
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
	 * 查询文件夹下的所有文件
	 * s
	 * @return
	 * @throws IOException 
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/getFiles")
	public List<FTPfiles> queryFiles(String folder) throws IOException {
			List<FTPfiles> resultList = new ArrayList<FTPfiles>();
		if(FTPListAllFiles.login(IPADDRESS, PORTNUM, USER, PWD)){
			List<String> filesList = FTPListAllFiles.filesList(ROOTPATH+folder + "/", "jpg");
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
	public Map<String, Object> downloadFile(String fileName){
		Map<String, Object> hashMap = new HashMap<String, Object>();
		String[] split = fileName.split("/");
		 try {
			 File file = new File("D:/DownLogFromFtp");
			 if(!file.exists()){
				 file.mkdir();
			 }
			 
			boolean flag = FTPUtils.downloadFile(IPADDRESS, PORTNUM, USER, PWD,ROOTPATH+split[0]+"/",split[1] , DOWNLOADADDRESS);
			if (flag) {
				hashMap.put("RET", "succ");
			}
			
		 } catch (Exception e) {
			 hashMap.put("RET", "fail");
			e.printStackTrace();
		}
		
		return hashMap;
	}
	
}
