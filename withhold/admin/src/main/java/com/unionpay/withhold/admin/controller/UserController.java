package com.unionpay.withhold.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;





import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	
	
	/**
	 * 重置密码
	 * 
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody
    @RequestMapping("/changePassword")
	public String changePassword(HttpSession session,String newPwd) throws ParseException {
		TUser sessionUser = (TUser) session.getAttribute("LOGIN_USER");
		TUser dbUser = userService.getSingleById(sessionUser.getUserId());
		String passwordMark = "w5y1j5z1s1l1z6z0y8z1m1l0c5r5y3z4";
		passwordMark = passwordMark + newPwd;
		dbUser.setPwd(MD5Util.MD5(passwordMark));
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +30);//
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
		String pwdVal = format.format(cal.getTime().getTime());
//		user.setPwdValid(new Date());// 密码重置有效期更新为当前时间，登录后会强制修改密码
//		user.setPwdValid(new Timestamp(new Date().getTime()));// 密码重置有效期更新为当前时间，登录后会强制修改密码
		Date date = format.parse(pwdVal);
		Map<String,String> jsonMap=new HashMap<>();
		try {
			userService.resetPwd(dbUser, date);
			jsonMap.put("retcode", "succ");
			jsonMap.put("retinfo", "修改成功");
		} catch (Exception e) {
			jsonMap.put("retinfo", "修改失败");
			e.printStackTrace();
		}
		JSONObject jsonObject = JSONObject.fromObject(jsonMap);
		
        //3、将json对象转化为json字符串
        String result = jsonObject.toString();
		System.out.println(result);
		return result;
	}
}
