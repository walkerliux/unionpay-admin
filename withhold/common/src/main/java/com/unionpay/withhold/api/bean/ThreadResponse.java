package com.unionpay.withhold.api.bean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * XML解析对象
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Response")
@XmlType(name = "Response", propOrder = { "Root", "signature" })
public class ThreadResponse implements Serializable {

	private static final long serialVersionUID = -6765100196395847462L;

	private TRspRoot Root;

	private String signature;

	public TRspRoot getRoot() {
		return Root;
	}

	public void setRoot(TRspRoot root) {
		Root = root;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
