package com.hyc.stringcopy;
/**
 * @createtime 2017年3月21日 下午2:41:26
 * @description 含有一个未实现cloneable接口的引用变量
 */
public class AddAttrStudent implements Cloneable{
	public String name;
	
	public Student student;//引用变量
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public AddAttrStudent(String name, Student student) {
		this.name = name;
		this.student = student;
	}
	/**
	 * 实现Cloneable接口，重写clone方法
	 */
	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return  null;
		}
	}
}
