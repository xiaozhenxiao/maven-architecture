package com.hanyun.platform.member.api.service.impl;

import java.io.IOException;
import java.util.List;
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
import com.hanyun.platform.member.api.domain.BrandMemberType;
import com.hanyun.platform.member.api.service.BrandMemberTypeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class BrandMemberTypeServiceTest {
	@Autowired
	private BrandMemberTypeService brandMemberTypeService;
	
	@Before
	public void before(){
		System.out.println("before!!");
	}
	
	@Test
	public void testAddBrandMemberType(){
		for (int i = 0; i < 5; i++) {
			BrandMemberType memberType = new BrandMemberType();
			memberType.setBrandId("b00a4561-a72e-4db3-8d2d-83020f676e0d");
			memberType.setName("普通会员");
			memberType.setTypeId(UUID.randomUUID().toString());
//			brandMemberTypeService.addBrandMemberType(memberType);
			brandMemberTypeService.addBrandMemberTypeSelective(memberType);
		} 
	}
	
	@Test
	public void testGetById() throws IOException{
		System.out.println(JsonUtil.toJson(brandMemberTypeService.getById(1l)));
	}
	@Test
	public void testGetByBrandId() throws IOException{
		List<BrandMemberType> types = brandMemberTypeService.getByBrandId("b00a4561-a72e-4db3-8d2d-83020f676e0d");
		if(CollectionUtils.isNotEmpty(types)){
			for (BrandMemberType type : types) {
				System.out.println(JsonUtil.toJson(type));
			}
		}
	}
	
	@Test
	public void testUpdateByIdSelective(){
		BrandMemberType memberType = new BrandMemberType();
		memberType.setId(1l);
		memberType.setName("普通会员");
		brandMemberTypeService.updateByIdSelective(memberType);
	}
	
	@Test
	public void testGetCount(){
		System.out.println(brandMemberTypeService.getCount());
	}
	
	@After
	public void after(){
		System.out.println("after!!");
	}

}
