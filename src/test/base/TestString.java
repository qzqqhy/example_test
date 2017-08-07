package test.base;

import imitate.string.ImitateString;
import imitate.string.SoftTypeEnum;

import java.util.Arrays;

public class TestString {

    public static void main(String[] args) {
        String tt = "123456abcdef";
        char result[];
        result = Arrays.copyOf(tt.toCharArray(), tt.length());
        ImitateString iss = new ImitateString(result);
        int seh = (int) 'f';
        int i = iss.indexOf(seh, 0);
        System.out.println(i);
        System.out.println(0x010000);

        String HHmm = "123433334444591";
        System.out.println(HHmm.endsWith("59"));
    }


    /**
     * 拷贝字符串到 char 数组
     */
    private void copyOfArray() {
        String tt = "123456abcdef";
        char result[];
        result = Arrays.copyOf(tt.toCharArray(), tt.length());
        System.out.print(result);
    }

    private static void t4() {
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

        String str1 = "a";
        String str2 = "b";
        String str3 = "ab";
        String str31 = "ab";
        String str4 = (str1 + str2).toString();
        String str5 = new String("ab");

        System.out.println(str5.equals(str3));
        System.out.println(str5 == str3);
        System.out.println(str5.intern() == str31);
        System.out.println(str5.intern() == str4);
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
