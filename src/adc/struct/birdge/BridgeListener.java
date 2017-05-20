package adc.struct.birdge;
/**   
* @Title: BridgeListener.java 
* @Package adc.struct.birdge 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午4:27:20 
* @version V1.0   
*/
public class BridgeListener  {

    private IListener iListener;

    public void method1(){  
        iListener.method1();  
    }  
      
    
    
    
    public IListener getiListener() {
        return iListener;
    }

    public void setiListener(IListener iListener) {
        this.iListener = iListener;
    }
    
}

