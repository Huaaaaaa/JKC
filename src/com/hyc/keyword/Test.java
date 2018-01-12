package com.hyc.keyword;

public class Test {

	static {
		System.out.println("test static");
	}

	Base base = new Base("mytest");

	public Test() {
		System.out.println("test constructor");
	}


	public static void main(String[] args) {
		/**
		 * 类的加载顺序： Test--MyClass--Base 静态方法的执行和类加载的顺序一致，而构造方法的执行顺序却与类加载的顺序相反，
		 * 而且如果在执行某一个类的构造方法之前创建了另一个类的实例，则优先执行被实例化类的构造方法
		 * 注意：在实例化一个对象之前，首先要初始化该对象中的成员变量，所以Test类中先执行Base的实例化，再执行Test构造函数
		 */
		new MyClass();
	}

}
