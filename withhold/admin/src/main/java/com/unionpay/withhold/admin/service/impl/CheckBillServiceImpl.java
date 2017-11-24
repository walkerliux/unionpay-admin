package com.unionpay.withhold.admin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ResultBean;
import com.unionpay.withhold.admin.mapper.TBnkTxnMapper;
import com.unionpay.withhold.admin.mapper.TCheckfileMistakeMapper;
import com.unionpay.withhold.admin.mapper.TChnlDetaMapper;
import com.unionpay.withhold.admin.mapper.TSelfTxnMapper;
import com.unionpay.withhold.admin.mapper.TSettProcessMapper;
import com.unionpay.withhold.admin.pojo.TCheckfileMistake;
import com.unionpay.withhold.admin.pojo.TCheckfileMistakeExample;
import com.unionpay.withhold.admin.pojo.TChnlDetaExample;
import com.unionpay.withhold.admin.pojo.TSelfTxn;
import com.unionpay.withhold.admin.pojo.TSelfTxnExample;
import com.unionpay.withhold.admin.pojo.TSettProcess;
import com.unionpay.withhold.admin.pojo.TSettProcessExample;
import com.unionpay.withhold.admin.service.CheckBillService;
import com.unionpay.withhold.utils.DateUtil;

@Service
@Transactional
public class CheckBillServiceImpl implements CheckBillService {
	@Autowired
	private TChnlDetaMapper chnlDetaMapper;
	
	@Autowired
	private TSettProcessMapper settProcessMapper;
	
	@Autowired
	private TCheckfileMistakeMapper checkfileMistakeMapper;
	
	@Autowired
	private TSelfTxnMapper selfTxnMapper;
	
	@Autowired
	private TBnkTxnMapper bnkTxnMapper;
	
	@Override
	public ResultBean checkBill(String filestartid) {
		TSettProcess settProcess=new TSettProcess();
		if (StringUtils.isNotEmpty(filestartid)) {
			settProcess=settProcessMapper.selectByPrimaryKey(Integer.valueOf(filestartid));
		}
		//1,迁移数据
		Map<String, Object> map = new HashMap<>();
		map.put("filestartid", filestartid);
		map.put("instiid", settProcess.getInstiid());
		int flag =selfTxnMapper.insertFromTxnLog(map);
		
		TSettProcessExample example = new TSettProcessExample();
		TSettProcessExample.Criteria criteria=example.createCriteria();
		
		criteria.andTidEqualTo(Integer.valueOf(filestartid));
		if (flag>0) {
			//2,对账(正确的改状态, 错误的需要写到差错表)
			selfTxnMapper.updateByCheckBill(map);
			bnkTxnMapper.updateByCheckBill(map);
			selfTxnMapper.insertMistake(map);
			bnkTxnMapper.insertMistake(map);
			settProcess.setStatus("01");
			settProcessMapper.updateByExampleSelective(settProcess, example);
			return new ResultBean("对账完成");
		}else{
			settProcess.setStatus("99");
			settProcessMapper.updateByExampleSelective(settProcess, example);
			return new ResultBean("001","无数据需要对账");
		}
	}

	@Override
	public List<?> getAllChannel() {
		return chnlDetaMapper.selectByExample(new TChnlDetaExample());
	}

	@Override
	public List<TSettProcess> queryPorcess(Map<String, Object> variables) {
		TSettProcessExample example = new TSettProcessExample();
		TSettProcessExample.Criteria criteria=example.createCriteria();
		if (variables.containsKey("startDate")) {
			criteria.andStarttimeGreaterThanOrEqualTo(variables.get("startDate").toString());
		}
		if (variables.containsKey("endDate")) {
			criteria.andStarttimeLessThanOrEqualTo(variables.get("endDate").toString()+"235959");
		}
		if (variables.containsKey("instiid")) {
			criteria.andInstiidEqualTo(variables.get("instiid").toString());
		}
		example.setOrderByClause("tid desc");
		return settProcessMapper.selectByExample(example);
	}

	@Override
	public Map<String, Object> saveProcess(String instiid) {
		Map<String, Object> resultMap = new HashMap<>();
		TSettProcess settProcess = new TSettProcess();
		settProcess.setInstiid(instiid);
		settProcess.setStage("11");
		settProcess.setSpeed(0);
		settProcess.setStatus("00");
		settProcess.setStarttime(DateUtil.getCurrentDateTime());
		int flag = settProcessMapper.insertSelective(settProcess);
		if (flag>0) {
			resultMap.put("INFO", "任务添加成功");
			resultMap.put("CODE", "00");
		}else{
			resultMap.put("INFO", "任务添加失败");
			resultMap.put("CODE", "01");
		}
		return resultMap;
	}

	@Override
	public List<TCheckfileMistake> queryFail(Map<String, Object> variables) {
		TCheckfileMistakeExample example = new TCheckfileMistakeExample();
		TCheckfileMistakeExample.Criteria criteria =example.createCriteria();
		if (variables.containsKey("proid")) {
			criteria.andProidEqualTo(Long.valueOf(variables.get("proid").toString()));
		}
		List<TCheckfileMistake> list = checkfileMistakeMapper.selectByExample(example);
		return list;
	}

	@Override
	public List<TSelfTxn> querySuccess(Map<String, Object> variables) {
		TSelfTxnExample example=new TSelfTxnExample();
		TSelfTxnExample.Criteria criteria= example.createCriteria();
		if (variables.containsKey("proid")) {
			criteria.andProidEqualTo(Long.valueOf(variables.get("proid").toString()));
		}
		criteria.andStatusEqualTo("9");
		criteria.andResultEqualTo("02");
		List<TSelfTxn> list = selfTxnMapper.selectByExample(example);
		return list;
	}

	@Override
	public ResultBean dealmistake(String result, String status, String iid,long uid) {
		TCheckfileMistakeExample example= new TCheckfileMistakeExample();
		TCheckfileMistakeExample.Criteria criteria=example.createCriteria();
		TCheckfileMistake mistake=new TCheckfileMistake();
		mistake.setMistatus(status);
		mistake.setDealOpinion(result);
		mistake.setDealOperatorId(uid);
		mistake.setDealDate(new Date());
		criteria.andIidEqualTo(Integer.valueOf(iid));
		int flag =checkfileMistakeMapper.updateByExampleSelective(mistake, example);
		if (flag>0) {
			return new ResultBean("处理完成");
		}else{
			return new ResultBean("01","处理失败");
		}
		
	}

	@Override
	public Map<String, Object> dealReasult(String proid) {
		Map<String, Object> paramap=new HashMap<>();
		Map<String, Object> map=new HashMap<>();
		paramap.put("proid", proid);
		Map<String, Object> returnMap =new HashMap<>();
		returnMap=selfTxnMapper.localSuccessSum(paramap);
		map.put("succSum", returnMap.get("sums"));
		map.put("succNumber", returnMap.get("number"));
	    returnMap=checkfileMistakeMapper.localMistakeSum(paramap);
	    map.put("failLocalSum", returnMap.get("sums"));
		map.put("failLocalNumber", returnMap.get("number"));
	    returnMap=checkfileMistakeMapper.merchMistakeSum(paramap);
	    map.put("failMerchSum", returnMap.get("sums"));
		map.put("failMerchNumber", returnMap.get("number"));
		return map;
	}

	@Override
	public List<TSelfTxn> queryCheckFileInfo(String merchno, String date) {
		Map<String, Object> param=new HashMap<>();
		param.put("merchno", merchno);
		param.put("date", date);
		return selfTxnMapper.queryCheckFileInfo(param);
	}
}
