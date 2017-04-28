package test.base;

/**
 * @Title: LongTest.java
 * @Package test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年5月30日 下午10:35:26
 * @version V1.0
 */
public class LongTest {

	public static void main(String[] args) {
		Long a = 127L;// -128 127 有效值范围
		Long b = 127L;
		long c = 33333;
		long d = 33333;
		System.out.println(a == b);
		System.out.println(a.longValue() == b.longValue());
		System.out.println(c == d);
		// -----------------------Method Summary 方法总结
		Long val = 1471957578L;

		System.out.println(val.bitCount(1L));
		System.out.println(val.byteValue());
		System.out.println(val.decode("1471957578"));
		System.out.println(val.lowestOneBit(0));
		System.out.println(val.reverse(0));
		System.out.println(val.valueOf(8));
		System.out.println(val.valueOf("101", 10));
	}
}
