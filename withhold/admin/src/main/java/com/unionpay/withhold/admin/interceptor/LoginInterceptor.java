package com.unionpay.withhold.admin.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.dao.JedisClient;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
import com.unionpay.withhold.admin.utils.StringUtil;
import com.unionpay.withhold.admin.utils.SystemUtils;

public class LoginInterceptor implements HandlerInterceptor {
	@Autowired
	private UserService userService;
	@Autowired
	JedisClient jedisClient;
	@Value("${REDIS_USER_KEY}")
	private String REDIS_USER_KEY;
	@Value("${REDIS_IP_KEY}")
	private String REDIS_IP_KEY;
	@Value("${REDIS_BROWSER_KEY}")
	private String REDIS_BROWSER_KEY;
	@Value("${REDIS_SESSION_EXPIRE}")
	private int REDIS_SESSION_EXPIRE;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//登录用户唯一标示符
		String token = MyCookieUtils.getCookieValue(request, "eb_token");
		//获取当前ip
		String ipAddr = SystemUtils.getIpAddr(request);
		//redis中ip
		String ipRedis = jedisClient.get(REDIS_IP_KEY+":"+token);
		//获取当前浏览器
		String browserInfo = SystemUtils.getRequestBrowserInfo(request);
		//redis中浏览器
		String browser = jedisClient.get(REDIS_BROWSER_KEY+":"+token);
		//user相同的情况下
		if (!ipAddr.equals(ipRedis)||!browserInfo.equals(browser)) {
			jedisClient.del(REDIS_IP_KEY+":"+token);
			jedisClient.del(REDIS_USER_KEY+":"+token);
			jedisClient.del(REDIS_BROWSER_KEY+":"+token);
		}
		String userValue = jedisClient.get(REDIS_USER_KEY+":"+token);
		if (StringUtil.isNull(userValue)) {
			/*String requestURI = request.getRequestURI();
			StringBuffer requestURL = request.getRequestURL();*/
			//response.sendRedirect("http://localhost:8080/admin/?alltime");
			 PrintWriter out = response.getWriter();
	            out.print("<script type='application/javascript'>  parent.location.href='../index.jsp' </script>");
	            out.flush();
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
