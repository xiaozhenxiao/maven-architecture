package com.myself.test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hanyun.platform.ground.util.json.JsonUtil;
import com.hanyun.platform.member.api.domain.BrandMember;
import com.hanyun.platform.member.util.DateUtil;

public class ListSort {
	public static void main(String[] args) {
		List<BrandMember> members =  new ArrayList<BrandMember>();
		
		BrandMember member = new BrandMember();
		Date date = DateUtil.stringToDate("2016-06-22", "yyyy-MM-dd");
		member.setLastServiceTime(date);
		members.add(member);
		BrandMember member1 = new BrandMember();
		Date date1 = DateUtil.stringToDate("2016-05-22", "yyyy-MM-dd");
		member1.setLastServiceTime(date1);
		members.add(member1);
		BrandMember member2 = new BrandMember();
		Date date2 = DateUtil.stringToDate("2016-03-22", "yyyy-MM-dd");
		member2.setLastServiceTime(date2);
		members.add(member2);
		BrandMember member3 = new BrandMember();
		Date date3 = DateUtil.stringToDate("2016-07-22", "yyyy-MM-dd");
		member3.setLastServiceTime(date3);
		members.add(member3);
		BrandMember member4 = new BrandMember();
		Date date4 = DateUtil.stringToDate("2016-01-22", "yyyy-MM-dd");
		member4.setLastServiceTime(date4);
		members.add(member4);
		BrandMember member5 = new BrandMember();
		Date date5 = DateUtil.stringToDate("2016-11-22", "yyyy-MM-dd");
		member5.setLastServiceTime(date5);
		members.add(member5);
		BrandMember member6 = new BrandMember();
		Date date6 = DateUtil.stringToDate("2016-02-22", "yyyy-MM-dd");
		member6.setLastServiceTime(date6);
		members.add(member6);
		BrandMember member7 = new BrandMember();
		Date date7 = DateUtil.stringToDate("2016-04-22", "yyyy-MM-dd");
		member7.setLastServiceTime(date7);
		members.add(member7);
		BrandMember member8 = new BrandMember();
		Date date8 = DateUtil.stringToDate("2016-08-22", "yyyy-MM-dd");
		member8.setLastServiceTime(date8);
		members.add(member8);
		for (BrandMember brandMember : members) {
			System.out.println(DateUtil.dateToString(brandMember.getLastServiceTime(), "yyyy-MM-dd"));
		}
		Collections.sort(members, new Comparator<BrandMember>() {
            public int compare(BrandMember arg0, BrandMember arg1) {
                return arg1.getLastServiceTime().compareTo(arg0.getLastServiceTime());
            }
        });
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (BrandMember brandMember : members) {
			System.out.println(DateUtil.dateToString(brandMember.getLastServiceTime(), "yyyy-MM-dd"));
		}
		System.out.println("**************************************************************");
		String json = "[{\"total\":\"2000\"}, {\"total\":\"10000\"}, {\"total\":\"6000\"}, {\"total\":\"14000\"}, {\"total\":\"12000\"}]";
		try {
			List<Map<String, String>> list = JsonUtil.fromJson(json, List.class);
			for (Map<String, String> map : list) {
				String total = map.get("total");
				System.out.println(total);
			}
			Comparator<Map<String, String>> comparator = new Comparator<Map<String, String>>() {
	            public int compare(Map<String, String> arg0, Map<String, String> arg1) {
	            	int result = 0;
	            	String stt1 = arg0.get("total");
					String stt2 = arg1.get("total");
					Double tt1 = (stt1!=null)?Double.valueOf(stt1):0;
					Double tt2 = (stt2!=null)?Double.valueOf(stt2):0;
					
					result = tt1.compareTo(tt2);
	                return result;
	            }
	        };
	        System.out.println("---------------------------------------------------");
			Collections.sort(list, comparator);
			for (Map<String, String> map : list) {
				String total = map.get("total");
				System.out.println(total);
			}
			
			
			int[] a = {2,5,3,7,1,8,3,9,15,6};
			quickSort(a, 0, 9);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void quickSort(int[] a, int start, int end){
		
		if(start<end){
			int base = a[start];
			int i = start, j = end;
			while(i<=j){
				while (i<end && base>a[i])
					i++;
				while(j>start && base<a[j])
					j--;
				if(i<=j){
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					i++;
					j--;
				}
				for (int aa : a) {
					System.out.print(aa + "\t");
				}
				System.out.println("\n"+i+ "-------------------------------------------" + j);
			}
			if(start<j)
				quickSort(a, start, j);
			if(end>i)
				quickSort(a, i, end);
		}
		
		
	}

}
