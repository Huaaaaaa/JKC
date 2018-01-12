package com.hyc.stringcopy;
/**
 * 字符串浅拷贝方式
 * @createtime 2017年3月21日 上午10:25:17
 * @description
 */
public class DeepCopy {

	public static void copy(){
		//原始对象
		Student stu = new Student("原始对象为srcObject", 23, "man");
		DeepClassic classicSrc = new DeepClassic(stu, "原始名称srcName",1101);
		
		//拷贝对象
		DeepClassic classicCopy = (DeepClassic) classicSrc.clone();
		
		System.out.println("原始对象的名称属性是："+classicSrc.getName()+"\t\t"+"拷贝对象的属性名称是："+classicCopy.getName());
		System.out.println("原始对象的id属性是："+classicSrc.getId()+"\t\t\t"+"拷贝对象的id属性是："+classicCopy.getId());
		System.out.println("原始对象的对象属性name是："+classicSrc.getStudent().getName()+"\t"+"拷贝对象的对象属性name是："+classicCopy.getStudent().getName());
		System.out.println("原始对象的对象属性aget是："+classicSrc.getStudent().getAge()+"\t\t\t"+"拷贝对象的对象属性age是："+classicCopy.getStudent().getAge());
		System.out.println("原始对象的对象属性gender是："+classicSrc.getStudent().getGender()+"\t\t"+"拷贝对象的对象属性gnder是："+classicCopy.getStudent().getGender());
		
		System.out.println("原始对象和拷贝对象"+(classicSrc==classicCopy?"相同":"不相同"));
		System.out.println("原始对象和拷贝对象的对象属性student"+(classicSrc.getStudent()==classicCopy.getStudent()?"相同":"不相同"));
		System.out.println("原始对象和拷贝对象的name属性"+(classicSrc.getName()==classicCopy.getName()?"一样":"不一样"));
		System.out.println("原始对象和拷贝对象的Student属性名"+(classicSrc.getStudent().getName()==classicCopy.getStudent().getName()?"一样":"不一样"));
		
		
		System.out.println("=============修改原始对象后==========");
		
		classicSrc.setName("修改原始名称为modySrcName");
		classicSrc.setId(1102);
		classicSrc.getStudent().setName("修改原始对象的名称modySrcObject");
		classicSrc.getStudent().setAge(33);
		classicSrc.getStudent().setGender("女");
		
		System.out.println("原始对象的名称属性是："+classicSrc.getName()+"\t\t"+"拷贝对象的属性名称是："+classicCopy.getName());
		System.out.println("原始对象的id属性是："+classicSrc.getId()+"\t\t\t\t"+"拷贝对象的id属性是："+classicCopy.getId());
		System.out.println("原始对象的对象属性name是："+classicSrc.getStudent().getName()+"\t"+"拷贝对象的对象属性name是："+classicCopy.getStudent().getName());
		System.out.println("原始对象的对象属性aget是："+classicSrc.getStudent().getAge()+"\t\t\t\t"+"拷贝对象的对象属性age是："+classicCopy.getStudent().getAge());
		System.out.println("原始对象的对象属性gender是："+classicSrc.getStudent().getGender()+"\t\t\t"+"拷贝对象的对象属性gnder是："+classicCopy.getStudent().getGender());
		
		System.out.println("原始对象和拷贝对象"+(classicSrc==classicCopy?"相同":"不相同"));
		System.out.println("原始对象和拷贝对象的对象属性student"+(classicSrc.getStudent()==classicCopy.getStudent()?"相同":"不相同"));
		System.out.println("原始对象和拷贝对象的name属性"+(classicSrc.getName()==classicCopy.getName()?"一样":"不一样"));
		System.out.println("原始对象和拷贝对象的Student属性名"+(classicSrc.getStudent().getName()==classicCopy.getStudent().getName()?"一样":"不一样"));
		
		
		
		System.out.println("=============修改拷贝对象后==========");
		
		classicCopy.setName("修改拷贝名称为modyCopyName");
		classicCopy.setId(1103);
		classicCopy.getStudent().setName("修改拷贝对象的名称modyCopyObject");
		classicCopy.getStudent().setAge(50);
		classicCopy.getStudent().setGender("男女");
		
		System.out.println("原始对象的名称属性是："+classicSrc.getName()+"\t\t"+"拷贝对象的属性名称是："+classicCopy.getName());
		System.out.println("原始对象的id属性是："+classicSrc.getId()+"\t\t\t\t"+"拷贝对象的id属性是："+classicCopy.getId());
		System.out.println("原始对象的对象属性name是："+classicSrc.getStudent().getName()+"拷贝对象的对象属性name是："+classicCopy.getStudent().getName());
		System.out.println("原始对象的对象属性aget是："+classicSrc.getStudent().getAge()+"\t\t\t\t"+"拷贝对象的对象属性age是："+classicCopy.getStudent().getAge());
		System.out.println("原始对象的对象属性gender是："+classicSrc.getStudent().getGender()+"\t\t\t"+"拷贝对象的对象属性gnder是："+classicCopy.getStudent().getGender());
		
		System.out.println("原始对象和拷贝对象"+(classicSrc==classicCopy?"相同":"不相同"));
		System.out.println("原始对象和拷贝对象的对象属性student"+(classicSrc.getStudent()==classicCopy.getStudent()?"相同":"不相同"));
		System.out.println("原始对象和拷贝对象的name属性"+(classicSrc.getName()==classicCopy.getName()?"一样":"不一样"));
		System.out.println("原始对象和拷贝对象的Student属性名"+(classicSrc.getStudent().getName()==classicCopy.getStudent().getName()?"一样":"不一样"));
	}
}
