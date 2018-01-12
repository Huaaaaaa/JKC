package com.hyc.type;

public class TypeChange {

	public static void main(String[] args) {
		byte b = int2byte(10);
		System.out.println("int转字节：" + b);
		System.out.println("字节转int:" + byte2int(b));
	}

	public static int byte2int(byte b) {
		int i = (int) b;
		return i;
	}

	public static byte int2byte(int i) {
		byte b = (byte) i;
		return b;
	}

	/**
	 * 字节数组转16位字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteArray2HexStr(byte[] byteArray) {
		String hexStr = "";
		for (int i = 0; i < byteArray.length; i++) {
			// 将数组中的每一个字节与
			String hex = Integer.toHexString(byteArray[i] & 0xFF);
			if (hex.length() == 1) {
				hex = "0" + hex;
			}
			hexStr += hex;
		}
		return hexStr.toUpperCase();
	}
}
