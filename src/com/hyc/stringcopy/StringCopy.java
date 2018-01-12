package com.hyc.stringcopy;
/**
 * 字符串拷贝方式
 * @createtime 2017年3月21日 上午10:09:03
 * @description
 */

public class StringCopy {
	
	public static void main(String[] args) {
//		ShallowCopy.copy();
		/**
		 *  运行结果如下：
		 * 	原始对象的名称属性是：原始名称srcName			拷贝对象的属性名称是：原始名称srcName
			原始对象的id属性是：1101			                              拷贝对象的id属性是：1101
			原始对象的对象属性name是：原始对象为srcObject	拷贝对象的对象属性name是：原始对象为srcObject
			原始对象的对象属性aget是：23					拷贝对象的对象属性age是：23
			原始对象的对象属性gender是：man				拷贝对象的对象属性gnder是：man
			原始对象和拷贝对象不相同
			原始对象和拷贝对象的name属性一样
			原始对象和拷贝对象的Student属性名一样
			=============修改原始对象后==========
			原始对象的名称属性是：修改原始名称为modySrcName			拷贝对象的属性名称是：原始名称srcName
			原始对象的id属性是：1102								拷贝对象的id属性是：1101
			原始对象的对象属性name是：修改原始对象的名称modySrcObject	拷贝对象的对象属性name是：修改原始对象的名称modySrcObject
			原始对象的对象属性aget是：33							拷贝对象的对象属性age是：33
			原始对象的对象属性gender是：女						拷贝对象的对象属性gnder是：女
			原始对象和拷贝对象不相同
			原始对象和拷贝对象的name属性不一样
			原始对象和拷贝对象的Student属性名一样
			=============修改拷贝对象后==========
			原始对象的名称属性是：修改原始名称为modySrcName				拷贝对象的属性名称是：修改拷贝名称为modyCopyName
			原始对象的id属性是：1102									拷贝对象的id属性是：1103
			原始对象的对象属性name是：修改拷贝对象的名称modyCopyObject	拷贝对象的对象属性name是：修改拷贝对象的名称modyCopyObject
			原始对象的对象属性aget是：50								拷贝对象的对象属性age是：50
			原始对象的对象属性gender是：男女							拷贝对象的对象属性gnder是：男女
			原始对象和拷贝对象不相同
			原始对象和拷贝对象的name属性不一样
			原始对象和拷贝对象的Student属性名一样

		 *结论：
		 *如果拷贝对象是基本类型，则源对象的改变不会影响拷贝对象
		 *如果拷贝对象是引用类型，则源对象的改变会影响拷贝对象；拷贝对象的改变也会影响源对象
		 */
		
		DeepCopy.copy();
		/**
		 *  运行结果如下：
		 *  原始对象的名称属性是：原始名称srcName			拷贝对象的属性名称是：原始名称srcName
			原始对象的id属性是：1101						拷贝对象的id属性是：1101
			原始对象的对象属性name是：原始对象为srcObject	拷贝对象的对象属性name是：原始对象为srcObject
			原始对象的对象属性aget是：23					拷贝对象的对象属性age是：23
			原始对象的对象属性gender是：man				拷贝对象的对象属性gnder是：man
			原始对象和拷贝对象不相同
			原始对象和拷贝对象的name属性一样
			原始对象和拷贝对象的Student属性名一样
			=============修改原始对象后==========
			原始对象的名称属性是：修改原始名称为modySrcName			拷贝对象的属性名称是：原始名称srcName
			原始对象的id属性是：1102								拷贝对象的id属性是：1101
			原始对象的对象属性name是：修改原始对象的名称modySrcObject	拷贝对象的对象属性name是：修改原始对象的名称modySrcObject
			原始对象的对象属性aget是：33							拷贝对象的对象属性age是：33
			原始对象的对象属性gender是：女						拷贝对象的对象属性gnder是：女
			原始对象和拷贝对象不相同
			原始对象和拷贝对象的name属性不一样
			原始对象和拷贝对象的Student属性名一样
			=============修改拷贝对象后==========
			原始对象的名称属性是：修改原始名称为modySrcName				拷贝对象的属性名称是：修改拷贝名称为modyCopyName
			原始对象的id属性是：1102									拷贝对象的id属性是：1103
			原始对象的对象属性name是：修改拷贝对象的名称modyCopyObject	拷贝对象的对象属性name是：修改拷贝对象的名称modyCopyObject
			原始对象的对象属性aget是：50								拷贝对象的对象属性age是：50
			原始对象的对象属性gender是：男女							拷贝对象的对象属性gnder是：男女
			原始对象和拷贝对象不相同
			原始对象和拷贝对象的name属性不一样
			原始对象和拷贝对象的Student属性名一样

		 */
	}
	
	
}
