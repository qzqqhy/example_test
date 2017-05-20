package adc.struct.template;
/**   
* @Title: TempTest.java 
* @Package adc.struct.template 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午5:34:58 
* @version V1.0   
*/
public class TempTest {

    public static void main(String[] args) {
        AbstractP p=new Sub1();
        AbstractP p2=new Sub2();
        p.getClassName();
        p2.getClassName();
    }
}

