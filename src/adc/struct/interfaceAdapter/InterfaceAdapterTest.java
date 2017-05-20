package adc.struct.interfaceAdapter;
/**   
* @Title: InterfaceAdapterTest.java 
* @Package adc.struct.interfaceAdapter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午3:25:33 
* @version V1.0   
*/
public class InterfaceAdapterTest {

    public static void main(String[] args) {
        AbsOld old=new LightAdapter();
        old.method1();
        old.method2();
        AbsOld mold=new MusicAdapter();
        mold.method1();
        mold.method2();
    }
}

