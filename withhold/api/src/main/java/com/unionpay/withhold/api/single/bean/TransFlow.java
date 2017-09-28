package com.unionpay.withhold.api.single.bean;

import java.util.Date;

public class TransFlow {
    private Integer id;

    private String passwayOrderId;

    private String mchntOrderId;

    private String priAcctNo;

    private String name;

    private String phone;

    private String idCard;

    private String mchntCd;

    private String chnlId;

    private String passwayId;

    private String passwayMchntCd;

    private String transFactorId;

    private String transTp;

    private String transStatus;

    private String dkType;

    private Long transAt;

    private String transTm;

    private String batchId;

    private String respCd;

    private String respMsg;

    private String origRespCd;

    private String origRespMsg;

    private Integer mchntFee;

    private Integer passwayGain;

    private Integer chnlGain;

    private Integer upGain;

    private String transSource;

    private String interfaceBackUrl;

    private String interfaceNotifyState;

    private Integer interfaceNotifyTimes;

    private Date interfaceNotifyTs;

    private String recCrtUser;

    private Date recCrtTs;

    private String recUpdUser;

    private Date recUpdTs;

    private String resv1;

    private String resv2;

    private String resv3;

    private String resv4;

    private String certId;

    public String getCertId() {
		return certId;
	}

	public void setCertId(String certId) {
		this.certId = certId;
	}

	private String transDt;

////////////////////////////////////////////////////
/// My Coding Starting
    private String chnlNm;
    private String mchntNm;
    
    public String getChnlNm() {
		return chnlNm;
	}

	public void setChnlNm(String chnlNm) {
		this.chnlNm = chnlNm;
	}

	public String getMchntNm() {
		return mchntNm;
	}

	public void setMchntNm(String mchntNm) {
		this.mchntNm = mchntNm;
	}
/// My Coding End
////////////////////////////////////////////////////
	
	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPasswayOrderId() {
        return passwayOrderId;
    }

    public void setPasswayOrderId(String passwayOrderId) {
        this.passwayOrderId = passwayOrderId == null ? null : passwayOrderId.trim();
    }

    public String getMchntOrderId() {
        return mchntOrderId;
    }

    public void setMchntOrderId(String mchntOrderId) {
        this.mchntOrderId = mchntOrderId == null ? null : mchntOrderId.trim();
    }

    public String getPriAcctNo() {
        return priAcctNo;
    }

