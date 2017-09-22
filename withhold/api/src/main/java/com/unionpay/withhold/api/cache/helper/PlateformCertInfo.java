package com.unionpay.withhold.api.cache.helper;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

public class PlateformCertInfo {
	private X509Certificate certificate;
	private PrivateKey privateKey;
	private String certId;
	public X509Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(X509Certificate certificate) {
		this.certificate = certificate;
	}
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	public String getCertId() {
		return certId;
	}
	public void setCertId(String certId) {
		this.certId = certId;
	}
}
