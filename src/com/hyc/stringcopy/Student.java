package com.hyc.stringcopy;

/**
 * 创建一个学生对象
 * 
 * @createtime 2017年3月21日 上午10:15:20
 * @description
 */
public class Student {
	String name;

	int age;

	String gender;

	public Student(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
