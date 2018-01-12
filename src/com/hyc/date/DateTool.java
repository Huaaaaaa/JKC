package com.hyc.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description 日期工具类
 * @createtime 2017年11月30日 下午2:05:02
 * @email cyhua_csu@163.com
 * @song 平凡之路
 */
public class DateTool {

	/**
	 * 网上看到的段子，简直神作
	 * 
	 * @return
	 */
	public static Date getYesterday1() {
		try {
			Thread.sleep(24 * 60 * 60 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	/**
	 * 获取今天的开始时间
	 * 
	 * @return
	 */
	public static Date getTodayBegin() {
		Calendar calender = new GregorianCalendar();
		calender.set(Calendar.HOUR_OF_DAY, 0);//某天某时
		calender.set(Calendar.MINUTE, 0);//某天某时某分
		calender.set(Calendar.SECOND, 0);//某天某时某分某秒
		System.out.println("今天的开始时间是："+calender.getTime());
		return calender.getTime();
	}

	/**
	 * 获取今天的结束时间
	 * @return
	 */
	public static Date getTodayEnd() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR_OF_DAY,23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		System.out.println("今天的结束时间是："+calendar.getTime());
		return calendar.getTime();
	}
	
	/**
	 * 获取指定日期在一个月当中的第几天
	 * @return
	 */
	public static int getDayOfMonth(Date date){
		Calendar calender = new GregorianCalendar();
		calender.setTime(date);
		int day = calender.get(Calendar.DAY_OF_MONTH);//某月某天
		System.out.println(date+"是一个月的第"+day+"天");
		System.out.println(calender.get(Calendar.HOUR_OF_DAY));
		System.out.println(calender.get(Calendar.MINUTE));
		System.out.println(calender.get(Calendar.SECOND));
		return day;
	}
	
	/**
	 * 获取昨天的开始时间
	 * @return
	 */
	public static Date getYesterdayBegin(){
		Calendar calender = new GregorianCalendar();
		calender.setTime(getTodayBegin());
		calender.add(Calendar.DAY_OF_MONTH,-1);
		System.out.println("昨天的开始时间是："+calender.getTime());
		return calender.getTime();
	}
	
	/**
	 * 获取昨天的结束时间
	 * @return
	 */
	public static Date getYesterdayEnd(){
		Calendar calender = new GregorianCalendar();
		calender.setTime(getTodayEnd());
		calender.add(Calendar.DAY_OF_MONTH,-1);
		System.out.println("昨天的结束时间是："+calender.getTime());
		return calender.getTime();
	}
	
	/**
	 * 获取明天的开始时间
	 * @return
	 */
	public static Date getTomorrowBegin(){
		Calendar calender = new GregorianCalendar();
		calender.setTime(getTodayBegin());
		calender.add(Calendar.DAY_OF_MONTH,1);
		System.out.println("明天的开始时间是："+calender.getTime());
		return calender.getTime();
	}
	
	/**
	 * 获取明天的结束时间
	 * @return
	 */
	public static Date getTomorrowEnd(){
		Calendar calender = new GregorianCalendar();
		calender.setTime(getTodayEnd());
		calender.add(Calendar.DAY_OF_MONTH,1);
		System.out.println("明天的结束时间是："+calender.getTime());
		return calender.getTime();
	}
	
	/**
	 * 获取本周开始时间
	 * @return
	 */
	public static Date getStartOfWeek(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(getTodayBegin());
		int day = calendar.get(Calendar.DAY_OF_WEEK);//某星期第几天
		//本周开始的天为往后推今天所在天数-1
		calendar.add(Calendar.DAY_OF_WEEK,-(--day));
		System.out.println("本周开始时间是："+calendar.getTime());
		return calendar.getTime();
	}
	
	/**
	 * 获取本周结束时间
	 * @return
	 */
	public static Date getEndOfWeek(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(getTodayEnd());
		int day = calendar.get(Calendar.DAY_OF_WEEK);//某星期第几天
		day = 7-day;
		//本周结束日期是今天所在天往前推（7-今天）天
		calendar.add(Calendar.DAY_OF_WEEK,day);
		System.out.println("本周结束时间是："+calendar.getTime());
		return calendar.getTime();
	}
}
