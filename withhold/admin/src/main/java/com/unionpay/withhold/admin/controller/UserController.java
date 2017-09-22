package com.unionpay.withhold.admin.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;





import org.springframework.web.servlet.ModelAndView;

import com.unionpay.withhold.admin.Bean.PageBean;
import com.unionpay.withhold.admin.pojo.TFunction;
import com.unionpay.withhold.admin.pojo.TRole;
import com.unionpay.withhold.admin.pojo.TRoleFunct;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserFunct;
import com.unionpay.withhold.admin.pojo.TUserRole;
import com.unionpay.withhold.admin.service.FunctionService;
import com.unionpay.withhold.admin.service.RoleFunctService;
import com.unionpay.withhold.admin.service.RoleService;
import com.unionpay.withhold.admin.service.UserFunctService;
import com.unionpay.withhold.admin.service.UserRoleService;
import com.unionpay.withhold.admin.service.UserService;
import com.unionpay.withhold.admin.utils.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserRoleService  userRoleService;
	@Autowired
	private FunctionService functionService;
	@Autowired
	private UserFunctService userFunctService;
	@Autowired
	private RoleFunctService roleFunctService;
	@ResponseBody
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView result=new ModelAndView("/system/user/user_manager");
        return result;
    }
	/**
	 * 显示所有角色
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/showRoles")
	public List<?> showRole(String status){
		 List<TRole> allRole = roleService.findByProperty("00");
		
		return allRole;
	}
	
	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/update")
	public List<?> update(HttpServletRequest request,TUser user) {
		TUser loginUser = (TUser) request.getSession().getAttribute("LOGIN_USER");
		user.setCreator(loginUser.getLoginName());
		ArrayList<String> list = new ArrayList<String>();
		try {
			userService.updateUser(user);
			list.add("更新成功");
		} catch (Exception e) {
			list.add("更新失败");
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/query")
	public PageBean query(TUser user,String roleId,int page,int rows){
		
		PageBean resultBean = userService.findUserByPage(user,roleId,page, rows);
		
		return resultBean;
		
	}
	/**
	 * 通过ID查询用户信息
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/getSingleById")
	public TUser getSingleById(Long userId) {
		TUser user = userService.getSingleById(userId);
		return user;
	}
	/**
	 * 新增用户信息
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/save")
	public List<?> save(HttpServletRequest request,TUser user) {
		ArrayList<String> list = new ArrayList<String>();
		TUser loginUser = (TUser) request.getSession().getAttribute("LOGIN_USER");
		user.setCreator(loginUser.getLoginName());
		String passwordMark = "w5y1j5z1s1l1z6z0y8z1m1l0c5r5y3z4";
		passwordMark = passwordMark + "123456";
		user.setPwd(MD5Util.MD5(passwordMark));
		user.setCreateDate(new Date());
		user.setPwdValid(new Date());
		user.setStatus("00");
		
		try {
			userService.saveUser(user);
			list.add("保存成功");
		} catch (Exception e) {
			list.add("保存失败");
			e.printStackTrace();
		}
		
		return list;
	}
	/**
	 * 注销用户
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/delete")
    public String delete(HttpServletRequest request,Long userId) {	    
	    TUser user = userService.getSingleById(userId);
	    user.setStatus("01");
	    try {
			userService.updateUser(user);
			return "true";
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	   
		return "false";
	}

	
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
	
	
	
	/**
	 * 加载所有角色
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryRoleAllList")
	public List<?> queryRoleAllList() {
		return roleService.findByProperty("00");
	}

	/**
	 * 加载用户已经有的角色
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryRoleListhave")
	public List<?> queryRoleListhave(Long userId) {
		List<TRole> rolelist = (List<TRole>) roleService.findAllRole();
		List<TUserRole> rolefunctList = (List<TUserRole>) userRoleService.findByProperty(userId);
		
		List<TRole> haverolelist = new ArrayList<TRole>();
		for (TRole roleMl : rolelist) {
			for (TUserRole rfctml : rolefunctList) {
				if ((roleMl.getRoleId()).equals(rfctml.getRoleId())) {
					haverolelist.add(roleMl);
				}
			}
		}
		return haverolelist;

	}
	/**
	 * 保存用户角色
	 * 
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/SaveUserRole")
	public String SaveUserRole(String userFunc,Long userId) {
		userRoleService.deleteOldUserRole(userId);
		if(userFunc != null && !userFunc.equals("")){
			String[] roleId = userFunc.split(",");
			List<TUserRole> userRoleList = new ArrayList<TUserRole>();
			//Long num = 1L;
			for (int i = 0; i < roleId.length; i++) {
				TUserRole model = new TUserRole();
				//model.setUserRoleId(num);
				model.setUserId(userId);
				model.setRoleId(Long.valueOf(roleId[i]));
				userRoleList.add(model);
				//num++;
			}
			userRoleService.save(userRoleList);
			return "true";
		}
		return "false";
	}
	
	/**
	 * 加载用户已经有的权限
	 * 
	 * @return
	 */
	@ResponseBody
   @RequestMapping("/queryFunction")
	public Map<String, Object> queryFunction(HttpServletRequest request,Long userId) {
		
		List<TRoleFunct> roleFucList = new ArrayList<TRoleFunct>();
		TUser user = (TUser) request.getSession().getAttribute("LOGIN_USER");
		//得到所有菜单
		List<TFunction> list = (List<TFunction>) functionService.findFunction();

		List<TUserRole> allRoleList =userRoleService.findByProperty(userId);
		
		//得到要操作的用户的所有角色的Id
		List<Long> roleIdlist = new ArrayList<Long>();
		for (TUserRole role : allRoleList) {
			roleIdlist.add(role.getRoleId());
		}
		
		if (roleIdlist!=null&&roleIdlist.size() > 0) {
			//得到角色-菜单中间表
				roleFucList = roleFunctService.findRoleFunctByRoleIds(roleIdlist);
		}
		//得到要操作的用户的用户-菜单表
		List<TUserFunct> userFunctList = userFunctService.findByProperty(userId);
		List<TFunction> removeList = new ArrayList<TFunction>();
		List<TFunction> children = new ArrayList<TFunction>();
		for (TFunction function : list) {
			if ("0".equals(function.getParentId())) {// 根节点
				if (children != null) {
					children = null;
				}
				function.setChildren(new ArrayList<TFunction>());
				children = function.getChildren();
				function.setState("closed");
			} else {// 子节点
				for (TRoleFunct roleFunct : roleFucList) {
					if (roleFunct.getFunctId().equals(function.getFunctId())) {
						function.setChecked("true");
						function.setText("<span style='color:blue'>" + function.getFunctName() + "</span>");
						//function.setId(function.getFunctId().toString());
					}
				}
				for (TUserFunct userFunct : userFunctList) {
					if (userFunct.getFunctId().equals(function.getFunctId())) {
						function.setChecked("true");
					}
				}
				children.add(function);
				removeList.add(function);
			}
			function.setId(function.getFunctId().toString());
			if(function.getText() == null || function.getText().toString().equals("")){
				function.setText(function.getFunctName());
				//function.setId(function.getFunctId().toString());
			}
		}
		list.removeAll(removeList);// 移除全部的子节点数据

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", list);
		result.put("roleFunction", roleFucList);
		return result;
	}

	/**
	 * 保存用户权限
	 * 
	 * @return
	 */
	@ResponseBody
   @RequestMapping("/saveAuth")
	public String saveAuth(String userFunc,Long userId) {
		userFunctService.deleteOldFunc(userId);
		if(userFunc != null &&!userFunc.equals("")){
			String[] funcId = userFunc.split(",");
			List<TUserFunct> functList = new ArrayList<TUserFunct>();
			Long num = 1L;
			for (int i = 0; i < funcId.length; i++) {
				TUserFunct model = new TUserFunct();
				//model.setUserFunctId(num);
				model.setUserId(userId);
				model.setFunctId(Long.valueOf(funcId[i]));
				functList.add(model);
				num++;
			}
			userFunctService.save(functList);
			return "true";
		}
		return "false";
	}
}
