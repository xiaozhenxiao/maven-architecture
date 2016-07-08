package com.hanyun.platform.member.api.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hanyun.platform.member.api.domain.BrandMember;
import com.hanyun.platform.member.api.domain.Orders;
import com.hanyun.platform.member.api.domain.UserInfo;
import com.hanyun.platform.member.api.service.BrandMemberService;
import com.hanyun.platform.member.api.service.MemberService;
import com.hanyun.platform.member.api.service.OrdersService;
import com.hanyun.platform.member.api.service.UserInfoService;
import com.hanyun.platform.member.util.DateUtil;
import com.hanyun.platform.member.util.ParamUtil;
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private BrandMemberService brandMemberService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private OrdersService ordersService;
	
	@Override
	public Map<String, Object> queryMemberOfBrand(String brandId,
			Long memberId, String name, String phone, String source,
			final Integer sort, String startTime, String endTime, Integer page,
			Integer size) {
		Integer start = (page<1)?0:(page-1)*size;
		boolean param = ParamUtil.isNotNull(memberId, name, phone, startTime, endTime);
		List<UserInfo> userInfos = userInfoService.getByIdAndNameAndPhone(memberId, name, phone, startTime, endTime, start, size);
		List<Map<String, Object>> list = ordersService.getStatistics(brandId);
		List<BrandMember> members = brandMemberService.getMemberOfBrandByPage(brandId, source, start, size);
		final SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
		List<Map<String, String>> resultList = new ArrayList<Map<String,String>>();
		Long count = 0L;
		
		if(param && CollectionUtils.isNotEmpty(userInfos)){
			count = userInfoService.getCount(memberId, name, phone, startTime, endTime);
			for (UserInfo userInfo : userInfos) {
				Map<String, String> result = new HashMap<String, String>();
				BrandMember member = brandMemberService.getMember(brandId, userInfo.getUserId());
				if(source != null){
					if(!(source.equals(member.getSourceStoreId()))){
						continue;
					}
				}
				Date lastTime = new Date();
				if(member != null){
					lastTime = member.getLastServiceTime();
				}
				result.put("userId", userInfo.getId().toString());
				result.put("memberId", member.getId().toString());
				result.put("source", member.getSourceStoreId());
				result.put("sourceName", member.getSourceStoreName());
				result.put("name", userInfo.getName());
				result.put("gender", String.valueOf(userInfo.getGender()));
				result.put("phone", userInfo.getPhone());
				result.put("status", String.valueOf(member.getStatus()));
				result.put("lastTime", format.format(lastTime));
				if(CollectionUtils.isNotEmpty(list)){
					for (Map<String, Object> map : list) {
						String userId = String.valueOf(map.get("userId"));
						if(userId.equals(userInfo.getUserId())){
							String total = String.valueOf(map.get("total"));
							String times = String.valueOf(map.get("times"));
							String avg = String.valueOf(map.get("single"));
							result.put("total", total);
							result.put("times", times);
							result.put("avg", avg);
							break;
						}
					}
				}
				resultList.add(result);
			}
		}else if(CollectionUtils.isNotEmpty(members)){
			count = brandMemberService.getSourceCount(brandId, source);
			for (BrandMember member : members) {
				Map<String, String> result = new HashMap<String, String>();
				String userId = member.getUserId();
				Date lastTime = new Date();
				if(member != null){
					lastTime = member.getLastServiceTime();
				}
				UserInfo userInfo = userInfoService.getByUserId(userId);
				if(userInfo == null) continue;
				result.put("lastTime", format.format(lastTime));
				result.put("userId", userInfo.getId().toString());
				result.put("memberId", member.getId().toString());
				result.put("source", member.getSourceStoreId());
				result.put("sourceName", member.getSourceStoreName());
				result.put("name", userInfo.getName());
				result.put("gender", String.valueOf(userInfo.getGender()));
				result.put("phone", userInfo.getPhone());
				result.put("status", String.valueOf(member.getStatus()));
				for (Map<String, Object> map : list) {
					String uId = String.valueOf(map.get("userId"));
					if(uId.equals(userId)){
						result.put("total", String.valueOf(map.get("total")));
						result.put("times", String.valueOf(map.get("times")));
						result.put("avg", String.valueOf(map.get("single")));
					}
				}
				resultList.add(result);
			}
		}
		Collections.sort(resultList, new Comparator<Map<String, String>>() {
            public int compare(Map<String, String> arg0, Map<String, String> arg1) {
            	int result = 0;
            	try {
					Date lt1 = format.parse(arg0.get("lastTime"));
					Date lt2 = format.parse(arg0.get("lastTime"));
					String stt1 = arg0.get("total");
					String stt2 = arg1.get("total");
					Double tt1 = (stt1!=null)?Double.valueOf(stt1):0;
					Double tt2 = (stt2!=null)?Double.valueOf(stt2):0;
					String t1 = arg0.get("times");
					String t2 = arg1.get("times");
					Long tm1 = (t1!=null)?Long.valueOf(t1):0;
					Long tm2 = (t2!=null)?Long.valueOf(t2):0;
					if(sort==null){
						result = tt1.compareTo(tt2);
					} else {
						if (sort == 0) {
							result = tt1.compareTo(tt2);
						} else if (sort == 1) {
							result = tm1.compareTo(tm2);
						} else {
							result = lt1.compareTo(lt2);
						}
					}					
				} catch (ParseException e) {
					e.printStackTrace();
				}
                return result;
            }
        });
		List<Map<String, String>> stores = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 5; i++) {
			Map<String, String> store = new HashMap<String, String>();
			//TODO 需从门店表中查得
			store.put("storeId", "xxxxxxxxx"+i);
			store.put("storeName", "门店"+i*i);
			stores.add(store);
		}
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("data", resultList);
		resultMap.put("pageCount", Math.ceil(count.doubleValue()/size.doubleValue()));//Math.ceil(length.doubleValue()/size.doubleValue()));
		resultMap.put("page", page);
		resultMap.put("brandId", brandId);
		resultMap.put("stores", stores);
		resultMap.put("memberId", memberId);
		resultMap.put("name", name);
		resultMap.put("sort", sort);
		resultMap.put("source", source);
		resultMap.put("phone", phone);
		resultMap.put("startTime", startTime);
		resultMap.put("endTime", endTime);
		return resultMap;
	}

	@Override
	public boolean modifyUserInfoStatus(Long id, Integer status) {
		int result = brandMemberService.updateStatusById(id, status);
		if(result>0)
			return true;
		return false;
	
	}

	@Override
	public Map<String, Object> consumptionRecord(Long id, String brandId,
			Integer tongjiTime, Integer page, Integer size) {

		Date startTime = null;
		Date currDate = new Date();
		if(tongjiTime.equals(0)){
			startTime = DateUtil.addMonth(new Date(), -1);
		}else {
			startTime = DateUtil.addMonth(new Date(), -3);
		}
		
		UserInfo userInfo = userInfoService.getById(id);
		//统计相关
		List<BrandMember> members =  brandMemberService.getByUserId(userInfo.getUserId());
		Long consumTimes = ordersService.getConsumTimes(brandId, userInfo.getUserId(), startTime, currDate);
		Long brandConsumTimes = ordersService.getBrandConsumTimes(brandId, startTime, currDate);
		Long consumSum = ordersService.getConsumSum(brandId, userInfo.getUserId(), startTime, currDate);
		Long brandConsumSum = ordersService.getBrandConsumSum(brandId, startTime, currDate);
		Long brandMemberCount = brandMemberService.getCount(brandId);
		if(consumSum==null)
			consumSum = 0L;
		if(brandConsumSum==null)
			brandConsumSum = 0L;
		if(consumTimes==null)
			consumTimes = 0L;
		if(brandConsumTimes==null)
			brandConsumTimes = 0L;
		if(brandMemberCount==null)
			brandMemberCount = 0L;
		
		Long distance = DateUtil.getDistanceDays(currDate, userInfo.getCreateTime());
		Long totalConsumFq = 0L;
		Long brandFq = 0L;
		if(CollectionUtils.isNotEmpty(members)){
			for (BrandMember brandMember : members) {
				Long memberConsumTimes = ordersService.getConsumTimes(brandId, brandMember.getUserId(), startTime, currDate);
				if(memberConsumTimes>0){
					Long consumFq =  distance/memberConsumTimes;
					totalConsumFq += consumFq;
				}
			}
			brandFq = totalConsumFq/members.size();
		}
		Long brandTimes = 0L;
		Long brandSum = 0L;
		if(brandMemberCount>0){
			brandTimes = brandConsumTimes/brandMemberCount;
			brandSum = brandConsumSum/brandMemberCount;
		}
		Long consumFq = 0L;
		Long avgConsum = 0L;
		if(consumTimes>0){
			consumFq = distance/consumTimes;
			avgConsum = consumSum/consumTimes;
		}
		Long avgbrand = 0L;
		if(brandConsumTimes>0)
			avgbrand = brandConsumSum/brandConsumTimes;
		
		Map<String, Long> tongJiMap = new HashMap<String, Long>();
		tongJiMap.put("consumTimes", consumTimes);//消费笔数
		tongJiMap.put("brandTimes", brandTimes);//店内平均消费笔数
		tongJiMap.put("consumSum", consumSum);//消费总额
		tongJiMap.put("brandSum", brandSum);//店内平均消费总额
		tongJiMap.put("consumFq", consumFq);//消费频次
		tongJiMap.put("brandFq", brandFq);//店内平均消费频次
		tongJiMap.put("avgConsum", avgConsum);//平均单笔消费
		tongJiMap.put("avgbrand", avgbrand);//店内平均单笔消费		
		
		Date lastTime = null;
		if(CollectionUtils.isNotEmpty(members)){
			Collections.sort(members, new Comparator<BrandMember>() {
	            public int compare(BrandMember arg0, BrandMember arg1) {
	                return arg1.getLastServiceTime().compareTo(arg0.getLastServiceTime());
	            }
	        });
			lastTime = members.get(0).getLastServiceTime();
		}
		
		List<Orders> memberRecords = ordersService.getByUserId(userInfo.getUserId(), brandId, (page-1)*size, size);
		Long count = ordersService.getUserCount(userInfo.getUserId(), brandId);
		List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
		if(CollectionUtils.isNotEmpty(memberRecords)){
			for (Orders orders : memberRecords) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("consumId", orders.getPayId());
				map.put("time", DateUtil.dateToString(orders.getCreateTime(), "yy-MM-dd hh:mm:ss"));
				map.put("money", orders.getOrderPrice().toString());
				map.put("marketing", orders.getActivityName());
				map.put("payType", orders.getPayType());
				map.put("payStatus", orders.getPayStatus());
				resultList.add(map);
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Long diff = (lastTime == null) ? DateUtil.getDistanceDays(currDate,
				userInfo.getCreateTime()) : DateUtil.getDistanceDays(
						currDate, lastTime);
		resultMap.put("data", resultList);
		resultMap.put("tongji", tongJiMap);
		resultMap.put("pageCount", Math.ceil(count.doubleValue()/size.doubleValue()));
		resultMap.put("user", userInfo);
		resultMap.put("lastTime", lastTime);
		resultMap.put("diff", diff);
		resultMap.put("page", page);
		resultMap.put("brandId", brandId);
		resultMap.put("tongjiTime", tongjiTime);
		
		return resultMap;
	}

}
