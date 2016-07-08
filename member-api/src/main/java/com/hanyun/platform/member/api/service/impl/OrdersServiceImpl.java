package com.hanyun.platform.member.api.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hanyun.platform.member.api.dao.OrdersDao;
import com.hanyun.platform.member.api.domain.Orders;
import com.hanyun.platform.member.api.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;

	@Override
	public void addOrders(Orders orders) {
		ordersDao.insert(orders);
	}

	@Override
	public void addOrdersSelective(Orders orders) {
		ordersDao.insertSelective(orders);		
	}

	@Override
	public Orders getById(Long id) {
		return ordersDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Orders> getByUserId(String userId, String brandId, Integer offset,
			Integer pageSize) {
		return ordersDao.selectByUserId(userId, brandId, offset, pageSize);
	}

	@Override
	public int updateByIdSelective(Orders orders) {
		return ordersDao.updateByPrimaryKeySelective(orders);
	}

	@Override
	public Long getUserCount(String userId, String brandId) {
		return ordersDao.selectUserCount(userId, brandId);
	}

	@Override
	public Long getConsumTimes(String brandId, String userId, Date startTime,
			Date endTime) {
		return ordersDao.selectConsumTimes(brandId, userId, startTime, endTime);
	}

	@Override
	public Long getBrandConsumTimes(String brandId, Date startTime, Date endTime) {
		return ordersDao.selectBrandConsumTimes(brandId, startTime, endTime);
	}

	@Override
	public Long getConsumSum(String brandId, String userId, Date startTime,
			Date endTime) {
		return ordersDao.selectConsumSum(brandId, userId, startTime, endTime);
	}

	@Override
	public Long getBrandConsumSum(String brandId, Date startTime, Date endTime) {
		return ordersDao.selectBrandConsumSum(brandId, startTime, endTime);
	}

	@Override
	public List<Map<String, Object>> getStatistics(String brandId) {
		return ordersDao.selectStatistics(brandId);
	}

	
}
