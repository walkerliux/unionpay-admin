package com.unionpay.withhold.admin.pojo;

public class TTxnsLog {
    private String txnseqno;//交易序列号

    private String txndate;//交易日期

    private String txntime;//交易时间

    private String apptype;//应用类型

    private String busitype;//业务类型

    private String busicode;//业务代码

    private Long amount;//交易金额[合计]

    private Long tradcomm;//交易佣金

    private Long chnlfee;//通道成本

    private Long coopfee;//代理商手续费

    private Long txnfee;//交易手续费(商户手续费)

    private String riskver;//分控版本[商户角色]

    private String splitver;//分润版本[商户角色]

    private String feever;//扣率版本[商户角色]

    private String prdtver;//产品版本[商户角色]

    private String checkstandver;//收银台版本[商户角色]

    private String routver;//路由版本[客户角色]

    private String pan;//转出帐号或卡号或付款账号

    private String cardtype;//转出帐号类型

    private String cardinstino;//转出帐号或卡号所属机构

    private String inpan;//转入帐号或卡号或收款账号

    private String incardtype;//转入帐号或卡号类型

    private String incardinstino;//转入帐号或卡号机构代码

    private String accordno;//受理订单号

    private String accordinst;//受理订单所属机构

    private String accsecmerno;//受理二级商户号(商户号)

    private String accfirmerno;//受理一级商户号(渠道号)

    private String accsettledate;//受理清算日期

    private String accordcommitime;//受理定提交时间

    private String accordfintime;//受理定单完成时间

    private String accretcode;//受理应答码

    private String accretinfo;//受理应答信息

    private String paytype;//支付类型（01：快捷，02：网银，03：账户,04:代付）

    private String payordno;//支付定单号

    private String payinst;//通道代码

    private String payfirmerno;//支付一级商户号

    private String paysecmerno;//支付二级商户号

    private String payordcomtime;//支付定单提交时间

    private String payordfintime;//支付定单完成时间

    private String payrettsnseqno;//支付方交易流水号

    private String payretcode;//支付方应答码

    private String payretinfo;//支付方应答信息

    private String appordno;//应用定单号

    private String appinst;//应用所属机构

    private String appordcommitime;//应用定单提交时间

    private String appordfintime;//应用定单完成时间

    private String tradeseltxn;//交易查询流水[证联金融返给客户端流水 vs 交易序列号]

    private String retcode;//中心应答码

    private String retinfo;//中心应答信息

    private String tradestatflag;//交易状态标志位

    private String tradetxnflag;//交易所涉流水表标志位

    private String txncode;//路由层次[当前交易号]

    private String cashcode;//收银代码

    private String relate;//涉及流水表标志

    private String retdatetime;//中心应答时间

    private String txnseqnoOg;//原交易序列号

    private String notes;//备注

    private String remarks;//

    private String accmemberid;//受理会员号

    private String apporderstatus;//应用定单状态

    private String apporderinfo;//应用订单应答信息

    private String accbusicode;//账务业务代码

    private String acccoopinstino;//受理合作机构号

    private String panName;//转出帐户名/付款账户名称

    private String productcode;//产品代码

    private String groupcode;//行业群组号

    private String inpanName;//收款账户名称

    private String feepaymodel;//手续费付款方式 01预付费 02后付费

