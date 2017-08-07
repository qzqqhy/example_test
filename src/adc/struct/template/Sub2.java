package adc.struct.template;

/**
 * 下模板方法模式，就是指：一个抽象类中，有一个主方法可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用
 *
 * @author shiwenlong
 * @version V1.0
 * @Title: AbstractCalculator.java
 * @Package adc.struct.template
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午5:30:33
 */
public class Sub2 extends AbstractP {
    /*被子类重写的方法*/
    public Class getTClass() {
        return this.getClass();
    }


}

