package com.hanyun.platform.member.api.service;

import java.util.List;
import com.hanyun.platform.member.api.domain.UserInfo;

public interface UserInfoService {
	void addUserInfo(UserInfo user);

	void addUserInfoSelective(UserInfo user);
	
	List<UserInfo> getUsers();

	UserInfo getByPhone(String phone);
	
	UserInfo getById(Long id);

	Long getCount(Long memberId, String name, String phone, String startTime,
			String endTime);

	void updateByIdSelective(UserInfo user);

	UserInfo getByUserId(String userId);

	List<UserInfo> getByIdAndNameAndPhone(Long memberId, String name,
			String phone, String startTime, String endTime, Integer offset,
			Integer size);
}
