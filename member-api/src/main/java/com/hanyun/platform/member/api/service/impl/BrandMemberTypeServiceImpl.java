package com.hanyun.platform.member.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanyun.platform.member.api.dao.BrandMemberTypeDao;
import com.hanyun.platform.member.api.domain.BrandMemberType;
import com.hanyun.platform.member.api.service.BrandMemberTypeService;

@Service
public class BrandMemberTypeServiceImpl implements BrandMemberTypeService {

	@Autowired
	private BrandMemberTypeDao brandMemberTypeDao;
	
	@Override
	public void addBrandMemberType(BrandMemberType memberType) {
		brandMemberTypeDao.insert(memberType);
	}

	@Override
	public void addBrandMemberTypeSelective(BrandMemberType memberType) {
		brandMemberTypeDao.insertSelective(memberType);
	}

	@Override
	public BrandMemberType getById(Long id) {
		return brandMemberTypeDao.selectById(id);
	}

	@Override
	public List<BrandMemberType> getByBrandId(String brandId) {
		return brandMemberTypeDao.selectByBrandId(brandId);
	}

	@Override
	public int updateByIdSelective(BrandMemberType record) {
		return brandMemberTypeDao.updateByIdSelective(record);
	}

	@Override
	public Long getCount() {
		return brandMemberTypeDao.selectCount();
	}

}
