package com.hyc.keyword.corderorder;

/**
 * 包含静态代码块、构造代码块和构造方法的类1
 * 
 * @author huayingcao
 *
 */
public class Code1 {
	static {
		System.out.println("code1的静态代码块");
	}

	{
		System.out.println("code1的构造代码块");
	}

	public Code1() {
		System.out.println("code1的构造方法");
	}

}
