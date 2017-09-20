package com.unionpay.withhold.admin.test;



import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;


import com.unionpay.withhold.admin.mapper.TUserMapper;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserExample;
import com.unionpay.withhold.admin.pojo.TUserExample.Criteria;
import com.unionpay.withhold.admin.utils.MD5Util;

public class LoginTest {
	@Autowired
	private TUserMapper tUserMapper;
	@Test
	public void login(){
		/*TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo("002");
		List<TUser> users = tUserMapper.selectByExample(example);
		TUser tUser = users.get(0);
		System.out.println(tUser.getPwd());*/
		String md5 = MD5Util.MD5("123456");
		System.out.println(md5);
		
	}

}
