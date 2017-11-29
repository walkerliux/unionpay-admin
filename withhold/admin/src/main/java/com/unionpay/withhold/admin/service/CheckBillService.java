package com.unionpay.withhold.admin.service;

import java.util.List;
import java.util.Map;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.pojo.TCheckfileMistake;
import com.unionpay.withhold.admin.pojo.TChnlDeta;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSettProcess;

/**
 * 对账
 * @author: zhangshd
 * @date:   2017年10月24日 下午3:19:32   
 * @version :v1.0
 */
public interface CheckBillService {
	public ResultBean checkBill(String filestartid);

	public List<TChnlDeta> getAllChannel();

	public List<TSettProcess> queryPorcess(Map<String, Object> variables);

	public boolean saveProcess(String instiid);

	public List<TCheckfileMistake> queryFail(Map<String, Object> variables);

	public List<TSelfTxn> querySuccess(Map<String, Object> variables);

	public ResultBean dealmistake(String result, String status, String iid,long uid);

	public Map<String, Object> dealReasult(String proid);

	public List<TSelfTxn> queryCheckFileInfo(String merchno, String date);
	
	public TSettProcess isPorcess(String instid ,String date);

}
