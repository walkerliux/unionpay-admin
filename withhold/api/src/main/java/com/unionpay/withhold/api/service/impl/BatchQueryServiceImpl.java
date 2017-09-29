package com.unionpay.withhold.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.batch.bean.BatchQueryReqBean;
import com.unionpay.withhold.api.batch.bean.BatchQueryResBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.common.enums.ResponseTypeEnum;
import com.unionpay.withhold.api.exception.DataErrorException;
import com.unionpay.withhold.api.service.BatchTradeService;
import com.unionpay.withhold.api.util.FlaterUtils;
import com.unionpay.withhold.api.util.ValidateLocator;
import com.unionpay.withhold.trade.api.FEAPI;
import com.unionpay.withhold.trade.api.bean.BatchCollectQueryBean;
import com.unionpay.withhold.trade.api.bean.ResultBean;
import com.unionpay.withhold.utils.BeanCopyUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 批量查询服务
 * @author: 张世栋
 * @date: 2017年8月30日
 * @version 1.0
 */
@SuppressWarnings("all")
@Service("batchQueryService")
public class BatchQueryServiceImpl implements BatchTradeService {
	private static final Logger logger = LoggerFactory.getLogger(BatchQueryServiceImpl.class);
	@Autowired
	private FEAPI fe;
	@SuppressWarnings("rawtypes")
	@Override
	public MessageBean invoke(MessageBean messageBean) {
		BatchQueryResBean batchQueryResBean=new BatchQueryResBean();
		try {
			BatchQueryReqBean reqBean = (BatchQueryReqBean) JSONObject.toBean(JSONObject.fromObject(messageBean.getData()),
					BatchQueryReqBean.class);
			batchQueryResBean = BeanCopyUtil.copyBean(BatchQueryResBean.class, reqBean);
			ValidateLocator.validateBeans(reqBean,false);
			BatchQueryReqBean batchQueryReqBean=BeanCopyUtil.copyBean(BatchQueryReqBean.class, reqBean);
			String data= JSONObject.fromObject(batchQueryReqBean).toString();
			logger.info("调用代扣查询处理序列化数据==>{}",data);
			//TODO:模拟
			ResultBean resultBean=new ResultBean(); //fe.queryBatchCollect(data);
			if (!resultBean.isResultBool()) {
				batchQueryResBean.setRespCode(resultBean.getRespCode());
				batchQueryResBean.setRespMsg(resultBean.getRespMsg());
			} else {
				batchQueryResBean.setRespCode(ResponseTypeEnum.success.getCode());
				batchQueryResBean.setRespMsg(ResponseTypeEnum.success.getMessage());
				
				/*Map<String, Class> mapClass=new HashMap<>();
				mapClass.put("resultObj", BatchCollectQueryBean.class);
				//返回结果处理
				resultBean=(ResultBean) JSONObject.toBean(JSONObject.fromObject(responseContent), ResultBean.class,mapClass);
				BatchQueryBean batchResultBean = (BatchQueryBean) resultBean.getResultObj();
				BeanCopyUtil.copyBean(batchQueryResBean, batchResultBean);
				//保留域数据处理
				batchQueryResBean.setFileContent(
							FlaterUtils.deflater(JSONArray.fromObject(batchResultBean.getCollectFileContent()).toString()));*/
				
			}
		} catch (DataErrorException e) {
			e.printStackTrace();
			batchQueryResBean.setRespCode(e.getRespCode());
			batchQueryResBean.setRespMsg(e.getRespMessage());
			logger.error(e.getRespMessage());
		} catch (Exception e) {
			e.printStackTrace();
			batchQueryResBean.setRespCode(ResponseTypeEnum.fail.getCode());
			batchQueryResBean.setRespMsg(ResponseTypeEnum.fail.getMessage());
		}
		logger.info("代扣查询返回的数据==>{}",JSONObject.fromObject(batchQueryResBean).toString());
		messageBean.setData(JSONObject.fromObject(batchQueryResBean).toString());
		return messageBean;
	}

}
