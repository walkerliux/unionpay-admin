package com.unionpay.withhold.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TChnlCpdkBatch;
import com.unionpay.withhold.admin.pojo.TChnlCpdkLog;
import com.unionpay.withhold.admin.pojo.TOrderCollectBatch;
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
	 * 核心流水查询页面
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
	 * 核心流水条件分页查询
	 * @author:LIUXIN
	 * @return ModelAndView
	 * 
	 * @version v1.0
	 */
	@RequestMapping("/getTxnsLogByPage")
	@ResponseBody
	public PageBean getTxnsLogByPage(TTxnsLog tTxnsLog,String stime,String etime,int page,int rows) {
		PageBean resultBean =tradeService.getTxnsLogByPage(tTxnsLog,stime,etime,page,rows);
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
	 * 获取单条信息详情
	 * @param tid
	 * @return
	 */
	@RequestMapping("/getSingleById")
	@ResponseBody
	public Object getgetSingleById(String tid) {
		
	    return tradeService.getSingleById(tid);
	}
	
}
