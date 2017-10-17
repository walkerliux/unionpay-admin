package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TChnlDeta;

public interface ChannelService {
	
	List<TChnlDeta> selectByCondition(TChnlDeta chnlDeta);

	ResultBean addChannel(TChnlDeta chnlDeta, String rates);

	TChnlDeta queryChannelById(int selfId);

	ResultBean updateChannel(TChnlDeta chnlDeta);
}
