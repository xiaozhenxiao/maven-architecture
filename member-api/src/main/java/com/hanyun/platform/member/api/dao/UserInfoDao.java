package com.hanyun.platform.member.api.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.hanyun.platform.member.api.domain.UserInfo;

@Repository
public interface UserInfoDao {
	void insert(UserInfo user);

	void insertSelective(UserInfo user);
	
	List<UserInfo> selectUsers();

	UserInfo selectByPhone(String phone);

	UserInfo selectById(Long id);
	
	Long selectCount(@Param("id") Long memberId, @Param("name") String name,
			@Param("phone") String phone, @Param("startTime") String startTime,
			@Param("endTime") String endTime);

	void updateByIdSelective(UserInfo user);

	UserInfo selectByUserId(String userId);

	List<UserInfo> selectByIdAndNameAndPhone(@Param("id") Long memberId,
			@Param("name") String name, @Param("phone") String phone,
			@Param("startTime") String startTime,
			@Param("endTime") String endTime, @Param("offset") Integer offset,
			@Param("pageSize") Integer pageSize);
}
