package com.hyc.keyword;

public class TestStaticMethod {

	public void getObj(String name) {
		// MyInfo mi1 = new MyInfo();
		/*
		 * 当已经通过静态代码块初始化静态变量之后，使用构造函数初始化赋值是否起作用
		 */
		MyInfo mi = new MyInfo("王五", 22, "女");
		String name1 = MyInfo.name;// 通过(类名.变量名)的方法调用静态变量
		if (name1.equals(name)) {
			System.out.println("我叫" + name + ",性别" + MyInfo.gender + ",今年"
					+ MyInfo.age + "岁");
		} else {
			System.out.println("我叫" + mi.name + ",性别" + mi.gender + ",今年"
					+ mi.age + "岁");
		}
	}

	public static void main(String[] args) {
		String[] s = {"","","",""};
		TestStaticMethod tsm = new TestStaticMethod();
		tsm.getObj("李四");
		// this.getObj(mi.name); 不能在静态方法中直接调用非静态方法
	}

}
