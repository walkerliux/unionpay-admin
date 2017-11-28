package com.unionpay.withhold.admin.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.FtpBean;
import com.unionpay.withhold.admin.service.FtpService;

@Service
@Transactional
public class FtpServiceImpl implements FtpService{

	@Value("${IPADDRESS}")
	private String IPADDRESS;
	@Value("${PORTNUM}")
	private String PORTNUM;
	@Value("${USER}")
	private String USER;
	@Value("${PWD}")
	private String PWD;
	
	
	@Override
	public FtpBean getFtpBean() {
		FtpBean ftpBean =new FtpBean();
		ftpBean.setIp(IPADDRESS);
		ftpBean.setPort(PORTNUM);
		ftpBean.setUsers(USER);
		ftpBean.setPwd(PWD);
		return ftpBean;
	}
	

	
	

}
