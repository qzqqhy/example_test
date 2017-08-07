package test.dynamic.proxy;

import org.junit.Test;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: ProxyTest.java
 * @Package test.dynamic.proxy
 * @Description:动态代理测试类
 * @Company www.viewhigh.com
 * @date 2016年6月27日 上午11:24:23
 */
public class ProxyTest {

    @Test
    public void testProxy() {
        // 实例化目标对象
        UserService userService = new UserServiceImpl();
        // 实例化InvocationHandler
        MyInvocationHandler invocationHandler = new MyInvocationHandler(userService);
        // 根据目标对象生成代理对象
        UserService proxy = (UserService) invocationHandler.getProxy();
        proxy.add();

    }

}
