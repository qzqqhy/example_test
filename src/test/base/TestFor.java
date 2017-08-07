package test.base;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: TestFor.java
 * @Package test
 * @Description: 循环测试
 * @Company www.viewhigh.com
 * @date 2016年6月14日 上午10:35:57
 */
public class TestFor {

    public static void main(String[] args) {
        int i = 0;
        for (; ; ) {
            i++;
            System.out.println(i);
            if (i > 100) {
                return;
            }
        }
    }

}

