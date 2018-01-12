package com.hyc.keyword;
/**
 * 测试构造代码块、静态代码块和构造方法的执行顺序
 * @author huayingcao
 *
 */
public class TestCodeOrder {

	{
		System.out.println("构造代码块");
	}

	public TestCodeOrder() {
		System.out.println("构造方法");
	}

	static {
		System.out.println("静态代码块");
	}

	public static void main(String[] args) {
		/*
		 * 输出顺序依次为：
		 * 静态代码块---构造代码块---构造方法
		 */
		new TestCodeOrder();
		
	}

}
