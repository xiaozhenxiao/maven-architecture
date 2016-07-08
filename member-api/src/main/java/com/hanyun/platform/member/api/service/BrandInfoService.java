package com.hanyun.platform.member.api.service;

import java.util.List;
import java.util.Map;

import com.hanyun.platform.member.api.domain.BrandInfo;

public interface BrandInfoService {
	void addBrandInfo(BrandInfo brand);
	void addBrandInfoSelective(BrandInfo brand);
	BrandInfo selectByBrandId(String id);
	void updateByPrimaryKeySelective(BrandInfo brand);
	Long getCount();
	List<BrandInfo> getBrandByPage(Map<String, Object> map);

}
