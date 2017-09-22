package com.unionpay.withhold.api.schedule;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
/*import com.unionpay.dk.busi.base.ThreadTaskPool;
import com.unionpay.dk.cache.helper.PropertiesHelper;
import com.unionpay.dk.common.constant.CommonConstants;
import com.unionpay.dk.model.BatchDetail;
import com.unionpay.dk.model.TransFlow;
import com.unionpay.dk.service.OperateLogService;
import com.unionpay.dk.service.TransFlowService;*/
import com.unionpay.withhold.api.task.NotifyTransFlowTask;

/**
 * 定时触发器，
 * 	1）遍历出当前未处理的代扣数据，生成进代扣处理器内
 *  2）遍历出处理中的代扣数据状态，生成进查询处理器内
 * 
 * @author Luke
 *
 */
@Component
public class TransFlowAssistSchedule {
	public static final Logger logger = Logger.getLogger(TransFlowAssistSchedule.class);

	/*@Resource
	TransFlowService transFlowService;

	@Resource
	OperateLogService operateLogService;
*/
	/**
	 * 定时任务：1. 每隔5秒查询一次需要异步推送的消息。
	 */
	@Scheduled(cron = "0/5 * *  * * ? ")
	void asynNotifyHandler() {
		/*// 查询交易
		if (PropertiesHelper.getInstance().getBooleanProperty("mchntPushSwitch", false)) {
			try {
				ThreadTaskPool taskPool = ThreadTaskPool.getInstance();
				// 提取待推送的任务列表
				List<TransFlow> newNotifyTasks = transFlowService.findTaskTrans();
				if(newNotifyTasks != null && newNotifyTasks.size() > 0) {
					logger.info("【定时器】异步推送下游交易状态任务：" + newNotifyTasks.size());
					
					for (TransFlow transFlow : newNotifyTasks) {
						taskPool.executeWithDiscardPolicy(new NotifyTransFlowTask(transFlow));
					}	
				}
				
				// 提取待推送的补偿的任务列表
				// 查询5秒前的数据
				Long curMilSeconds = System.currentTimeMillis();
				List<TransFlow> retryNotifyTasks = transFlowService.findTaskRetryTrans(new Timestamp(curMilSeconds - 5 * 1000));
				if(retryNotifyTasks != null && retryNotifyTasks.size() > 0) {
					logger.info("【定时器】异步推送下游交易状态重发任务：" + retryNotifyTasks.size());
					
					for (TransFlow transFlow : retryNotifyTasks) {
						taskPool.executeWithDiscardPolicy(new NotifyTransFlowTask(transFlow));
					}
				}
				
			} catch (Exception e) {
				logger.error("【定时器】异步推送下游交易状态异常", e);
			}
		}*/
	}

	/**
	 * 交易处理逻辑
	 * 
	 * @param transDetail
	 * @param dkType
	 * @param transSource
	 * @param userId
	 * @param queryTransFlow 
	 * @param request
	 * @return
	 *//*
	public JSONObject transHandle(BatchDetail transDetail, String dkType, String transSource, String userId, TransFlow queryTransFlow, HttpServletRequest request) {
		JSONObject jsonObj = new JSONObject();

		// 获取订单号计数，更新计数值
		String orderIdCount = transFlowService.getOrderIdCount(request);
		// 计数值获取失败
		if (orderIdCount == null) {
			logger.error("获取订单号计数序列失败！");
			jsonObj.put("success", false);
			jsonObj.put("msg", "获取订单号计数序列失败！");
			jsonObj.put("respCd", "0007");
			return jsonObj;
		}

		Date date = new Date();

		// 交易发送前校验：商户和渠道
		logger.info("开始进行交易发送前校验...");
		JSONObject verifyRslt = transFlowService.transVerify(transDetail, dkType, transSource, userId, orderIdCount,
				date, request);

		Boolean verifyState = verifyRslt.getBoolean("success");
		if (!verifyState) {
			logger.info("交易发送前校验失败！");
			return verifyRslt;
		}

		logger.info("交易发送前校验成功！");

		// 构造查询请求参数
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateStr = format.format(date);
		String pswOrderId = dateStr + orderIdCount;

		queryTransFlow.setMchntCd(transDetail.getMchntCd());
		queryTransFlow.setPasswayOrderId(pswOrderId);
		if (StringUtils.isEmpty(transDetail.getTransTm())) {
			queryTransFlow.setTransTm(dateStr);
		} else {
			queryTransFlow.setTransTm(transDetail.getTransTm());
		}
		queryTransFlow.setTransTp(CommonConstants.TRANS_TP_SINGLE);

		return verifyRslt;
	}*/
}
