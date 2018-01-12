package com.hyc.stringcopy;
/**
 * @createtime 2017年3月21日 下午2:57:42
 * @description  含有实现了cloneable接口的引用对象StudentClone
 */
public class AddAttrStudentClone implements Cloneable{
	public String name;
	public StudentClone studentClone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public StudentClone getStudentClone() {
		return studentClone;
	}
	public void setStudentClone(StudentClone studentClone) {
		this.studentClone = studentClone;
	}
	
	
	public AddAttrStudentClone(String name, StudentClone studentClone) {
		this.name = name;
		this.studentClone = studentClone;
	}
	
	/**
	 * 重写clone方法，同时调用引用对象的clone方法
	 */
	public Object clone(){
		try {
			AddAttrStudentClone aasc = (AddAttrStudentClone) super.clone();
			aasc.studentClone = (StudentClone) studentClone.clone();
			return aasc;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
