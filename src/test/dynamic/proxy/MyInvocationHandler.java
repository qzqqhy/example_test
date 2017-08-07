package test.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: MyInvocationHandler.java
 * @Package test.dynamic.proxy
 * @Description: 实现自己的InvocationHandler
 * @Company www.viewhigh.com
 * @date 2016年6月27日 上午11:03:53
 */
public class MyInvocationHandler implements InvocationHandler {
    // 目标对象
    private Object target;

    /**
     * 构造方法
     *
     * @param target 目标对象
     */
    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("----------------------------目标对象执行前打印---------------------------");
        Object result = method.invoke(target, args);
        System.out.println("----------------------------目标对象执行后打印---------------------------");
        return result;
    }

    /**
     * 获取目标对象的代理对象
     *
     * @return 代理对象
     */
    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(),
                this);
    }
}
