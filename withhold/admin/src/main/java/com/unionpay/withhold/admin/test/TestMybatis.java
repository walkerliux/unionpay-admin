package com.unionpay.withhold.admin.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.unionpay.withhold.admin.mapper.TBankMapper;
import com.unionpay.withhold.admin.pojo.TBank;
import com.unionpay.withhold.admin.pojo.TBankExample;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("/spring.xml")
public class TestMybatis {
	@Autowired
	private TBankMapper tBankMapper;
	@Autowired

	@Test
	public void testQueryBank(){
		TBankExample example = new TBankExample();
		TBankExample.Criteria criteria = example.createCriteria();
		criteria.andTidEqualTo("1");
		List<TBank> list = tBankMapper.selectByExample(example);
		System.out.println(list);
		/*TBank tBank = tBankMapper.selectByTid("1");
		System.out.println(tBank);*/
	} 
	
	
}
