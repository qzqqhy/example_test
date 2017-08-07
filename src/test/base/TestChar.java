package test.base;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: TestChar.java
 * @Package test.base
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年8月12日 上午10:11:41
 */
public class TestChar {

    public static void main(String[] args) {
        int[] i = {47, 97, 99, 99, 111, 117, 110, 116, 47, 114, 101, 102, 117, 110, 100, 47, 100, 101, 116, 97, 105, 108, 63, 105, 100, 61, 52, 50};
        for (int j = 0; j < i.length; j++) {
            System.out.print((char) i[j]);
        }
    }

}
