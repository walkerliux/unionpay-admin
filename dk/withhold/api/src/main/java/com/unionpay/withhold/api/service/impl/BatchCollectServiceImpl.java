package com.unionpay.withhold.api.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.batch.bean.BatchCollectFileContentBean;
import com.unionpay.withhold.api.batch.bean.BatchCollectReqBean;
import com.unionpay.withhold.api.batch.bean.BatchCollectResBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.exception.DataErrorException;
import com.unionpay.withhold.api.service.BatchTradeService;
import com.unionpay.withhold.api.util.FlaterUtils;
import com.unionpay.withhold.api.util.ValidateLocator;
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
	@Override
	public MessageBean invoke(MessageBean messageBean) {
		BatchCollectResBean batchCollectResBean = new BatchCollectResBean();
		try{
			//api批量代收
			BatchCollectReqBean reqBean = (BatchCollectReqBean) JSONObject
					.toBean(JSONObject.fromObject(messageBean.getData()), BatchCollectReqBean.class);
			batchCollectResBean = BeanCopyUtil.copyBean(BatchCollectResBean.class, reqBean);
			ValidateLocator.validateBeans(reqBean,false);
			//TODO:(1)产品业务批量代收
			//BatchCollectionBean batchCollectionBean = BeanCopyUtil.copyBean(BatchCollectionBean.class, reqBean);
			//List<BatchCollectionFileContentBean> fileContents = new ArrayList<>();
			if (StringUtils.isNotEmpty(reqBean.getFileContent())) {
				JSONArray data = JSONArray.fromObject(FlaterUtils.inflater(reqBean.getFileContent()));
				List<BatchCollectFileContentBean> batchCollectFileContents = data.toList(data,BatchCollectFileContentBean.class);
				//解析   业务报文   文件域
				for (BatchCollectFileContentBean batchCollectFileContent : batchCollectFileContents) {
					//业务报文数据校验
					ValidateLocator.validateBeans(batchCollectFileContent,false);
					//TODO: (2)
					//BatchCollectionFileContentBean fileContentBean = BeanCopyUtil.copyBean(BatchCollectionFileContentBean.class,batchCollectFileContent);
					
					//保留域数据校验
					/*if(fileContentBean.getCardType() == "02"){
						if(StringUtils.isNotBlank(fileContentBean.getCvn2())){
							batchCollectResBean.setRespCode("error");
							batchCollectResBean.setRespMsg("cvn2不能为空！");
							messageBean.setData(JSONObject.fromObject(batchCollectResBean).toString());
							return messageBean;
						}
						if(StringUtils.isNotBlank(fileContentBean.getExpired())){
							batchCollectResBean.setRespCode("error");
							batchCollectResBean.setRespMsg("信用卡有效期不能为空！");
							messageBean.setData(JSONObject.fromObject(batchCollectResBean).toString());
							return messageBean;
						}
					}
					fileContents.add(fileContentBean);*/
				}
			}
			//batchCollectionBean.setFileContent(fileContents);
			
			//批量代付交易
			//String responseContent = httpUtils.executeHttpPost(url,list,Constants.Encoding.UTF_8);
			//logger.info("批量代收处理结果:"+responseContent);
			//ResultBean resultBean=(ResultBean) JSONObject.toBean(JSONObject.fromObject(responseContent), ResultBean.class);

			/*if (!resultBean.isResultBool()) {
				batchCollectResBean.setRespCode(resultBean.getErrCode().toString());
				batchCollectResBean.setRespMsg(resultBean.getErrMsg().toString());
			} else {
				batchCollectResBean.setTn(resultBean.getResultObj().toString());
				batchCollectResBean.setRespCode(ResponseTypeEnum.success.getCode());
				batchCollectResBean.setRespMsg(ResponseTypeEnum.success.getMessage());
			}*/
		} catch (DataErrorException e) {
			/*batchCollectResBean.setRespCode(ResponseTypeEnum.dataError.getCode());
			batchCollectResBean.setRespMsg(ResponseTypeEnum.dataError.getMessage());
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackTrace(e));*/
		} catch (Exception e) {
			/*batchCollectResBean.setRespCode(ResponseTypeEnum.fail.getCode());
			batchCollectResBean.setRespMsg(ResponseTypeEnum.fail.getMessage());
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackTrace(e));*/
		}finally {
			//httpUtils.closeConnection();
		}
		
		messageBean.setData(JSONObject.fromObject(batchCollectResBean).toString());
		return messageBean;
	}
}
