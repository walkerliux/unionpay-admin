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

	PageBean getTnxLogInfoByMerno(String accsecmerno,String retcode,String stime,String etime,int page,int rows);

	PageBean getTnxLogInfoByCoopno(String accfirmerno, String retcode,
			String stime, String etime, int page, int rows);

	PageBean getTnxLogInfoByPayinst(String payinst, String retcode,
			String stime, String etime, int page, int rows);

	PageBean getMerchDayCountByPage(String accsecmerno, String dayormonth,
			String stime, String etime, int page, int rows);

	PageBean getMerDayCountInfo(String accsecmerno,String txndate, int page, int rows);

	PageBean getCoopMonthCountByPage(String accfirmerno, String year,
			String month, int page, int rows);

	PageBean getCoopMonthCountInfo(String accfirmerno, String txndate,
			 int page, int rows);

}
