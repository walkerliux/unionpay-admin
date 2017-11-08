package com.unionpay.withhold.admin.pojo;

import java.util.Date;

public class TChnlHyldkLog {
    private Integer tid;

    private String txnseqno;//交易序列号

    private String trxcode;//交易代码

    private String version;

    private String datatype;//数据格式 2：xml格式

    private String processlevel;//处理级别 0实时处理

    private String reqsn;//交易流水号

    private String signedmsg;//签名信息

    private String businesscode;//业务代码

    private String merchantid;

    private String totalitem;//总记录数

    private Integer totalsum;//总金额 单位：分

    private String sn;//记录序号

    private String eusercode;//银联网络用户编号

    private String bankcode;//银行代码

    private String accounttype;//账号类型 00银行卡，01存折

    private String accountno;//账号

    private String accountname;//账号名 

    private Integer amount;//金额

    private String currency;//货币类型 人民币：CNY, 港元：HKD，美元：USD

    private String protocol;//用户id

    private String protocoluserid;//协议用户编号

    private String idtype;//开户证件类型0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9. 警官证, X.其他证件

    private String id;//证件号

    private String tel;//电话

    private String remark;//备注

    private String retcode;//返回码(状态)

    private String errmsg;//返回信息

    private String reserve1;

    private String reserve2;//保留域2

    private Date intime;

    private Date uptime;

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

    public String getTrxcode() {
        return trxcode;
    }

    public void setTrxcode(String trxcode) {
        this.trxcode = trxcode == null ? null : trxcode.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype == null ? null : datatype.trim();
    }

    public String getProcesslevel() {
        return processlevel;
    }

    public void setProcesslevel(String processlevel) {
        this.processlevel = processlevel == null ? null : processlevel.trim();
    }

    public String getReqsn() {
        return reqsn;
    }

    public void setReqsn(String reqsn) {
        this.reqsn = reqsn == null ? null : reqsn.trim();
    }

    public String getSignedmsg() {
        return signedmsg;
    }

    public void setSignedmsg(String signedmsg) {
        this.signedmsg = signedmsg == null ? null : signedmsg.trim();
    }

    public String getBusinesscode() {
        return businesscode;
    }

    public void setBusinesscode(String businesscode) {
        this.businesscode = businesscode == null ? null : businesscode.trim();
    }

    public String getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(String merchantid) {
        this.merchantid = merchantid == null ? null : merchantid.trim();
    }

    public String getTotalitem() {
        return totalitem;
    }

    public void setTotalitem(String totalitem) {
        this.totalitem = totalitem == null ? null : totalitem.trim();
    }

    public Integer getTotalsum() {
        return totalsum;
    }

    public void setTotalsum(Integer totalsum) {
        this.totalsum = totalsum;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getEusercode() {
        return eusercode;
    }

    public void setEusercode(String eusercode) {
        this.eusercode = eusercode == null ? null : eusercode.trim();
    }

    public String getBankcode() {
        return bankcode;
    }

    public void setBankcode(String bankcode) {
        this.bankcode = bankcode == null ? null : bankcode.trim();
    }

    public String getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(String accounttype) {
        this.accounttype = accounttype == null ? null : accounttype.trim();
    }

    public String getAccountno() {
        return accountno;
    }

    public void setAccountno(String accountno) {
        this.accountno = accountno == null ? null : accountno.trim();
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname == null ? null : accountname.trim();
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getProtocoluserid() {
        return protocoluserid;
    }

    public void setProtocoluserid(String protocoluserid) {
        this.protocoluserid = protocoluserid == null ? null : protocoluserid.trim();
    }

    public String getIdtype() {
        return idtype;
    }

    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode == null ? null : retcode.trim();
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg == null ? null : errmsg.trim();
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }
}