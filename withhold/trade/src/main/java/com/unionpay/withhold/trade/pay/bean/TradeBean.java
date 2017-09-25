package com.unionpay.withhold.trade.pay.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Queue;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.enums.BusinessEnum;
import com.unionpay.withhold.trade.pay.pojo.TxnLogPayDO;
import com.unionpay.withhold.trade.route.pojo.RouteConfigDO;

public class TradeBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6695993898874417229L;
	/**
	 * 交易序列号
	 */
	private String txnseqno;
	/**
	 * 业务类型
	 */
	private BusinessEnum businessEnum;
	/**
	 * 受理批次号
	 */
	private String tn;
	
	/**
	 * 交易流水（核心）
	 */
	private TxnLogPayDO txnLogPayDO;
	
	/**
	 * 交易通道集合
	 */
	private Queue<RouteConfigDO> tradeChnlQueue;

	/**
	 * 通道代码（当前）
	 */
	private String chnlCode;
	/**
	 * 交易检查结果
	 */
	private ResultBean tradeCheck;
	/**
	 * 商户手续费结果
	 */
	private ResultBean merchFee;
	/**
	 * 渠道（代理商）手续费结果
	 */
	private ResultBean agentFee;
	/**
	 * 通道（交易渠道）手续费结果
	 */
	private ResultBean chnlFee;
	/**
	 * 商户风控结果
	 */
	private ResultBean merchRisk;
	/**
	 * 手续费最终处理结果
	 */
	private ResultBean finalFee;
	/**
	 * 渠道（代理商）风控
	 */
	private ResultBean agentRisk;
	/**
	 * 通道风控（交易渠道风控）
	 */
	private ResultBean chnlRisk;
	/**
	 * 风控最终结果
	 */
	private ResultBean finalRisk;
	/**
	 * 交易最终结果
	 */
	private ResultBean finalTrade;
	
	public String getTxnseqno() {
		return txnseqno;
	}

	public void setTxnseqno(String txnseqno) {
		this.txnseqno = txnseqno;
	}

	public String getTn() {
		return tn;
	}

	public void setTn(String tn) {
		this.tn = tn;
	}

	public TxnLogPayDO getTxnLogPayDO() {
		return txnLogPayDO;
	}

	public void setTxnLogPayDO(TxnLogPayDO txnLogPayDO) {
		this.txnLogPayDO = txnLogPayDO;
	}

	public BusinessEnum getBusinessEnum() {
		return businessEnum;
	}

	public void setBusinessEnum(BusinessEnum businessEnum) {
		this.businessEnum = businessEnum;
	}

	public ResultBean getTradeCheck() {
		return tradeCheck;
	}

	public void setTradeCheck(ResultBean tradeCheck) {
		this.tradeCheck = tradeCheck;
	}

	public Queue<RouteConfigDO> getTradeChnlQueue() {
		return tradeChnlQueue;
	}

	public void setTradeChnlQueue(Queue<RouteConfigDO> tradeChnlQueue) {
		this.tradeChnlQueue = tradeChnlQueue;
	}

	public String getChnlCode() {
		
		return chnlCode;
	}

	public void setChnlCode(String chnlCode) {
		this.chnlCode = chnlCode;
	}

	public ResultBean getMerchRisk() {
		return merchRisk;
	}

	public void setMerchRisk(ResultBean merchRisk) {
		this.merchRisk = merchRisk;
	}

	public ResultBean getAgentRisk() {
		return agentRisk;
	}

	public void setAgentRisk(ResultBean agentRisk) {
		this.agentRisk = agentRisk;
	}

	public ResultBean getChnlRisk() {
		return chnlRisk;
	}

	public void setChnlRisk(ResultBean chnlRisk) {
		this.chnlRisk = chnlRisk;
	}

	public ResultBean getMerchFee() {
		return merchFee;
	}

	public void setMerchFee(ResultBean merchFee) {
		this.merchFee = merchFee;
	}

	public ResultBean getAgentFee() {
		return agentFee;
	}

	public void setAgentFee(ResultBean agentFee) {
		this.agentFee = agentFee;
	}

	public ResultBean getChnlFee() {
		return chnlFee;
	}

	public void setChnlFee(ResultBean chnlFee) {
		this.chnlFee = chnlFee;
	}

	public ResultBean getFinalFee() {
		return finalFee;
	}

	public void setFinalFee(ResultBean finalFee) {
		this.finalFee = finalFee;
	}

	public ResultBean getFinalRisk() {
		return finalRisk;
	}

	public void setFinalRisk(ResultBean finalRisk) {
		this.finalRisk = finalRisk;
	}

	public ResultBean getFinalTrade() {
		return finalTrade;
	}

	public void setFinalTrade(ResultBean finalTrade) {
		this.finalTrade = finalTrade;
	}
	
	
}
