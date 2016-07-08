package com.hanyun.platform.member.api.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanyun.platform.member.api.dao.BrandInfoDao;
import com.hanyun.platform.member.api.domain.BrandInfo;
import com.hanyun.platform.member.api.service.BrandInfoService;
@Service
public class BrandInfoServiceImpl implements BrandInfoService{

	@Autowired
	private BrandInfoDao brandInfoDao;
	
	@Override
	public void addBrandInfo(BrandInfo brand) {
		brandInfoDao.insert(brand);
	}

	@Override
	public void addBrandInfoSelective(BrandInfo brand) {
		brandInfoDao.insertSelective(brand);
	}

	@Override
	public BrandInfo selectByBrandId(String id) {
		return brandInfoDao.selectByBrandId(id);
	}

	@Override
	public void updateByPrimaryKeySelective(BrandInfo brand) {
		brandInfoDao.updateByPrimaryKeySelective(brand);
	}

	@Override
	public Long getCount() {
		return brandInfoDao.selectCount();
	}

	@Override
	public List<BrandInfo> getBrandByPage(Map<String, Object> map) {
		return brandInfoDao.selectByPage(map);
	}

}
