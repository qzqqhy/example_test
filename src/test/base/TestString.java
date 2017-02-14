package test.base;

import imitate.string.ImitateString;
import imitate.string.SoftTypeEnum;

public class TestString {

	public static void main(String[] args) {
		String s1 = "天苍苍野茫茫，胡狼无影鼠猖狂";
		char[] cs = s1.toCharArray();
		int[] codePoints = new int[s1.length()];
		for (int i = 0; i < codePoints.length; i++) {
			codePoints[i] = (int) cs[i];
		}
		int offset = 0;
		int count = 9;
		ImitateString imstr = new ImitateString(codePoints, offset, count);
		String str = new String(codePoints, offset, count);

		System.out.println(imstr);
	}

	// 替换字符
	private static void t3() {
		String str = "\r\n fd\r\nkl";
		System.out.println(str.replaceAll("\r", "").replaceAll("\n", ""));
		System.out.println(str);
	}

	// 模仿String char[] 声明字符串对象，自定义写了 字符串 倒序 生成
	private static void t2(String str) {
		int count = str.length();
		int offset = 8;
		char[] value = str.toCharArray();

		ImitateString t2 = new ImitateString(value, offset, count, SoftTypeEnum.ASC);
		System.out.println(t2.toString());
	}

	private static void t1() {
		String t1 = "flsakjdfle11?111";
		System.out.println(t1.substring(0, t1.indexOf("?")));
	}

}