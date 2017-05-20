package adc.struct.classAdapter;
/** 新的适配器达到了 扩展旧类的方法 
 * 
* @Title: NewAdapater.java 
* @Package adc.struct.classAdapter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午3:08:22 
* @version V1.0   
*/
public class NewAdapater extends Old implements INew{
 

    @Override
    public void method2() {
       System.out.println(" this is method2 ");
    }

    
    public static void main(String[] args) {
        NewAdapater ada=new NewAdapater();
        ada.method1();
        ada.method2();
    }
    
}

