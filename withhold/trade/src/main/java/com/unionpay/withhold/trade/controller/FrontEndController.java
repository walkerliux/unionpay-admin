package com.unionpay.withhold.trade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.api.bean.CPBackFileNotifyBean;
import com.unionpay.withhold.api.bean.MerchCheckFileBean;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectQueryBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectQueryBean;
import com.unionpay.withhold.trade.order.service.CollectBusinessService;
import com.unionpay.withhold.trade.pay.service.ChannelNotifyService;
import com.unionpay.withhold.trade.pay.service.CollectPayService;
import com.unionpay.withhold.trade.pay.service.MerchCheckFileService;
import com.unionpay.withhold.trade.pay.service.OrderDownloadCheckFileService;

@RestController
@RequestMapping(value="/api/v1/fe")
public class FrontEndController {

	private static final Logger logger = LoggerFactory.getLogger(FrontEndController.class);
	
	@Autowired
	private CollectBusinessService  collectBusinessService;
	@Autowired
	private CollectPayService collectPayService;
	@Autowired
	private ChannelNotifyService channelNotifyService;
	@Autowired
	private OrderDownloadCheckFileService orderDownloadCheckFileService;
	/**
	 * 实时代扣
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/realtime/collect",method=RequestMethod.POST)
	public ResultBean realTimeCollect(String data) {
		long currentTimeMillis = System.currentTimeMillis();
		ResultBean resultBean = new ResultBean();
		resultBean.setRespCode("0000");
		resultBean.setRespMsg("成功");
		SingleCollectBean singleCollectBean = JSON.parseObject(data, SingleCollectBean.class);
		resultBean = collectBusinessService.createSingleCollectOrder(singleCollectBean);
		if(resultBean.isResultBool()) {
			String tn = (String)resultBean.getResultObj();
			resultBean = collectPayService.singleCollectPay(tn);
			resultBean.setResultObj(tn);
		}
		logger.info((System.currentTimeMillis()-currentTimeMillis)+"");
		return resultBean;
	} 	
	
	/**
	 * 批量代扣
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/batch/collect",method=RequestMethod.POST)
	public ResultBean batchCollect(String data) {
		long currentTimeMillis = System.currentTimeMillis();
		ResultBean resultBean = new ResultBean("0000", "成功");
		BatchCollectBean batchCollectBean = JSON.parseObject(data.trim(), BatchCollectBean.class);
		resultBean = collectBusinessService.createBatchCollectOrder(batchCollectBean);
		//logger.info(JSON.toJSONString(resultBean));
		if(resultBean.isResultBool()) {
			String tn = (String)resultBean.getResultObj();
			resultBean = collectPayService.batchCollectPay(tn);
			resultBean.setResultObj(tn);
		}
		logger.info((System.currentTimeMillis()-currentTimeMillis)+"");
		return resultBean;
	}
	
	/**
	 * 实时代扣查询
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/realtime/query/collect",method=RequestMethod.POST)
	public ResultBean queryRealTimeCollect(String data) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		SingleCollectQueryBean singleCollectQueryBean = JSON.parseObject(data, SingleCollectQueryBean.class);
		resultBean = collectBusinessService.querySingleCollectOrder(singleCollectQueryBean);
		return resultBean;
	}
	/**
	 * 批量代扣查询
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/batch/query/collect",method=RequestMethod.POST)
	public ResultBean queryBatchCollect(String data) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		BatchCollectQueryBean batchCollectQueryBean = JSON.parseObject(data, BatchCollectQueryBean.class);
		resultBean = collectBusinessService.queryBatchCollectOrder(batchCollectQueryBean);
		return resultBean;
	}
	
	/**
	 * ChinaPay批量代收回盘异步通知
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/path/cp/batchnotify",method=RequestMethod.POST)
	public ResultBean cpBatchTradeNotify(String data) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		try {
			CPBackFileNotifyBean fileNotifyBean = JSON.parseObject(data, CPBackFileNotifyBean.class);
			channelNotifyService.chinaPayNotify(fileNotifyBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("OD046", "系统内部错误");
			resultBean.setResultBool(false);
		}
		return resultBean;
	}
	
	/**
	 * 对账文件下载
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/checkfile/download",method=RequestMethod.POST)
	public ResultBean downloadCheckFile(String data) {
		MerchCheckFileBean merchCheckFileBean = JSON.parseObject(data, MerchCheckFileBean.class);
		ResultBean resultBean = orderDownloadCheckFileService.downloadCheckFile(merchCheckFileBean);
		return resultBean;
	}
}
