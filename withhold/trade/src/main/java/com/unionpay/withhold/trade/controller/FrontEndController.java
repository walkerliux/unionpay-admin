package com.unionpay.withhold.trade.controller;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.unionpay.withhold.api.bean.MerchantRequest;
import com.unionpay.withhold.api.bean.MerchantResponse;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.utils.XMLUtils;

@RestController
@RequestMapping(value="/api/v1/fe")
public class FrontEndController {

	private static final Logger logger = LoggerFactory.getLogger(FrontEndController.class);
	/**
	 * 实时代扣
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/realtime/collect",method=RequestMethod.GET)
	public ResultBean realTimeCollect(String data) {
		logger.info(data);
		ResultBean resultBean = new ResultBean();
		resultBean.setRespCode("0000");
		resultBean.setRespMsg("成功");
		MerchantResponse response = new MerchantResponse();
		response.setSignature("1233456");
		resultBean.setResultObj(response);
		return resultBean;
	} 	
	
	/**
	 * 批量代扣
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/batch/collect",method=RequestMethod.POST)
	public ResultBean batchCollect(String data) {
		
		return null;
	}
	
	/**
	 * 实时代扣查询
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/realtime/query/collect",method=RequestMethod.POST)
	public ResultBean queryRealTimeCollect(String data) {
		
		return null;
	}
	/**
	 * 批量代扣查询
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/batch/query/collect",method=RequestMethod.POST)
	public ResultBean queryBatchCollect(String data) {
		
		return null;
	}
	
	/**
	 * 验签报文
	 * @param xml
	 * @return
	 */
	@RequestMapping(value="/realtime/validateSignature",method=RequestMethod.POST)
	public ResultBean validateSignature(String xml) {
		ResultBean resultBean = null;
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
		ResultBean resultBean = null;
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
		
		return null;
	}
	
	/**
	 * 对账文件下载
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/checkfile/download",method=RequestMethod.POST)
	public ResultBean downloadCheckFile(String data) {
		
		return null;
	}
}
