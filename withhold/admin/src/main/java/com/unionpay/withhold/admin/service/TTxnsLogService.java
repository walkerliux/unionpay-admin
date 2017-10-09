package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TTxnsLog;

public interface TTxnsLogService {

	PageBean findPassagewayByPage(String payinst,String apporderstatus, String stime,String etime, int page,
			int rows);

	PageBean findMerchantByPage(String accsecmerno,String apporderstatus, String stime, String etime,
			int page, int rows);

	PageBean findChannelByPage(String pathcode,String apporderstatus, String stime, String etime,
			int page, int rows);

	TTxnsLog queryDetailsById(String txnseqno);

}
