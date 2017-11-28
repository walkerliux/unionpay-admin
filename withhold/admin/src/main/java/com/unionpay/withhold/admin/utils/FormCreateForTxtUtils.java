package com.unionpay.withhold.admin.utils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormCreateForTxtUtils {

	/*private final static Logger log = LoggerFactory.getLogger(FormCreateForTxtUtils.class);
	@SuppressWarnings("all")
	public static Map<String, Object> createTxt(String prefix,TxnsForPortalBean txnsForPortalBean,FtpBean ftpBean,Map<String, Object> dataMap,FileService fileService) {
		log.info(prefix+"form create start intime");
		String fileType="txt";
		String merId=txnsForPortalBean.getMerid();
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) dataMap.get("rows");
		FileOutputStream outSTr = null;
		FileInputStream inStream=null;
		BufferedOutputStream Buff = null;
		String filenamewithouttype=prefix + "-" + txnsForPortalBean.getStime() + "-" + txnsForPortalBean.getEtime();
		String fileName = prefix + "-" + txnsForPortalBean.getStime() + "-" + txnsForPortalBean.getEtime() + "."+fileType;
		String enter = "\r\n";
		StringBuffer write;
		boolean flag = false;
		Map<String, Object> returnResult = new HashMap<>();
		try {
			String dirPath=createDir(prefix, merId);
			String localpath=System.getProperty("user.home")+"/tempdata/formData/"+dirPath;
			File localDir=new File(localpath);
			if (!localDir.exists()) {
				localDir.mkdirs();
			}
			outSTr = new FileOutputStream(new File(localpath+fileName));
			Buff = new BufferedOutputStream(outSTr);
			for (Map<String, Object> map : dataList) {
				write = new StringBuffer();
				for (String in : map.keySet()) {
					write.append(map.get(in).equals("null") ? "无" : map.get(in));
					write.append(",");
				}
				write.append(enter);
				Buff.write(write.toString().getBytes("UTF-8"));
			}
			flag = true;
			Buff.flush();
			Buff.close();
			outSTr.flush();
			outSTr.close();
			inStream=new FileInputStream(new File(localpath+fileName));
			flag =ftpUpload(prefix, inStream, fileName, ftpBean,merId);
			Map<String, Object> map =null;
			if (flag) {
				FileBean fileBean=new FileBean();
				if (prefix.length()>4) {
					prefix=prefix.substring(0, 4);
				}
				fileBean.setBusyType(prefix);
				fileBean.setFileName(filenamewithouttype);
				fileBean.setFileType(fileType);
				fileBean.setFtpPath(dirPath);
				fileBean.setLocalPath(dirPath);
				fileBean.setMemberId(merId);
				map = fileService.saveFile(fileBean);
				log.info(prefix + merId + "Form create sucess intime ");
				
			} else {
				log.info(prefix + merId + "Form create fail intime ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				Buff.close();
				outSTr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		log.info(prefix+"form create end intime");
		return returnResult;
	}
	
	private static String createDir(String prefix, String merId) {
		if (prefix.length()>4) {
			prefix=prefix.substring(0, 4);
		}
		String path = "FormsData" + File.separatorChar+merId+File.separatorChar;
		String dirPath=path + prefix + File.separatorChar + DateUtil.getCurrentDate() + File.separatorChar;
		return dirPath;
	}
	
	public static void main(String[] args) {
		System.out.println(FormServiceImpl.class.getResource("").getPath());
		System.out.println("user.home path: " + System.getProperty("user.home"));
		System.out.println("user.dir path: " + System.getProperty("user.dir"));
		String aString = "1234";
		System.out.println(aString.substring(0,4));
	}
	
	private static boolean ftpUpload(String pre, InputStream in, String fileName,FtpBean ftpBean,String merId) {
		return FTPUtils.uploadFile(ftpBean.getIp(), Integer.valueOf(ftpBean.getPort()), ftpBean.getUsers(), ftpBean.getPwd(),"",createDir(pre,merId), fileName, in);
	}*/
	
}
