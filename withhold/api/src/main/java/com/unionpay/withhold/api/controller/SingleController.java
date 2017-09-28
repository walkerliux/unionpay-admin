package com.unionpay.withhold.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.api.bean.TRspRoot;
import com.unionpay.withhold.api.bean.ThreadResponse;
import com.unionpay.withhold.api.common.constant.CommonBusiConstants;
import com.unionpay.withhold.api.exception.AbstractBusiException;
import com.unionpay.withhold.api.model.MerchMk;
import com.unionpay.withhold.api.service.MerchMkService;
import com.unionpay.withhold.api.single.bean.TransFlow;
import com.unionpay.withhold.api.util.HttpClient;
import com.unionpay.withhold.api.util.MerchantCertUtil;
import com.unionpay.withhold.utils.XMLUtils;

/**
 * 实时代扣接口
 * @author: 张世栋
 * @date: 2017年9月25日10:48:49
 * @version 1.0
 */
@Controller
@RequestMapping("/single/")
public class SingleController {

	@Autowired
	private MerchMkService merchMkService;
	
	private Logger log = LoggerFactory.getLogger(SingleController.class);
	@ResponseBody
	@RequestMapping("notice")
	public String notice(String data) {
		TransFlow transFlow =JSON.parseObject(data, TransFlow.class);
		MerchMk merchMk=merchMkService.selectByPrimaryKey("");
		try {
			executeSave(transFlow,merchMk.getLocalpubkey(),merchMk.getPlatformpfxpwd());
		} catch (AbstractBusiException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	@ResponseBody
	@RequestMapping("noticetest")
	public String noticetest(String data) {
		log.info("实时代扣异步通知测试接收到的数据=====>"+data);
		return "测试是成功的接受到的参数是==>"+data;
	}
	
	public int executeSave(TransFlow transFlow ,String path,String pwd) throws AbstractBusiException {
		TransFlow savedTransFlow = new TransFlow();
		savedTransFlow.setId(transFlow.getId());
		String requestBody = makeRequestBody(transFlow,path,pwd);
		String reqUrl = transFlow.getInterfaceBackUrl();
		if (reqUrl != null) {
			HttpClient httpClient = new HttpClient(reqUrl, 30000, 30000);
			log.debug("开始推送通知...");
			int status = -1;
			try {
				status = httpClient.send(requestBody, "UTF-8");
				// 通知成功设置状态
				if(200 == status && "000000".equals(httpClient.getResult())) {
					log.info("推送成功通知...");
					savedTransFlow.setInterfaceNotifyState("1");
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else {
			// 通知失败，没有配置回调地址
			savedTransFlow.setInterfaceNotifyState("3");
			//transFlowService.updateByPrimaryKeySelective(savedTransFlow);
		}
		
		return 0;
	}
	
	/**
	 * 
	 * @param transFlow
	 * @return
	 */
	private String makeRequestBody(TransFlow transFlow,String path,String pwd) {
		ThreadResponse threadResponse = new ThreadResponse();
		try {
			TRspRoot tRspRoot = new TRspRoot();
			threadResponse.setRoot(tRspRoot);
			tRspRoot.setVersion(CommonBusiConstants.TRANS_VERSION);
			tRspRoot.setEncoding(CommonBusiConstants.TRANS_ENCODING);
			tRspRoot.setCertId("");
			tRspRoot.setSignMethod(CommonBusiConstants.TRANS_SIGNMETHOD);
			tRspRoot.setTransType(transFlow.getTransTp());
			tRspRoot.setOrderId(transFlow.getMchntOrderId());
			tRspRoot.setMchntCd(transFlow.getMchntCd());
			tRspRoot.setDkType(transFlow.getDkType());
			tRspRoot.setTransAt(transFlow.getTransAt().toString());
			tRspRoot.setAtType(CommonBusiConstants.TRANS_ATTYPE);
			tRspRoot.setTransTm(transFlow.getTransTm());
			tRspRoot.setQueryId(transFlow.getMchntOrderId());
			tRspRoot.setRespCod(transFlow.getRespCd());
			tRspRoot.setRespMsg(transFlow.getOrigRespMsg());
			double transAt = (double) transFlow.getTransAt();
			transAt = transAt / 100;
			tRspRoot.setSettleAt("" + transAt);
			tRspRoot.setSettleType("");
			tRspRoot.setSettleDate("");
			tRspRoot.setExchangeDate("");
			tRspRoot.setExchangeRate("");
			MerchantCertUtil.addSignature(threadResponse,path,pwd);
			return XMLUtils.convertToXml(threadResponse);
		} catch (Exception e) {
			log.info("交易服务出现异常" + e.getMessage(), e);
			try {
				String resultMsg = e.getMessage();
				TRspRoot root = new TRspRoot();
				threadResponse.setRoot(root);
				// 25 交易失败，请确认失败原因
				threadResponse.getRoot().setRespCod("0025");
				threadResponse.getRoot().setRespMsg(resultMsg);
				MerchantCertUtil.addSignature(threadResponse,path,pwd);
				return XMLUtils.convertToXml(threadResponse);
			} catch (Exception e1) {
				log.info("交易服务异常处理出现异常" + e.getMessage(), e);
				return "error";
			}
		}
	}
	
	
	
	
}
