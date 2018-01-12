package com.hyc.deepcopy;
/**
 * @createtime 2017年3月21日 下午3:57:36
 * @description 测试深拷贝
 */
public class DeepCopy {
	public static void main(String[] args) {
		try {
			DeepCopySerial.deepCopy();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
