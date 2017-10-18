package com.unionpay.withhold.admin.service;

import java.util.List;
import java.util.Map;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TChnlDeta;

public interface ChannelService {
	
	List<TChnlDeta> selectByCondition(TChnlDeta chnlDeta);

	ResultBean addChannel(TChnlDeta chnlDeta, String rates);

	TChnlDeta queryChannelById(int selfId);

	ResultBean updateChannel(TChnlDeta chnlDeta);

	Map<String, Object> queryChannelBankByChnlcode(String chnlcode);

	ResultBean changeChannlBank(List<String> debitoldlist, List<String> debitnewlist, List<String> creditdataoldlist,
			List<String> creditdatanewlist, String chnlcode,long userid);
}
