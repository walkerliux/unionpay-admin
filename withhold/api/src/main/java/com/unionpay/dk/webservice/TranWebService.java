package com.unionpay.dk.webservice;

/**
 * 
 * @author Luke
 *
 */
public interface TranWebService {
	/**
	 * 发起交易接口
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String launchTran(String message);

	/**
	 * 查询交易接口
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String queryTranResult(String message);
	
	/**
	 * 下载对账文件
	 *
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String downloadTrans(String message);
}
