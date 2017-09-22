package com.unionpay.dk.webservice.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.unionpay.dk.webservice.TranWebService;
import com.unionpay.withhold.api.bean.MerchantRequest;
import com.unionpay.withhold.api.bean.MerchantResponse;
import com.unionpay.withhold.api.bean.QReqRoot;
import com.unionpay.withhold.api.bean.QueryRequest;
import com.unionpay.withhold.api.bean.QueryResponse;
import com.unionpay.withhold.api.bean.ReqRoot;
import com.unionpay.withhold.api.common.bean.DkContext;
import com.unionpay.withhold.api.common.bean.DkContextImpl;
import com.unionpay.withhold.api.exception.AbstractBusiException;
import com.unionpay.withhold.api.exception.DataErrorException;
import com.unionpay.withhold.api.exception.TransFlowException;
import com.unionpay.withhold.api.exception.ValidateLocator;
import com.unionpay.withhold.api.model.MerchMk;
import com.unionpay.withhold.api.service.MerchMkService;
import com.unionpay.withhold.api.util.MerchantCertUtil;
import com.unionpay.withhold.api.util.XMLUtils;

/**
 * 关于ws交易及查询的实现
 * 
 * @author 张世栋
 *
 */
@Service
public class TranWebServiceImpl implements TranWebService {
	private static Logger logger = Logger.getLogger(TranWebServiceImpl.class);

	
	@Autowired
	private MerchMkService merchMkService;
	/**
	 * 单笔交易
	 */
	@Override
	public String launchTran(String message) {
		MerchantRequest merchantRequest;
		MerchantResponse response = new MerchantResponse(); // 应答实体
		logger.info("交易服务开始");
		try {
			merchantRequest = XMLUtils.converyToJavaBean(message.trim(), MerchantRequest.class);
			response = XMLUtils.convertToRes(merchantRequest);
			DkContext context = new DkContextImpl();
			context.set("req", merchantRequest);
			ReqRoot root = merchantRequest.getRoot();
			MerchMk merchMk=merchMkService.selectByPrimaryKey(root.getMchntCd());
			try {
				launchTranValidate(context,merchMk.getMemberpubkey(),merchantRequest);
				response.getRoot().setRespCod("00");
				response.getRoot().setRespMsg("交易成功！");
				//TODO:调用业务逻辑
				//String respCode = context.getString("respCode");
				//String respMsg = context.getString("respMsg");
			}
			catch(DataErrorException e) {
				logger.warn("参数异常：【" + e.getRespCode()+ "】" + e.getRespMessage());
				response.getRoot().setRespCod(e.getRespCode());
				response.getRoot().setRespMsg(e.getRespMessage());
			}
			catch(Exception e) {
				logger.error(e, e);
				response.getRoot().setRespCod("0025");
				response.getRoot().setRespMsg("交易异常");
			}
			
			logger.info("交易服务生成应答报文");
			MerchantCertUtil.addSignature(response,merchMk.getLocalpubkey(),merchMk.getPlatformpfxpwd());
			return XMLUtils.convertToXml(response);
		} catch (Exception e) {
			logger.info("交易服务异常处理出现异常" + e.getMessage(), e);
			
			String resultMsg = "交易服务出现异常";
			response.getRoot().setRespCod("0025");
			response.getRoot().setRespMsg(resultMsg);
			try {
				return XMLUtils.convertToXml(response);
			} 
			catch (Exception e1) {
				logger.info("生成异常交易返回报文出错：" + e1.getMessage(), e1);
				return "error";
			}
		}
	}

	/**
	 * 交易查询
	 */
	@Override
	public String queryTranResult(String message) {
		QueryRequest queryRequest;
		QueryResponse queryResponse = new QueryResponse();
		logger.info("查询服务开始");
		try {
			queryRequest = XMLUtils.converyToJavaBean(message.trim(), QueryRequest.class);
			queryResponse = XMLUtils.convertToRes(queryRequest);
			logger.info("查询服务初始化信息准备成功");
			DkContext context = new DkContextImpl();
			QReqRoot root = queryRequest.getRoot();
			MerchMk merchMk=merchMkService.selectByPrimaryKey(root.getMchntCd());
			queryTranValidate(context,merchMk.getMemberpubkey(),queryRequest);
			//TODO:调用业务逻辑
			String respCode = "00";
			String respMsg = "查询成功";
			queryResponse.getRoot().setRespCod(respCode);
			queryResponse.getRoot().setRespMsg(respMsg);
			logger.info("交易服务生成应答报文");
			MerchantCertUtil.addSignatureQuery(queryResponse,merchMk.getLocalpubkey(),merchMk.getPlatformpfxpwd());
			return XMLUtils.convertToXml(queryResponse);
			
		} catch(DataErrorException e){
			return "error";
		}
		catch (Exception e) {
			logger.error("交易服务异常处理出现异常" + e.getMessage(), e);
			queryResponse.getRoot().setRespCod("0025");
			queryResponse.getRoot().setRespMsg("交易服务异常处理出现异常");
			try {
				return XMLUtils.convertToXml(queryResponse);
			} 
			catch (Exception e1) {
				logger.info("生成异常交易返回报文出错：" + e1.getMessage(), e1);
				return "error";
			}
		}
	}
	
	private int launchTranValidate(DkContext context,String certFilename,MerchantRequest request) throws AbstractBusiException {
		logger.info("【下游代扣交易】基本参数效验：" + JSON.toJSONString(context));
		ReqRoot root = request.getRoot();
		boolean verifySignature = context.getBoolean("verifySignature");
		// 校验报文是否加签
		if (verifySignature && StringUtils.isEmpty(request.getSignature())) {
			logger.info("商户请求报文验签失败");
			throw new TransFlowException("0028", "商户请求报文验签失败");
		}
		
		if (!MerchantCertUtil.validate(request, certFilename)) {
			logger.info("商户请求报文验签失败");
			throw new TransFlowException("0028", "商户请求报文验签失败");
		}
		logger.info("交易服务初始化信息准备成功");
		
		ValidateLocator.validateBeans(root);
		return 0;
	}
	
	private int queryTranValidate(DkContext context,String certFilename,QueryRequest request) throws AbstractBusiException {
		logger.info("【下游代扣交易】基本参数效验：" + JSON.toJSONString(context));
		QReqRoot root = request.getRoot();
		boolean verifySignature = context.getBoolean("verifySignature");
		// 校验报文是否加签
		if (verifySignature && StringUtils.isEmpty(request.getSignature())) {
			logger.info("商户请求报文验签失败");
			throw new TransFlowException("0028", "商户请求报文验签失败");
		}
		if (!MerchantCertUtil.validateQuery(request, certFilename)) {
			logger.info("商户请求报文验签失败");
			throw new TransFlowException("0028", "商户请求报文验签失败");
		}
		logger.info("交易服务初始化信息准备成功");
		
		ValidateLocator.validateBeans(root);
		return 0;
	}
	
}
