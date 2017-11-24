package com.unionpay.withhold.admin.Bean;

import java.io.File;
import java.util.TimerTask;

public class MyTimer extends TimerTask {
	private String fileName;
	private String localPath;
	
	public MyTimer(String fileName, String localPath) {
		super();
		this.fileName = fileName;
		this.localPath = localPath;
	}

	@Override
	public void run() {
		if (localPath!=null&&!"".equals("")) {
			File file = new File(localPath+"/"+fileName);
			if (file.exists()&&file.isFile()) {
				file.delete();
			}
		}else {
			File file = new File(fileName);
			if (file.exists()&&file.isFile()) {
				file.delete();
			}
		}
		
	}
}
