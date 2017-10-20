package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TTxnsLog;

public interface TTxnsLogService {

	PageBean findChannelByPage(String payinst,String retcode, String stime,String etime, int page,
			int rows);

	PageBean findMerchantByPage(String accsecmerno,String retcode, String stime, String etime,
			int page, int rows);

	PageBean findCoopByPage(String accfirmerno,String retcode, String stime, String etime,
			int page, int rows);

	List<TTxnsLog> getTnxLogInfoByMerno(String accsecmerno);

}
