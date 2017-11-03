package com.unionpay.withhold.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
import com.unionpay.withhold.admin.pojo.TOrderCollectDeta;
import com.unionpay.withhold.admin.pojo.TOrderCollectSingle;
import com.unionpay.withhold.admin.pojo.TTxnsLog;
import com.unionpay.withhold.admin.service.TradeService;

@Controller
@RequestMapping("/trade")
public class TradeController {
	@Autowired
	private TradeService tradeService;

	/**
	 * 订单实时查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/single_collect_order_query")
	public ModelAndView showSingle_collect_order_query() {
		 ModelAndView result=new ModelAndView("/trade/single_collect_order_query");
	     return result;
	}
	/**
	 * 订单批量查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/batch_collect_order_query")
	public ModelAndView showBatch_collect_order_query() {
		 ModelAndView result=new ModelAndView("/trade/batch_collect_order_query");
	     return result;
	}
	/**
	 * 实时核心流水查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/txns_log")
	public ModelAndView showTxns_log() {
		 ModelAndView result=new ModelAndView("/trade/txns_log");
	     return result;
	}
	/**
	 * 历史核心流水查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/txns_log_bak")
	public ModelAndView showTxns_log_bak() {
		 ModelAndView result=new ModelAndView("/trade/txns_log_bak");
	     return result;
	}
	/**
	 * 渠道流水批量查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/chn_collect_batch_log_query")
	public ModelAndView showChn_collect_batch_log_query() {
		 ModelAndView result=new ModelAndView("/trade/chn_collect_batch_log_query");
	     return result;
	}
	/**
	 * 渠道流水实时查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/chn_collect_single_log_query")

	public ModelAndView showChn_collect_single_log_query() {
		 ModelAndView result=new ModelAndView("/trade/chn_collect_single_log_query");
	     return result;
	}
	
	/**
	 * 实时核心流水条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0getTxnsLogBakByPage
	 */
	@RequestMapping("/getTxnsLogByPage")
	@ResponseBody
	public PageBean getTxnsLogByPage(TTxnsLog tTxnsLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getTxnsLogByPage(tTxnsLog,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 历史核心流水条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0getTxnsLogBakByPage
	 */
	@RequestMapping("/getTxnsLogBakByPage")
	@ResponseBody
	public PageBean getTxnsLogBakByPage(TTxnsLog tTxnsLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getTxnsLogBakByPage(tTxnsLog,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 订单批量条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getBatchOrderByPage")
	@ResponseBody
	public PageBean getBatchOrderByPage(TOrderCollectBatch orderBatch,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getBatchOrderByPage(orderBatch,stime,etime,page,rows);
	    return resultBean;
	}
	
	
	/**
	 * 订单实时条件分页查询 
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getSingleOrderByPage")
	@ResponseBody
	public PageBean getSingleOrderByPage(TOrderCollectSingle orderSingle,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getSingleOrderByPage(orderSingle,stime,etime,page,rows);
	    return resultBean;
	}

	/**
	 * 渠道批量条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getChnCollectBatchLogByPage")
	@ResponseBody
	public PageBean getChnCollectBatchLogByPage(TChnlCpdkBatch tChnlCpdkBatch,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getChnCollectBatchLogByPage(tChnlCpdkBatch,stime,etime,page,rows);
	    return resultBean;
	}

	/**
	 * 渠道实时条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getChnCollectSingleLogByPage")
	@ResponseBody
	public PageBean getChnCollectSingleLogByPage(TChnlCpdkLog tChnlCpdkLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getChnCollectSingleLogByPage(tChnlCpdkLog,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 渠道实时条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getMerchantDaySettlement")
	@ResponseBody
	public PageBean getMerchantDaySettlement(TTxnsLog tTxnsLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getMerchantDaySettlement(tTxnsLog,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 获取单条实时订单信息详情
	 * @param tid
	 * @return
	 */
	@RequestMapping("/getSingleById")
	@ResponseBody
	public Object getgetSingleById(String tid) {
		
	    return tradeService.getSingleById(tid);
	}
	
	/**
	 * 获取单条实时订单信息详情
	 * @param txnseqno
	 * @return 
	 */
	@RequestMapping("/getTxnsLogByTxnseqno")
	@ResponseBody
	public TTxnsLog getTxnsLogByTxnseqno(String txnseqno) {
		TTxnsLog txnsLog =tradeService.getTxnsLogByTxnseqno(txnseqno);
	    return txnsLog;
	}
	/**
	 * 获取单条实时订单信息详情
	 * @param txnseqno
	 * @return getTxnsLogBakByTxnseqno
	 */
	@RequestMapping("/getTxnsLogBakByTxnseqno")
	@ResponseBody
	public TTxnsLog getTxnsLogBakByTxnseqno(String txnseqno) {
		TTxnsLog txnsLog =tradeService.getTxnsLogBakByTxnseqno(txnseqno);
	    return txnsLog;
	}
	//getCollectOrderDetaByBatchNo?batchno=1505978983775
	/**
	 * 获取批量订单明细
	 * @param batchno
	 * @return
	 */
	@RequestMapping("/getCollectOrderDetaByBatchNo")
	@ResponseBody
	public PageBean getCollectOrderDetaByBatchNo(String batchno,int page,int rows) {
		PageBean result =tradeService.getCollectOrderDetaByBatchNo(batchno,page,rows);
	    return result;
	}
	//getChnCollectDetaByBatchNo
	/**
	 * 获取批量渠道明细
	 * @param batchno
	 * @return
	 */
	@RequestMapping("/getChnCollectDetaByBatchNo")
	@ResponseBody
	public PageBean getChnCollectDetaByBatchNo(String batchno,int page,int rows) {
		PageBean result =tradeService.getChnCollectDetaByBatchNo(batchno,page,rows);
	    return result;
	}
	
	/*******************************************历史查询***********************************/
	/**
	 * 历史订单实时查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/single_collect_order_query_bak")
	public ModelAndView showSingle_collect_order_query_bak() {
		 ModelAndView result=new ModelAndView("/trade/single_collect_order_query_bak");
	     return result;
	}
	/**
	 * 历史订单批量查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/batch_collect_order_query_bak")
	public ModelAndView showBatch_collect_order_query_bak() {
		 ModelAndView result=new ModelAndView("/trade/batch_collect_order_query_bak");
	     return result;
	}
	/**
	 * 历史渠道流水批量查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/chn_collect_batch_log_query_bak")
	public ModelAndView showChn_collect_batch_log_query_bak() {
		 ModelAndView result=new ModelAndView("/trade/chn_collect_batch_log_query_bak");
	     return result;
	}
	/**
	 * 历史渠道流水实时查询页面
	 * @author: 
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/chn_collect_single_log_query_bak")
	public ModelAndView showChn_collect_single_log_query_bak() {
		 ModelAndView result=new ModelAndView("/trade/chn_collect_single_log_query_bak");
	     return result;
	}
	/**
	 * 订单批量条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getBatchOrderByPage_bak")
	@ResponseBody
	public PageBean getBatchOrderByPage_bak(TOrderCollectBatch orderBatch,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getBatchOrderByPage_bak(orderBatch,stime,etime,page,rows);
	    return resultBean;
	}
	
	
	/**
	 * 订单实时条件分页查询 
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getSingleOrderByPage_bak")
	@ResponseBody
	public PageBean getSingleOrderByPage_bak(TOrderCollectSingle orderSingle,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getSingleOrderByPage_bak(orderSingle,stime,etime,page,rows);
	    return resultBean;
	}

	/**
	 * 渠道批量条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getChnCollectBatchLogByPage_bak")
	@ResponseBody
	public PageBean getChnCollectBatchLogByPage_bak(TChnlCpdkBatch tChnlCpdkBatch,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getChnCollectBatchLogByPage_bak(tChnlCpdkBatch,stime,etime,page,rows);
	    return resultBean;
	}

	/**
	 * 渠道实时条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getChnCollectSingleLogByPage_bak")
	@ResponseBody
	public PageBean getChnCollectSingleLogByPage_bak(TChnlCpdkLog tChnlCpdkLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getChnCollectSingleLogByPage_bak(tChnlCpdkLog,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 渠道实时条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getMerchantDaySettlement_bak")
	@ResponseBody
	public PageBean getMerchantDaySettlement_bak(TTxnsLog tTxnsLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getMerchantDaySettlement(tTxnsLog,stime,etime,page,rows);
	    return resultBean;
	}
	/**
	 * 获取单条实时订单信息详情
	 * @param tid
	 * @return
	 */
	@RequestMapping("/getOrderSingleById_bak")
	@ResponseBody
	public Object getOrderSingleById_bak(String tid) {
		
	    return tradeService.getOrderSingleById_bak(tid);
	}
	
	/**
	 * 获取单条实时核心流水信息详情
	 * @param txnseqno
	 * @return 
	 */
	@RequestMapping("/getTxnsLogByTxnseqno_bak")
	@ResponseBody
	public TTxnsLog getTxnsLogByTxnseqno_bak(String txnseqno) {
		TTxnsLog txnsLog =tradeService.getTxnsLogByTxnseqno(txnseqno);
	    return txnsLog;
	}
	/**
	 * 获取单条实时订单信息详情
	 * @param txnseqno
	 * @return getTxnsLogBakByTxnseqno
	 */
	@RequestMapping("/getTxnsLogBakByTxnseqno_bak")
	@ResponseBody
	public TTxnsLog getTxnsLogBakByTxnseqno_bak(String txnseqno) {
		TTxnsLog txnsLog =tradeService.getTxnsLogBakByTxnseqno(txnseqno);
	    return txnsLog;
	}
	/**
	 * 获取批量订单明细
	 * @param batchno
	 * @return
	 */
	@RequestMapping("/getCollectOrderDetaByBatchNo_bak")
	@ResponseBody
	public PageBean getCollectOrderDetaByBatchNo_bak(String batchno,int page,int rows) {
		PageBean result =tradeService.getCollectOrderDetaByBatchNo_bak(batchno,page,rows);
	    return result;
	}
	//getChnCollectDetaByBatchNo
	/**
	 * 获取批量渠道明细
	 * @param batchno
	 * @return
	 */
	@RequestMapping("/getChnCollectDetaByBatchNo_bak")
	@ResponseBody
	public PageBean getChnCollectDetaByBatchNo_bak(String batchno,int page,int rows) {
		PageBean result =tradeService.getChnCollectDetaByBatchNo_bak(batchno,page,rows);
	    return result;
	}
}
