package com.hanyun.platform.member.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanyun.platform.member.api.dao.BrandMemberDao;
import com.hanyun.platform.member.api.domain.BrandMember;
import com.hanyun.platform.member.api.service.BrandMemberService;
@Service
public class BrandMemberServiceImpl implements BrandMemberService {

	@Autowired
	private BrandMemberDao brandMemberDao;
	
	@Override
	public void addBrandMember(BrandMember member) {
		brandMemberDao.insert(member);
	}

	@Override
	public void addBrandMemberSelective(BrandMember member) {
		brandMemberDao.insertSelective(member);
	}

	@Override
	public BrandMember getById(Long id) {
		return brandMemberDao.selectById(id);
	}

	@Override
	public int updateByIdSelective(BrandMember member) {
		return brandMemberDao.updateByIdSelective(member);
	}

	@Override
	public Long getSourceCount(String brandId, String source) {
		return brandMemberDao.selectSourceCount(brandId, source);
	}

	@Override
	public List<BrandMember> getMemberOfBrandByPage(String brandId,
			String source, Integer start, Integer size) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandId", brandId);
		map.put("source", source);
		map.put("offset", start);
		map.put("pageSize", size);
		return brandMemberDao.selectMemberOfBrandByPage(map);
	}

	@Override
	public BrandMember getMember(String brandId, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("brandId", brandId);
		map.put("userId", userId);
		List<BrandMember> members = brandMemberDao.selectMember(map);
		if (CollectionUtils.isNotEmpty(members)) {
			return members.get(0);
		}
		return null;
	}

	@Override
	public List<BrandMember> getByUserId(String userId) {
		return brandMemberDao.selectByUserId(userId);
	}

	@Override
	public int updateByUserIdSelective(BrandMember member) {
		return brandMemberDao.updateByUserIdSelective(member);
	}

	@Override
	public int updateStatusById(Long id, Integer status) {
		return brandMemberDao.updateStatusById(id, status);
	}

	@Override
	public Long getCount(String brandId) {
		return brandMemberDao.selectCount(brandId);
	}

}
