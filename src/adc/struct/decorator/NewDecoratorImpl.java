package adc.struct.decorator;

/**
 * @author shiwenlong
 * @version V1.0
 * @Title: IOld.java
 * @Package adc.struct.decorator
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午3:35:33
 */
public class NewDecoratorImpl implements IOld {
    private IOld old;

    public NewDecoratorImpl(IOld old) {
        super();
        this.old = old;
    }

    public void method1() {
        System.out.println("this NewDecoratorImpl method1 start ");
        old.method1();
        System.out.println("this NewDecoratorImpl method1 end ");
    }
}

