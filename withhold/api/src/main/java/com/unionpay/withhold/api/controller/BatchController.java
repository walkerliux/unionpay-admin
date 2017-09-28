package com.unionpay.withhold.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.unionpay.withhold.api.batch.bean.BatchCollectNoticeReqBean;
import com.unionpay.withhold.api.batch.bean.CallBackReqBean;
import com.unionpay.withhold.api.batch.bean.ResponseBaseBean;
import com.unionpay.withhold.api.common.bean.AdditBean;
import com.unionpay.withhold.api.common.bean.BaseBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.common.enums.ResponseTypeEnum;
import com.unionpay.withhold.api.service.BatchTradeService;
import com.unionpay.withhold.api.service.MessageDecodeService;
import com.unionpay.withhold.api.service.MessageEncryptService;
import com.unionpay.withhold.api.signaturn.util.AESUtil;
import com.unionpay.withhold.api.util.ApplicationContextUtil;
import com.unionpay.withhold.api.util.DateUtils;
import com.unionpay.withhold.api.util.HttpUtils;
import com.unionpay.withhold.api.util.RiskInfoUtils;

import net.sf.json.JSONObject;
/**
 * 批量代收付接口
 * @author: 张世栋
 * @date: 2017年9月25日10:48:49
 * @version 1.0
 */
@Controller
@RequestMapping("/batch/")
public class BatchController {

	private Logger log = LoggerFactory.getLogger(BatchController.class);
	private BatchTradeService collectAndPaySerivce;
	
	private final String accessType="1";
	private final String encryMethod="01";
	//解密验签
	@Autowired
	private MessageDecodeService messageDecodeService;
	//加密加签
	@Autowired
	private MessageEncryptService messageEncryptService;
	
	/**
	 * 批量代收付Api
	 * @author: zhangshd
	 * @date: 2017年9月25日11:39:46
	 * @version v1.0
	 */
	@ResponseBody
	@RequestMapping("payAndCollectApi")
	public MessageBean payAndCollectApi(MessageBean messageBean) {
		log.info("批量代扣Api请求的参数(密文)===>" +JSONObject.fromObject(messageBean).toString());
		MessageBean requestBean=null;
		MessageBean responseBean=null;
		ResponseBaseBean responseBaseBean = new ResponseBaseBean();
		//附加数据准备
		AdditBean requestAddit= (AdditBean) JSONObject.toBean(JSONObject.fromObject(messageBean.getAddit()), AdditBean.class);
		AdditBean additBean=prepareAdditbean(requestAddit.getMerId(),requestAddit.getCertId());
		try {
			//验签,解密
			requestBean=messageDecodeService.decodeAndVerify_2048(messageBean);
			log.info("批量代扣Api验签解密后的数据===>" +JSONObject.fromObject(messageBean).toString());
			// 获取基础信息
			BaseBean baseBean = (BaseBean) JSONObject.toBean(JSONObject.fromObject(requestBean.getData()),BaseBean.class);
			// 确定处理接口方法
			collectAndPaySerivce = (BatchTradeService) ApplicationContextUtil.getBeanById(com.unionpay.withhold.api.common.enums.BatchTxnTypeEnum.getTxnTypeEnum(baseBean.getTxnType()).getClassName());
			// 业务处理
			responseBean = collectAndPaySerivce.invoke(requestBean);
			log.info("批量代扣Api业务处理返回数据(未加密)===>" +JSONObject.fromObject(responseBean).toString());
			responseBean=messageEncryptService.encryptAndSigntrue_2048(responseBean.getData(), additBean);
			
		} catch (Exception e) {
			e.printStackTrace();
			responseBaseBean.setRespCode(ResponseTypeEnum.decodeError.getCode());
			responseBaseBean.setRespMsg(ResponseTypeEnum.decodeError.getMessage());
			try {
				responseBean=messageEncryptService.encryptAndSigntrue_2048(responseBean.getData(), additBean);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		log.info("批量代扣Api业务处理返回数据(已加密)===>" +JSONObject.fromObject(responseBean).toString());
		return responseBean;
	}
	//附加数据（风控信息）；
	private AdditBean prepareAdditbean(String merid,String certid){
		AdditBean additBean = new AdditBean();
		try {
			additBean.setCertId(certid);
			additBean.setEncryKey(AESUtil.getAESKey());
			additBean.setAccessType(accessType);
			additBean.setMerId(merid);
			additBean.setEncryMethod(encryMethod);
			Map<String, Object> riskInfo = new TreeMap<String, Object>();
			riskInfo.put("random", RiskInfoUtils.randomInt(32));
			riskInfo.put("timestamp", DateUtils.geCurrentDateTimeStr());
			riskInfo.put("deviceID", RiskInfoUtils.getMacAddress());
			additBean.setRiskInfo(JSONObject.fromObject(riskInfo).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return additBean;
	}
	
	@ResponseBody
	@RequestMapping(value ="callback",produces="text/html;charset=UTF-8")
	public String callback(String data) {
		log.info("回调访问参数====>{}",data);
		CallBackReqBean callBackReqBean=(CallBackReqBean) JSONObject.toBean(JSONObject.fromObject(data), CallBackReqBean.class);
		System.out.println(JSON.toJSONString(callBackReqBean));
		//TODO:逻辑处理(透传)
		return "ChinapayOk";
	}
	
	@ResponseBody
	@RequestMapping("notice")
	public String notice(String data) {
		BatchCollectNoticeReqBean batchCollectNoticeReqBean=(BatchCollectNoticeReqBean) JSONObject.toBean(JSONObject.fromObject(data), BatchCollectNoticeReqBean.class);
		batchCollectNoticeReqBean.prepareBasicData();
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("data", JSON.toJSONString(batchCollectNoticeReqBean));
		String result="";
		try {
			result =HttpUtils.post(batchCollectNoticeReqBean.getBackUrl(), paramMap);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("noticetest")
	public String noticetest(String data) {
		log.info("批量代扣异步通知测试接收到的数据=====>"+data);
		return "测试是成功的接受到的参数是==>"+data;
	}
}
