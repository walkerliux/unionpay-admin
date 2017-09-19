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
import com.unionpay.withhold.trade.order.pojo.OrderCollectSingleDO;
import com.unionpay.withhold.trade.order.service.OrderCollectSingleService;
import com.unionpay.withhold.utils.DateUtil;
import com.unionpay.withhold.utils.XMLUtils;

@RestController
@RequestMapping(value="/api/v1/fe")
public class FrontEndController {

	private static final Logger logger = LoggerFactory.getLogger(FrontEndController.class);
	
	@Autowired
	private OrderCollectSingleService orderCollectSingleService;
	/**
	 * 实时代扣
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/realtime/collect",method=RequestMethod.POST)
	public ResultBean realTimeCollect(String data) {
		logger.info(data);
		ResultBean resultBean = new ResultBean();
		resultBean.setRespCode("0000");
		resultBean.setRespMsg("成功");
		MerchantResponse response = new MerchantResponse();
		response.setSignature("1233456");
		resultBean.setResultObj(response);
		/*OrderCollectSingleDO orderCollectSingle = new OrderCollectSingleDO();
		orderCollectSingle.setVersion("1.0");
		orderCollectSingle.setEncoding("1");
		orderCollectSingle.setTxntype("02");
		orderCollectSingle.setTxnsubtype("00");
		orderCollectSingle.setBiztype("000002");
		orderCollectSingle.setBackurl("http://192.168.2.17:8180/notify/NotifyServlet");
		orderCollectSingle.setMerid("200000000001588");
		orderCollectSingle.setMerabbr("");
		orderCollectSingle.setOrderid(System.currentTimeMillis()+"");
		orderCollectSingle.setTxntime(DateUtil.getCurrentTime());
		orderCollectSingle.setPaytimeout("20180202000000");
		orderCollectSingle.setTxnamt(12L);
		orderCollectSingle.setCurrencycode("156");
		orderCollectSingle.setOrderdesc("集中代收实时测试");
		orderCollectSingle.setDebtorbank("203121000010");
		orderCollectSingle.setDebtoraccount("6228480018543668979");
		orderCollectSingle.setDebtorname("测试账户1");
		orderCollectSingle.setDebtorconsign("200000000001588000000000000062");
		orderCollectSingle.setCreditorbank("203121000010");
		orderCollectSingle.setCreditoraccount("6228480018543668970");
		orderCollectSingle.setCreditorname("测试账户2");
		orderCollectSingle.setProprietary("09001");
		orderCollectSingle.setRelatetradetxn(System.currentTimeMillis()+"");
		orderCollectSingle.setTn(System.currentTimeMillis()+"");
		orderCollectSingleService.saveOrderCollectSingle(orderCollectSingle);*/
		OrderCollectSingleDO collectSingle = orderCollectSingleService.getOrderinfoByOrderNoAndMerchNo("200000000001588", "1505800926000");
		logger.info(JSON.toJSONString(collectSingle));
		return resultBean;
	} 	
	
	/**
	 * 批量代扣
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/batch/collect",method=RequestMethod.POST)
	public ResultBean batchCollect(String data) {
		ResultBean resultBean = new ResultBean("0000", "成功");
		
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