    private String pathcode;//渠道标记位

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno == null ? null : txnseqno.trim();
    }

    public String getTxndate() {
        return txndate;
    }

    public void setTxndate(String txndate) {
        this.txndate = txndate == null ? null : txndate.trim();
    }

    public String getTxntime() {
        return txntime;
    }

    public void setTxntime(String txntime) {
        this.txntime = txntime == null ? null : txntime.trim();
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype == null ? null : apptype.trim();
    }

    public String getBusitype() {
        return busitype;
    }

    public void setBusitype(String busitype) {
        this.busitype = busitype == null ? null : busitype.trim();
    }

    public String getBusicode() {
        return busicode;
    }

    public void setBusicode(String busicode) {
        this.busicode = busicode == null ? null : busicode.trim();
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getTradcomm() {
        return tradcomm;
    }

    public void setTradcomm(Long tradcomm) {
        this.tradcomm = tradcomm;
    }

    public Long getChnlfee() {
        return chnlfee;
    }

    public void setChnlfee(Long chnlfee) {
        this.chnlfee = chnlfee;
    }

    public Long getCoopfee() {
        return coopfee;
    }

    public void setCoopfee(Long coopfee) {
        this.coopfee = coopfee;
    }

    public Long getTxnfee() {
        return txnfee;
    }

    public void setTxnfee(Long txnfee) {
        this.txnfee = txnfee;
    }

    public String getRiskver() {
        return riskver;
    }

    public void setRiskver(String riskver) {
        this.riskver = riskver == null ? null : riskver.trim();
    }

    public String getSplitver() {
        return splitver;
    }

    public void setSplitver(String splitver) {
        this.splitver = splitver == null ? null : splitver.trim();
    }

    public String getFeever() {
        return feever;
    }

    public void setFeever(String feever) {
        this.feever = feever == null ? null : feever.trim();
    }

    public String getPrdtver() {
        return prdtver;
    }

    public void setPrdtver(String prdtver) {
        this.prdtver = prdtver == null ? null : prdtver.trim();
    }

    public String getCheckstandver() {
        return checkstandver;
    }

    public void setCheckstandver(String checkstandver) {
        this.checkstandver = checkstandver == null ? null : checkstandver.trim();
    }

    public String getRoutver() {
        return routver;
    }

    public void setRoutver(String routver) {
        this.routver = routver == null ? null : routver.trim();
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan == null ? null : pan.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getCardinstino() {
        return cardinstino;
    }

    public void setCardinstino(String cardinstino) {
        this.cardinstino = cardinstino == null ? null : cardinstino.trim();
    }

    public String getInpan() {
        return inpan;
    }

    public void setInpan(String inpan) {
        this.inpan = inpan == null ? null : inpan.trim();
    }

    public String getIncardtype() {
        return incardtype;
    }

    public void setIncardtype(String incardtype) {
        this.incardtype = incardtype == null ? null : incardtype.trim();
    }

    public String getIncardinstino() {
        return incardinstino;
    }

    public void setIncardinstino(String incardinstino) {
        this.incardinstino = incardinstino == null ? null : incardinstino.trim();
    }

    public String getAccordno() {
        return accordno;
    }

    public void setAccordno(String accordno) {
        this.accordno = accordno == null ? null : accordno.trim();
    }

    public String getAccordinst() {
        return accordinst;
    }

    public void setAccordinst(String accordinst) {
        this.accordinst = accordinst == null ? null : accordinst.trim();
    }

    public String getAccsecmerno() {
        return accsecmerno;
    }

    public void setAccsecmerno(String accsecmerno) {
        this.accsecmerno = accsecmerno == null ? null : accsecmerno.trim();
    }

    public String getAccfirmerno() {
        return accfirmerno;
    }

    public void setAccfirmerno(String accfirmerno) {
        this.accfirmerno = accfirmerno == null ? null : accfirmerno.trim();
    }

    public String getAccsettledate() {
        return accsettledate;
    }

    public void setAccsettledate(String accsettledate) {
        this.accsettledate = accsettledate == null ? null : accsettledate.trim();
    }

    public String getAccordcommitime() {
        return accordcommitime;
    }

    public void setAccordcommitime(String accordcommitime) {
        this.accordcommitime = accordcommitime == null ? null : accordcommitime.trim();
    }

    public String getAccordfintime() {
        return accordfintime;
    }

    public void setAccordfintime(String accordfintime) {
        this.accordfintime = accordfintime == null ? null : accordfintime.trim();
    }

    public String getAccretcode() {
        return accretcode;
    }

    public void setAccretcode(String accretcode) {
        this.accretcode = accretcode == null ? null : accretcode.trim();
    }

    public String getAccretinfo() {
        return accretinfo;
    }

    public void setAccretinfo(String accretinfo) {
        this.accretinfo = accretinfo == null ? null : accretinfo.trim();
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype == null ? null : paytype.trim();
    }

    public String getPayordno() {
        return payordno;
    }

    public void setPayordno(String payordno) {
        this.payordno = payordno == null ? null : payordno.trim();
    }

    public String getPayinst() {
        return payinst;
    }

    public void setPayinst(String payinst) {
        this.payinst = payinst == null ? null : payinst.trim();
    }

    public String getPayfirmerno() {
        return payfirmerno;
    }

    public void setPayfirmerno(String payfirmerno) {
        this.payfirmerno = payfirmerno == null ? null : payfirmerno.trim();
    }

    public String getPaysecmerno() {
        return paysecmerno;
    }

    public void setPaysecmerno(String paysecmerno) {
        this.paysecmerno = paysecmerno == null ? null : paysecmerno.trim();
    }

    public String getPayordcomtime() {
        return payordcomtime;
    }

    public void setPayordcomtime(String payordcomtime) {
        this.payordcomtime = payordcomtime == null ? null : payordcomtime.trim();
    }

    public String getPayordfintime() {
        return payordfintime;
    }

    public void setPayordfintime(String payordfintime) {
        this.payordfintime = payordfintime == null ? null : payordfintime.trim();
    }

    public String getPayrettsnseqno() {
        return payrettsnseqno;
    }

    public void setPayrettsnseqno(String payrettsnseqno) {
        this.payrettsnseqno = payrettsnseqno == null ? null : payrettsnseqno.trim();
    }

    public String getPayretcode() {
        return payretcode;
    }

    public void setPayretcode(String payretcode) {
        this.payretcode = payretcode == null ? null : payretcode.trim();
    }

    public String getPayretinfo() {
        return payretinfo;
    }

    public void setPayretinfo(String payretinfo) {
        this.payretinfo = payretinfo == null ? null : payretinfo.trim();
    }

    public String getAppordno() {
        return appordno;
    }

    public void setAppordno(String appordno) {
        this.appordno = appordno == null ? null : appordno.trim();
    }

    public String getAppinst() {
        return appinst;
    }

    public void setAppinst(String appinst) {
        this.appinst = appinst == null ? null : appinst.trim();
    }

    public String getAppordcommitime() {
        return appordcommitime;
    }

    public void setAppordcommitime(String appordcommitime) {
        this.appordcommitime = appordcommitime == null ? null : appordcommitime.trim();
    }

    public String getAppordfintime() {
        return appordfintime;
    }

    public void setAppordfintime(String appordfintime) {
        this.appordfintime = appordfintime == null ? null : appordfintime.trim();
    }

    public String getTradeseltxn() {
        return tradeseltxn;
    }

    public void setTradeseltxn(String tradeseltxn) {
        this.tradeseltxn = tradeseltxn == null ? null : tradeseltxn.trim();
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    public String getRetinfo() {
        return retinfo;
    }

    public void setRetinfo(String retinfo) {
        this.retinfo = retinfo == null ? null : retinfo.trim();
    }

    public String getTradestatflag() {
        return tradestatflag;
    }

    public void setTradestatflag(String tradestatflag) {
        this.tradestatflag = tradestatflag == null ? null : tradestatflag.trim();
    }

    public String getTradetxnflag() {
        return tradetxnflag;
    }

    public void setTradetxnflag(String tradetxnflag) {
        this.tradetxnflag = tradetxnflag == null ? null : tradetxnflag.trim();
    }

    public String getTxncode() {
        return txncode;
    }

    public void setTxncode(String txncode) {
        this.txncode = txncode == null ? null : txncode.trim();
    }

    public String getCashcode() {
        return cashcode;
    }

    public void setCashcode(String cashcode) {
        this.cashcode = cashcode == null ? null : cashcode.trim();
    }

    public String getRelate() {
        return relate;
    }

    public void setRelate(String relate) {
        this.relate = relate == null ? null : relate.trim();
    }

    public String getRetdatetime() {
        return retdatetime;
    }

    public void setRetdatetime(String retdatetime) {
        this.retdatetime = retdatetime == null ? null : retdatetime.trim();
    }

    public String getTxnseqnoOg() {
        return txnseqnoOg;
    }

    public void setTxnseqnoOg(String txnseqnoOg) {
        this.txnseqnoOg = txnseqnoOg == null ? null : txnseqnoOg.trim();
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getAccmemberid() {
        return accmemberid;
    }

    public void setAccmemberid(String accmemberid) {
        this.accmemberid = accmemberid == null ? null : accmemberid.trim();
    }

    public String getApporderstatus() {
        return apporderstatus;
    }

    public void setApporderstatus(String apporderstatus) {
        this.apporderstatus = apporderstatus == null ? null : apporderstatus.trim();
    }

    public String getApporderinfo() {
        return apporderinfo;
    }

    public void setApporderinfo(String apporderinfo) {
        this.apporderinfo = apporderinfo == null ? null : apporderinfo.trim();
    }

    public String getAccbusicode() {
        return accbusicode;
    }

    public void setAccbusicode(String accbusicode) {
        this.accbusicode = accbusicode == null ? null : accbusicode.trim();
    }

    public String getAcccoopinstino() {
        return acccoopinstino;
    }

    public void setAcccoopinstino(String acccoopinstino) {
        this.acccoopinstino = acccoopinstino == null ? null : acccoopinstino.trim();
    }

    public String getPanName() {
        return panName;
    }

    public void setPanName(String panName) {
        this.panName = panName == null ? null : panName.trim();
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode == null ? null : productcode.trim();
    }

    public String getGroupcode() {
        return groupcode;
    }

    public void setGroupcode(String groupcode) {
        this.groupcode = groupcode == null ? null : groupcode.trim();
    }

    public String getInpanName() {
        return inpanName;
    }

    public void setInpanName(String inpanName) {
        this.inpanName = inpanName == null ? null : inpanName.trim();
    }

    public String getFeepaymodel() {
        return feepaymodel;
    }

    public void setFeepaymodel(String feepaymodel) {
        this.feepaymodel = feepaymodel == null ? null : feepaymodel.trim();
    }

    public String getPathcode() {
        return pathcode;
    }

    public void setPathcode(String pathcode) {
        this.pathcode = pathcode == null ? null : pathcode.trim();
    }
  //新加 关联字段
    private String memberName;//商户名
	private String chnlname;//通道名
	private String caname;//渠道名
	private String tradeelement;//TRADEELEMENT
	private int total;//count统计总数
	private String bankName;
	
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getChnlname() {
		return chnlname;
	}

	public void setChnlname(String chnlname) {
		this.chnlname = chnlname;
	}

	public String getCaname() {
		return caname;
	}

	public void setCaname(String caname) {
		this.caname = caname;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getTradeelement() {
		return tradeelement;
	}

	public void setTradeelement(String tradeelement) {
		this.tradeelement = tradeelement;
	}
    
}