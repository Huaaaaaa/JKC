package com.hyc.keyword;

public class MyClass extends Test {
	Base base = new Base("myclass");
	static {
		System.out.println("myclass static");
	}

	public MyClass() {
		System.out.println("myclass constructor");
	}

}
