package adc.test.single;
/**   
* @Title: EHSingle.java 
* @Package adc.test.single 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 上午11:11:23 
* @version V1.0   
*/
public class EHSingle {

    private static EHSingle instance=new EHSingle();
    
    private EHSingle() {
        super();
    }

    public EHSingle getInstance(){
        return instance;
    }
   
}

