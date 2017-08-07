package adc.struct.template;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: TempTest.java
 * @Package adc.struct.template
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午5:34:58
 */
public class TempTest {

    public static void main(String[] args) {
        AbstractP p = new Sub1();
        AbstractP p2 = new Sub2();
        p.getClassName();
        p2.getClassName();
    }
}

