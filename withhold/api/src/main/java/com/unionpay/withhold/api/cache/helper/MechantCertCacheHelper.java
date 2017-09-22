package com.unionpay.withhold.api.cache.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 商户密钥证书文件缓存数据
 * 
 * @author Luke
 *
 */
@Service
public class MechantCertCacheHelper {
	private static final Logger logger = Logger.getLogger(MechantCertCacheHelper.class);
    public  X509Certificate getCertByFileName(String fileName) {
    	X509Certificate pubCert =null;
    	try {
	    	File certFile = new File(fileName);
			if(certFile.isFile() && (certFile.getName().endsWith("crt") || certFile.getName().endsWith("cer"))) {
				String keyName = certFile.getName();
					logger.debug("开始装载密钥： " + keyName);
					InputStream in = null;
					try {
	    				in = new FileInputStream(certFile);
	    				CertificateFactory cf = CertificateFactory.getInstance("X.509");
	    				pubCert= (X509Certificate) cf.generateCertificate(in);
	    				logger.debug("装载成功密钥： " + keyName + ", SerialNumber=" + pubCert.getSerialNumber());
					}
					catch(Exception e) {
						logger.error(e);;
					}
					finally {
						if(in != null) {
							in.close();
						}
					}
				}
        } catch (Exception e) {
        	logger.error(e);
        }
    	return pubCert;
    }
}
