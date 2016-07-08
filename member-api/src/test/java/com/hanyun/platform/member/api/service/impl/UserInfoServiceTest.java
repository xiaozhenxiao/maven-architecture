package com.hanyun.platform.member.api.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanyun.platform.ground.util.json.JsonUtil;
import com.hanyun.platform.member.api.domain.UserInfo;
import com.hanyun.platform.member.api.service.UserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class UserInfoServiceTest {
	@Autowired
	private UserInfoService userInfoService;
	
	@Before
	public void before(){
		System.out.println("before!!");
	}
	
	@Test
	public void testAddUserInfo(){
		for (int i = 0; i < 100; i++) {
			UserInfo user = new UserInfo();
			user.setUserId(UUID.randomUUID().toString());
			user.setName("老八"+i);
			user.setPhone("1958555579"+i);
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			userInfoService.addUserInfo(user);
		}
		
//		userInfoService.addUserInfoSelective(user);
	}

	@Test
	public void testGetByPhone(){
		UserInfo userInfo = userInfoService.getByPhone("19585555791");
		try {
			System.out.println(JsonUtil.toJson(userInfo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testGetByUserId(){
		UserInfo userInfo = userInfoService.getByUserId("dad6b6e2-6b54-45a9-a46e-23424f31a161");
		try {
			System.out.println(JsonUtil.toJson(userInfo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testUpdateByIdSelective(){
		UserInfo user = new UserInfo();
		user.setId(3l);
		user.setPhone("18888888888");
		userInfoService.updateByIdSelective(user);
	}
	@Test
	public void testGetByIdAndNameAndPhone() throws IOException {
		Long memberId = null;//1l;
		String name = "老";
		String phone = null;//"1858985678";
//		String startTime = "2016-06-21 20:15:49";
		String startTime = null;
		String endTime = null;
//		String endTime = "2016-06-23 20:15:49";
		List<UserInfo> users = userInfoService.getByIdAndNameAndPhone(memberId, name,
				phone, startTime, endTime,0,10);
		System.out.println(JsonUtil.toJson(users));
	}
	
	@After
	public void after(){
		System.out.println("after!!");
	}

}
