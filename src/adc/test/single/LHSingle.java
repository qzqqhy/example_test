package adc.test.single;
/**   双重校验锁
* @Title: LHSingle.java 
* @Package adc.test.single 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 上午11:13:07 
* @version V1.0   
*/
public class LHSingle {

    private static LHSingle lHSingle;
    private LHSingle (){};   

    public LHSingle getInstance(){
        if(lHSingle==null){
            synchronized (LHSingle.class) {
                if(lHSingle==null){
                    lHSingle=new LHSingle();
                }
            }
        }
        return lHSingle;
    }
}

