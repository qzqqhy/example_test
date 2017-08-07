package test.dynamic.proxy;

/**
 * @author zhongqiang.qiu
 * @version V1.0
 * @Title: UserServiceImpl.java
 * @Package test.dynamic.proxy
 * @Description: 目标对象
 * @Company www.viewhigh.com
 * @date 2016年6月27日 上午11:18:05
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
