package com.hanyun.platform.member.api.service;

import java.util.List;
import com.hanyun.platform.member.api.domain.BrandMemberType;

public interface BrandMemberTypeService {
	void addBrandMemberType(BrandMemberType memberType);
	void addBrandMemberTypeSelective(BrandMemberType memberType);
	BrandMemberType getById(Long id);
	List<BrandMemberType> getByBrandId(String brandId);
	int updateByIdSelective(BrandMemberType record);
	Long getCount();

}
