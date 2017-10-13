package com.unionpay.withhold.admin.pojo;

public class TChnlCpdkLog {
    private Integer tid;//主键

    private String txnseqno;//交易序列号

    private String merid;//商户编号

    private String transdate;//商户日期

    private String orderno;//订单号

    private String transtype;//交易类型

    private String openbankid;//开户行号

    private String cardtype;//卡折标志

    private String cardno;//卡号/折号

    private String usrname;//持卡人姓名

    private String certtype;//证件类型

    private String certid;//证件号

    private String curyid;//交易币种

    private String transamt;//金额

    private String purpose;//用途

    private String priv1;//私有域

    private String version;//版本号

    private String gateid;//网关号

    private String termtype;//渠道类型

    private String paymode;//交易模式

    private String userid;//用户ID

    private String userregistertime;//用户注册时间

    private String usermail;//用户注册邮箱

    private String usermobile;//用户注册手机号

    private String disksn;//PC 硬盘序列号

    private String mac;//PC mac地址

    private String imei;//手机串号IMEI

    private String ip;//用户IP

    private String coordinates;//代付经纬度信息

    private String basestationsn;//手机所在基站序列号

    private String codeinputtype;//短信验证码输入操作特征

    private String mobileforbank;//预留手机号

    private String orderdesc;//购买商品明细

    private String chkvalue;//签名值

    private String responsecode;//应答信息

    private String transstat;//代扣状态

    private String message;//描述

    private String chnlretdate;//渠道返回日期

    private String intime;//插入时间

    private String uptime;//更新时间

    private String chnlfee;//通道手续费(通道成本)

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTxnseqno() {
        return txnseqno;
    }

    public void setTxnseqno(String txnseqno) {
        this.txnseqno = txnseqno == null ? null : txnseqno.trim();
    }

    public String getMerid() {
        return merid;
    }

    public void setMerid(String merid) {
        this.merid = merid == null ? null : merid.trim();
    }

    public String getTransdate() {
        return transdate;
    }

    public void setTransdate(String transdate) {
        this.transdate = transdate == null ? null : transdate.trim();
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno == null ? null : orderno.trim();
    }

    public String getTranstype() {
        return transtype;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype == null ? null : transtype.trim();
    }

    public String getOpenbankid() {
        return openbankid;
    }

    public void setOpenbankid(String openbankid) {
        this.openbankid = openbankid == null ? null : openbankid.trim();
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public String getCardno() {
        return cardno;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno == null ? null : cardno.trim();
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname == null ? null : usrname.trim();
    }

    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype == null ? null : certtype.trim();
    }

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid == null ? null : certid.trim();
    }

    public String getCuryid() {
        return curyid;
    }

    public void setCuryid(String curyid) {
        this.curyid = curyid == null ? null : curyid.trim();
    }

    public String getTransamt() {
        return transamt;
    }

    public void setTransamt(String transamt) {
        this.transamt = transamt == null ? null : transamt.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getPriv1() {
        return priv1;
    }

    public void setPriv1(String priv1) {
        this.priv1 = priv1 == null ? null : priv1.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getGateid() {
        return gateid;
    }

    public void setGateid(String gateid) {
        this.gateid = gateid == null ? null : gateid.trim();
    }

    public String getTermtype() {
        return termtype;
    }

    public void setTermtype(String termtype) {
        this.termtype = termtype == null ? null : termtype.trim();
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode == null ? null : paymode.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUserregistertime() {
        return userregistertime;
    }

    public void setUserregistertime(String userregistertime) {
        this.userregistertime = userregistertime == null ? null : userregistertime.trim();
    }

    public String getUsermail() {
        return usermail;
    }

    public void setUsermail(String usermail) {
        this.usermail = usermail == null ? null : usermail.trim();
    }

    public String getUsermobile() {
        return usermobile;
    }

    public void setUsermobile(String usermobile) {
        this.usermobile = usermobile == null ? null : usermobile.trim();
    }

    public String getDisksn() {
        return disksn;
    }

    public void setDisksn(String disksn) {
        this.disksn = disksn == null ? null : disksn.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei == null ? null : imei.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates == null ? null : coordinates.trim();
    }

    public String getBasestationsn() {
        return basestationsn;
    }

    public void setBasestationsn(String basestationsn) {
        this.basestationsn = basestationsn == null ? null : basestationsn.trim();
    }

    public String getCodeinputtype() {
        return codeinputtype;
    }

    public void setCodeinputtype(String codeinputtype) {
        this.codeinputtype = codeinputtype == null ? null : codeinputtype.trim();
    }

    public String getMobileforbank() {
        return mobileforbank;
    }

    public void setMobileforbank(String mobileforbank) {
        this.mobileforbank = mobileforbank == null ? null : mobileforbank.trim();
    }

    public String getOrderdesc() {
        return orderdesc;
    }

    public void setOrderdesc(String orderdesc) {
        this.orderdesc = orderdesc == null ? null : orderdesc.trim();
    }

    public String getChkvalue() {
        return chkvalue;
    }

    public void setChkvalue(String chkvalue) {
        this.chkvalue = chkvalue == null ? null : chkvalue.trim();
    }

    public String getResponsecode() {
        return responsecode;
    }

    public void setResponsecode(String responsecode) {
        this.responsecode = responsecode == null ? null : responsecode.trim();
    }

    public String getTransstat() {
        return transstat;
    }

    public void setTransstat(String transstat) {
        this.transstat = transstat == null ? null : transstat.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getChnlretdate() {
        return chnlretdate;
    }

    public void setChnlretdate(String chnlretdate) {
        this.chnlretdate = chnlretdate == null ? null : chnlretdate.trim();
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime == null ? null : intime.trim();
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime == null ? null : uptime.trim();
    }

    public String getChnlfee() {
        return chnlfee;
    }

    public void setChnlfee(String chnlfee) {
        this.chnlfee = chnlfee == null ? null : chnlfee.trim();
    }
}