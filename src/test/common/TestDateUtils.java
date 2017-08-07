package test.common;

import test.util.DateUtils;


/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: TestDateUtils.java
 * @Package test.common
 * @Description: TODO(用一句话描述该文件做什么)
 * @Company www.viewhigh.com
 * @date 2016年6月15日 上午10:06:56
 */
public class TestDateUtils extends BaseTest {

    public static void main(String[] args) {
        String dStr = DateUtils.formatDate(1770532705000L);
        System.out.println(dStr);
//		System.out.println(DateUtils.formatUnixDateMis("2016-06-21 11:33:44", "yyyy-MM-dd HH:mm:ss"));
//		System.out.println(DateUtils.getUnixTimeMis() + " " + new Date().getTime());
    }

}
