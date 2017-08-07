package test.base;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: TestInteger.java
 * @Package test.base
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年6月20日 上午11:27:01
 */
public class TestInteger {

    public static void main(String[] args) {
        System.out.println(54372 >>> 16);
    }

    public static void t1() {
        int n = 1 >>> 1;
        int a = 0x00000000 << 1;
        System.out.println(n + " " + a);
        System.out.println(0x0000000a);
    }

    /**
     * @Title: t1
     * @Description: 字符串加密
     * @author qzq
     */
    public static void encryption(String str) {
        // String str = "只对你有感觉《只对你有感觉-林俊杰》ࡀ⃙⎖";
        char[] c = str.toCharArray();
        for (char d : c) {
            int ic = (int) d;
            System.out.print(ic + " ,");
        }
    }

    /**
     * @param m
     * @Title: decrypt
     * @Description: 解密
     * @author qzq
     */
    public static void decrypt(int[] m) {
        for (int i = 0; i < m.length; i++) {
            char c = (char) m[i];
            System.out.print(c);
        }
    }
}
