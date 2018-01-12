package com.hyc.keyword.corderorder;

/**
 * 测试代码块和构造函数的执行顺序以及两种代码块的执行的次数
 * 
 * @author huayingcao
 *
 */
public class TestOrderAndNum {
	static {
		System.out.println("主类中的静态代码块");
	}

	public TestOrderAndNum() {
		System.out.println("主类中的构造方法");
	}

	public static void main(String[] args) {
		TestOrderAndNum toan = new TestOrderAndNum();
		Code1 code11 = new Code1();// code1的静态代码块--code1的构造代码块--code1的构造方法
		Code1 code12 = new Code1();// code1的构造代码块--code1的构造方法
		Code2 code21 = new Code2();// code2的静态代码块--code2的构造代码块--code2的构造方法
		Code2 code22 = new Code2();// code2的构造代码块--code2的构造方法
	}
}
