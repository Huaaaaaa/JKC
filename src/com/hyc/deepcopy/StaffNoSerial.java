package com.hyc.deepcopy;

import java.io.Serializable;

/**
 * @createtime 2017年3月21日 下午3:35:26
 * @description 被序列化的员工类
 */
public class StaffNoSerial implements Serializable{
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
	
	public StaffNoSerial(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
