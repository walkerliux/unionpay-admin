package com.unionpay.withhold.admin.service;

import java.util.List;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TChnlHyldkLog;
import com.unionpay.withhold.admin.pojo.TChnlHyldkLogBak;
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



	TTxnsLog getTxnsLogByTxnseqno(String txnseqno);

	PageBean getCollectOrderDetaByBatchNo(String batchno,
			int page, int rows);

	PageBean getChnCollectDetaByBatchNo(String batchno, int page, int rows);

	PageBean getTxnsLogBakByPage(TTxnsLog tTxnsLog, String stime, String etime,
			int page, int rows);

	TTxnsLog getTxnsLogBakByTxnseqno(String txnseqno);

	PageBean getBatchOrderByPage_bak(TOrderCollectBatch orderBatch,
			String stime, String etime, int page, int rows);

	PageBean getSingleOrderByPage_bak(TOrderCollectSingle orderSingle,
			String stime, String etime, int page, int rows);

	PageBean getCollectOrderDetaByBatchNo_bak(String batchno, int page, int rows);

	Object getOrderSingleById_bak(String tid);

	PageBean getChnCollectSingleLogByPage_bak(TChnlCpdkLog tChnlCpdkLog,
			String stime, String etime, int page, int rows);

	PageBean getChnCollectBatchLogByPage_bak(TChnlCpdkBatch tChnlCpdkBatch,
			String stime, String etime, int page, int rows);

	PageBean getChnCollectDetaByBatchNo_bak(String batchno, int page, int rows);

	PageBean getHYLCollectDeta(TChnlHyldkLog hyldkLog,String stime,String etime,int page,int rows);

	PageBean getHYLCollectBakDeta(TChnlHyldkLogBak hyldkLog,String stime,String etime,int page,int rows);

	List<TChnlHyldkLog> getHYLStatus();

	List<TChnlHyldkLog> getHYLbakStatus();

	List<TChnlCpdkLog> getCPStatus();

	List<TChnlCpdkLog> getCPbakStatus();

}
