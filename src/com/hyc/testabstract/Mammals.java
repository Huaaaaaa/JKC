package com.hyc.testabstract;
/**
 * @createtime 2017年3月17日 上午10:33:27
 * @description 哺乳类 
 */
public abstract class Mammals {
	public String foods;
	
	public abstract void nurse();
	
	public void eat(String food){
		this.foods = food;
		System.out.println("吃"+foods);
	}
}

