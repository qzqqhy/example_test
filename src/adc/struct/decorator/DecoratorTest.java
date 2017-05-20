package adc.struct.decorator;
/**   装饰模式就是给一个对象增加一些新的功能，而且是动态的，要求装饰对象和被装饰对象实现同一个接口，装饰对象持有被装饰对象的实例
* @Title: DecoratorTest.java 
* @Package adc.struct.decorator 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午3:42:25 
* @version V1.0   
*/
public class DecoratorTest {

    public static void main(String[] args) {
        IOld old=new OldImpl();
        IOld inew=new NewDecoratorImpl(old);
        inew.method1();
        
    }
}

