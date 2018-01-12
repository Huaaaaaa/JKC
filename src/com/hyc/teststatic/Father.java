package com.hyc.teststatic;

import java.util.Date;

/**
 * @createtime 2017年3月17日 下午4:25:26
 * @description 定义一个父类
 */
public class Father {
	
	public static String name = "变量father";
	
	public static long  date = new Date().getTime();
	
	public String time = String.valueOf(System.currentTimeMillis());
	/**
	 * 静态代码块
	 */
	static{
		System.out.println("父类静态代码块");
		System.out.println("父类静态代码块日期是："+String.valueOf(date));
	}
	
	/**
	 * 非静态代码块
	 */
	{
		System.out.println("父类非静态代码块");
		System.out.println("父类非静态代码块执行时间是："+time);
	}
	
	/**
	 * 默认构造方法
	 */
	public Father(){
		this("构造father");
		System.out.println("父类默认构造方法");
	}
	
	public Father(String name){
		System.out.println("父类含参构造方法");
		this.name = name;
	}

}
