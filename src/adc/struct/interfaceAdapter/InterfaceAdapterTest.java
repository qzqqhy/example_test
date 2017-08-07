package adc.struct.interfaceAdapter;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: InterfaceAdapterTest.java
 * @Package adc.struct.interfaceAdapter
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午3:25:33
 */
public class InterfaceAdapterTest {

    public static void main(String[] args) {
        AbsOld old = new LightAdapter();
        old.method1();
        old.method2();
        AbsOld mold = new MusicAdapter();
        mold.method1();
        mold.method2();
    }
}

