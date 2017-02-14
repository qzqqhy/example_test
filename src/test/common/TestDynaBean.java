package test.common;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.LazyDynaBean;

/**   
* @Title: TestDynaBean.java 
* @Package test.common 
* @Description: DynaBean是BeanUtils里的宝贝之一。有了动态Bean，就不用写那么多VO出来了，特别那些只是为了和View交互而存在的bean，i hate Form Bean。
* @author zhongqiang.qiu
* @Company www.viewhigh.com
* @date 2016年6月15日 上午9:54:24 
* @version V1.0   
*/
public class TestDynaBean extends BaseTest{

    public static void main(String[] args) {
        DynaBean car = new LazyDynaBean();
        car.set("carNo",1);
        car.set("owner","张三");
        System.out.println(car.get("owner"));
    }

}

