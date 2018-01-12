package com.hyc.keyword;

public class Base {
	static {
		System.out.println("base static");
	}

	public Base(String msg) {
		System.out.println("base constructor" + msg);
	}
}
