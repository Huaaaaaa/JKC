package com.hyc.keyword;

/**
 * 用户的基本信息类，通过构造方法初始化 也可以用静态代码块的方法进行赋值
 * 
 * @author huayingcao
 *
 */
public class MyInfo {
	public static String name;
	public static int age;
	public static String gender;
	static {
		name = "李四";
		age = 23;
		gender = "男";
	}

	public MyInfo(String name, int age, String gender) {
		MyInfo.name = name;
		MyInfo.age = age;
		MyInfo.gender = gender;
	}

	// public MyInfo(String name) {
	// MyInfo.name = name;
	// }
}
