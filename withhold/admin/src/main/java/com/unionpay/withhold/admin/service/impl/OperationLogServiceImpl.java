package com.unionpay.withhold.admin.service.impl;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.dao.JedisClient;
import com.unionpay.withhold.admin.mapper.TOperationLogMapper;
import com.unionpay.withhold.admin.pojo.TOperationLog;
import com.unionpay.withhold.admin.pojo.TOperationLogExample;
import com.unionpay.withhold.admin.pojo.TOperationLogExample.Criteria;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.OperationLogService;
import com.unionpay.withhold.admin.utils.JsonUtils;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
@Service
@Transactional
public class OperationLogServiceImpl implements OperationLogService {
	@Value("${REDIS_USER_KEY}")
	private String REDIS_USER_KEY;
	@Value("${REDIS_IP_KEY}")
	private String REDIS_IP_KEY;
	@Value("${REDIS_BROWSER_KEY}")
	private String REDIS_BROWSER_KEY;
	@Value("${REDIS_SESSION_EXPIRE}")
	private int REDIS_SESSION_EXPIRE;
	@Autowired
	JedisClient jedisClient;

	@Autowired
	private TOperationLogMapper tOperationLogMapper;
	@Override
	public PageBean findLogByPage(String userId, String userName,
			Date beginDate, Date endDate, int page, int rows) {
		TOperationLogExample operationLogExample = new TOperationLogExample();
		Criteria criteria = operationLogExample.createCriteria();
		
		if (userId!=null&&!"".equals(userId)) {
			criteria.andUserIdEqualTo(userId);
		}
		if (userName!=null&&!"".equals(userName)) {
			criteria.andUsernameEqualTo(userName);
		}
		if (beginDate != null&&endDate!=null) {
			criteria.andOpDateBetween(beginDate, endDate);
		}
		int total = tOperationLogMapper.countByExample(operationLogExample);
		operationLogExample.setPageNum(page);
		operationLogExample.setPageSize(rows);
		operationLogExample.setOrderByClause("LOG_ID DESC");
		List<TOperationLog> list = tOperationLogMapper.selectByExample(operationLogExample);
		
		return new PageBean(total, list);
	}
	@Override
	public void addOperationLog(HttpServletRequest request,String opContent) {

		String cookieValue = MyCookieUtils.getCookieValue(request, "eb_token");
		String userValue = jedisClient.get(REDIS_USER_KEY+":"+cookieValue);
		if (userValue!=null&&!"".equals(userValue)) {
			
		
		TUser tUser = JsonUtils.jsonToPojo(userValue,TUser.class);
		TOperationLog tOperationLog = new TOperationLog();
		tOperationLog.setUserId(tUser.getUserId().toString());
		tOperationLog.setUsername(tUser.getUserName());

		tOperationLog.setOpContent(opContent);
		tOperationLog.setOpDate(new Date());
		try {
			InetAddress localAddress = OperationLogServiceImpl.getLocalHostLANAddress();
			tOperationLog.setIp(localAddress.getHostAddress());
			//tOperationLog.setHostName(localAddress.getHostName());
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
		tOperationLogMapper.insertSelective(tOperationLog);
		}
	}
	
	public static InetAddress getLocalHostLANAddress() throws Exception {
	    try {
	        InetAddress candidateAddress = null;
	        // 遍历所有的网络接口
	        for (Enumeration ifaces = NetworkInterface.getNetworkInterfaces(); ifaces.hasMoreElements(); ) {
	            NetworkInterface iface = (NetworkInterface) ifaces.nextElement();
	            // 在所有的接口下再遍历IP
	            for (Enumeration inetAddrs = iface.getInetAddresses(); inetAddrs.hasMoreElements(); ) {
	                InetAddress inetAddr = (InetAddress) inetAddrs.nextElement();
	                if (!inetAddr.isLoopbackAddress()) {// 排除loopback类型地址
	                    if (inetAddr.isSiteLocalAddress()) {
	                        // 如果是site-local地址，就是它了
	                        return inetAddr;
	                    } else if (candidateAddress == null) {
	                        // site-local类型的地址未被发现，先记录候选地址
	                        candidateAddress = inetAddr;
	                    }
	                }
	            }
	        }
	        if (candidateAddress != null) {
	            return candidateAddress;
	        }
	        // 如果没有发现 non-loopback地址.只能用最次选的方案
	        InetAddress jdkSuppliedAddress = InetAddress.getLocalHost();
	        return jdkSuppliedAddress;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
