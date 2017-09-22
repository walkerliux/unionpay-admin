package com.unionpay.withhold.api.common.bean;

import java.sql.Timestamp;

/**
 * 通道信息
 * 
 * @author weidan
 *
 */
public class PasswayInfo {

	/**
	 * 主键id
	 */
	private Integer id;
	/**
	 * 通道id
	 */
	private String passwayId;
	/**
	 * 通道名称
	 */
	private String passwayName;
	/**
	 * 通道公钥
	 */
	private String passwayPublicKey;
	/**
	 * 代扣平台公钥
	 */
	private String dkPublicKey;
	/**
	 * 代扣平台私钥
	 */
	private String dkPrivateKey;
	/**
	 * 代扣平台证书路径
	 */
	private String dkPrivatePwd;
	/**
	 * 代扣平台证书id
	 */
	private String dkCertId;
	/**
	 * 代扣平台加密证书id
	 */
	private String dkEncryptCertId;
	/**
	 * 通道状态
	 */
	private String passwayStatus;
	/**
	 * 创建人
	 */
	private String recCrtUser;
	/**
	 * 创建时间
	 */
	private Timestamp recCrtTs;
	/**
	 * 更新人
	 */
	private String recUpdUser;
	/**
	 * 更新时间
	 */
	private Timestamp recUpdTs;

	private String resv1;

	private String resv2;

	private String factorNames;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPasswayId() {
		return passwayId;
	}

	public void setPasswayId(String passwayId) {
		this.passwayId = passwayId;
	}

	public String getPasswayName() {
		return passwayName;
	}

	public void setPasswayName(String passwayName) {
		this.passwayName = passwayName;
	}

	public String getPasswayPublicKey() {
		return passwayPublicKey;
	}

	public void setPasswayPublicKey(String passwayPublicKey) {
		this.passwayPublicKey = passwayPublicKey;
	}

	public String getDkPublicKey() {
		return dkPublicKey;
	}

	public void setDkPublicKey(String dkPublicKey) {
		this.dkPublicKey = dkPublicKey;
	}

	public String getDkPrivateKey() {
		return dkPrivateKey;
	}

	public void setDkPrivateKey(String dkPrivateKey) {
		this.dkPrivateKey = dkPrivateKey;
	}

	public String getDkPrivatePwd() {
		return dkPrivatePwd;
	}

	public void setDkPrivatePwd(String dkPrivatePwd) {
		this.dkPrivatePwd = dkPrivatePwd;
	}

	public String getDkCertId() {
		return dkCertId;
	}

	public void setDkCertId(String dkCertId) {
		this.dkCertId = dkCertId;
	}

	public String getDkEncryptCertId() {
		return dkEncryptCertId;
	}

	public void setDkEncryptCertId(String dkEncryptCertId) {
		this.dkEncryptCertId = dkEncryptCertId;
	}

	public String getPasswayStatus() {
		return passwayStatus;
	}

	public void setPasswayStatus(String passwayStatus) {
		this.passwayStatus = passwayStatus;
	}

	public String getRecCrtUser() {
		return recCrtUser;
	}

	public void setRecCrtUser(String recCrtUser) {
		this.recCrtUser = recCrtUser;
	}

	public Timestamp getRecCrtTs() {
		return recCrtTs;
	}

	public void setRecCrtTs(Timestamp recCrtTs) {
		this.recCrtTs = recCrtTs;
	}

	public String getRecUpdUser() {
		return recUpdUser;
	}

	public void setRecUpdUser(String recUpdUser) {
		this.recUpdUser = recUpdUser;
	}

	public Timestamp getRecUpdTs() {
		return recUpdTs;
	}

	public void setRecUpdTs(Timestamp recUpdTs) {
		this.recUpdTs = recUpdTs;
	}

	public String getResv1() {
		return resv1;
	}

	public void setResv1(String resv1) {
		this.resv1 = resv1;
	}

	public String getResv2() {
		return resv2;
	}

	public void setResv2(String resv2) {
		this.resv2 = resv2;
	}

	public String getFactorNames() {
		return factorNames;
	}

	public void setFactorNames(String factorNames) {
		this.factorNames = factorNames;
	}

	@Override
	public String toString() {
		return "PasswayInfo [id=" + id + ", passwayId=" + passwayId + ", passwayName=" + passwayName
				+ ", passwayPublicKey=" + passwayPublicKey + ", dkPublicKey=" + dkPublicKey + ", dkPrivateKey="
				+ dkPrivateKey + ", dkPrivatePwd=" + dkPrivatePwd + ", dkCertId=" + dkCertId + ", dkEncryptCertId="
				+ dkEncryptCertId + ", passwayStatus=" + passwayStatus + ", recCrtUser=" + recCrtUser + ", recCrtTs="
				+ recCrtTs + ", recUpdUser=" + recUpdUser + ", recUpdTs=" + recUpdTs + ", resv1=" + resv1 + ", resv2="
				+ resv2 + ", transFactorIds=" + factorNames + "]";
	}

}
