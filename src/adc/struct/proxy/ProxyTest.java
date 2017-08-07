package adc.struct.proxy;

/**
 * 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替原对象进行一些操作，比如我们在租房子的时候回去找中介，为什么呢？因为你对该地区房屋的信息掌握的不够全面，希望找一个更熟悉的人去帮你做，此处的代理就是这个意思
 *
 * @author shiwenlong
 * @version V1.0
 * @Title: ProxyTest.java
 * @Package adc.struct.proxy
 * @Description: TODO(用一句话描述该文件做什么)
 * @date 2017年5月11日 下午4:00:56
 */
public class ProxyTest {

    //代理有点像装饰模式 ，区别：被代理的对象是在 代理创建，
    public static void main(String[] args) {
        IListener proxy = new TvListenerProxy();
        proxy.method1();
    }
}

