package com.unionpay.withhold.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unionpay.withhold.api.batch.bean.BatchQueryResBean;
import com.unionpay.withhold.api.common.bean.MessageBean;
import com.unionpay.withhold.api.service.BatchTradeService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 批量查询服务
 * @author: yuanshaodong
 * @date: 2017年8月30日
 * @version 1.0
 */
@SuppressWarnings("all")
@Service("batchQueryService")
public class BatchQueryServiceImpl implements BatchTradeService {
	private static final Logger logger = LoggerFactory.getLogger(BatchQueryServiceImpl.class);
	
	private final String collectFlag="01";
	private final String payFlag ="02";

	@SuppressWarnings("rawtypes")
	@Override
	public MessageBean invoke(MessageBean messageBean) {
		BatchQueryResBean batchQueryResBean=new BatchQueryResBean();
		/*try {
			BatchQueryReqBean reqBean = (BatchQueryReqBean) JSONObject.toBean(JSONObject.fromObject(messageBean.getData()),
					BatchQueryReqBean.class);
			batchQueryResBean = BeanCopyUtil.copyBean(BatchQueryResBean.class, reqBean);
			ValidateLocator.validateBeans(reqBean);
			ResultBean resultBean = null;
			String url = null;
			
			if (collectFlag.equals(reqBean.getBusiType())) {// 批量代收
				url=urlBean.getBatchQueryCollectUrl();
			} else if (payFlag.equals(reqBean.getBusiType())) {// 批量代付
				url=urlBean.getBatchQueryPayUrl();
			}
			
			httpUtils.openConnection();
			String responseContent = httpUtils.executeHttpGet(url+"/"+reqBean.getMerId()+"/"+reqBean.getBatchNo()+"/"+reqBean.getTxnDate(),Constants.Encoding.UTF_8);
			logger.info("批量查询结果:"+responseContent);
			resultBean=(ResultBean) JSONObject.toBean(JSONObject.fromObject(responseContent), ResultBean.class);
			
			if (!resultBean.isResultBool()) {
				batchQueryResBean.setRespCode(resultBean.getErrCode().toString());
				batchQueryResBean.setRespMsg(resultBean.getErrMsg().toString());
			} else {
				batchQueryResBean.setRespCode(ResponseTypeEnum.success.getCode());
				batchQueryResBean.setRespMsg(ResponseTypeEnum.success.getMessage());
				
				Map<String, Class> mapClass=new HashMap<>();
				if (collectFlag.equals(reqBean.getBusiType())) {// 批量代收
					mapClass.put("resultObj", BatchQueryBean.class);
					mapClass.put("fileContentList", BatchQueryCollectFileContentBean.class);
				} else if (payFlag.equals(reqBean.getBusiType())) {// 批量代付
					mapClass.put("resultObj", BatchQueryBean.class);
					mapClass.put("fileContentList", BatchQueryPayFileContentBean.class);
				}
				//返回结果处理
				resultBean=(ResultBean) JSONObject.toBean(JSONObject.fromObject(responseContent), ResultBean.class,mapClass);
				BatchQueryBean batchResultBean = (BatchQueryBean) resultBean.getResultObj();
				BeanCopyUtil.copyBean(batchQueryResBean, batchResultBean);
				//保留域数据处理
				if (collectFlag.equals(reqBean.getBusiType())) {// 批量代收
					batchQueryResBean.setFileContent(
							FlaterUtils.deflater(JSONArray.fromObject(batchResultBean.getCollectFileContent()).toString()));
				} else if (payFlag.equals(reqBean.getBusiType())) {// 批量代付
					batchQueryResBean.setFileContent(
							FlaterUtils.deflater(JSONArray.fromObject(batchResultBean.getPayFileContent()).toString()));
				}
			}
		} catch (DataErrorException e) {
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackTrace(e));
			batchQueryResBean.setRespCode(ResponseTypeEnum.dataError.getCode());
			batchQueryResBean.setRespMsg(ResponseTypeEnum.dataError.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(ExceptionUtil.getStackTrace(e));
			batchQueryResBean.setRespCode(ResponseTypeEnum.fail.getCode());
			batchQueryResBean.setRespMsg(ResponseTypeEnum.fail.getMessage());
		}finally {
			httpUtils.closeConnection();
		}*/
		messageBean.setData(JSONObject.fromObject(batchQueryResBean).toString());
		return messageBean;
	}

}
