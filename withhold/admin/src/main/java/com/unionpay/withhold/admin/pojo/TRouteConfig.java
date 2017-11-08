package com.unionpay.withhold.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class TRouteConfig {
	private Integer rid;

	private Long routid;

	private String routver;

	private String stime;

	private String etime;

	private BigDecimal minamt;

	private BigDecimal maxamt;

	private String bankcode;

	private String busicode;

	private String cardtype;

	private String chnlcode;

	private String status;

	private Date intime;

	private Long inuser;

	private Date uptime;

	private Long upuser;

	private Long orders;

	private String isdef;

	private String tradeele;

	private String notes;

	private String remarks;

	/** 关联属性 **/
	private String routname;
	private String banknames;
	private String businames;
	private String cardtypenames;
	private String tradeeleName;
	private String chnlname;

	/** 传参属性 **/
	private String[] bankcodes;
	private String[] busicodes;
	private String[] cardtypes;

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Long getRoutid() {
		return routid;
	}

	public void setRoutid(Long routid) {
		this.routid = routid;
	}

	public String getRoutver() {
		return routver;
	}

	public void setRoutver(String routver) {
		this.routver = routver == null ? null : routver.trim();
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime == null ? null : stime.trim();
	}

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime == null ? null : etime.trim();
	}

	public BigDecimal getMinamt() {
		return minamt;
	}

	public void setMinamt(BigDecimal minamt) {
		this.minamt = minamt;
	}

	public BigDecimal getMaxamt() {
		return maxamt;
	}

	public void setMaxamt(BigDecimal maxamt) {
		this.maxamt = maxamt;
	}

	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode == null ? null : bankcode.trim();
	}

	public String getBusicode() {
		return busicode;
	}

	public void setBusicode(String busicode) {
		this.busicode = busicode == null ? null : busicode.trim();
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype == null ? null : cardtype.trim();
	}

	public String getChnlcode() {
		return chnlcode;
	}

	public void setChnlcode(String chnlcode) {
		this.chnlcode = chnlcode == null ? null : chnlcode.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Long getInuser() {
		return inuser;
	}

	public void setInuser(Long inuser) {
		this.inuser = inuser;
	}

	public Date getUptime() {
		return uptime;
	}

	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}

	public Long getUpuser() {
		return upuser;
	}

	public void setUpuser(Long upuser) {
		this.upuser = upuser;
	}

	public Long getOrders() {
		return orders;
	}

	public void setOrders(Long orders) {
		this.orders = orders;
	}

	public String getIsdef() {
		return isdef;
	}

	public void setIsdef(String isdef) {
		this.isdef = isdef == null ? null : isdef.trim();
	}

	public String getTradeele() {
		return tradeele;
	}

	public void setTradeele(String tradeele) {
		this.tradeele = tradeele == null ? null : tradeele.trim();
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

	public String getRoutname() {
		return routname;
	}

	public void setRoutname(String routname) {
		this.routname = routname == null ? null : routname.trim();
	}

	public String getBanknames() {
		return banknames;
	}

	public void setBanknames(String banknames) {
		this.banknames = banknames == null ? null : banknames.trim();
	}

	public String getBusinames() {
		return businames;
	}

	public void setBusinames(String businames) {
		this.businames = businames == null ? null : businames.trim();
	}

	public String getCardtypenames() {
		return cardtypenames;
	}

	public void setCardtypenames(String cardtypenames) {
		this.cardtypenames = cardtypenames == null ? null : cardtypenames.trim();
	}

	public String getTradeeleName() {
		return tradeeleName;
	}

	public void setTradeeleName(String tradeeleName) {
		this.tradeeleName = tradeeleName == null ? null : tradeeleName.trim();
	}

	public String getChnlname() {
		return chnlname;
	}

	public void setChnlname(String chnlname) {
		this.chnlname = chnlname == null ? null : chnlname.trim();
	}

	public String[] getBankcodes() {
		return bankcodes;
	}

	public void setBankcodes(String[] bankcodes) {
		this.bankcodes = bankcodes;
	}

	public String[] getBusicodes() {
		return busicodes;
	}

	public void setBusicodes(String[] busicodes) {
		this.busicodes = busicodes;
	}

	public String[] getCardtypes() {
		return cardtypes;
	}

	public void setCardtypes(String[] cardtypes) {
		this.cardtypes = cardtypes;
	}

}