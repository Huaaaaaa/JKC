package com.hyc.testabstract;
/**
 * 
 * @author huayingcao
 * @createtime 2017年3月17日 上午10:55:45
 * @description 子类-牛继承抽象类Mummual
 */
public class Cattle implements BaseAction{

	@Override
	public void eat() {
		System.out.println("eat");
		
	}

	@Override
	public void sleep() {
		System.out.println("sleep");
		
	}
	
}

