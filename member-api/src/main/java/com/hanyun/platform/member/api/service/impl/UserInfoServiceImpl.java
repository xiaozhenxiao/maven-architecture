package com.hanyun.platform.member.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanyun.platform.member.api.dao.UserInfoDao;
import com.hanyun.platform.member.api.domain.UserInfo;
import com.hanyun.platform.member.api.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public void addUserInfo(UserInfo user) {
		userInfoDao.insert(user);
	}

	@Override
	public void addUserInfoSelective(UserInfo user) {
		userInfoDao.insertSelective(user);
	}

	@Override
	public UserInfo getByPhone(String phone) {
		return userInfoDao.selectByPhone(phone);
	}

	@Override
	public void updateByIdSelective(UserInfo user) {
		userInfoDao.updateByIdSelective(user);
	}

	@Override
	public UserInfo getByUserId(String userId) {
		return userInfoDao.selectByUserId(userId);
	}

	@Override
	public List<UserInfo> getByIdAndNameAndPhone(Long memberId, String name,
			String phone, String startTime, String endTime, Integer offset,
			Integer size) {
		return userInfoDao.selectByIdAndNameAndPhone(memberId, name, phone,
				startTime, endTime, offset, size);
	}

	@Override
	public Long getCount(Long memberId, String name, String phone,
			String startTime, String endTime) {
		return userInfoDao.selectCount(memberId, name, phone, startTime, endTime);
	}

	@Override
	public UserInfo getById(Long id) {
		return userInfoDao.selectById(id);
	}

	@Override
	public List<UserInfo> getUsers() {
		return userInfoDao.selectUsers();
	}

}
