package com.hanyun.platform.member.api.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hanyun.platform.member.api.domain.BrandMember;

@Repository
public interface BrandMemberDao {
	void insert(BrandMember member);

	void insertSelective(BrandMember member);

	BrandMember selectById(Long id);

	List<BrandMember> selectByUserId(String userId);

	int updateByIdSelective(BrandMember member);

	int updateByUserIdSelective(BrandMember member);
	
	int updateStatusById(@Param("id")Long id, @Param("status")Integer status);

	Long selectSourceCount(@Param("brandId")String brandId, @Param("source")String source);
	
	Long selectCount(String brandId);

	List<BrandMember> selectMemberOfBrandByPage(Map<String, Object> map);

	List<BrandMember> selectMember(Map<String, Object> map);
}
