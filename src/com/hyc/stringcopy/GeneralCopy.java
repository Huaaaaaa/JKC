package com.hyc.stringcopy;


/**
 * @createtime 2017年3月21日 下午2:15:49
 * @description
 */
public class GeneralCopy {
	public static void main(String[] args) {
		
		/**
		 * 普通对象的赋值
		 * 结论：
		 * 1、将对象a赋值给对象b时，对象a和对象b都指向同一片内存地址
		 * 2、任何一个对象的改变都会引起另一个对象的改变
		 * 3、普通的对象赋值就是浅拷贝
		 */
		System.out.println("---------普通的对象赋值---------");
		Student a = new Student("zhangsan", 20, "man");
		Student b = a;
		b.name = "lisi";
		System.out.println(a==b);//true
		System.out.println(a.name);//lisi
		a.name = "zhangsan1";
		System.out.println(a==b);//true
		System.out.println(b.name);//zhangsan1
		
		/**
		 * 对象的拷贝
		 * 结论：
		 * 1、拷贝对象时新建了一个实例
		 * 2、任何一个对象的改变都不会引起另一个对象的改变
		 * 3、但这不能说明克隆就是深拷贝
		 * 4、无引用变量时克隆为深拷贝
		 */
		System.out.println("---------无引用变量的克隆---------");
		StudentClone sca = new StudentClone("zhangsan",20);
		StudentClone scb = (StudentClone) sca.clone();
		scb.name = "lisi";
		System.out.println(sca==scb);//false
		System.out.println(sca.name);//zhangsan
		sca.name = "zhangsan1";
		System.out.println(sca==scb);//false
		System.out.println(scb.name);//lisi
		
		/**
		 * 含有引用变量的拷贝（引用变量没实现cloneable接口）
		 * 结论：
		 * 1、拷贝对象建立了一个实例
		 * 2、其中一个对象的普通变量改变时不会引起另一个对象普通变量的改变
		 * 3、其中一个对象的引用变量的改变引起另一个对象引用变量的改变
		 * 4、有引用变量且引用变量未实现cloeable接口时克隆为浅拷贝
		 */
		System.out.println("---------有引用变量的克隆---------");
		Student stu = new Student("张三",20,"男");
		AddAttrStudent aas1 = new AddAttrStudent("克隆1",stu);
		AddAttrStudent aas2 = (AddAttrStudent) aas1.clone();
		System.out.println(aas1==aas2);//false
		System.out.println(aas1.name);//克隆1
		System.out.println(aas2.name);//克隆1
		System.out.println(aas1.student == aas2.student);//true
		System.out.println(aas1.student.name);//张三
		System.out.println(aas2.student.name);//张三
		System.out.println("------改变原对象-------");
		aas1.name ="克隆2";
		aas1.student.name = "张三1";
		System.out.println(aas1==aas2);//false
		System.out.println(aas1.name);//克隆2
		System.out.println(aas2.name);//克隆1
		System.out.println(aas1.student == aas2.student);//true
		System.out.println(aas1.student.name);//张三1
		System.out.println(aas2.student.name);//张三1
		System.out.println("------改变拷贝对象-------");
		aas2.name ="克隆";
		aas2.student.name = "李四";
		System.out.println(aas1==aas2);//false
		System.out.println(aas1.name);//克隆2
		System.out.println(aas2.name);//克隆
		System.out.println(aas1.student == aas2.student);//true
		System.out.println(aas1.student.name);//李四
		System.out.println(aas2.student.name);//李四
		
		/**
		 * 含有引用变量的拷贝（引用变量也实现了cloneable接口）
		 * 结论：
		 * 1、拷贝对象创建了一个新的实例
		 * 2、其中一个对象的任何变量改变时都不会引起另一个对象的变量改变
		 * 3、拷贝的对象和源对象之间没有任何关系，它们是两个完全独立的个体，即深拷贝
		 * 4、想要实现深拷贝，在重写clone时还有拷贝它里面的引用变量
		 * 缺点：这种实现深拷贝的方式要让所有的引用变量都实现cloneable接口，并且要递归地clone所有引用变量，比较复杂
		 * 解决方法：序列化--反序列化
		 */
		System.out.println("---------有实现cloneabe接口的引用变量的克隆---------");
		StudentClone sc = new StudentClone("张三", 20);
		AddAttrStudentClone aasc1 = new AddAttrStudentClone("克隆1", sc);
		//克隆对象
		AddAttrStudentClone aasc2 = (AddAttrStudentClone) aasc1.clone();
		
		System.out.println(aasc1==aasc2);//false
		System.out.println(aasc1.name);//克隆1
		System.out.println(aasc2.name);//克隆1
		System.out.println(aasc1.studentClone == aasc2.studentClone);//false
		System.out.println(aasc1.studentClone.name);//张三
		System.out.println(aasc2.studentClone.name);//张三
		//改变克隆对象
		aasc2.name = "克隆2";
		aasc2.studentClone.name = "李四";
		System.out.println(aasc1==aasc2);//false
		System.out.println(aasc1.name);//克隆1
		System.out.println(aasc2.name);//克隆2
		System.out.println(aasc1.studentClone == aasc2.studentClone);//false
		System.out.println(aasc1.studentClone.name);//张三
		System.out.println(aasc2.studentClone.name);//李四
		
		//改变原对象
		aasc1.name ="克隆3";
		aasc1.studentClone.name = "张三2";
		System.out.println(aasc1==aasc2);//false
		System.out.println(aasc1.name);//克隆3
		System.out.println(aasc2.name);//克隆2
		System.out.println(aasc1.studentClone == aasc2.studentClone);//false
		System.out.println(aasc1.studentClone.name);//张三2
		System.out.println(aasc2.studentClone.name);//李四
	}
}
