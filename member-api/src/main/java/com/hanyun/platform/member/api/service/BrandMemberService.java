package com.hanyun.platform.member.api.service;

import java.util.List;

import com.hanyun.platform.member.api.domain.BrandMember;

public interface BrandMemberService {
	void addBrandMember(BrandMember member);

	void addBrandMemberSelective(BrandMember member);

	BrandMember getById(Long id);

	List<BrandMember> getByUserId(String userId);

	int updateByIdSelective(BrandMember member);

	int updateByUserIdSelective(BrandMember member);
	
	int updateStatusById(Long id, Integer status);

	Long getCount(String brandId);

	List<BrandMember> getMemberOfBrandByPage(String brandId, String source,
			Integer start, Integer size);

	BrandMember getMember(String brandId, String userId);

	Long getSourceCount(String brandId, String source);
}