    public void setPriAcctNo(String priAcctNo) {
        this.priAcctNo = priAcctNo == null ? null : priAcctNo.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getMchntCd() {
        return mchntCd;
    }

    public void setMchntCd(String mchntCd) {
        this.mchntCd = mchntCd == null ? null : mchntCd.trim();
    }

    public String getChnlId() {
        return chnlId;
    }

    public void setChnlId(String chnlId) {
        this.chnlId = chnlId == null ? null : chnlId.trim();
    }

    public String getPasswayId() {
        return passwayId;
    }

    public void setPasswayId(String passwayId) {
        this.passwayId = passwayId == null ? null : passwayId.trim();
    }

    public String getPasswayMchntCd() {
        return passwayMchntCd;
    }

    public void setPasswayMchntCd(String passwayMchntCd) {
        this.passwayMchntCd = passwayMchntCd == null ? null : passwayMchntCd.trim();
    }

    public String getTransFactorId() {
        return transFactorId;
    }

    public void setTransFactorId(String transFactorId) {
        this.transFactorId = transFactorId == null ? null : transFactorId.trim();
    }

    public String getTransTp() {
        return transTp;
    }

    public void setTransTp(String transTp) {
        this.transTp = transTp == null ? null : transTp.trim();
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus == null ? null : transStatus.trim();
    }

    public String getDkType() {
        return dkType;
    }

    public void setDkType(String dkType) {
        this.dkType = dkType == null ? null : dkType.trim();
    }

    public Long getTransAt() {
        return transAt;
    }

    public void setTransAt(Long transAt) {
        this.transAt = transAt;
    }

    public String getTransTm() {
        return transTm;
    }

    public void setTransTm(String transTm) {
        this.transTm = transTm == null ? null : transTm.trim();
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId == null ? null : batchId.trim();
    }

    public String getRespCd() {
        return respCd;
    }

    public void setRespCd(String respCd) {
        this.respCd = respCd == null ? null : respCd.trim();
    }

    public String getRespMsg() {
        return respMsg;
    }

    public void setRespMsg(String respMsg) {
        this.respMsg = respMsg == null ? null : respMsg.trim();
    }

    public String getOrigRespCd() {
        return origRespCd;
    }

    public void setOrigRespCd(String origRespCd) {
        this.origRespCd = origRespCd == null ? null : origRespCd.trim();
    }

    public String getOrigRespMsg() {
        return origRespMsg;
    }

    public void setOrigRespMsg(String origRespMsg) {
        this.origRespMsg = origRespMsg == null ? null : origRespMsg.trim();
    }

    public Integer getMchntFee() {
        return mchntFee;
    }

    public void setMchntFee(Integer mchntFee) {
        this.mchntFee = mchntFee;
    }

    public Integer getPasswayGain() {
        return passwayGain;
    }

    public void setPasswayGain(Integer passwayGain) {
        this.passwayGain = passwayGain;
    }

    public Integer getChnlGain() {
        return chnlGain;
    }

    public void setChnlGain(Integer chnlGain) {
        this.chnlGain = chnlGain;
    }

    public Integer getUpGain() {
        return upGain;
    }

    public void setUpGain(Integer upGain) {
        this.upGain = upGain;
    }

    public String getTransSource() {
        return transSource;
    }

    public void setTransSource(String transSource) {
        this.transSource = transSource == null ? null : transSource.trim();
    }

    public String getInterfaceBackUrl() {
        return interfaceBackUrl;
    }

    public void setInterfaceBackUrl(String interfaceBackUrl) {
        this.interfaceBackUrl = interfaceBackUrl == null ? null : interfaceBackUrl.trim();
    }

    public String getInterfaceNotifyState() {
        return interfaceNotifyState;
    }

    public void setInterfaceNotifyState(String interfaceNotifyState) {
        this.interfaceNotifyState = interfaceNotifyState == null ? null : interfaceNotifyState.trim();
    }

    public Integer getInterfaceNotifyTimes() {
        return interfaceNotifyTimes;
    }

    public void setInterfaceNotifyTimes(Integer interfaceNotifyTimes) {
        this.interfaceNotifyTimes = interfaceNotifyTimes;
    }

    public Date getInterfaceNotifyTs() {
        return interfaceNotifyTs;
    }

    public void setInterfaceNotifyTs(Date interfaceNotifyTs) {
        this.interfaceNotifyTs = interfaceNotifyTs;
    }

    public String getRecCrtUser() {
        return recCrtUser;
    }

    public void setRecCrtUser(String recCrtUser) {
        this.recCrtUser = recCrtUser == null ? null : recCrtUser.trim();
    }

    public Date getRecCrtTs() {
        return recCrtTs;
    }

    public void setRecCrtTs(Date recCrtTs) {
        this.recCrtTs = recCrtTs;
    }

    public String getRecUpdUser() {
        return recUpdUser;
    }

    public void setRecUpdUser(String recUpdUser) {
        this.recUpdUser = recUpdUser == null ? null : recUpdUser.trim();
    }

    public Date getRecUpdTs() {
        return recUpdTs;
    }

    public void setRecUpdTs(Date recUpdTs) {
        this.recUpdTs = recUpdTs;
    }

    public String getResv1() {
        return resv1;
    }

    public void setResv1(String resv1) {
        this.resv1 = resv1 == null ? null : resv1.trim();
    }

    public String getResv2() {
        return resv2;
    }

    public void setResv2(String resv2) {
        this.resv2 = resv2 == null ? null : resv2.trim();
    }

    public String getResv3() {
        return resv3;
    }

    public void setResv3(String resv3) {
        this.resv3 = resv3 == null ? null : resv3.trim();
    }

    public String getResv4() {
        return resv4;
    }

    public void setResv4(String resv4) {
        this.resv4 = resv4 == null ? null : resv4.trim();
    }

    public String getTransDt() {
        return transDt;
    }

    public void setTransDt(String transDt) {
        this.transDt = transDt == null ? null : transDt.trim();
    }
}