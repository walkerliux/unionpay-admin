package com.unionpay.withhold.trade.risk.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.bean.ResultBean;
import com.unionpay.withhold.trade.risk.bean.RiskBean;
import com.unionpay.withhold.trade.risk.bean.RiskLevelEnum;
import com.unionpay.withhold.trade.risk.dao.RiskDAO;
import com.unionpay.withhold.trade.risk.dao.RiskListDAO;
import com.unionpay.withhold.trade.risk.dao.RiskTradeLogDAO;
import com.unionpay.withhold.trade.risk.pojo.RiskListDO;
import com.unionpay.withhold.trade.risk.pojo.RiskTradeLogDO;
import com.unionpay.withhold.trade.risk.service.TradeRiskService;

@Service
public class TradeRiskServiceImpl implements TradeRiskService {

	@Autowired
	private RiskDAO riskDAO;
	@Autowired
	private RiskTradeLogDAO riskTradeLogDAO;
	@Autowired
	private RiskListDAO riskListDAO;
	
	@Override
	@Transactional(readOnly=true)
	public ResultBean merchRiskControl(RiskBean riskBean) {
		ResultBean resultBean = null;
		List<Map<String, Object>> riskList = riskDAO.merchRiskControl(riskBean);
		int riskLevel = 0;
        short riskOrder = 0;
        RiskLevelEnum riskLevelEnum = null;
        String riskInfo = "";
        if(riskList.size()>0){
            riskInfo = riskList.get(0).get("RISK")+"";
            if(riskInfo.indexOf(",")>0){
            	String[] riskInfos =riskInfo.split(",");
            	try {
    				riskOrder = Short.valueOf(riskInfos[0]);
    				riskLevel = Integer.valueOf(riskInfos[1]);
    				riskLevelEnum = RiskLevelEnum.fromValue(riskLevel);
    				
    			} catch (Exception e) {
    				e.printStackTrace();
    				//throw new TradeRiskException("TR001");
    				resultBean = new ResultBean("TR001", "风控系统异常");
    			}
            }else{
            	riskLevelEnum = RiskLevelEnum.fromValue(Integer.valueOf(riskInfo));
            }
        }else{
            //throw new TradeException("T034");
        	//throw new TradeRiskException("TR002");
        	resultBean = new ResultBean("TR002", "无法取得风控规则");
        }
        if(resultBean != null) {
        	resultBean.setResultBool(false);
        }else {
        	if(RiskLevelEnum.PASS==riskLevelEnum){//交易通过
            	resultBean = new ResultBean("0000", "通过");
                return resultBean;
            }else {
            	 //记录风控日志
                RiskListDO riskStrategy =  riskListDAO.getRiskStrategy(riskOrder);
                resultBean = new ResultBean(riskOrder+"", "交易有风险");
                resultBean.setResultBool(false);
                resultBean.setResultObj(riskStrategy);
            }
        	resultBean.setSecondObj(riskLevel);
        }
        if(RiskLevelEnum.REFUSE==riskLevelEnum){//交易拒绝
        	resultBean = new ResultBean("TR003", "交易有风险,被风控系统拒绝");
            resultBean.setResultBool(false);
            resultBean.setSecondObj(riskLevel);
        }
		return resultBean;
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResultBean agentRiskControl(RiskBean riskBean) {
		ResultBean resultBean = null;
		List<Map<String, Object>> riskList = riskDAO.agentRiskControl(riskBean);
		int riskLevel = 0;
        short riskOrder = 0;
        RiskLevelEnum riskLevelEnum = null;
        String riskInfo = "";
        if(riskList.size()>0){
            riskInfo = riskList.get(0).get("RISK")+"";
            if(riskInfo.indexOf(",")>0){
            	String[] riskInfos =riskInfo.split(",");
            	try {
    				riskOrder = Short.valueOf(riskInfos[0]);
    				riskLevel = Integer.valueOf(riskInfos[1]);
    				riskLevelEnum = RiskLevelEnum.fromValue(riskLevel);
    			} catch (Exception e) {
    				e.printStackTrace();
    				//throw new TradeRiskException("TR001");
    				resultBean = new ResultBean("TR001", "风控系统异常");
    			}
            }else{
            	riskLevelEnum = RiskLevelEnum.fromValue(Integer.valueOf(riskInfo));
            }
        }else{
            //throw new TradeException("T034");
        	//throw new TradeRiskException("TR002");
        	resultBean = new ResultBean("TR002", "无法取得风控规则");
        }
        if(resultBean != null) {
        	resultBean.setResultBool(false);
        }else {
        	if(RiskLevelEnum.PASS==riskLevelEnum){//交易通过
            	resultBean = new ResultBean("0000", "通过");
                return resultBean;
            }else {
            	 //记录风控日志
                RiskListDO riskStrategy =  riskListDAO.getRiskStrategy(riskOrder);
                resultBean = new ResultBean(riskOrder+"", "交易有风险");
                resultBean.setResultBool(false);
                resultBean.setResultObj(riskStrategy);
                
            }
        	resultBean.setSecondObj(riskLevel);
        }
        if(RiskLevelEnum.REFUSE==riskLevelEnum){//交易拒绝
        	resultBean = new ResultBean("TR003", "交易有风险,被风控系统拒绝");
            resultBean.setResultBool(false);
            resultBean.setSecondObj(riskLevel);
        }
		return resultBean;
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResultBean aisleRiskControl(RiskBean riskBean) {
		ResultBean resultBean = null;
		List<Map<String, Object>> riskList = riskDAO.aisleRiskControl(riskBean);
		int riskLevel = 0;
        short riskOrder = 0;
        RiskLevelEnum riskLevelEnum = null;
        String riskInfo = "";
        if(riskList.size()>0){
            riskInfo = riskList.get(0).get("RISK")+"";
            if(riskInfo.indexOf(",")>0){
            	String[] riskInfos =riskInfo.split(",");
            	try {
    				riskOrder = Short.valueOf(riskInfos[0]);
    				riskLevel = Integer.valueOf(riskInfos[1]);
    				riskLevelEnum = RiskLevelEnum.fromValue(riskLevel);
    			} catch (Exception e) {
    				e.printStackTrace();
    				//throw new TradeRiskException("TR001");
    				resultBean = new ResultBean("TR001", "风控系统异常");
    			}
            }else{
            	riskLevelEnum = RiskLevelEnum.fromValue(Integer.valueOf(riskInfo));
            }
        }else{
            //throw new TradeException("T034");
        	//throw new TradeRiskException("TR002");
        	resultBean = new ResultBean("TR002", "无法取得风控规则");
        }
        if(resultBean != null) {
        	resultBean.setResultBool(false);
        }else {
        	if(RiskLevelEnum.PASS==riskLevelEnum){//交易通过
            	resultBean = new ResultBean("0000", "通过");
                return resultBean;
            }else {
            	 //记录风控日志
                RiskListDO riskStrategy =  riskListDAO.getRiskStrategy(riskOrder);
                resultBean = new ResultBean(riskOrder+"", "交易有风险");
                resultBean.setResultBool(false);
                resultBean.setResultObj(riskStrategy);
            }
        	resultBean.setSecondObj(riskLevel);
        }
        if(RiskLevelEnum.REFUSE==riskLevelEnum){//交易拒绝
        	resultBean = new ResultBean("TR003", "交易有风险,被风控系统拒绝");
            resultBean.setResultBool(false);
            resultBean.setSecondObj(riskLevel);
        }
		return resultBean;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void saveRiskTradeLog(RiskTradeLogDO riskTradeLog) {
		riskTradeLogDAO.insert(riskTradeLog);
	}
	
	
}
