package com.unionpay.withhold.trade.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.unionpay.withhold.trade.api.bean.ResultBean;

@Component
public class FEAPI {
	@Autowired
    private RestTemplate template;
	
	private final static String url="http://localhost:8080/trade/api/v1/fe";
	/**
	 * 实时代扣
	 * @param data
	 * @return
	 */
	public ResultBean realTimeCollect(String data) {
		return template.getForObject(url+"/realtime/collect?data={data}", ResultBean.class, data);
	} 	
	
	/**
	 * 批量代扣
	 * @param data
	 * @return
	 */
	public ResultBean batchCollect(String data) {
		return template.postForObject(url+"/batch/collect?data={data}", null, ResultBean.class, data);
	}
	
	/**
	 * 实时代扣查询
	 * @param data
	 * @return
	 */
	public ResultBean queryRealTimeCollect(String data) {
		return template.postForObject(url+"/realtime/query/collect?data={data}", null, ResultBean.class, data);
	}
	/**
	 * 批量代扣查询
	 * @param data
	 * @return
	 */
	public ResultBean queryBatchCollect(String data) {
		return template.postForObject(url+"/batch/query/collect?data={data}", null, ResultBean.class, data);
	}
	
	/**
	 * 验签报文
	 * @param xml
	 * @return
	 */
	public ResultBean validateSignature(String xml) {
		return template.postForObject(url+"/realtime/validateSignature?xml={xml}", null, ResultBean.class, xml);
	}
	/**
	 * 加签报文
	 * @param xml
	 * @return
	 */
	public ResultBean addSignature(String xml) {
		return template.postForObject(url+"/realtime/addSignature?xml={xml}", null, ResultBean.class, xml);
	}
	
	/**
	 * ChinaPay批量代收异步通知
	 * @param data
	 * @return
	 */
	public ResultBean cpBatchTradeNotify(String data) {
		return template.postForObject(url+"/path/cp/batchnotify?data={data}", null, ResultBean.class, data);
	}
	
	/**
	 * 对账文件下载
	 * @param data
	 * @return
	 */
	public ResultBean downloadCheckFile(String data) {
		return template.postForObject(url+"/checkfile/download?data={data}", null, ResultBean.class, data);
	}
}
