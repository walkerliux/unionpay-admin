package com.unionpay.withhold.admin.service;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TMerchChnl;
import com.unionpay.withhold.admin.pojo.TMerchChnlWithBLOBs;
import com.unionpay.withhold.admin.pojo.TMerchDeta;
import com.unionpay.withhold.admin.pojo.TMerchDetaApply;

public interface MerchChnlService {
	/**
	 * 查询商户通道信息
	 * @param merchDeta
	 * @param chnlcode 
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean queryMerchChnl(TMerchDeta merchDeta, String chnlcode, Integer page, Integer rows);
	/**
	 * 修改商户通道信息
	 * @param merchDeta
	 * @return
	 */
	ResultBean updateMerchDChnl(TMerchChnlWithBLOBs merchChnl);
	/**
	 * 查看商户通道信息
	 * @param selfId
	 * @return
	 */
	TMerchChnlWithBLOBs querydateMerchDChnlById(Integer tid);
	
	/**
	 * 增加通道信息
	 * @param merchChnl
	 * @return
	 */
	ResultBean addMerchChnl(TMerchChnlWithBLOBs merchChnl);
	/**
	 * 查询商户通道信息
	 * @param merchDeta
	 * @param chnlcode
	 * @param page
	 * @param rows
	 * @return
	 */
	PageBean queryaddMerchChnl(TMerchDeta merchDeta, String chnlcode,
			Integer page, Integer rows);
	/**
	 * 注销商户通道信息
	 * @param merchChnl
	 * @return
	 */
	ResultBean logoutMerchChnl(TMerchChnlWithBLOBs merchChnl);
	/**
	 * 启动商户通道信息
	 * @param merchChnl
	 * @return
	 */
	ResultBean startMerchChnl(TMerchChnlWithBLOBs merchChnl);

}
