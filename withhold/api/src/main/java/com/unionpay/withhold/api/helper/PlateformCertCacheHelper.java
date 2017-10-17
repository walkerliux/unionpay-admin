package com.unionpay.withhold.api.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 平台密钥管理
 * 
 * @author 张世栋
 *
 */
@Service
public class PlateformCertCacheHelper {
	private static final Logger logger = Logger.getLogger(PlateformCertCacheHelper.class);
    /**
     * 获取 平台pfx证书信息
     */
    public PlateformCertInfo getPlatFormCertInfo(String certPath,String dkPrivateKeyPwd) throws Exception {
    	PlateformCertInfo  plateformCertInfo=new PlateformCertInfo();
		String alias = "";
		KeyStore keyStore = getKeyInfo(certPath, dkPrivateKeyPwd, "PKCS12");
		Enumeration<String> aliasEnum = keyStore.aliases();
		if (aliasEnum.hasMoreElements()) {
			alias = (String) aliasEnum.nextElement();
		}
		InputStream in = new FileInputStream(certPath);
		keyStore.load(in, dkPrivateKeyPwd.toCharArray());
		in.close();
		PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, dkPrivateKeyPwd.toCharArray());
		if (privateKey == null) {
			logger.error("装载平台密钥异常，未匹配到有效的私钥信息");
			return null;
		}
		plateformCertInfo.setPrivateKey(privateKey);
		X509Certificate certificate=(X509Certificate) keyStore.getCertificate(alias);
		plateformCertInfo.setCertificate(certificate);
		plateformCertInfo.setCertId(certificate.getSerialNumber().toString());
		return plateformCertInfo;
    }
	/**
	 * 
	 * @param pfxKeyFile
	 * @param keyPwd
	 * @param type
	 * @return
	 * @throws IOException
	 */
	private KeyStore getKeyInfo(String pfxKeyFile, String keyPwd, String type) throws IOException {
		FileInputStream fis = null;
		try {
			KeyStore ks = null;
			if ("JKS".equals(type)) {
				ks = KeyStore.getInstance(type);
			} else if ("PKCS12".equals(type)) {
				ks = KeyStore.getInstance(type);
			}
			fis = new FileInputStream(pfxKeyFile);

			if (null != ks) {
				ks.load(fis, keyPwd.toCharArray());
			}
			return ks;
		} catch (Exception e) {
		} finally {
			if (null != fis)
				fis.close();
		}
		return null;
	}
}
