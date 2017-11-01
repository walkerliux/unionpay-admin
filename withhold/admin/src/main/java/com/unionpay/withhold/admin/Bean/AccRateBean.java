package com.unionpay.withhold.admin.Bean;

public class AccRateBean {
	//分段扣率接受字段
	 private String startRange;
	 private String endrange;
	 private String rateType;
	 //分段扣率-特殊公式接收字段
	 private String feeRate;
	 private String minFee;
	 private String maxFee;
	//特殊公式接受字段
	 private String function;
	 private String fixFee;
	 
	public String getStartRange() {
		return startRange;
	}
	public void setStartRange(String startRange) {
		this.startRange = startRange;
	}
	public String getEndrange() {
		return endrange;
	}
	public void setEndrange(String endrange) {
		this.endrange = endrange;
	}
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getFeeRate() {
		return feeRate;
	}
	public void setFeeRate(String feeRate) {
		this.feeRate = feeRate;
	}
	public String getMinFee() {
		return minFee;
	}
	public void setMinFee(String minFee) {
		this.minFee = minFee;
	}
	public String getMaxFee() {
		return maxFee;
	}
	public void setMaxFee(String maxFee) {
		this.maxFee = maxFee;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getFixFee() {
		return fixFee;
	}
	public void setFixFee(String fixFee) {
		this.fixFee = fixFee;
	}
	 
	 


}
