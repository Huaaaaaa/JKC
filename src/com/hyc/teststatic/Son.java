package com.hyc.teststatic;

import java.util.Date;
/**
 * @createtime 2017年3月17日 下午5:17:02
 * @description  创建一个子类
 */
public class Son extends Father{
	public static String name = "子类name";
	
	public static long  date = new Date().getTime();
	
	public String time = String.valueOf(System.currentTimeMillis());
	/**
	 * 静态代码块
	 */
	static{
		System.out.println("子类静态代码块");
		System.out.println("子类静态代码块日期是："+String.valueOf(date));
	}
	
	/**
	 * 非静态代码块
	 */
	{
		System.out.println("子类非静态代码块");
		System.out.println("子类非静态代码块执行时间是："+time);
	}
	
	/**
	 * 静态方法
	 * @param names
	 */
	public static void getName(String names){
		Son.name = names;
		System.out.println(name);
	}
	
	/**
	 * 默认构造方法
	 */
	public Son(){
		this("构造son");
		System.out.println("子类默认构造方法");
	}
	
	public Son(String names){
		System.out.println("子类含参构造方法");
		this.name = names;
	}
	
	public static void main(String[] args) {
		getName("son-name");
		new Son();
	}
}

/*不继承父类时--执行结果如下：
 * 顺序：静态变量->静态代码块->非静态变量->非静态代码块->构造方法
子类静态代码块
子类静态代码块日期是：1489742299514
son-name
子类非静态代码块
子类非静态代码块执行时间是：1489742299514
子类含参构造方法
子类默认构造方法
*/

/*继承父类时-执行结果如下：
 * 顺序：父类静态变量->父类静态代码块->子类静态变量->子类静态代码块->父类非静态变量->父类非静态代码块->父类构造方法->子类非静态变量->子类非静态代码块->子类构造方法
父类静态代码块
父类静态代码块日期是：1489743876335
子类静态代码块
子类静态代码块日期是：1489743876336
son-name
父类非静态代码块
父类非静态代码块执行时间是：1489743876336
父类含参构造方法
父类默认构造方法
子类非静态代码块
子类非静态代码块执行时间是：1489743876336
子类含参构造方法
子类默认构造方法*/
