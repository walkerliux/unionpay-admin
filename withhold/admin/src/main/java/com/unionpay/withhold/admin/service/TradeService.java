package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectDeta;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingle;
import com.unionpay.withhold.admin.pojo.TTxnsLog;

public interface TradeService {

	PageBean getTxnsLogByPage(TTxnsLog tTxnsLog, String stime, String etime,
			int page, int rows);

	PageBean getBatchOrderByPage(TOrderCollectBatch orderBatch, String stime, String etime,
			int page, int rows);

	PageBean getSingleOrderByPage(TOrderCollectSingle orderSingle, String stime,
			String etime, int page, int rows);

	PageBean getChnCollectBatchLogByPage(TChnlCpdkBatch tChnlCpdkBatch, String stime,
			String etime, int page, int rows);

	PageBean getChnCollectSingleLogByPage(TChnlCpdkLog tChnlCpdkLog, String stime,
			String etime, int page, int rows);

	PageBean getMerchantDaySettlement(TTxnsLog tTxnsLog, String stime,
			String etime, int page, int rows);

	Object getSingleById(String tid);

	Object getshowCoop();

	TTxnsLog getTxnsLogByTxnseqno(String txnseqno);

	PageBean getCollectOrderDetaByBatchNo(String batchno,
			int page, int rows);

}
