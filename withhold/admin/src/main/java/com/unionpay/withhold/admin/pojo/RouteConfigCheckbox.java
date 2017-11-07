package com.unionpay.withhold.admin.pojo;

import java.util.List;

public class RouteConfigCheckbox {
	private List<TBank> bankList;
	private List<TBusiness> businessList;
	private List<TParaDic> paraDicList;

	
	
	public RouteConfigCheckbox(List<TBank> bankList, List<TBusiness> businessList, List<TParaDic> paraDicList) {
		this.bankList = bankList;
		this.businessList = businessList;
		this.paraDicList = paraDicList;
	}

	public List<TBank> getBankList() {
		return bankList;
	}

	public void setBankList(List<TBank> bankList) {
		this.bankList = bankList;
	}

	public List<TBusiness> getBusinessList() {
		return businessList;
	}

	public void setBusinessList(List<TBusiness> businessList) {
		this.businessList = businessList;
	}

	public List<TParaDic> getParaDicList() {
		return paraDicList;
	}

	public void setParaDicList(List<TParaDic> paraDicList) {
		this.paraDicList = paraDicList;
	}

}
