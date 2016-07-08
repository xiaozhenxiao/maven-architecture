package com.hanyun.platform.member.api.service;

import java.util.Map;

public interface MemberService {
	Map<String, Object> queryMemberOfBrand(String brandId, Long memberId,
			String name, String phone, String source, final Integer sort,
			String startTime, String endTime, Integer page, Integer size);

	boolean modifyUserInfoStatus(Long id, Integer status);

	Map<String, Object> consumptionRecord(Long id, String brandId,
			Integer tongjiTime, Integer page, Integer size);

}
