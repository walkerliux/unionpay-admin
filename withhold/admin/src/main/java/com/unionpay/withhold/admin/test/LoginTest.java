package com.unionpay.withhold.admin.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.unionpay.withhold.admin.mapper.TUserMapper;
import com.unionpay.withhold.admin.pojo.TUser;
import com.unionpay.withhold.admin.pojo.TUserExample;
import com.unionpay.withhold.admin.pojo.TUserExample.Criteria;
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/spring.xml")
public class LoginTest {
	@Autowired
	private TUserMapper tUserMapper;
	@Test
	public void login(){
		TUserExample example = new TUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserNameEqualTo("002");
		List<TUser> users = tUserMapper.selectByExample(example);
		TUser tUser = users.get(0);
		System.out.println(tUser.getPwd());
		
		
	}

}
