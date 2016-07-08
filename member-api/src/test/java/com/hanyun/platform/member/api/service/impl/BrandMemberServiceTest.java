package com.hanyun.platform.member.api.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hanyun.platform.ground.util.json.JsonUtil;
import com.hanyun.platform.member.api.domain.BrandInfo;
import com.hanyun.platform.member.api.domain.BrandMember;
import com.hanyun.platform.member.api.domain.UserInfo;
import com.hanyun.platform.member.api.service.BrandInfoService;
import com.hanyun.platform.member.api.service.BrandMemberService;
import com.hanyun.platform.member.api.service.UserInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class BrandMemberServiceTest {
	@Autowired
	private BrandMemberService brandMemberService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private BrandInfoService brandInfoService;
	
	@Before
	public void before(){
		System.out.println("before!!");
	}
	
	@Test
	public void testAddBrandMember(){
		List<UserInfo> users = userInfoService.getUsers();
		int j = 0;	
		if (CollectionUtils.isNotEmpty(users)) {
			int i = 0;
				for (UserInfo userInfo : users) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("brandType", "餐饮");
					map.put("columnName", "id");
					map.put("orderType", "asc");
					map.put("offset", j>55?55:j);
					map.put("pageSize", new Random().nextInt(20));
					List<BrandInfo> brandInfos = brandInfoService.getBrandByPage(map);
					int size = brandInfos.size();
					if (CollectionUtils.isNotEmpty(brandInfos)) {
						System.out.println(++i + " --- " + size);
						for (BrandInfo brandInfo : brandInfos) {
							BrandMember member = new BrandMember();
							member.setUserId(userInfo.getUserId());
							member.setBrandId(brandInfo.getBrandId());
							member.setMemberId(UUID.randomUUID().toString());
							member.setTypeId(UUID.randomUUID().toString());
							member.setStatus(0);
							member.setLevel("一级会员");
							member.setExpiry("2017-12-12");
							member.setTotalPrice(new Random().nextInt(2000));
							member.setServiceCount(new Random().nextInt(20));
							member.setLastServiceTime(new Date());
							member.setServiceAvgDay("20");
							member.setSourceStoreId("xxxxxxxxx");
							member.setSourceStoreName("nnnnnnnnn");
							member.setCreateTime(new Date());
							member.setUpdateTime(new Date());
							brandMemberService.addBrandMemberSelective(member);
						}
					}
					j++;
//						brandMemberService.addBrandMember(member);
				}
			}
		
	}
	
	@Test
	public void testGetById() throws IOException{
		BrandMember member = brandMemberService.getById(18l);
		System.out.println(JsonUtil.toJson(member));
	}
	
	@Test
	public void testUpdateByIdSelectivee(){
		BrandMember member = new BrandMember();
		member.setId(149l);
		member.setLevel("特级会员");
		brandMemberService.updateByIdSelective(member);
	}
	
	@Test
	public void testGetCount(){
		System.out.println("count: " + brandMemberService.getCount("c276c1bb-6add-44eb-86e5-10ef87aff312"));
	}
	
	@Test
	public void testGetMemberOfBrandByPage() throws IOException{
		List<BrandMember> members = brandMemberService.getMemberOfBrandByPage("c276c1bb-6add-44eb-86e5-10ef87aff312","xxxxxxxxx", 0, 10);
		if(CollectionUtils.isNotEmpty(members)){
			for (BrandMember member : members) {
				System.out.println(JsonUtil.toJson(member));
			}
		}
	}
	@Test
	public void testGetMember() throws IOException{
		BrandMember member = brandMemberService.getMember("c276c1bb-6add-44eb-86e5-10ef87aff312","760c1519-c3d8-4fb6-88bf-622c61a2a09d");
		System.out.println(JsonUtil.toJson(member));
	}
	@Test
	public void testUpdateStatusById() throws IOException{
		int member = brandMemberService.updateStatusById(149l,1);
		System.out.println(JsonUtil.toJson(member));
	}
	
	@After
	public void after(){
		System.out.println("after!!");
	}

}
