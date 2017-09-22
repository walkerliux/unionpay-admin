package com.unionpay.dk.webservice;

import javax.annotation.Resource;

import org.apache.cxf.aegis.databinding.AegisDatabinding;
import org.apache.cxf.frontend.ServerFactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;


/**
 * ws启动类
 * 
 * @author zsd
 * @since 2017年9月21日12:34:56
 **/
@Component
public class WSServerInitializingBean implements InitializingBean {

	private static String DEFAULT_IP = "127.0.0.1";
	private static String DEFAULT_PORT = "10003";

	@Resource
	private TranWebService tran;

	/*@Resource
	ConfigService configService;*/

	@Override
	public void afterPropertiesSet() throws Exception {
		ServerFactoryBean fac = new ServerFactoryBean();
		fac.setServiceClass(TranWebService.class);
		fac.setAddress("http://" + getDefaultIp() + ":" + getDefaultPort() + "/dkTranFlow");
		fac.setServiceBean(tran);
		fac.getServiceFactory().setDataBinding(new AegisDatabinding());
		fac.create();
	}

	protected String getDefaultIp() {
		/*if (configService.findByKey("dk_ws_ip") != null) {
			return configService.findByKey("dk_ws_ip").getDkValue();
		}*/
		return DEFAULT_IP;
	}

	protected String getDefaultPort() {
		/*if (configService.findByKey("dk_ws_post") != null) {
			return configService.findByKey("dk_ws_post").getDkValue();
		}*/
		return DEFAULT_PORT;
	}

}
