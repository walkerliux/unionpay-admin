package com.unionpay.dk.webservice.impl;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.unionpay.dk.webservice.TranWebService;
import com.unionpay.withhold.api.bean.DownloadRequest;
import com.unionpay.withhold.api.bean.DownloadResponse;
import com.unionpay.withhold.api.bean.DwnReqRoot;
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
import com.unionpay.withhold.api.model.MerchMk;
import com.unionpay.withhold.api.service.MerchMkService;
import com.unionpay.withhold.api.util.MerchantCertUtil;
import com.unionpay.withhold.api.util.ValidateLocator;
import com.unionpay.withhold.api.util.XMLUtils;
import com.unionpay.withhold.trade.api.FEAPI;
import com.unionpay.withhold.trade.api.bean.ResultBean;
import com.unionpay.withhold.trade.api.bean.SingleCollectBean;
import com.unionpay.withhold.utils.BeanCopyUtil;
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
	@Autowired
	private FEAPI fe;
	/**
	 * 单笔交易
	 */
	@Override
	public String launchTran(String message) {
		MerchantRequest merchantRequest;
		MerchantResponse response = new MerchantResponse(); // 应答实体
		String result="";
		logger.info("交易服务开始");
		MerchMk merchMk=null;
		try {
			merchantRequest = XMLUtils.converyToJavaBean(message.trim(), MerchantRequest.class);
			response = XMLUtils.convertToRes(merchantRequest);
			DkContext context = new DkContextImpl();
			context.set("req", merchantRequest);
			ReqRoot root = merchantRequest.getRoot();
		    merchMk=merchMkService.selectByPrimaryKey(root.getCertId());
				launchTranValidate(context,merchMk.getMemberpubkey(),merchantRequest);
				SingleCollectBean singleCollectBean=BeanCopyUtil.copyBean(SingleCollectBean.class, root);
				//TODO:暂时测试
				ResultBean resultBean =new ResultBean();//fe.realTimeCollect(JSONObject.fromObject(singleCollectBean).toString());
				if (resultBean!=null && resultBean.isResultBool()) {
					response.getRoot().setRespCod("00");
					response.getRoot().setRespMsg("交易成功！");
				}else{
					response.getRoot().setRespCod(resultBean.getRespCode());
					response.getRoot().setRespMsg(resultBean.getRespMsg());
				}
			
		    }catch(DataErrorException e) {
				logger.warn("参数异常：【" + e.getRespCode()+ "】" + e.getRespMessage());
				response.getRoot().setRespCod(e.getRespCode());
				response.getRoot().setRespMsg(e.getRespMessage());
			}
			catch(Exception e) {
				logger.error(e, e);
				response.getRoot().setRespCod("0025");
				response.getRoot().setRespMsg("交易异常");
			}
			try {
				logger.info("交易服务生成应答报文");
				MerchantCertUtil.addSignature(response,merchMk.getLocalpubkey(),merchMk.getPlatformpfxpwd());
				result= XMLUtils.convertToXml(response);
			} catch (Exception e) {
				logger.info("交易应答报文生成异常,无法正常返回客户信息");
				logger.error(e, e);
				result="error";
			}
			return result;
	}

	/**
	 * 交易查询
	 */
	@Override
	public String queryTranResult(String message) {
		QueryRequest queryRequest;
		QueryResponse queryResponse = new QueryResponse();
		String result="";
		MerchMk merchMk=new MerchMk();
		logger.info("查询服务开始");
		try {
			queryRequest = XMLUtils.converyToJavaBean(message.trim(), QueryRequest.class);
			queryResponse = XMLUtils.convertToRes(queryRequest);
			logger.info("查询服务初始化信息准备成功");
			DkContext context = new DkContextImpl();
			QReqRoot root = queryRequest.getRoot();
		    merchMk=merchMkService.selectByPrimaryKey(root.getCertId());
			queryTranValidate(context,merchMk.getMemberpubkey(),queryRequest);
			//TODO:调用业务逻辑
			queryResponse.getRoot().setRespCod("00");
			queryResponse.getRoot().setRespMsg("查询成功");
			logger.info("交易服务生成应答报文");
		} catch(DataErrorException e){
			logger.warn("参数异常：【" + e.getRespCode()+ "】" + e.getRespMessage());
			queryResponse.getRoot().setRespCod(e.getRespCode());
			queryResponse.getRoot().setRespMsg(e.getRespMessage());
		}
		catch (Exception e) {
			logger.error("交易服务异常处理出现异常" + e.getMessage(), e);
			queryResponse.getRoot().setRespCod("0025");
			queryResponse.getRoot().setRespMsg("交易服务异常处理出现异常");
		}
		try {
			MerchantCertUtil.addSignatureQuery(queryResponse,merchMk.getLocalpubkey(),merchMk.getPlatformpfxpwd());
			result= XMLUtils.convertToXml(queryResponse);
		} 
		catch (Exception e1) {
			logger.info("生成异常交易返回报文出错：" + e1.getMessage(), e1);
			return "error";
		}
		
		return result;
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
		
		ValidateLocator.validateBeans(root,true);
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
		
		ValidateLocator.validateBeans(root,true);
		return 0;
	}
	
	private int downTranValidate(DkContext context,String certFilename,DownloadRequest request) throws AbstractBusiException {
		logger.info("【下游代扣交易】基本参数效验：" + JSON.toJSONString(context));
		DwnReqRoot root = request.getRoot();
		boolean verifySignature = context.getBoolean("verifySignature");
		// 校验报文是否加签
		if (verifySignature && StringUtils.isEmpty(request.getSignature())) {
			logger.info("商户请求报文验签失败");
			throw new TransFlowException("0028", "商户请求报文验签失败");
		}
		if (!MerchantCertUtil.validateDown(request, certFilename)) {
			logger.info("商户请求报文验签失败");
			throw new TransFlowException("0028", "商户请求报文验签失败");
		}
		logger.info("交易服务初始化信息准备成功");
		
		ValidateLocator.validateBeans(root,true);
		return 0;
	}

	@Override
	public String downloadTrans(String message) {
		DownloadRequest downloadRequest;
		DownloadResponse downloadResponse = new DownloadResponse();
		logger.info("查询服务开始");
		MerchMk merchMk=new MerchMk();
		try {
			downloadRequest = XMLUtils.converyToJavaBean(message.trim(), DownloadRequest.class);
			downloadResponse = XMLUtils.convertToRes(downloadRequest);
			logger.info("查询服务初始化信息准备成功");
			DkContext context = new DkContextImpl();
			DwnReqRoot root = downloadRequest.getRoot();
		    merchMk=merchMkService.selectByPrimaryKey(root.getCertId());
			downTranValidate(context,merchMk.getMemberpubkey(),downloadRequest);
			//TODO:调用业务逻辑
			String respCode = "00";
			String respMsg = "下载成功";
			downloadResponse.getRoot().setRespCod(respCode);
			downloadResponse.getRoot().setRespMsg(respMsg);
			logger.info("交易服务生成应答报文");
			
		} catch(DataErrorException e){
			logger.error("参数异常：【" + e.getRespCode()+ "】" + e.getRespMessage());
			downloadResponse.getRoot().setRespCod(e.getRespCode());
			downloadResponse.getRoot().setRespMsg(e.getRespMessage());
		}
		catch (Exception e) {
			logger.error("交易服务异常处理出现异常" + e.getMessage(), e);
			downloadResponse.getRoot().setRespCod("0025");
			downloadResponse.getRoot().setRespMsg("交易服务异常处理出现异常");
		}
		try {
			MerchantCertUtil.addSignatureDown(downloadResponse,merchMk.getLocalpubkey(),merchMk.getPlatformpfxpwd());
			return XMLUtils.convertToXml(downloadResponse);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
}
