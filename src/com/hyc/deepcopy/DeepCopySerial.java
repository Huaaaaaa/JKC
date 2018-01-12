package com.hyc.deepcopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @createtime 2017年3月21日 下午3:38:33
 * @description 序列化实现深度拷贝
 */
public class DeepCopySerial {

	public static void deepCopy() throws Exception{
		StaffNoSerial staff =  new StaffNoSerial("张三",20);

		DepartmentSeria department = new DepartmentSeria("研发类", staff);

		CompanySerial company = new CompanySerial("阿里巴巴", department);

		CompanySerial companyCopy = null;
		/**
		 * 第一种：文件输入输出流方式
		 */
		FileOutputStream fos = new FileOutputStream(new File("F:/deep.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(company);
		

		FileInputStream fis = new FileInputStream(new File("F:/deep.txt"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		companyCopy =  (CompanySerial) ois.readObject();
		
		
		/**
		 * 第二种：字节数组输入输出流方式
		 */
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
//		ObjectOutputStream oos1 = new ObjectOutputStream(baos);
//		oos1.writeObject(company);
//		
//		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//		ObjectInputStream ois1 = new ObjectInputStream(bais);
//		companyCopy = (CompanySerial) ois1.readObject();
		
		//沒做修改的情況下
		System.out.println(company==companyCopy);//false
		System.out.println(company.name);//阿里巴巴
		System.out.println(companyCopy.name);//阿里巴巴
		System.out.println(company.departmentNoSerial == companyCopy.departmentNoSerial);//false
		System.out.println(company.departmentNoSerial.name);//研发类
		System.out.println(companyCopy.departmentNoSerial.name);//研发类
		System.out.println(company.departmentNoSerial.staffNoSerial == companyCopy.departmentNoSerial.staffNoSerial);//false
		System.out.println(company.departmentNoSerial.staffNoSerial.name);//张三
		System.out.println(companyCopy.departmentNoSerial.staffNoSerial.name);//张三
		
		System.out.println("\n修改原對象\n");
		company.name = "拷贝原阿里巴巴";
		company.departmentNoSerial.name = "拷贝原研发类";
		company.departmentNoSerial.staffNoSerial.name = "拷贝原张三";
		System.out.println(company==companyCopy);//false
		System.out.println(company.name);//拷贝原阿里巴巴
		System.out.println(companyCopy.name);//阿里巴巴
		System.out.println(company.departmentNoSerial == companyCopy.departmentNoSerial);//false
		System.out.println(company.departmentNoSerial.name);//拷贝原研发类
		System.out.println(companyCopy.departmentNoSerial.name);//研发类
		System.out.println(company.departmentNoSerial.staffNoSerial == companyCopy.departmentNoSerial.staffNoSerial);//false
		System.out.println(company.departmentNoSerial.staffNoSerial.name);//拷贝原张三
		System.out.println(companyCopy.departmentNoSerial.staffNoSerial.name);//张三
		
		System.out.println("\n修改拷贝對象\n");
		companyCopy.name = "腾讯";
		companyCopy.departmentNoSerial.name = "财务类";
		companyCopy.departmentNoSerial.staffNoSerial.name = "李四";
		System.out.println(company==companyCopy);//false
		System.out.println(company.name);//拷贝原阿里巴巴
		System.out.println(companyCopy.name);//腾讯
		System.out.println(company.departmentNoSerial == companyCopy.departmentNoSerial);//false
		System.out.println(company.departmentNoSerial.name);//拷贝原研发类
		System.out.println(companyCopy.departmentNoSerial.name);//财务类
		System.out.println(company.departmentNoSerial.staffNoSerial == companyCopy.departmentNoSerial.staffNoSerial);//false
		System.out.println(company.departmentNoSerial.staffNoSerial.name);//拷贝原张三
		System.out.println(companyCopy.departmentNoSerial.staffNoSerial.name);//李四
		
	}
}
