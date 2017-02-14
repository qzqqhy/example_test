package test.base;

import java.lang.imitatestring.ImitateString;

/**
 * @Title: TestArray.java
 * @Package test.base
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年7月5日 上午11:36:32
 * @version V1.0
 */
public class TestArray {

	public static void main(String[] args) {
		String str = "当你孤单你会想起谁";
		char[] src = str.toCharArray();// 临时数组
		int[] nums = new int[src.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = src[i];
		}
		bubbleSort(nums);
		System.out.println(new String(nums, 0, nums.length));
	}

	public static void bubbleSort(int[] array) {
		int len = array.length;
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int i = 0; i < len - 1; i++) {
				if (array[i] > array[i + 1]) {
					int temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					flag = true;
				}
			}
			len--;
		}
	}

	/**
	 * 
	 * @Title: t2
	 * @Description: 系统System.arraycopy 方法使用
	 * @author Administrator
	 */
	public static void t2() {
		String str = "当你孤单你会想起谁";
		char[] src = str.toCharArray();// 临时数组
		int srcPos = 0;// 源数组要复制的起始位置
		int length = 9;// 复制的长度
		char[] dest = new char[length];
		int destPos = 0;// 目的数组放置的起始位置
		// t1();
		// 系统自带数组复制方法，其内部实现非java编写
		System.arraycopy(src, srcPos, dest, destPos, length);
		ImitateString su = new ImitateString(dest);
		System.out.println(su.toString());
	}

	public static void t1() {
		String[] array = { "2222", "1111" };
		String keySuffix = "";
		for (int i = 0; i < array.length; i++) {
			keySuffix = keySuffix.concat(array[i] + ",");
		}
		System.out.println(keySuffix);
	}

}
