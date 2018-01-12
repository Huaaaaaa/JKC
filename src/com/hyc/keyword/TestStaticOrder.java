package com.hyc.keyword;

/**
 * 测试静态代码块的执行顺序
 * 静态代码块是按照其物理顺序依次执行的
 * 
 * @author huayingcao
 *
 */
public class TestStaticOrder {
	static {
		System.out.println("第一个静态代码块");
	}

	public static void main(String[] args) {
		System.out.println("主函数");
	}

	static {
		System.out.println("第二个静态代码块");
	}
}
