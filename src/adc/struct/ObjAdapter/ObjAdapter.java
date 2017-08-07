package adc.struct.ObjAdapter;

import adc.struct.classAdapter.Old;

/**
 * 对象的适配器模式
 * 基本思路和类的适配器模式相同，只是将Adapter类作修改，这次不继承Source类，而是持有Source类的实例，以达到解决兼容性的问题
 *
 * @author shiwenlong
 * @version V1.0
 * @Title: ObjAdapter.java
 * @Package adc.struct.ObjAdapter
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午3:15:05
 */
public class ObjAdapter {

    private Old old;

    private ObjAdapter(Old old) {
        this.old = old;
    }

    public void method2() {
        System.out.println("this is method2");
    }


    public void method1() {
        old.method1();
    }

    public static void main(String[] args) {
        Old old = new Old();
        ObjAdapter target = new ObjAdapter(old);
        target.method1();
        target.method2();
    }

}

