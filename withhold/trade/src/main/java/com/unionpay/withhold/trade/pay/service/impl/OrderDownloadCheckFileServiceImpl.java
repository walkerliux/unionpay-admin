package com.unionpay.withhold.trade.pay.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.api.bean.MerchCheckFileBean;
import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.pay.dao.OrderDownloadCheckFileDAO;
import com.unionpay.withhold.trade.pay.pojo.OrderDownloadCheckFileDO;
import com.unionpay.withhold.trade.pay.service.MerchCheckFileService;
import com.unionpay.withhold.trade.pay.service.OrderDownloadCheckFileService;

@Service
public class OrderDownloadCheckFileServiceImpl implements OrderDownloadCheckFileService {

	@Autowired
	private OrderDownloadCheckFileDAO orderDownloadCheckFileDAO;
	@Autowired
	private MerchCheckFileService merchCheckFileService;
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public ResultBean downloadCheckFile(MerchCheckFileBean merchCheckFileBean) {
		ResultBean resultBean = null;
		String path = merchCheckFileService.getMerchCheckFilePath(merchCheckFileBean.getMchnt_cd(), merchCheckFileBean.getTrans_dt());
		if(StringUtils.isNotEmpty(path)) {
			resultBean = new ResultBean("0000", "查询登记受理成功");
			resultBean.setResultObj(path);
		}else {
			resultBean = new ResultBean("0999", "系统处理失败");
			resultBean.setResultBool(false);
		}
		OrderDownloadCheckFileDO record = new OrderDownloadCheckFileDO();
		record.setCertId(merchCheckFileBean.getCert_id());
		record.setDlUrl(path);
		record.setEncoding(merchCheckFileBean.getEncoding());
		record.setMchntCd(merchCheckFileBean.getMchnt_cd());
		record.setQueryDt(merchCheckFileBean.getQuery_dt());
		record.setQueryId(merchCheckFileBean.getQuery_id());
		record.setRespcode(resultBean.getRespCode());
		record.setRespmsg(resultBean.getRespMsg());
		record.setSignMethod(merchCheckFileBean.getSign_method());
		record.setTransDt(merchCheckFileBean.getTrans_dt());
		record.setTransType(merchCheckFileBean.getTrans_type());
		record.setVersion(merchCheckFileBean.getVersion());
		orderDownloadCheckFileDAO.insert(record);
		return resultBean;
	}
}
