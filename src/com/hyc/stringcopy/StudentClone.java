package com.hyc.stringcopy;
/**
 * @createtime 2017年3月21日 下午2:25:17
 * @description  实现了cloneable接口
 */
public class StudentClone implements Cloneable{
	public String name;
	public int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public StudentClone(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * 重写clone方法
	 */
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
}
