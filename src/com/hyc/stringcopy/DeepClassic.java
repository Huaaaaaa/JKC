package com.hyc.stringcopy;



/**
 * 创建一个班级对象
 * @createtime 2017年3月21日 上午10:16:45
 * @description
 */
public class DeepClassic implements Cloneable{
	
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
	
	

	public DeepClassic(Student student, String name, int id) {
		this.student = student;
		this.name = name;
		this.id = id;
	}

	/**
	 * 深度拷贝
	 */
	public Object clone(){
		DeepClassic dc = new DeepClassic(student, name, id);
		return dc;
	}

}
