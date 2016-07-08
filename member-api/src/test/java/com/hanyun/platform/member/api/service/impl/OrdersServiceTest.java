package com.hanyun.platform.member.api.service.impl;

import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
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
import com.hanyun.platform.member.api.domain.BrandMember;
import com.hanyun.platform.member.api.domain.Orders;
import com.hanyun.platform.member.api.service.BrandMemberService;
import com.hanyun.platform.member.api.service.OrdersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-config.xml"})
public class OrdersServiceTest {
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private BrandMemberService brandMemberService;
	
	@Before
	public void before(){
		System.out.println("before!!");
	}
	
	@Test
	public void testAddOrders(){
		
		/*for (int i = 912; i < 1465; i++) {
			BrandMember member = brandMemberService.getById(Long.valueOf(i));
			int jend = new Random().nextInt(20);
			for (int j = 0; j < jend; j++) {
				Orders orders = new Orders();
				orders.setActivityId("acc11" + j);
				orders.setActivityName("acc11N");
				orders.setActualPrice(Long.valueOf(new Random().nextInt(900)));
				orders.setBrandId(member.getBrandId());
				orders.setOrderId("xxxxxxxxx"+ j + i);
				orders.setOrderPrice(Long.valueOf(new Random().nextInt(1000)));
				orders.setOrderStatus("成功");
				orders.setOrderType("零售服务");
				orders.setPayId("pppppppp"+i+j);
				orders.setPayStatus("支付成功");
				orders.setPayType("支付宝支付");
				orders.setStoreId("001");
				orders.setUserId(member.getUserId());
				orders.setCreateTime(new Date());
				orders.setUpdateTime(new Date());
//				ordersService.addOrders(orders);
				ordersService.addOrdersSelective(orders);
			}
			
		}*/
		Orders orders = new Orders();
		orders.setOrderCheckSrc(0);
		orders.setActivityId("acc11");
		orders.setActivityName("acc11N");
		orders.setActualPrice(Long.valueOf(new Random().nextInt(900)));
		orders.setBrandId("wdfvbnklrgb89");
		orders.setOrderId("xxxxxxxxx");
		orders.setOrderPrice(Long.valueOf(new Random().nextInt(1000)));
		orders.setOrderStatus("成功");
		orders.setOrderType("零售服务");
		orders.setPayId("pppppppp");
		orders.setPayStatus("支付成功");
		orders.setPayType("支付宝支付");
		orders.setStoreId("001");
		orders.setUserId("uuuuefghm,.pokjb");
		orders.setCreateTime(new Date());
		orders.setUpdateTime(new Date());
//				ordersService.addOrders(orders);
		ordersService.addOrdersSelective(orders);
	}
	
	@Test
	public void testGetById() throws IOException{}
	@Test
	public void testGetByUserId() throws IOException{}
	@Test
	public void testGetStatistics() throws IOException{}
	
	@Test
	public void testUpdateByIdSelectivee(){}
	
	@Test
	public void testGetCount(){}
	
	@Test
	public void testGetByPage() throws IOException{}
	
	@After
	public void after(){
		System.out.println("after!!");
	}

}
