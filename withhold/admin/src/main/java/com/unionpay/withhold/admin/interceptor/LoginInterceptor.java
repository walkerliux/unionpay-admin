 package com.unionpay.withhold.admin.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.unionpay.withhold.admin.dao.JedisClient;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MyCookieUtils;
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
		String requestType = request.getHeader("X-Requested-With");//识别ajax的响应头  
		//user相同的情况下
		if (!ipAddr.equals(ipRedis)||!browserInfo.equals(browser)) {
			// 检测响应头是否属于AJAX请求
			if (requestType != null && requestType.equals("XMLHttpRequest")) {
				 response.setHeader("sessionstatus", "timeout"); 
				 JSONObject json = new JSONObject();
				 json.put("errMsg", "您的登录已失效,请重新登录");
				 request.setCharacterEncoding("UTF-8");
				 response.setContentType("text/html;charset=utf-8");
				 response.getWriter().write(json.toString());
			}else {
				PrintWriter out = response.getWriter();
				out.println("<html>");      
				out.println("<script>");      
			    out.println("window.open ('"+request.getContextPath()+"/"+"','_top')");      
			    out.println("</script>");       
				 //out.print("<script type='application/javascript'>  parent.location.href='../index.jsp' </script>");  
			    out.println("</html>");
			    out.flush();
			}
	         
			return false;
		}
		jedisClient.expire(REDIS_USER_KEY+":"+token, REDIS_SESSION_EXPIRE);
		jedisClient.expire(REDIS_IP_KEY+":"+token, REDIS_SESSION_EXPIRE);
		jedisClient.expire(REDIS_BROWSER_KEY+":"+token, REDIS_SESSION_EXPIRE);
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
