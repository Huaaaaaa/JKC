package com.hyc.deepcopy;

import java.io.Serializable;

/**
 * @createtime 2017年3月21日 下午3:34:24
 * @description 被序列化的部门类
 */
public class DepartmentSeria implements Serializable{
	public String name;
	public StaffNoSerial staffNoSerial;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StaffNoSerial getStaffNoSerial() {
		return staffNoSerial;
	}
	public void setStaffNoSerial(StaffNoSerial staffNoSerial) {
		this.staffNoSerial = staffNoSerial;
	}
	public DepartmentSeria(String name, StaffNoSerial staffNoSerial) {
		this.name = name;
		this.staffNoSerial = staffNoSerial;
	}

}
