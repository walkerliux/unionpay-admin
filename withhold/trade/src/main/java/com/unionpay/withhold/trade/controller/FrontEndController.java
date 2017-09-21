package com.unionpay.withhold.trade.controller;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.api.bean.MerchantRequest;
import com.unionpay.withhold.api.bean.MerchantResponse;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.order.bean.BatchCollectBean;
import com.unionpay.withhold.trade.order.bean.SingleCollectBean;
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.CollectBusinessService;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
import com.unionpay.withhold.utils.DateUtil;
import com.unionpay.withhold.utils.XMLUtils;

@RestController
@RequestMapping(value="/api/v1/fe")
public class FrontEndController {

	private static final Logger logger = LoggerFactory.getLogger(FrontEndController.class);
	
	@Autowired
	private CollectBusinessService  collectBusinessService;
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
		return resultBean;
	}
	
	/**
	 * 验签报文
	 * @param xml
	 * @return
	 */
	@RequestMapping(value="/realtime/validateSignature",method=RequestMethod.POST)
	public ResultBean validateSignature(String xml) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		try {
			MerchantRequest request = XMLUtils.converyToJavaBean(xml.trim(), MerchantRequest.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("", "非法的XML报文");
		}
		return resultBean;
	}
	/**
	 * 加签报文
	 * @param xml
	 * @return
	 */
	@RequestMapping(value="/realtime/addSignature",method=RequestMethod.POST)
	public ResultBean addSignature(String xml) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		try {
			MerchantResponse response = XMLUtils.converyToJavaBean(xml.trim(),MerchantResponse.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resultBean = new ResultBean("", "非法的XML报文");
		}
		return resultBean;
	}
	
	/**
	 * ChinaPay批量代收异步通知
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/path/cp/batchnotify",method=RequestMethod.POST)
	public ResultBean cpBatchTradeNotify(String data) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		return resultBean;
	}
	
	/**
	 * 对账文件下载
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/checkfile/download",method=RequestMethod.POST)
	public ResultBean downloadCheckFile(String data) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		return resultBean;
	}
}
