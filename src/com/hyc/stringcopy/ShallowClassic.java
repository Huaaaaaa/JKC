package com.hyc.stringcopy;

import com.sun.org.apache.bcel.internal.generic.DCMPG;



/**
 * 创建一个班级对象
 * @createtime 2017年3月21日 上午10:16:45
 * @description
 */
public class ShallowClassic implements Cloneable{
	
	public Student student;
	
	public String name;
	
	public int id;
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	public ShallowClassic(Student student, String name, int id) {
		this.student = student;
		this.name = name;
		this.id = id;
	}

	/**
	 * 浅度拷贝
	 */
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
