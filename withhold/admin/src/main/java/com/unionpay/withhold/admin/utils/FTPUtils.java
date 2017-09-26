package com.unionpay.withhold.admin.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * ftp上传下载工具类
 */
public class FTPUtils {

	/** 
	 * Description: 向FTP服务器上传文件 
	 * @param host FTP服务器hostname 
	 * @param port FTP服务器端口 
	 * @param username FTP登录账号 
	 * @param password FTP登录密码 
	 * @param basePath FTP服务器基础目录
	 * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
	 * @param filename 上传到FTP服务器上的文件名 
	 * @param input 输入流 
	 * @return 成功返回true，否则返回false 
	 */  
	public static boolean uploadFile(String host, int port, String username, String password, String basePath,
			String filePath, String filename, InputStream input) {
		boolean result = false;
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect(host, port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			ftp.enterLocalPassiveMode();
			ftp.setControlEncoding("GBK");
//			reply = ftp.getReplyCode();
			//切换到上传目录
			if (!ftp.changeWorkingDirectory(basePath+filePath)) {
				String[] dirs = filePath.split("/");
				String tempPath = basePath;
				for (String dir : dirs) {
					if (null == dir || "".equals(dir)) continue;
					tempPath += dir +"/";
					if (!ftp.changeWorkingDirectory(tempPath)) {
						if (!ftp.makeDirectory(new String(tempPath.getBytes("GBK"),"iso-8859-1"))) {
							return result;
						} else {
							ftp.changeWorkingDirectory(tempPath);
						}
					}
				}
			}
			//设置上传文件的类型为二进制类型
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			//上传文件
			if (!ftp.storeFile(new String(filename.getBytes("GBK"),"iso-8859-1"), input)) {
				return result;
			}
			input.close();
			ftp.logout();
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		return result;
	}
	
	/** 
	 * Description: 从FTP服务器下载文件 
	 * @param host FTP服务器hostname 
	 * @param port FTP服务器端口 
	 * @param username FTP登录账号 
	 * @param password FTP登录密码 
	 * @param remotePath FTP服务器上的相对路径 
	 * @param fileName 要下载的文件名 
	 * @param localPath 下载后保存到本地的路径 
	 * @return 
	 */  
	public static boolean downloadFile(String host, int port, String username, String password, String remotePath,
			String fileName, String localPath) {
		long currentTime = System.currentTimeMillis();
		
		
		boolean result = false;
		FTPClient ftp = new FTPClient();
		OutputStream is = null;
		try {
			ftp.connect(host, port);
			// 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			ftp.setBufferSize(1024);
			ftp.enterLocalPassiveMode();
			ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
			File localFile = new File(localPath + "/" + fileName);
			is = new FileOutputStream(localFile);
			ftp.retrieveFile(fileName, is);
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			 IOUtils.closeQuietly(is);
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
				}
			}
		}
		System.out.println("excute time:"+(System.currentTimeMillis()-currentTime));
		return result;
	}
	
	public static void main(String[] args) {
		try {
	        FileInputStream in=new FileInputStream(new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\aa.jpg"));
	        String resFileName = "aa.jpg";
//	        String uploadDir = "E:\\";
//	        String filePath = "86b59f1e522a4e3d94037eb1c9503f30.jpg";
	        resFileName =UUID.randomUUID().toString().replace("-", "") + resFileName.substring(resFileName.lastIndexOf("."));
	        boolean flag = uploadFile("192.168.2.12", 21, "webftp", "webftp","agency/","200000000001602/20170727/01", resFileName, in);  
//	        boolean flag = FTPUtils.downloadFile("192.168.2.12", 21, "webftp", "webftp","agency/200000000001599/",filePath , uploadDir);
	        System.out.println(flag);  
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	}
}
