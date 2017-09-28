package com.unionpay.withhold.admin.utils;

import java.util.ArrayList;
import java.util.List;

import com.unionpay.withhold.admin.Bean.ChnlType;
import com.unionpay.withhold.admin.Bean.ChnlTypeEnum;

public class EnumUtils {
	public static List<ChnlType> getType(){
		List<ChnlType> list = new ArrayList<ChnlType>();
		ChnlTypeEnum[] values = ChnlTypeEnum.values();
		for (ChnlTypeEnum chnlTypeEnum : values) {
			ChnlType chnlType = new ChnlType();
			chnlType.setCode(chnlTypeEnum.getCode());
			chnlType.setName(chnlTypeEnum.getName());
			list.add(chnlType);
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		List<ChnlType> list = EnumUtils.getType();
		for (ChnlType chnlType : list) {
			System.out.println(chnlType.getCode()+chnlType.getName());
		}
	}

}
