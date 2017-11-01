package com.unionpay.withhold.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.ResultBean;
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
	private TSelfTxnMapper selfTxn;

	@Autowired
	private TChnlDetaMapper chnlDetaMapper;
	
	@Autowired
	private TSettProcessMapper settProcessMapper;
	
	@Autowired
	private TCheckfileMistakeMapper checkfileMistakeMapper;
	
	@Autowired
	private TSelfTxnMapper selfTxnMapper;
	@Override
	public ResultBean checkBill() {
		//1,迁移数据
		//2,对账(正确的改状态, 错误的需要写到差错表)
		return null;
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
}
