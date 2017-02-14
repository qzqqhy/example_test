package test.dynamic.proxy;

/**
 * @Title: UserService.java
 * @Package test.dynamic.proxy
 * @Description:目标对象实现的接口，用JDK来生成代理对象一定要实现一个接口
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年6月27日 上午11:15:08
 * @version V1.0
 */
public interface UserService {
    /**
     * 
     * @Title: add @Description: 目标方法 @param 设定文件 @return void 返回类型 @throws
     */
    public abstract void add();
}
