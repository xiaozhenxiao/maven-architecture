package com.hanyun.platform.member.api.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hanyun.platform.member.api.service.MemberService;

@Controller
@RequestMapping(value = "/brand")
public class BrandMemberController {
	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "/member", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> queryMemberOfBrand(
			@RequestParam("brandid") String brandId,
			@RequestParam(value = "memberid", required = false) Long memberId,
			@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "source", required = false) String source,
			@RequestParam(value = "sort", required = false) final Integer sort,
			@RequestParam(value = "starttime", required = false) String startTime,
			@RequestParam(value = "endtime", required = false) String endTime,
			@RequestParam(value = "start") Integer page,
			@RequestParam("size") Integer size) {
		return memberService.queryMemberOfBrand(brandId, memberId, name, phone,
				source, sort, startTime, endTime, page, size);
	}

	@RequestMapping(value = "/userinfo", method = { RequestMethod.GET })
	@ResponseBody
	public boolean modifyUserInfoStatus(@RequestParam("id") Long id,
			@RequestParam(value = "status", required = false) Integer status) {
		return memberService.modifyUserInfoStatus(id, status);
	}

	@RequestMapping(value = "/consume-record", method = { RequestMethod.GET })
	@ResponseBody
	public Map<String, Object> consumptionRecord(@RequestParam("id") Long id,
			@RequestParam("brandid") String brandId,
			@RequestParam("tongjitime") Integer tongjiTime,
			@RequestParam(value = "start") Integer page,
			@RequestParam("size") Integer size) {
		return memberService.consumptionRecord(id, brandId, tongjiTime, page,
				size);
	}

}
