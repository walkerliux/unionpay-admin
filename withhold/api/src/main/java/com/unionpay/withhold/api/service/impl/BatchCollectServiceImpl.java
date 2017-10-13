package com.unionpay.withhold.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.batch.bean.BatchCollectFileContentBean;
import com.unionpay.withhold.api.batch.bean.BatchCollectReqBean;
import com.unionpay.withhold.api.batch.bean.BatchCollectResBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.common.enums.ResponseTypeEnum;
import com.unionpay.withhold.api.exception.DataErrorException;
import com.unionpay.withhold.api.service.BatchTradeService;
import com.unionpay.withhold.api.util.FlaterUtils;
import com.unionpay.withhold.api.util.ValidateLocator;
import com.unionpay.withhold.trade.api.FEAPI;
import com.unionpay.withhold.trade.api.bean.BatchCollectBean;
import com.unionpay.withhold.trade.api.bean.BatchCollectDetaBean;
import com.unionpay.withhold.trade.api.bean.ResultBean;
import com.unionpay.withhold.utils.BeanCopyUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 批量代收服务
 * @author: 张世栋
 * @date: 2017年9月25日14:06:05
 * @version 1.0
 */
@Service("batchCollectService")
public class BatchCollectServiceImpl implements BatchTradeService {
	private static final Logger logger = LoggerFactory.getLogger(BatchCollectServiceImpl.class);
	@Autowired
	private FEAPI fe;
	@SuppressWarnings({ "deprecation", "unchecked", "static-access" })
	@Override
	public MessageBean invoke(MessageBean messageBean) {
		BatchCollectResBean batchCollectResBean = new BatchCollectResBean();
		try{
			//api批量代收
			BatchCollectReqBean reqBean = (BatchCollectReqBean) JSONObject
					.toBean(JSONObject.fromObject(messageBean.getData()), BatchCollectReqBean.class);
			batchCollectResBean = BeanCopyUtil.copyBean(BatchCollectResBean.class, reqBean);
			ValidateLocator.validateBeans(reqBean,false);
			//产品业务批量代收
			BatchCollectBean batchCollectionBean = BeanCopyUtil.copyBean(BatchCollectBean.class, reqBean);
			List<BatchCollectDetaBean> fileContents = new ArrayList<>();
			if (StringUtils.isNotEmpty(reqBean.getFileContent())) {
				JSONArray data = JSONArray.fromObject(FlaterUtils.inflater(reqBean.getFileContent()));
				List<BatchCollectFileContentBean> batchCollectFileContents = data.toList(data,BatchCollectFileContentBean.class);
				//解析   业务报文   文件域
				for (BatchCollectFileContentBean batchCollectFileContent : batchCollectFileContents) {
					//业务报文数据校验
					ValidateLocator.validateBeans(batchCollectFileContent,false);
					BatchCollectDetaBean fileContentBean = BeanCopyUtil.copyBean(BatchCollectDetaBean.class,batchCollectFileContent);
					fileContents.add(fileContentBean);
				}
			}
			batchCollectionBean.setDetaList(fileContents);
			//批量代付交易
			String data = JSONObject.fromObject(batchCollectionBean).toString();
			logger.info("调用代扣业务处理序列化数据==>{}",data);
			ResultBean resultBean=new ResultBean("0000", "成功");//fe.batchCollect(data);

			if (!resultBean.isResultBool()) {
				batchCollectResBean.setRespCode(resultBean.getRespCode());
				batchCollectResBean.setRespMsg(resultBean.getRespMsg());
			} else {
				batchCollectResBean.setTn(resultBean.getResultObj().toString());
				batchCollectResBean.setRespCode(ResponseTypeEnum.success.getCode());
				batchCollectResBean.setRespMsg(ResponseTypeEnum.success.getMessage());
			}
		} catch (DataErrorException e) {
			batchCollectResBean.setRespCode(e.getRespCode());
			batchCollectResBean.setRespMsg(e.getRespMessage());
			logger.error(e.getRespMessage());
		} catch (Exception e) {
			batchCollectResBean.setRespCode(ResponseTypeEnum.fail.getCode());
			batchCollectResBean.setRespMsg(ResponseTypeEnum.fail.getMessage());
			logger.error(e.getMessage());
		}
		logger.error("批量代扣结果返回==>{}",JSONObject.fromObject(batchCollectResBean).toString());
		messageBean.setData(JSONObject.fromObject(batchCollectResBean).toString());
		return messageBean;
	}
}
