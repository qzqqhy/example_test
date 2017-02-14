package test.dynamic.proxy;

/**
 * @Title: UserServiceImpl.java
 * @Package test.dynamic.proxy
 * @Description: 目标对象
 * @author zhongqiang.qiu
 * @Company www.viewhigh.com
 * @date 2016年6月27日 上午11:18:05
 * @version V1.0
 */
public class UserServiceImpl implements UserService {

    /**
     * @see test.dynaic.proxy.UserService#add()
     */
    @Override
    public void add() {
        System.out.println("--------------------------------add------------------------------");
    }

}
