package com.hanyun.platform.member.api.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hanyun.platform.member.api.domain.Orders;

public interface OrdersService {
	void addOrders(Orders orders);

	void addOrdersSelective(Orders orders);

	Orders getById(Long id);
	
	List<Orders> getByUserId(String userId, String brandId, Integer offset, Integer pageSize);

	int updateByIdSelective(Orders orders);

	Long getUserCount(String userId,String brandId);

	Long getConsumTimes(String brandId, String userId, Date startTime,
			Date endTime);

	Long getBrandConsumTimes(String brandId, Date startTime, Date endTime);

	Long getConsumSum(String brandId, String userId, Date startTime,
			Date endTime);

	Long getBrandConsumSum(String brandId, Date startTime, Date endTime);

	List<Map<String, Object>> getStatistics(String brandId);
}
