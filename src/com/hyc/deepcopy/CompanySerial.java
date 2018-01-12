package com.hyc.deepcopy;

import java.io.Serializable;

/**
 * @createtime 2017年3月21日 下午3:33:26
 * @description 被序列化的公司类
 */
public class CompanySerial implements Serializable{
	public String name;
	public DepartmentSeria departmentNoSerial;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DepartmentSeria getDepartmentNoSerial() {
		return departmentNoSerial;
	}
	public void setDepartmentNoSerial(DepartmentSeria departmentNoSerial) {
		this.departmentNoSerial = departmentNoSerial;
	}
	
	public CompanySerial(String name, DepartmentSeria departmentNoSerial) {
		this.name = name;
		this.departmentNoSerial = departmentNoSerial;
	}
	
	
}
