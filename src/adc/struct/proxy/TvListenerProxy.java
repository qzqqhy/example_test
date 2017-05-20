package adc.struct.proxy;
/**   
* @Title: OldProxy.java 
* @Package adc.struct.proxy 
* @Description: TODO(用一句话描述该文件做什么) 
* @author shiwenlong   
* @date 2017年5月11日 下午3:54:26 
* @version V1.0   
*/
public class TvListenerProxy implements IListener {
    
    private TvListener tvl;
    public TvListenerProxy(){
     if(tvl==null){
         tvl=new TvListener();
     }
    }
    @Override
    public void method1() {
        System.out.println("this is TvListenerProxy start  ");
        tvl.method1();
        System.out.println("this is TvListenerProxy end ");
    }

}

