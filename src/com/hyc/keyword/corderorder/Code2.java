package com.hyc.keyword.corderorder;

/**
 * 包含静态代码块、构造代码块和构造方法的类2
 * 
 * @author huayingcao
 *
 */
public class Code2 {
	static {
		System.out.println("code2的静态代码块");
	}

	{
		System.out.println("code2的构造代码块");
	}

	public Code2() {
		System.out.println("code2的构造方法");
	}
}
