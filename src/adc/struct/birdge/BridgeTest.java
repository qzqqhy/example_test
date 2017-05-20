package adc.struct.birdge;
/**   桥接模式就是把事物和其具体实现分开，使他们可以各自独立的变化。桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，JDBC进行连接数据库的时候，在各个数据库之间进行切换，基本不需要动太多的代码，甚至丝毫不用动，原因就是JDBC提供统一接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了
* @Title: BridgeTest.java 
* @Package adc.struct.birdge 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午4:31:16 
* @version V1.0   
*/
public class BridgeTest {
    public static void main(String[] args) {  
        //桥类是不 实现接口 ，要于业务接口分离
        BridgeListener bridge = new BridgeListener();  
          
        /*调用第一个对象*/  
        IListener source1 = new LightListener();  
        bridge.setiListener(source1);  
        bridge.method1();  
          
        /*调用第二个对象*/  
        IListener source2 = new LightListener();  
        bridge.setiListener(source2);  
        bridge.method1();  
    }  
}

