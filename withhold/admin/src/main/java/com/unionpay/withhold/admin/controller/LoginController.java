package com.unionpay.withhold.admin.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.LoginUser;

import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.FunctionService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.CookieUtils;
import com.unionpay.withhold.admin.utils.MD5Util;

@Controller
@RequestMapping("/login")
public class LoginController {
	private List<?> funlist;
	
	private HttpServletResponse response;
	private HttpServletRequest request;
	private Map<String, Object> session;
	private ServletContext sc;
	private int pwdFlag;// 密码有效期过期标示 1-过期 0-未过期
	private int pwdDay;// 密码到期时间，5天时开始提示
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Autowired
	private UserService userService;
	@Autowired
	private FunctionService functionService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView login(TUser user, HttpServletRequest request,
			String randcode) {

		return new ModelAndView("/index");
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public ModelAndView loginSuccess(TUser user, HttpServletRequest request)
			throws ParseException {
		ModelAndView result = new ModelAndView("/index");
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute(
				"LOGIN_USER");
		if (loginUser == null) {
			return new ModelAndView("/login");
		}
		if (loginUser.getUser().getLoginName().equals("admin")) {
			funlist = functionService.findFunction();
		} else {
			funlist = functionService.findLoginFuntion(loginUser.getUser());
		}
		Integer pwdFlag = checkPWDDate(request);
		pwdDay = calcExpirationDay(request);

		result.addObject("loginName", loginUser.getUser().getLoginName());
		result.addObject("funlist", funlist);

		result.addObject("pwdDay", pwdDay);
		result.addObject("pwdFlag", pwdFlag);

		return result;
	}

	/**
	 * 验证用户登录信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/validateUser")
	public Map<String, Object> validateUser(TUser user,
			HttpServletRequest request, String randcode) {
		sc = request.getSession().getServletContext();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		String rand = "";
		HttpSession session = request.getSession(true);
		if (session.getAttribute("randCheckCode") == null) {
			rand = "";
		} else {
			rand = session.getAttribute("randCheckCode").toString();
		}
		if (!randcode.equals(rand)) {
			returnMap.put("ret", "err_rand");
			returnMap.put("info", "验证码错误！");
			return returnMap;
		}

		String passwordMark = "w5y1j5z1s1l1z6z0y8z1m1l0c5r5y3z4";
		passwordMark = passwordMark + user.getPwd();

		TUser userBean = new TUser();
		userBean.setLoginName(user.getLoginName());
		userBean.setStatus("00");
		userBean.setPwd(MD5Util.MD5(passwordMark));
		TUser DbUser = userService.getLoginUser(userBean);

		boolean loginFlag = false;
		if (DbUser != null) {
			if (DbUser.getLoginName().equals(user.getLoginName())
					&& DbUser.getPwd().equals(MD5Util.MD5(passwordMark))) {
				returnMap.put("ret", "success");
			} else {
				loginFlag = true;
			}
		} else {
			loginFlag = true;
		}
		if (loginFlag) {
			returnMap.put("ret", "err_user");
			returnMap.put("info", "用户名或密码错误！");
		} else {
			// 同一个账号二次登录第一次登录将被踢下线
			LoginUser loginUser = new LoginUser();
			loginUser.setSessionId(session.getId());
			loginUser.setUser(DbUser);

			LoginUser sessLoginUser = (LoginUser) session
					.getAttribute("LOGIN_USER");

			if (sessLoginUser == null) {
				session.setAttribute("LOGIN_USER", loginUser);
				Map<String, Object> applicaMap = (Map<String, Object>) sc
						.getAttribute("LOGIN_INFO");

				if (applicaMap == null) {
					Map<String, HttpSession> hashMap = new HashMap<String, HttpSession>();
					hashMap.put(DbUser.getLoginName(), session);
					sc.setAttribute("LOGIN_INFO", hashMap);
				} else {
					HttpSession appSession = (HttpSession) applicaMap
							.get(DbUser.getLoginName());
					if (appSession == null) {
						applicaMap.put(DbUser.getLoginName(), session);
						sc.setAttribute("LOGIN_INFO", applicaMap);
					}
					if (appSession != null
							&& appSession.getId() != loginUser.getSessionId()) {
						appSession.removeAttribute("LOGIN_USER");

						// session.setAttribute("LOGIN_USER", loginUser);
						applicaMap.remove(DbUser.getLoginName());
						// 加入不同用户的sessionID
						applicaMap.put(DbUser.getLoginName(), session);
						sc.setAttribute("LOGIN_INFO", applicaMap);
					}

				}

			} else {
				returnMap.put("ret", "err_user");
				returnMap.put("info", "请先退出之前的登录");
			}

		}
		return returnMap;
	}

	/**
	 * 操作栏
	 */
	@ResponseBody
	@RequestMapping("/querymenu")
	public ModelAndView querymenu() throws Exception {
		ModelAndView result = new ModelAndView("/index");
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute(
				"LOGIN_USER");
		if (loginUser.getUser().getLoginName().equals("admin")) {
			funlist = functionService.findFunction();
		} else {
			funlist = functionService.findLoginFuntion(loginUser.getUser());
		}
		session.put("Authority", funlist);
		Integer pwdFlag = checkPWDDate(request);
		pwdDay = calcExpirationDay(request);

		result.addObject("loginName", loginUser.getUser().getLoginName());
		result.addObject("funlist", funlist);
		result.addObject("pwdDay", pwdDay);
		result.addObject("pwdFlag", pwdFlag);

		return result;
	}

	/**
	 * 检查密码有效期
	 * 
	 * @throws ParseException
	 */
	private Integer checkPWDDate(HttpServletRequest request)
			throws ParseException {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute(
				"LOGIN_USER");
		pwdFlag = 0;
		String pwdTime = sdf.format(loginUser.getUser().getPwdValid());
		if (isNull(pwdTime)) {
			pwdFlag = 1;
		} else {
			long time = loginUser.getUser().getPwdValid().getTime();// 密码有效期
			long currentTime = new Date().getTime();// 当前时间
			if (currentTime > time) {
				pwdFlag = 1;
			}
		}
		return pwdFlag;
	}

	/**
	 * 计算时间间隔
	 * 
	 * @return
	 * @throws ParseException
	 */
	private int calcExpirationDay(HttpServletRequest request)
			throws ParseException {
		LoginUser loginUser = (LoginUser) request.getSession().getAttribute(
				"LOGIN_USER");
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(new Date());
		Calendar cal2 = Calendar.getInstance();
		if (isNull(loginUser.getUser().getPwdValid())) {
			cal2.setTime(new Date());
		} else {
			cal2.setTime(loginUser.getUser().getPwdValid());
			// cal2.setTime(sdf.parse(loginUser.getPwdValid()));
		}
		long l = cal2.getTimeInMillis() - cal1.getTimeInMillis();
		int days = new Long(l / (1000 * 60 * 60 * 24)).intValue();
		return days;
	}

	/**
	 * 用户登出
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, String userId) {

		ModelAndView result = new ModelAndView("/login");
		// HttpSession session = request.getSession(true);
		TUser tUser = userService.getSingleById(Integer.parseInt(userId));
		Map<String, HttpSession> applicaMap = (Map<String, HttpSession>) sc
				.getAttribute("LOGIN_INFO");
		HttpSession appSession = (HttpSession) applicaMap.get(tUser
				.getLoginName());

		if (!isNull(appSession.getAttribute("LOGIN_USER"))) {
			appSession.removeAttribute("LOGIN_USER");
		}
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("user.cookie")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return result;
	}

	/**
	 * 生成图片验证码
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/validateCode")
	public void validateCode(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 禁止缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("Expires", 0);
		// 指定生成的响应是图片
		response.setContentType("image/jpeg");
		int width = 65, height = 40;
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 获取图形上下文
		Graphics g = image.getGraphics();
		// 生成随机类
		Random random = new Random();
		// 设定背景色
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		// 设定字体
		g.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
		g.setColor(getRandColor(160, 200));
		for (int i = 0; i < 155; i++) {
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 取随机产生的认证码(4位数字)
		String sRand = "";
		for (int i = 0; i < 4; i++) {
			String rand = String.valueOf(random.nextInt(10));
			sRand += rand;
			// 将认证码显示到图象中
			g.setColor(new Color(20 + random.nextInt(110), 20 + random
					.nextInt(110), 20 + random.nextInt(110)));
			// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
			g.drawString(rand, 13 * i + 6, 26);
		}
		// 将认证码存入SESSION
		// 将生成的验证码保存到Session中
		HttpSession session = request.getSession(true);
		session.setAttribute("randCheckCode", sRand);
		// ActionContext.getContext().getSession().put("rand",sRand);
		// 图象生效
		g.dispose();
		ImageIO.write(image, "JPEG", response.getOutputStream());
	}

	/*
	 * 给定范围获得随机颜色
	 */
	private Color getRandColor(int fc, int bc) {
		Random random = new Random();
		if (fc > 255)
			fc = 255;
		if (bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}

	// 判断value是否为空
	public boolean isNull(Object value) {
		if (value == null || value.toString().equals("")) {
			return true;
		} else {
			return false;
		}

	}

	// 得到cookie
	public String getCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (CookieUtils.USER_COOKIE.equals(cookie.getName())) {
					String value = cookie.getValue();
					if (StringUtils.isNotBlank(value)) {
						String[] split = value.split(",");
						// String clientIp = split[0];
						String count = split[0];
						return count;
					}
				}
			}
		}
		return null;
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("http_client_ip");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		// 如果是多级代理，那么取第一个ip为客户ip
		if (ip != null && ip.indexOf(",") != -1) {
			ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
		}
		return ip;
	}
	
	
	 /**
	  * 检测用户是否登陆
	  * @param session
	  * @param account
	  * @return
	  */
	 public boolean checkLogin(HttpSession session,String account){
		 
		 return true;
	 }
	
	
}
