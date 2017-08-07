package adc.test.factory;

import adc.test.listener.ButtonListener;
import adc.test.listener.LightListener;
import adc.test.listener.MusicListener;

/**
 * 第一种如果传入的字符串有误，不能正确创建对象，第三种相对于第二种，不需要实例化工厂类，所以，大多数情况下，我们会选用第三种——静态工厂方法模式。
 * 普通传字符串模式 不建议写字符串方式 容易出错
 * 针对开关例子 ， 建造成生成不同监听器的工厂
 *
 * @author shiwenlong
 * @version V1.0
 * @Title: normalFactory.java
 * @Package adc.test.factory
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 上午11:42:07
 */
public class alwaysFactory {


    public static ButtonListener getLightListener() {
        return new LightListener();
    }

    public ButtonListener getMusicListener() {
        return new MusicListener();
    }
}

