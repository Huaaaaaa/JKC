package com.hyc.construct;

public class TestB {

	public static void main(String[] args) {
		TestA ta = new TestA();
		System.out.println("hn:"+ta.hn+";ak:"+ta.ak+";sk:"+ta.sk);
		
		ta.setValue();
		System.out.println("hn:"+ta.getHn()+";ak:"+ta.getAk()+";sk:"+ta.getSk());
	}
}
