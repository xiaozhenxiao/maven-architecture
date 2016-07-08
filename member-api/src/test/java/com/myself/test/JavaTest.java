package com.myself.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import com.hanyun.platform.member.util.DateUtil;

public class JavaTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		  list.add("JavaWeb编程词典");        //向列表中添加数据
		  list.add("Java编程词典");        //向列表中添加数据
		  list.add("C#编程词典");         //向列表中添加数据
		  list.add("ASP.NET编程词典");        //向列表中添加数据
		  list.add("VC编程词典");         //向列表中添加数据
		  list.add("SQL编程词典");        //向列表中添加数据
		  Iterator<String> its = list.iterator();     //获取集合迭代器
		  System.out.println("集合中所有元素对象：");
		  while (its.hasNext()) {        //循环遍历集合
		   System.out.print(its.next() + "  ");     //输出集合内容
		  }
		  List<String> subList = list.subList(3, 5);    //获取子列表
		  System.out.println("\n截取集合中部分元素：");
		  Iterator it = subList.iterator();
		  while (it.hasNext()) {
		   System.out.print(it.next() + "  ");
		  }
		  System.out.println();
		  Integer fenzi = 6;
		  Integer fenmu = 10;
		  System.out.println(Math.ceil(fenzi.doubleValue()/fenmu.doubleValue()));
		  
		  Date startTime = DateUtil.addDay(new Date(), -30);
		  Date startMonth = DateUtil.addMonth(new Date(), -1);
		  System.out.println(DateUtil.dateToString(startTime, "yy-MM-dd hh:mm:ss"));
		  System.out.println(DateUtil.dateToString(startMonth, "yy-MM-dd hh:mm:ss"));
		  
		  System.out.println("Double转换：" + Double.valueOf("10"));
		  
		  Integer testNull = null;
		  if(testNull == null){
			  System.out.println("null");
			  if(testNull == 0){
				  System.out.println("0");
			  }
		  }
		  
	}

}
