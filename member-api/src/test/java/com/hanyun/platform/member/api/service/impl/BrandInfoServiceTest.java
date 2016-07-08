package com.hanyun.platform.member.api.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.hanyun.platform.member.api.service.BrandInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class BrandInfoServiceTest {
	@Autowired
	private BrandInfoService brandInfoService;
	
	@Before
	public void before(){
		System.out.println("before!!");
	}
	
	@Test
	public void testAddBrandInfo(){
		for (int i = 0; i < 56; i++) {
			BrandInfo brand = new BrandInfo();
			brand.setBrandId(UUID.randomUUID().toString());
			brand.setBrandName("品牌" + i);
			brand.setBrandType("餐饮");
			brand.setBankAccount("brankAccount");
			brand.setBrandTypeId("typeId");
			brand.setCompanyName("companyName");
			brand.setDepositBank("depositBank");
			brand.setCreateTime(new Date());
			brand.setUpdateTime(new Date());
			brand.setBankId("BankId");
			brand.setBankName("BankName");
			brand.setIndustryId("eeeeeeeeeeee");
			brand.setIndustryName("nnnnnnnnn");
			brandInfoService.addBrandInfo(brand);
//			brandInfoService.addBrandInfoSelective(brand);
		} 
	}
	
	@Test
	public void testSelectByBrandId(){
		BrandInfo brandInfo = brandInfoService.selectByBrandId("ae51a056-3a67-4faf-94f2-997597e5b374");
		try {
			System.out.println(JsonUtil.toJson(brandInfo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testupdateByPrimaryKeySelective(){
		BrandInfo brand = new BrandInfo();
		brand.setId(1l);
		brand.setBrandName("全盛");
		brandInfoService.updateByPrimaryKeySelective(brand);
	}
	
	@Test
	public void testSelectCount(){
		System.out.println(brandInfoService.getCount());
	}
	
	@Test
	public void testgetBrandByPage() throws IOException{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandType", "餐饮");
		map.put("columnName", "id");
		map.put("orderType", "asc");
		map.put("offset", 10);
		map.put("pageSize", 10);
		List<BrandInfo> brands = brandInfoService.getBrandByPage(map);
		int i = 0;
		if(CollectionUtils.isNotEmpty(brands)){
			for (BrandInfo brand : brands) {
				System.out.println(++i + " : ");
				System.out.println(JsonUtil.toJson(brand));
			}
		}
	}
	
	@After
	public void after(){
		System.out.println("after!!");
	}

}
