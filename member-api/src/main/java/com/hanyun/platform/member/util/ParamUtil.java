package com.hanyun.platform.member.util;

public class ParamUtil {
	/**
	 * 有一个为NULL就返回true
	 * @param objects
	 * @return
	 */
	public static boolean isNull(Object... objects){
		boolean result = false;
		for (Object object : objects) {
			if(object == null){
				result = true;
				break;
			}
		}
		return result;
	}
	/**
	 * 有一个不为NULL就返回true
	 * @param objects
	 * @return
	 */
	public static boolean isNotNull(Object... objects){
		boolean result = false;
		for (Object object : objects) {
			if(object != null){
				result = true;
				break;
			}
		}
		return result;
	}

}
