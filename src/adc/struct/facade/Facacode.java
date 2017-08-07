package adc.struct.facade;

/**
 * 外观模式是为了解决类与类之家的依赖关系的，像spring一样，可以将类和类之间的关系配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中，降低了类类之间的耦合度
 *
 * @author shiwenlong
 * @version V1.0
 * @Title: Facacode.java
 * @Package adc.struct.facade
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午4:10:19
 */
public class Facacode {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
    }
}

