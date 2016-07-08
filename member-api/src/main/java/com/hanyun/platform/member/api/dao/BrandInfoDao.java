package com.hanyun.platform.member.api.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hanyun.platform.member.api.domain.BrandInfo;

@Repository
public interface BrandInfoDao {
	void insert(BrandInfo brand);
	void insertSelective(BrandInfo brand);
	BrandInfo selectByPrimaryKey(BrandInfo brand);
	BrandInfo selectByBrandId(String id);
	void updateByPrimaryKeySelective(BrandInfo brand);
	void deleteByPrimaryKey(BrandInfo brand);
	Long selectCount();
	List<BrandInfo> selectByPage(Map<String, Object> map);
}
